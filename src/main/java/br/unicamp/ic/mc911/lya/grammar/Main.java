package br.unicamp.ic.mc911.lya.grammar;

import br.unicamp.ic.mc911.lya.grammar.environment.Instruction;
import br.unicamp.ic.mc911.lya.grammar.environment.StringConstant;
import br.unicamp.ic.mc911.lya.grammar.visitors.codegen.CodegenLyaVisitor;
import br.unicamp.ic.mc911.lya.grammar.visitors.semantic.SemanticAnalysisVisitor;
import br.unicamp.ic.mc911.lya.grammar.environment.Environment;
import br.unicamp.ic.mc911.lya.grammar.visitors.PrinterLyaVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileName = args[0];

        final LyaLexer lexer = new LyaLexer(new ANTLRInputStream(new FileInputStream(inputFileName)));
        final LyaParser parser = new LyaParser(new CommonTokenStream(lexer));
        final LyaErrorListener errorListener = new LyaErrorListener();
        final Environment environment = new Environment();
        final PrinterLyaVisitor printerLyaVisitor = new PrinterLyaVisitor();
        final SemanticAnalysisVisitor semanticAnalysisVisitor = new SemanticAnalysisVisitor(environment);
        final CodegenLyaVisitor codegenVisitor = new CodegenLyaVisitor(environment);

        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);

        LyaParser.ProgramContext programContext = parser.program();

        semanticAnalysisVisitor.visit(programContext);
        codegenVisitor.visit(programContext);

        if (!errorListener.hasErrors) {
            System.out.print("H = [");
            boolean first = true;
            for (StringConstant stringConstant : environment.getStringHeap()) {
                if (!first) System.out.print(", ");
                System.out.print("\"" + stringConstant.getString() + "\"");
                first = false;
            }

            System.out.println("]");

            System.out.print("P = [");
            first = true;
            for (Instruction instruction: environment.getInstructions()) {
                if (!first)
                    System.out.print(", ");

                System.out.print(instruction);
                first = false;
            }

            System.out.println("]");

        }
    }

}
