// Generated from /home/diegorocha/Documents/MC911/src/main/java/br/unicamp/ic/mc911/lya/grammar/Lya.g4 by ANTLR 4.5.1
package br.unicamp.ic.mc911.lya.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LyaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGIT=1, WS=2, Nl=3, BlockComment=4, LineComment=5, COMMA=6, COLON=7, 
		SEMICOLON=8, UNDERSCORE=9, EQUALS=10, SINGLEQUOTE=11, DOUBLEQUOTE=12, 
		LPARENS=13, RPARENS=14, LBRACKET=15, RBRACKET=16, ARROW=17, STRINGCONCAT=18, 
		PLUS=19, MINUS=20, TIMES=21, DIVIDE=22, MODULO=23, AND=24, OR=25, NOT=26, 
		EQ=27, NEQ=28, LT=29, LE=30, GT=31, GE=32, ARRAY=33, BY=34, CHARS=35, 
		DCL=36, DO=37, DOWN=38, ELSE=39, ELSIF=40, END=41, EXIT=42, FI=43, FOR=44, 
		IF=45, IN=46, LOC=47, TYPE=48, OD=49, PROC=50, REF=51, RESULT=52, RETURN=53, 
		RETURNS=54, SYN=55, THEN=56, TO=57, WHILE=58, BOOL=59, CHAR=60, FALSE=61, 
		INT=62, LENGTH=63, LOWER=64, NULL=65, NUM=66, PRED=67, PRINT=68, READ=69, 
		SUCC=70, TRUE=71, UPPER=72, IDENTIFIER=73, CharLiteral=74, StringLiteral=75;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Character", "LINECOMMENT", "OPENCOMMENT", "CLOSECOMMENT", "DIGIT", "WS", 
		"Nl", "BlockComment", "LineComment", "COMMA", "COLON", "SEMICOLON", "UNDERSCORE", 
		"EQUALS", "SINGLEQUOTE", "DOUBLEQUOTE", "LPARENS", "RPARENS", "LBRACKET", 
		"RBRACKET", "ARROW", "STRINGCONCAT", "PLUS", "MINUS", "TIMES", "DIVIDE", 
		"MODULO", "AND", "OR", "NOT", "EQ", "NEQ", "LT", "LE", "GT", "GE", "ARRAY", 
		"BY", "CHARS", "DCL", "DO", "DOWN", "ELSE", "ELSIF", "END", "EXIT", "FI", 
		"FOR", "IF", "IN", "LOC", "TYPE", "OD", "PROC", "REF", "RESULT", "RETURN", 
		"RETURNS", "SYN", "THEN", "TO", "WHILE", "BOOL", "CHAR", "FALSE", "INT", 
		"LENGTH", "LOWER", "NULL", "NUM", "PRED", "PRINT", "READ", "SUCC", "TRUE", 
		"UPPER", "IDENTIFIER", "CharLiteral", "StringLiteral"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "','", "':'", "';'", "'_'", "'='", 
		"'''", "'\"'", "'('", "')'", "'['", "']'", "'->'", "'&'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'=='", "'!='", "'<'", "'<='", 
		"'>'", "'>='", "'array'", "'by'", "'chars'", "'dcl'", "'do'", "'down'", 
		"'else'", "'elseif'", "'end'", "'exit'", "'fi'", "'for'", "'if'", "'in'", 
		"'loc'", "'type'", "'od'", "'proc'", "'ref'", "'result'", "'return'", 
		"'returns'", "'syn'", "'then'", "'to'", "'while'", "'bool'", "'char'", 
		"'false'", "'int'", "'length'", "'lower'", "'null'", "'num'", "'pred'", 
		"'print'", "'read'", "'succ'", "'true'", "'upper'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DIGIT", "WS", "Nl", "BlockComment", "LineComment", "COMMA", "COLON", 
		"SEMICOLON", "UNDERSCORE", "EQUALS", "SINGLEQUOTE", "DOUBLEQUOTE", "LPARENS", 
		"RPARENS", "LBRACKET", "RBRACKET", "ARROW", "STRINGCONCAT", "PLUS", "MINUS", 
		"TIMES", "DIVIDE", "MODULO", "AND", "OR", "NOT", "EQ", "NEQ", "LT", "LE", 
		"GT", "GE", "ARRAY", "BY", "CHARS", "DCL", "DO", "DOWN", "ELSE", "ELSIF", 
		"END", "EXIT", "FI", "FOR", "IF", "IN", "LOC", "TYPE", "OD", "PROC", "REF", 
		"RESULT", "RETURN", "RETURNS", "SYN", "THEN", "TO", "WHILE", "BOOL", "CHAR", 
		"FALSE", "INT", "LENGTH", "LOWER", "NULL", "NUM", "PRED", "PRINT", "READ", 
		"SUCC", "TRUE", "UPPER", "IDENTIFIER", "CharLiteral", "StringLiteral"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LyaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lya.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2M\u01e8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\6\7\u00b0\n\7\r\7\16\7\u00b1\3\7\3\7"+
		"\3\b\5\b\u00b7\n\b\3\b\3\b\3\t\3\t\7\t\u00bd\n\t\f\t\16\t\u00c0\13\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\7\n\u00c9\n\n\f\n\16\n\u00cc\13\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3"+
		"&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3"+
		"+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3"+
		"/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\3\67\3\67\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:"+
		"\3:\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3=\3>\3>\3>\3?\3?"+
		"\3?\3?\3?\3?\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3C\3C\3C"+
		"\3C\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3G\3G\3G\3G"+
		"\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3L\3L"+
		"\3L\3L\3L\3M\3M\3M\3M\3M\3M\3N\3N\7N\u01d5\nN\fN\16N\u01d8\13N\3O\3O\5"+
		"O\u01dc\nO\3O\3O\3P\3P\7P\u01e2\nP\fP\16P\u01e5\13P\3P\3P\5\u00be\u00ca"+
		"\u01e3\2Q\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\b\27\t\31\n\33\13"+
		"\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25\61\26\63\27\65\30\67\319\32"+
		";\33=\34?\35A\36C\37E G!I\"K#M$O%Q&S\'U(W)Y*[+],_-a.c/e\60g\61i\62k\63"+
		"m\64o\65q\66s\67u8w9y:{;}<\177=\u0081>\u0083?\u0085@\u0087A\u0089B\u008b"+
		"C\u008dD\u008fE\u0091F\u0093G\u0095H\u0097I\u0099J\u009bK\u009dL\u009f"+
		"M\3\2\6\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\aac|\6\2\62;C\\aac|\u01ea\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\2\u009f\3\2\2\2\3\u00a1\3\2\2\2\5\u00a3\3\2\2\2\7\u00a6\3\2\2"+
		"\2\t\u00a9\3\2\2\2\13\u00ac\3\2\2\2\r\u00af\3\2\2\2\17\u00b6\3\2\2\2\21"+
		"\u00ba\3\2\2\2\23\u00c6\3\2\2\2\25\u00d1\3\2\2\2\27\u00d3\3\2\2\2\31\u00d5"+
		"\3\2\2\2\33\u00d7\3\2\2\2\35\u00d9\3\2\2\2\37\u00db\3\2\2\2!\u00dd\3\2"+
		"\2\2#\u00df\3\2\2\2%\u00e1\3\2\2\2\'\u00e3\3\2\2\2)\u00e5\3\2\2\2+\u00e7"+
		"\3\2\2\2-\u00ea\3\2\2\2/\u00ec\3\2\2\2\61\u00ee\3\2\2\2\63\u00f0\3\2\2"+
		"\2\65\u00f2\3\2\2\2\67\u00f4\3\2\2\29\u00f6\3\2\2\2;\u00f9\3\2\2\2=\u00fc"+
		"\3\2\2\2?\u00fe\3\2\2\2A\u0101\3\2\2\2C\u0104\3\2\2\2E\u0106\3\2\2\2G"+
		"\u0109\3\2\2\2I\u010b\3\2\2\2K\u010e\3\2\2\2M\u0114\3\2\2\2O\u0117\3\2"+
		"\2\2Q\u011d\3\2\2\2S\u0121\3\2\2\2U\u0124\3\2\2\2W\u0129\3\2\2\2Y\u012e"+
		"\3\2\2\2[\u0135\3\2\2\2]\u0139\3\2\2\2_\u013e\3\2\2\2a\u0141\3\2\2\2c"+
		"\u0145\3\2\2\2e\u0148\3\2\2\2g\u014b\3\2\2\2i\u014f\3\2\2\2k\u0154\3\2"+
		"\2\2m\u0157\3\2\2\2o\u015c\3\2\2\2q\u0160\3\2\2\2s\u0167\3\2\2\2u\u016e"+
		"\3\2\2\2w\u0176\3\2\2\2y\u017a\3\2\2\2{\u017f\3\2\2\2}\u0182\3\2\2\2\177"+
		"\u0188\3\2\2\2\u0081\u018d\3\2\2\2\u0083\u0192\3\2\2\2\u0085\u0198\3\2"+
		"\2\2\u0087\u019c\3\2\2\2\u0089\u01a3\3\2\2\2\u008b\u01a9\3\2\2\2\u008d"+
		"\u01ae\3\2\2\2\u008f\u01b2\3\2\2\2\u0091\u01b7\3\2\2\2\u0093\u01bd\3\2"+
		"\2\2\u0095\u01c2\3\2\2\2\u0097\u01c7\3\2\2\2\u0099\u01cc\3\2\2\2\u009b"+
		"\u01d2\3\2\2\2\u009d\u01d9\3\2\2\2\u009f\u01df\3\2\2\2\u00a1\u00a2\13"+
		"\2\2\2\u00a2\4\3\2\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a5\7\61\2\2\u00a5"+
		"\6\3\2\2\2\u00a6\u00a7\7\61\2\2\u00a7\u00a8\7,\2\2\u00a8\b\3\2\2\2\u00a9"+
		"\u00aa\7,\2\2\u00aa\u00ab\7\61\2\2\u00ab\n\3\2\2\2\u00ac\u00ad\t\2\2\2"+
		"\u00ad\f\3\2\2\2\u00ae\u00b0\t\3\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3"+
		"\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\b\7\2\2\u00b4\16\3\2\2\2\u00b5\u00b7\7\17\2\2\u00b6\u00b5\3\2\2"+
		"\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\f\2\2\u00b9\20"+
		"\3\2\2\2\u00ba\u00be\5\7\4\2\u00bb\u00bd\5\3\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\5\t\5\2\u00c2\u00c3\5\17\b\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\b\t\2\2\u00c5\22\3\2\2\2\u00c6\u00ca\5\5\3"+
		"\2\u00c7\u00c9\5\3\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00ce\5\17\b\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\b\n\2\2\u00d0\24\3\2\2"+
		"\2\u00d1\u00d2\7.\2\2\u00d2\26\3\2\2\2\u00d3\u00d4\7<\2\2\u00d4\30\3\2"+
		"\2\2\u00d5\u00d6\7=\2\2\u00d6\32\3\2\2\2\u00d7\u00d8\7a\2\2\u00d8\34\3"+
		"\2\2\2\u00d9\u00da\7?\2\2\u00da\36\3\2\2\2\u00db\u00dc\7)\2\2\u00dc \3"+
		"\2\2\2\u00dd\u00de\7$\2\2\u00de\"\3\2\2\2\u00df\u00e0\7*\2\2\u00e0$\3"+
		"\2\2\2\u00e1\u00e2\7+\2\2\u00e2&\3\2\2\2\u00e3\u00e4\7]\2\2\u00e4(\3\2"+
		"\2\2\u00e5\u00e6\7_\2\2\u00e6*\3\2\2\2\u00e7\u00e8\7/\2\2\u00e8\u00e9"+
		"\7@\2\2\u00e9,\3\2\2\2\u00ea\u00eb\7(\2\2\u00eb.\3\2\2\2\u00ec\u00ed\7"+
		"-\2\2\u00ed\60\3\2\2\2\u00ee\u00ef\7/\2\2\u00ef\62\3\2\2\2\u00f0\u00f1"+
		"\7,\2\2\u00f1\64\3\2\2\2\u00f2\u00f3\7\61\2\2\u00f3\66\3\2\2\2\u00f4\u00f5"+
		"\7\'\2\2\u00f58\3\2\2\2\u00f6\u00f7\7(\2\2\u00f7\u00f8\7(\2\2\u00f8:\3"+
		"\2\2\2\u00f9\u00fa\7~\2\2\u00fa\u00fb\7~\2\2\u00fb<\3\2\2\2\u00fc\u00fd"+
		"\7#\2\2\u00fd>\3\2\2\2\u00fe\u00ff\7?\2\2\u00ff\u0100\7?\2\2\u0100@\3"+
		"\2\2\2\u0101\u0102\7#\2\2\u0102\u0103\7?\2\2\u0103B\3\2\2\2\u0104\u0105"+
		"\7>\2\2\u0105D\3\2\2\2\u0106\u0107\7>\2\2\u0107\u0108\7?\2\2\u0108F\3"+
		"\2\2\2\u0109\u010a\7@\2\2\u010aH\3\2\2\2\u010b\u010c\7@\2\2\u010c\u010d"+
		"\7?\2\2\u010dJ\3\2\2\2\u010e\u010f\7c\2\2\u010f\u0110\7t\2\2\u0110\u0111"+
		"\7t\2\2\u0111\u0112\7c\2\2\u0112\u0113\7{\2\2\u0113L\3\2\2\2\u0114\u0115"+
		"\7d\2\2\u0115\u0116\7{\2\2\u0116N\3\2\2\2\u0117\u0118\7e\2\2\u0118\u0119"+
		"\7j\2\2\u0119\u011a\7c\2\2\u011a\u011b\7t\2\2\u011b\u011c\7u\2\2\u011c"+
		"P\3\2\2\2\u011d\u011e\7f\2\2\u011e\u011f\7e\2\2\u011f\u0120\7n\2\2\u0120"+
		"R\3\2\2\2\u0121\u0122\7f\2\2\u0122\u0123\7q\2\2\u0123T\3\2\2\2\u0124\u0125"+
		"\7f\2\2\u0125\u0126\7q\2\2\u0126\u0127\7y\2\2\u0127\u0128\7p\2\2\u0128"+
		"V\3\2\2\2\u0129\u012a\7g\2\2\u012a\u012b\7n\2\2\u012b\u012c\7u\2\2\u012c"+
		"\u012d\7g\2\2\u012dX\3\2\2\2\u012e\u012f\7g\2\2\u012f\u0130\7n\2\2\u0130"+
		"\u0131\7u\2\2\u0131\u0132\7g\2\2\u0132\u0133\7k\2\2\u0133\u0134\7h\2\2"+
		"\u0134Z\3\2\2\2\u0135\u0136\7g\2\2\u0136\u0137\7p\2\2\u0137\u0138\7f\2"+
		"\2\u0138\\\3\2\2\2\u0139\u013a\7g\2\2\u013a\u013b\7z\2\2\u013b\u013c\7"+
		"k\2\2\u013c\u013d\7v\2\2\u013d^\3\2\2\2\u013e\u013f\7h\2\2\u013f\u0140"+
		"\7k\2\2\u0140`\3\2\2\2\u0141\u0142\7h\2\2\u0142\u0143\7q\2\2\u0143\u0144"+
		"\7t\2\2\u0144b\3\2\2\2\u0145\u0146\7k\2\2\u0146\u0147\7h\2\2\u0147d\3"+
		"\2\2\2\u0148\u0149\7k\2\2\u0149\u014a\7p\2\2\u014af\3\2\2\2\u014b\u014c"+
		"\7n\2\2\u014c\u014d\7q\2\2\u014d\u014e\7e\2\2\u014eh\3\2\2\2\u014f\u0150"+
		"\7v\2\2\u0150\u0151\7{\2\2\u0151\u0152\7r\2\2\u0152\u0153\7g\2\2\u0153"+
		"j\3\2\2\2\u0154\u0155\7q\2\2\u0155\u0156\7f\2\2\u0156l\3\2\2\2\u0157\u0158"+
		"\7r\2\2\u0158\u0159\7t\2\2\u0159\u015a\7q\2\2\u015a\u015b\7e\2\2\u015b"+
		"n\3\2\2\2\u015c\u015d\7t\2\2\u015d\u015e\7g\2\2\u015e\u015f\7h\2\2\u015f"+
		"p\3\2\2\2\u0160\u0161\7t\2\2\u0161\u0162\7g\2\2\u0162\u0163\7u\2\2\u0163"+
		"\u0164\7w\2\2\u0164\u0165\7n\2\2\u0165\u0166\7v\2\2\u0166r\3\2\2\2\u0167"+
		"\u0168\7t\2\2\u0168\u0169\7g\2\2\u0169\u016a\7v\2\2\u016a\u016b\7w\2\2"+
		"\u016b\u016c\7t\2\2\u016c\u016d\7p\2\2\u016dt\3\2\2\2\u016e\u016f\7t\2"+
		"\2\u016f\u0170\7g\2\2\u0170\u0171\7v\2\2\u0171\u0172\7w\2\2\u0172\u0173"+
		"\7t\2\2\u0173\u0174\7p\2\2\u0174\u0175\7u\2\2\u0175v\3\2\2\2\u0176\u0177"+
		"\7u\2\2\u0177\u0178\7{\2\2\u0178\u0179\7p\2\2\u0179x\3\2\2\2\u017a\u017b"+
		"\7v\2\2\u017b\u017c\7j\2\2\u017c\u017d\7g\2\2\u017d\u017e\7p\2\2\u017e"+
		"z\3\2\2\2\u017f\u0180\7v\2\2\u0180\u0181\7q\2\2\u0181|\3\2\2\2\u0182\u0183"+
		"\7y\2\2\u0183\u0184\7j\2\2\u0184\u0185\7k\2\2\u0185\u0186\7n\2\2\u0186"+
		"\u0187\7g\2\2\u0187~\3\2\2\2\u0188\u0189\7d\2\2\u0189\u018a\7q\2\2\u018a"+
		"\u018b\7q\2\2\u018b\u018c\7n\2\2\u018c\u0080\3\2\2\2\u018d\u018e\7e\2"+
		"\2\u018e\u018f\7j\2\2\u018f\u0190\7c\2\2\u0190\u0191\7t\2\2\u0191\u0082"+
		"\3\2\2\2\u0192\u0193\7h\2\2\u0193\u0194\7c\2\2\u0194\u0195\7n\2\2\u0195"+
		"\u0196\7u\2\2\u0196\u0197\7g\2\2\u0197\u0084\3\2\2\2\u0198\u0199\7k\2"+
		"\2\u0199\u019a\7p\2\2\u019a\u019b\7v\2\2\u019b\u0086\3\2\2\2\u019c\u019d"+
		"\7n\2\2\u019d\u019e\7g\2\2\u019e\u019f\7p\2\2\u019f\u01a0\7i\2\2\u01a0"+
		"\u01a1\7v\2\2\u01a1\u01a2\7j\2\2\u01a2\u0088\3\2\2\2\u01a3\u01a4\7n\2"+
		"\2\u01a4\u01a5\7q\2\2\u01a5\u01a6\7y\2\2\u01a6\u01a7\7g\2\2\u01a7\u01a8"+
		"\7t\2\2\u01a8\u008a\3\2\2\2\u01a9\u01aa\7p\2\2\u01aa\u01ab\7w\2\2\u01ab"+
		"\u01ac\7n\2\2\u01ac\u01ad\7n\2\2\u01ad\u008c\3\2\2\2\u01ae\u01af\7p\2"+
		"\2\u01af\u01b0\7w\2\2\u01b0\u01b1\7o\2\2\u01b1\u008e\3\2\2\2\u01b2\u01b3"+
		"\7r\2\2\u01b3\u01b4\7t\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b6\7f\2\2\u01b6"+
		"\u0090\3\2\2\2\u01b7\u01b8\7r\2\2\u01b8\u01b9\7t\2\2\u01b9\u01ba\7k\2"+
		"\2\u01ba\u01bb\7p\2\2\u01bb\u01bc\7v\2\2\u01bc\u0092\3\2\2\2\u01bd\u01be"+
		"\7t\2\2\u01be\u01bf\7g\2\2\u01bf\u01c0\7c\2\2\u01c0\u01c1\7f\2\2\u01c1"+
		"\u0094\3\2\2\2\u01c2\u01c3\7u\2\2\u01c3\u01c4\7w\2\2\u01c4\u01c5\7e\2"+
		"\2\u01c5\u01c6\7e\2\2\u01c6\u0096\3\2\2\2\u01c7\u01c8\7v\2\2\u01c8\u01c9"+
		"\7t\2\2\u01c9\u01ca\7w\2\2\u01ca\u01cb\7g\2\2\u01cb\u0098\3\2\2\2\u01cc"+
		"\u01cd\7w\2\2\u01cd\u01ce\7r\2\2\u01ce\u01cf\7r\2\2\u01cf\u01d0\7g\2\2"+
		"\u01d0\u01d1\7t\2\2\u01d1\u009a\3\2\2\2\u01d2\u01d6\t\4\2\2\u01d3\u01d5"+
		"\t\5\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u009c\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01db\7)"+
		"\2\2\u01da\u01dc\5\3\2\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u01de\7)\2\2\u01de\u009e\3\2\2\2\u01df\u01e3\7$\2"+
		"\2\u01e0\u01e2\5\3\2\2\u01e1\u01e0\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e4"+
		"\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6"+
		"\u01e7\7$\2\2\u01e7\u00a0\3\2\2\2\n\2\u00b1\u00b6\u00be\u00ca\u01d6\u01db"+
		"\u01e3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}