package br.unicamp.ic.mc911.lya.grammar.visitors.utils;

import br.unicamp.ic.mc911.lya.grammar.LyaParser;
import br.unicamp.ic.mc911.lya.grammar.environment.*;
import br.unicamp.ic.mc911.lya.grammar.visitors.codegen.ConstantExpressionExtractorVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class LyaUtils {

    public static Type typeFromModeContext(Environment environment, LyaParser.ModoContext context) {
        if (context.mode_name() != null) {
            String modeName = context.mode_name().getText();
            Symbol modeSymbol = environment.lookup(modeName);

            if (modeSymbol == null) {
                throwError("Undefined mode " + modeName, context);
            }

            Type type = environment.findType(modeSymbol);

            if (type == null) {
                throwError(modeName + " is not a mode", context);
            }

            return type;
        } else if (context.reference_mode() != null) {
            String modeName = context.reference_mode().modo().getText();
            Symbol modeSymbol = environment.lookup(modeName);

            if (modeSymbol == null) {
                throwError("Undefined mode " + modeName, context);
            }

            Type type = environment.findType(modeSymbol);

            if (type == null) {
                throwError(modeName + " is not a mode", context);
            }

            return new ReferenceType(type);
        } else if (context.composite_mode() != null) {
            if (context.composite_mode().array_mode() != null) {
                String modeName = context.composite_mode().array_mode().element_mode().getText();
                Symbol modeSymbol = environment.lookup(modeName);

                if (modeSymbol == null) {
                    throwError("Undefined mode " + modeName, context);
                }

                Type type = environment.findType(modeSymbol);

                if (type == null) {
                    throwError(modeName + " is not a mode", context);
                }

                return new ArrayType(type);
            } else {
                return PrimitiveType.STRING;
            }
        } else {
            String modeName = context.discrete_mode().getText();
            Symbol modeSymbol = environment.lookup(modeName);

            if (modeSymbol == null) {
                throwError("Undefined mode " + modeName, context);
            }

            Type type = environment.findType(modeSymbol);

            if (type == null) {
                throwError(modeName + " is not a mode", context);
            }

            return type;
        }
    }

    public static int constantValueToInstArg(Object constant, ParserRuleContext context) {
        if (constant instanceof Integer) {
            return (Integer) constant;
        } else if (constant instanceof Character) {
            return (Character) constant;
        } else if (constant instanceof Boolean) {
            return ((Boolean) constant ? 1 : 0);
        } else if (constant instanceof StringConstant) {
            return ((StringConstant) constant).getIndex();
        }

        throwError("Illegal constant " + constant, context);
        return -1;
    }

    public static Type typeOfConstant(Object constant, ParserRuleContext context) {
        if (constant instanceof Integer) {
            return PrimitiveType.INT;
        } else if (constant instanceof Character) {
            return PrimitiveType.CHAR;
        } else if (constant instanceof Boolean) {
            return PrimitiveType.BOOL;
        } else if (constant instanceof StringConstant) {
            return PrimitiveType.STRING;
        }

        throwError("Illegal constant " + constant, context);
        return null;
    }

    public static int sizeFromMode(Environment environment, LyaParser.ModoContext context) {
        if (context.mode_name() != null) {
            return 1;
        } else if (context.reference_mode() != null) {
            return sizeFromMode(environment, context.reference_mode().modo());
        } else if (context.composite_mode() != null) {
            if (context.composite_mode().array_mode() != null) {
                int size = 1;

                for (LyaParser.Index_modeContext indexMode : context.composite_mode().array_mode().index_mode()) {
                    size *= sizeFromIndexMode(environment, indexMode);
                }

                return size;
            } else {
                return (Integer) new ConstantExpressionExtractorVisitor(environment).visit(context.composite_mode().string_mode().string_length());
            }
        } else {
            return 1;
        }
    }

    public static List<Integer> compositeIndexesSizes(Environment environment, LyaParser.Composite_modeContext context) {
        ConstantExpressionExtractorVisitor constantExtractor = new ConstantExpressionExtractorVisitor(environment);
        if (context.string_mode() != null) {
            return Collections.singletonList((Integer) new ConstantExpressionExtractorVisitor(environment).visit(context.string_mode().string_length()));
        } else {
            List<Integer> sizes = new ArrayList<Integer>();

            for (LyaParser.Index_modeContext indexMode : context.array_mode().index_mode()) {
                sizes.add(sizeFromIndexMode(environment, indexMode));
            }

            return sizes;
        }
    }

    private static int sizeFromIndexMode(Environment environment, LyaParser.Index_modeContext context) {
        ConstantExpressionExtractorVisitor constantExtractor = new ConstantExpressionExtractorVisitor(environment);
        if (context.discrete_mode() != null) {
            return (Integer) constantExtractor.visit(context.discrete_mode());
        } else {
            int begin = (Integer)constantExtractor.visit(context.literal_range().lower_bound());
            int end = (Integer)constantExtractor.visit(context.literal_range().upper_bound());

            return end - begin + 1;
        }
    }

    public static void throwError(String message, ParserRuleContext context) {
        throw new IllegalArgumentException(message + " on line " + context.getStart().getLine());
    }
}
