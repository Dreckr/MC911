package br.unicamp.ic.mc911.lya.grammar;

import br.unicamp.ic.mc911.lya.grammar.semantic.visitors.SemanticAnalysisVisitor;
import br.unicamp.ic.mc911.lya.grammar.semantic.Environment;
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
        final PrinterLyaVisitor printerLyaVisitor = new PrinterLyaVisitor();
        final SemanticAnalysisVisitor semanticAnalysisVisitor = new SemanticAnalysisVisitor(new Environment());

        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);

        Environment result = semanticAnalysisVisitor.visit(parser.program());

        if (!errorListener.hasErrors) {
            System.out.println(result);
        }
    }

}
