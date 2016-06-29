package br.unicamp.ic.mc911.lya.grammar.visitors;

import br.unicamp.ic.mc911.lya.grammar.LyaBaseVisitor;
import br.unicamp.ic.mc911.lya.grammar.LyaParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class PrinterLyaVisitor extends LyaBaseVisitor<String> {

    public String visitChildren(RuleNode node) {
        String result = LyaParser.ruleNames[node.getRuleContext().getRuleIndex()];
        int n = node.getChildCount();

//        result += ": " + node.getText();
        for(int i = 0; i < n && this.shouldVisitNextChild(node, result); ++i) {
            ParseTree c = node.getChild(i);
            String childResult = c.accept(this);
            if (childResult != null) {
                result += "\n\t" + childResult.replaceAll("\n", "\n\t");
            }
        }

        return result;
    }
}
