package br.unicamp.ic.mc911.lya.grammar;

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

        final PrinterLyaVisitor visitor = new PrinterLyaVisitor();
        final LyaLexer lexer = new LyaLexer(new ANTLRInputStream(new FileInputStream(inputFileName)));
        final LyaParser parser = new LyaParser(new CommonTokenStream(lexer));

        String result = visitor.visit(parser.program());

        System.out.println(result);
    }

}
