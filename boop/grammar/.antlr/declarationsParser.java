// Generated from d:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/boop/grammar/declarations.gn4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class declarationsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ABSTRACT=2, ALIAS=3, ASYNC=4, BASE=5, BOOL=6, BREAK=7, CASE=8, 
		CATCH=9, CHAR=10, CLASS=11, CONST=12, CONSTANT=13, CONTINUE=14, DEFAULT=15, 
		DELAYED=16, DICT=17, DICTIONARY=18, DO=19, DOUBLE=20, ELSE=21, ENUM=22, 
		ENUMERATION=23, EVENT=24, FALSE=25, FLOAT=26, FOR=27, FOREACH=28, FORMAT=29, 
		FORTIME=30, FROM=31, FUNC=32, GET=33, IF=34, IMPORT=35, INHERIT=36, INT=37, 
		INTERFACE=38, LIST=39, MILLISEC=40, MODULE=41, NULL=42, OVERRIDE=43, PRIVATE=44, 
		PROTECTED=45, PUBLIC=46, RECUR=47, REF=48, RETURN=49, REPEAT=50, SECOND=51, 
		SET=52, STATIC=53, STRING=54, STRUCT=55, SWITCH=56, THIS=57, THROW=58, 
		TIME=59, TRUE=60, TRY=61, VIRTUAL=62, VOID=63, WHILE=64, WHERE=65, LEFT_ANGLED_BRACKET=66, 
		RIGHT_ANGLED_BRACKET=67, LEFT_BRACKET=68, RIGHT_BRACKET=69, COLON=70, 
		COMMA=71, LEFT_BRACE=72, RIGHT_BRACE=73, EQUALS=74, LEFT_PAREN=75, RIGHT_PAREN=76, 
		DELIM_FUNC_RETURN=77, SEMICOLON=78, UNDERSCORE=79, OP_EQUALITY=80, INHERITS=81, 
		STRING_LITERAL=82, ALPHA=83;
	public static final int
		RULE_statement = 0, RULE_identifier = 1, RULE_block = 2, RULE_classBody = 3, 
		RULE_classHeading = 4, RULE_functionHeading = 5, RULE_programStatement = 6, 
		RULE_functionBody = 7, RULE_mainFunction = 8, RULE_value = 9, RULE_dataType = 10, 
		RULE_parameter = 11, RULE_expression = 12, RULE_accessModifier = 13, RULE_secondaryModifier = 14, 
		RULE_functionModifier = 15, RULE_modifier = 16, RULE_functionReturn = 17, 
		RULE_functionParameters = 18, RULE_moduleBody = 19, RULE_moduleHeading = 20, 
		RULE_variableDeclaration = 21, RULE_typeParameters = 22, RULE_recurLastParameter = 23, 
		RULE_recurParameters = 24, RULE_recurHeading = 25, RULE_arguments = 26, 
		RULE_functionCall = 27, RULE_structBody = 28, RULE_structHeading = 29, 
		RULE_enumBody = 30, RULE_enumHeading = 31, RULE_eventBody = 32, RULE_eventHeading = 33, 
		RULE_classBodyDeclarations = 34, RULE_interfaceSignature = 35, RULE_keyword = 36, 
		RULE_operator = 37, RULE_token = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "identifier", "block", "classBody", "classHeading", "functionHeading", 
			"programStatement", "functionBody", "mainFunction", "value", "dataType", 
			"parameter", "expression", "accessModifier", "secondaryModifier", "functionModifier", 
			"modifier", "functionReturn", "functionParameters", "moduleBody", "moduleHeading", 
			"variableDeclaration", "typeParameters", "recurLastParameter", "recurParameters", 
			"recurHeading", "arguments", "functionCall", "structBody", "structHeading", 
			"enumBody", "enumHeading", "eventBody", "eventHeading", "classBodyDeclarations", 
			"interfaceSignature", "keyword", "operator", "token"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'a'", "'abstract'", "'alias'", "'async'", "'base'", "'bool'", 
			"'break'", "'case'", "'catch'", "'char'", "'class'", "'const'", "'constant'", 
			"'continue'", "'default'", "'delayed'", "'dict'", "'dictionary'", "'do'", 
			"'double'", "'else'", "'enum'", "'enumeration'", "'event'", "'false'", 
			"'float'", "'for'", "'foreach'", "'format'", "'fortime'", "'from'", "'func'", 
			"'get'", "'if'", "'import'", "'inherit'", "'int'", "'interface'", "'list'", 
			"'millisec'", "'module'", "'null'", "'override'", "'private'", "'protected'", 
			"'public'", "'recur'", "'ref'", "'return'", "'repeat'", "'second'", "'set'", 
			"'static'", "'string'", "'struct'", "'switch'", "'this'", "'throw'", 
			"'time'", "'true'", "'try'", "'virtual'", "'void'", "'while'", "'where'", 
			"'<'", "'>'", "'['", "']'", "':'", "','", "'{'", "'}'", "'='", "'('", 
			"')'", "'->'", "';'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "ABSTRACT", "ALIAS", "ASYNC", "BASE", "BOOL", "BREAK", "CASE", 
			"CATCH", "CHAR", "CLASS", "CONST", "CONSTANT", "CONTINUE", "DEFAULT", 
			"DELAYED", "DICT", "DICTIONARY", "DO", "DOUBLE", "ELSE", "ENUM", "ENUMERATION", 
			"EVENT", "FALSE", "FLOAT", "FOR", "FOREACH", "FORMAT", "FORTIME", "FROM", 
			"FUNC", "GET", "IF", "IMPORT", "INHERIT", "INT", "INTERFACE", "LIST", 
			"MILLISEC", "MODULE", "NULL", "OVERRIDE", "PRIVATE", "PROTECTED", "PUBLIC", 
			"RECUR", "REF", "RETURN", "REPEAT", "SECOND", "SET", "STATIC", "STRING", 
			"STRUCT", "SWITCH", "THIS", "THROW", "TIME", "TRUE", "TRY", "VIRTUAL", 
			"VOID", "WHILE", "WHERE", "LEFT_ANGLED_BRACKET", "RIGHT_ANGLED_BRACKET", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "COLON", "COMMA", "LEFT_BRACE", "RIGHT_BRACE", 
			"EQUALS", "LEFT_PAREN", "RIGHT_PAREN", "DELIM_FUNC_RETURN", "SEMICOLON", 
			"UNDERSCORE", "OP_EQUALITY", "INHERITS", "STRING_LITERAL", "ALPHA"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "declarations.gn4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public declarationsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(declarationsParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(declarationsParser.IF, i);
		}
		public List<TerminalNode> ELSE() { return getTokens(declarationsParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(declarationsParser.ELSE, i);
		}
		public TerminalNode SEMICOLON() { return getToken(declarationsParser.SEMICOLON, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(IF);
				setState(79);
				match(ELSE);
				setState(80);
				match(IF);
				setState(81);
				match(ELSE);
				setState(82);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(IF);
				setState(84);
				match(ELSE);
				setState(85);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> ALPHA() { return getTokens(declarationsParser.ALPHA); }
		public TerminalNode ALPHA(int i) {
			return getToken(declarationsParser.ALPHA, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(88);
					match(ALPHA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(91); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(declarationsParser.RIGHT_BRACE, 0); }
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classBody);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				block();
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(LEFT_BRACE);
				setState(97);
				block();
				setState(98);
				match(RIGHT_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassHeadingContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(declarationsParser.PUBLIC, 0); }
		public TerminalNode CLASS() { return getToken(declarationsParser.CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(declarationsParser.RIGHT_BRACE, 0); }
		public ClassHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterClassHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitClassHeading(this);
		}
	}

	public final ClassHeadingContext classHeading() throws RecognitionException {
		ClassHeadingContext _localctx = new ClassHeadingContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classHeading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(PUBLIC);
			setState(103);
			match(CLASS);
			setState(104);
			identifier();
			setState(105);
			match(LEFT_BRACE);
			setState(106);
			classBody();
			setState(107);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionHeadingContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(declarationsParser.FUNC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionParametersContext functionParameters() {
			return getRuleContext(FunctionParametersContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public FunctionReturnContext functionReturn() {
			return getRuleContext(FunctionReturnContext.class,0);
		}
		public FunctionHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterFunctionHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitFunctionHeading(this);
		}
	}

	public final FunctionHeadingContext functionHeading() throws RecognitionException {
		FunctionHeadingContext _localctx = new FunctionHeadingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionHeading);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(FUNC);
				setState(110);
				identifier();
				setState(111);
				functionParameters();
				setState(112);
				functionBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(FUNC);
				setState(115);
				identifier();
				setState(116);
				functionParameters();
				setState(117);
				functionReturn();
				setState(118);
				functionBody();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramStatementContext extends ParserRuleContext {
		public FunctionHeadingContext functionHeading() {
			return getRuleContext(FunctionHeadingContext.class,0);
		}
		public ModuleHeadingContext moduleHeading() {
			return getRuleContext(ModuleHeadingContext.class,0);
		}
		public ClassHeadingContext classHeading() {
			return getRuleContext(ClassHeadingContext.class,0);
		}
		public ProgramStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterProgramStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitProgramStatement(this);
		}
	}

	public final ProgramStatementContext programStatement() throws RecognitionException {
		ProgramStatementContext _localctx = new ProgramStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_programStatement);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				functionHeading();
				}
				break;
			case MODULE:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				moduleHeading();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				classHeading();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionBodyContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(declarationsParser.RIGHT_BRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitFunctionBody(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionBody);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(LEFT_BRACE);
				setState(128);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(LEFT_BRACE);
				setState(130);
				block();
				setState(131);
				match(RIGHT_BRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainFunctionContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(declarationsParser.FUNC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(declarationsParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(declarationsParser.RIGHT_PAREN, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterMainFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitMainFunction(this);
		}
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mainFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(FUNC);
			setState(136);
			identifier();
			setState(137);
			match(LEFT_PAREN);
			setState(138);
			match(RIGHT_PAREN);
			setState(139);
			functionBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(declarationsParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(declarationsParser.BOOL, 0); }
		public TerminalNode FLOAT() { return getToken(declarationsParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(declarationsParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(declarationsParser.STRING, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitDataType(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014536016592960L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(declarationsParser.EQUALS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameter);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				dataType();
				setState(146);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				dataType();
				setState(149);
				identifier();
				{
				setState(150);
				match(EQUALS);
				setState(151);
				value();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(declarationsParser.STRING_LITERAL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				value();
				}
				break;
			case ALPHA:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				identifier();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(declarationsParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(declarationsParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(declarationsParser.PROTECTED, 0); }
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitAccessModifier(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SecondaryModifierContext extends ParserRuleContext {
		public TerminalNode VIRTUAL() { return getToken(declarationsParser.VIRTUAL, 0); }
		public TerminalNode ABSTRACT() { return getToken(declarationsParser.ABSTRACT, 0); }
		public TerminalNode OVERRIDE() { return getToken(declarationsParser.OVERRIDE, 0); }
		public SecondaryModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secondaryModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterSecondaryModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitSecondaryModifier(this);
		}
	}

	public final SecondaryModifierContext secondaryModifier() throws RecognitionException {
		SecondaryModifierContext _localctx = new SecondaryModifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_secondaryModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611694814520410116L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionModifierContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(declarationsParser.REPEAT, 0); }
		public TerminalNode DELAYED() { return getToken(declarationsParser.DELAYED, 0); }
		public TerminalNode ASYNC() { return getToken(declarationsParser.ASYNC, 0); }
		public FunctionModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterFunctionModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitFunctionModifier(this);
		}
	}

	public final FunctionModifierContext functionModifier() throws RecognitionException {
		FunctionModifierContext _localctx = new FunctionModifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899906908176L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public SecondaryModifierContext secondaryModifier() {
			return getRuleContext(SecondaryModifierContext.class,0);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_modifier);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				accessModifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				accessModifier();
				setState(168);
				secondaryModifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionReturnContext extends ParserRuleContext {
		public TerminalNode DELIM_FUNC_RETURN() { return getToken(declarationsParser.DELIM_FUNC_RETURN, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public FunctionReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterFunctionReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitFunctionReturn(this);
		}
	}

	public final FunctionReturnContext functionReturn() throws RecognitionException {
		FunctionReturnContext _localctx = new FunctionReturnContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(DELIM_FUNC_RETURN);
			setState(173);
			dataType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParametersContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(declarationsParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(declarationsParser.RIGHT_PAREN, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(declarationsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(declarationsParser.COMMA, i);
		}
		public FunctionParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitFunctionParameters(this);
		}
	}

	public final FunctionParametersContext functionParameters() throws RecognitionException {
		FunctionParametersContext _localctx = new FunctionParametersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(LEFT_PAREN);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014536016592960L) != 0)) {
				{
				setState(176);
				parameter();
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(177);
					match(COMMA);
					setState(178);
					parameter();
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(186);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleBodyContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(declarationsParser.RIGHT_BRACE, 0); }
		public List<ClassHeadingContext> classHeading() {
			return getRuleContexts(ClassHeadingContext.class);
		}
		public ClassHeadingContext classHeading(int i) {
			return getRuleContext(ClassHeadingContext.class,i);
		}
		public ModuleBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterModuleBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitModuleBody(this);
		}
	}

	public final ModuleBodyContext moduleBody() throws RecognitionException {
		ModuleBodyContext _localctx = new ModuleBodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(LEFT_BRACE);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(189);
				classHeading();
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleHeadingContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(declarationsParser.MODULE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ModuleBodyContext moduleBody() {
			return getRuleContext(ModuleBodyContext.class,0);
		}
		public ModuleHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterModuleHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitModuleHeading(this);
		}
	}

	public final ModuleHeadingContext moduleHeading() throws RecognitionException {
		ModuleHeadingContext _localctx = new ModuleHeadingContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_moduleHeading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(MODULE);
			setState(198);
			identifier();
			setState(199);
			moduleBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(declarationsParser.SEMICOLON, 0); }
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public TerminalNode OP_EQUALITY() { return getToken(declarationsParser.OP_EQUALITY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variableDeclaration);
		int _la;
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) {
					{
					setState(201);
					modifier();
					}
				}

				setState(204);
				dataType();
				setState(205);
				identifier();
				setState(206);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) {
					{
					setState(208);
					modifier();
					}
				}

				setState(211);
				dataType();
				setState(212);
				identifier();
				setState(213);
				match(OP_EQUALITY);
				setState(214);
				expression();
				setState(215);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LEFT_ANGLED_BRACKET() { return getToken(declarationsParser.LEFT_ANGLED_BRACKET, 0); }
		public TerminalNode RIGHT_ANGLED_BRACKET() { return getToken(declarationsParser.RIGHT_ANGLED_BRACKET, 0); }
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(declarationsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(declarationsParser.COMMA, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(LEFT_ANGLED_BRACKET);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014536016592960L) != 0)) {
				{
				setState(220);
				dataType();
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(221);
					match(COMMA);
					setState(222);
					dataType();
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(230);
			match(RIGHT_ANGLED_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecurLastParameterContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(declarationsParser.TIME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INT() { return getToken(declarationsParser.INT, 0); }
		public RecurLastParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recurLastParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterRecurLastParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitRecurLastParameter(this);
		}
	}

	public final RecurLastParameterContext recurLastParameter() throws RecognitionException {
		RecurLastParameterContext _localctx = new RecurLastParameterContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_recurLastParameter);
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(TIME);
				setState(233);
				identifier();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(INT);
				setState(235);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecurParametersContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(declarationsParser.LEFT_PAREN, 0); }
		public RecurLastParameterContext recurLastParameter() {
			return getRuleContext(RecurLastParameterContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(declarationsParser.RIGHT_PAREN, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(declarationsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(declarationsParser.COMMA, i);
		}
		public RecurParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recurParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterRecurParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitRecurParameters(this);
		}
	}

	public final RecurParametersContext recurParameters() throws RecognitionException {
		RecurParametersContext _localctx = new RecurParametersContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_recurParameters);
		int _la;
		try {
			int _alt;
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(LEFT_PAREN);
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(239);
					parameter();
					}
					}
					setState(242); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 18014536016592960L) != 0) );
				setState(246); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(244);
					match(COMMA);
					setState(245);
					parameter();
					}
					}
					setState(248); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(250);
				recurLastParameter();
				setState(251);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(LEFT_PAREN);
				setState(254);
				parameter();
				setState(257); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(255);
						match(COMMA);
						setState(256);
						parameter();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(259); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(261);
				match(COMMA);
				setState(262);
				recurLastParameter();
				setState(263);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecurHeadingContext extends ParserRuleContext {
		public TerminalNode RECUR() { return getToken(declarationsParser.RECUR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public RecurParametersContext recurParameters() {
			return getRuleContext(RecurParametersContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(declarationsParser.ASYNC, 0); }
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public FunctionReturnContext functionReturn() {
			return getRuleContext(FunctionReturnContext.class,0);
		}
		public RecurHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recurHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterRecurHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitRecurHeading(this);
		}
	}

	public final RecurHeadingContext recurHeading() throws RecognitionException {
		RecurHeadingContext _localctx = new RecurHeadingContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_recurHeading);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) {
				{
				setState(267);
				modifier();
				}
			}

			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(270);
				match(ASYNC);
				}
			}

			setState(273);
			match(RECUR);
			setState(274);
			identifier();
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_ANGLED_BRACKET) {
				{
				setState(275);
				typeParameters();
				}
			}

			setState(278);
			recurParameters();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DELIM_FUNC_RETURN) {
				{
				setState(279);
				functionReturn();
				}
			}

			setState(282);
			functionBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(284);
				expression();
				}
				}
				setState(287); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==STRING_LITERAL || _la==ALPHA );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(declarationsParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(declarationsParser.RIGHT_PAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			identifier();
			setState(290);
			match(LEFT_PAREN);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==STRING_LITERAL || _la==ALPHA) {
				{
				setState(291);
				arguments();
				}
			}

			setState(294);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructBodyContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(declarationsParser.RIGHT_BRACE, 0); }
		public StructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitStructBody(this);
		}
	}

	public final StructBodyContext structBody() throws RecognitionException {
		StructBodyContext _localctx = new StructBodyContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_structBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(LEFT_BRACE);
			setState(297);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructHeadingContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(declarationsParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StructBodyContext structBody() {
			return getRuleContext(StructBodyContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public StructHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterStructHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitStructHeading(this);
		}
	}

	public final StructHeadingContext structHeading() throws RecognitionException {
		StructHeadingContext _localctx = new StructHeadingContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_structHeading);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) {
				{
				setState(299);
				modifier();
				}
			}

			setState(302);
			match(STRUCT);
			setState(303);
			identifier();
			setState(304);
			structBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumBodyContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(declarationsParser.RIGHT_BRACE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(declarationsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(declarationsParser.COMMA, i);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitEnumBody(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(LEFT_BRACE);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHA) {
				{
				setState(307);
				identifier();
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(308);
					match(COMMA);
					setState(309);
					identifier();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(317);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumHeadingContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(declarationsParser.ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public EnumHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterEnumHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitEnumHeading(this);
		}
	}

	public final EnumHeadingContext enumHeading() throws RecognitionException {
		EnumHeadingContext _localctx = new EnumHeadingContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_enumHeading);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) {
				{
				setState(319);
				modifier();
				}
			}

			setState(322);
			match(ENUM);
			setState(323);
			identifier();
			setState(324);
			enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventBodyContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(declarationsParser.RIGHT_BRACE, 0); }
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public EventBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterEventBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitEventBody(this);
		}
	}

	public final EventBodyContext eventBody() throws RecognitionException {
		EventBodyContext _localctx = new EventBodyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_eventBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(LEFT_BRACE);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014536016592960L) != 0)) {
				{
				{
				setState(327);
				dataType();
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventHeadingContext extends ParserRuleContext {
		public TerminalNode EVENT() { return getToken(declarationsParser.EVENT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventBodyContext eventBody() {
			return getRuleContext(EventBodyContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public EventHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterEventHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitEventHeading(this);
		}
	}

	public final EventHeadingContext eventHeading() throws RecognitionException {
		EventHeadingContext _localctx = new EventHeadingContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_eventHeading);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) {
				{
				setState(335);
				modifier();
				}
			}

			setState(338);
			match(EVENT);
			setState(339);
			identifier();
			setState(340);
			eventBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyDeclarationsContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FunctionHeadingContext functionHeading() {
			return getRuleContext(FunctionHeadingContext.class,0);
		}
		public ClassHeadingContext classHeading() {
			return getRuleContext(ClassHeadingContext.class,0);
		}
		public StructHeadingContext structHeading() {
			return getRuleContext(StructHeadingContext.class,0);
		}
		public EnumHeadingContext enumHeading() {
			return getRuleContext(EnumHeadingContext.class,0);
		}
		public EventHeadingContext eventHeading() {
			return getRuleContext(EventHeadingContext.class,0);
		}
		public ClassBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterClassBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitClassBodyDeclarations(this);
		}
	}

	public final ClassBodyDeclarationsContext classBodyDeclarations() throws RecognitionException {
		ClassBodyDeclarationsContext _localctx = new ClassBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_classBodyDeclarations);
		try {
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				functionHeading();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				classHeading();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(345);
				structHeading();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(346);
				enumHeading();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(347);
				eventHeading();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceSignatureContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(declarationsParser.LEFT_BRACE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(declarationsParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(declarationsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(declarationsParser.COMMA, i);
		}
		public InterfaceSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterInterfaceSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitInterfaceSignature(this);
		}
	}

	public final InterfaceSignatureContext interfaceSignature() throws RecognitionException {
		InterfaceSignatureContext _localctx = new InterfaceSignatureContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_interfaceSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(LEFT_BRACE);
			setState(351);
			identifier();
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(352);
				match(COMMA);
				setState(353);
				identifier();
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(359);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(declarationsParser.ABSTRACT, 0); }
		public TerminalNode ALIAS() { return getToken(declarationsParser.ALIAS, 0); }
		public TerminalNode BASE() { return getToken(declarationsParser.BASE, 0); }
		public TerminalNode BOOL() { return getToken(declarationsParser.BOOL, 0); }
		public TerminalNode BREAK() { return getToken(declarationsParser.BREAK, 0); }
		public TerminalNode CASE() { return getToken(declarationsParser.CASE, 0); }
		public TerminalNode CATCH() { return getToken(declarationsParser.CATCH, 0); }
		public TerminalNode CHAR() { return getToken(declarationsParser.CHAR, 0); }
		public TerminalNode CLASS() { return getToken(declarationsParser.CLASS, 0); }
		public TerminalNode CONST() { return getToken(declarationsParser.CONST, 0); }
		public TerminalNode CONTINUE() { return getToken(declarationsParser.CONTINUE, 0); }
		public TerminalNode DEFAULT() { return getToken(declarationsParser.DEFAULT, 0); }
		public TerminalNode DICT() { return getToken(declarationsParser.DICT, 0); }
		public TerminalNode DO() { return getToken(declarationsParser.DO, 0); }
		public TerminalNode DOUBLE() { return getToken(declarationsParser.DOUBLE, 0); }
		public TerminalNode ELSE() { return getToken(declarationsParser.ELSE, 0); }
		public TerminalNode ENUM() { return getToken(declarationsParser.ENUM, 0); }
		public TerminalNode EVENT() { return getToken(declarationsParser.EVENT, 0); }
		public TerminalNode FALSE() { return getToken(declarationsParser.FALSE, 0); }
		public TerminalNode FLOAT() { return getToken(declarationsParser.FLOAT, 0); }
		public TerminalNode FOR() { return getToken(declarationsParser.FOR, 0); }
		public TerminalNode FOREACH() { return getToken(declarationsParser.FOREACH, 0); }
		public TerminalNode FORMAT() { return getToken(declarationsParser.FORMAT, 0); }
		public TerminalNode FORTIME() { return getToken(declarationsParser.FORTIME, 0); }
		public TerminalNode FROM() { return getToken(declarationsParser.FROM, 0); }
		public TerminalNode FUNC() { return getToken(declarationsParser.FUNC, 0); }
		public TerminalNode GET() { return getToken(declarationsParser.GET, 0); }
		public TerminalNode IF() { return getToken(declarationsParser.IF, 0); }
		public TerminalNode IMPORT() { return getToken(declarationsParser.IMPORT, 0); }
		public TerminalNode INHERIT() { return getToken(declarationsParser.INHERIT, 0); }
		public TerminalNode INT() { return getToken(declarationsParser.INT, 0); }
		public TerminalNode INTERFACE() { return getToken(declarationsParser.INTERFACE, 0); }
		public TerminalNode LIST() { return getToken(declarationsParser.LIST, 0); }
		public TerminalNode MILLISEC() { return getToken(declarationsParser.MILLISEC, 0); }
		public TerminalNode MODULE() { return getToken(declarationsParser.MODULE, 0); }
		public TerminalNode NULL() { return getToken(declarationsParser.NULL, 0); }
		public TerminalNode OVERRIDE() { return getToken(declarationsParser.OVERRIDE, 0); }
		public TerminalNode PRIVATE() { return getToken(declarationsParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(declarationsParser.PROTECTED, 0); }
		public TerminalNode PUBLIC() { return getToken(declarationsParser.PUBLIC, 0); }
		public TerminalNode RECUR() { return getToken(declarationsParser.RECUR, 0); }
		public TerminalNode REF() { return getToken(declarationsParser.REF, 0); }
		public TerminalNode RETURN() { return getToken(declarationsParser.RETURN, 0); }
		public TerminalNode SECOND() { return getToken(declarationsParser.SECOND, 0); }
		public TerminalNode SET() { return getToken(declarationsParser.SET, 0); }
		public TerminalNode STATIC() { return getToken(declarationsParser.STATIC, 0); }
		public TerminalNode STRING() { return getToken(declarationsParser.STRING, 0); }
		public TerminalNode STRUCT() { return getToken(declarationsParser.STRUCT, 0); }
		public TerminalNode SWITCH() { return getToken(declarationsParser.SWITCH, 0); }
		public TerminalNode THIS() { return getToken(declarationsParser.THIS, 0); }
		public TerminalNode THROW() { return getToken(declarationsParser.THROW, 0); }
		public TerminalNode TIME() { return getToken(declarationsParser.TIME, 0); }
		public TerminalNode TRUE() { return getToken(declarationsParser.TRUE, 0); }
		public TerminalNode TRY() { return getToken(declarationsParser.TRY, 0); }
		public TerminalNode VIRTUAL() { return getToken(declarationsParser.VIRTUAL, 0); }
		public TerminalNode VOID() { return getToken(declarationsParser.VOID, 0); }
		public TerminalNode WHILE() { return getToken(declarationsParser.WHILE, 0); }
		public TerminalNode WHERE() { return getToken(declarationsParser.WHERE, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if ( !(((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & -281474978891781L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_operator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TokenContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof declarationsListener ) ((declarationsListener)listener).exitToken(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_token);
		try {
			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				identifier();
				}
				break;
			case ABSTRACT:
			case ALIAS:
			case BASE:
			case BOOL:
			case BREAK:
			case CASE:
			case CATCH:
			case CHAR:
			case CLASS:
			case CONST:
			case CONTINUE:
			case DEFAULT:
			case DICT:
			case DO:
			case DOUBLE:
			case ELSE:
			case ENUM:
			case EVENT:
			case FALSE:
			case FLOAT:
			case FOR:
			case FOREACH:
			case FORMAT:
			case FORTIME:
			case FROM:
			case FUNC:
			case GET:
			case IF:
			case IMPORT:
			case INHERIT:
			case INT:
			case INTERFACE:
			case LIST:
			case MILLISEC:
			case MODULE:
			case NULL:
			case OVERRIDE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case RECUR:
			case REF:
			case RETURN:
			case SECOND:
			case SET:
			case STATIC:
			case STRING:
			case STRUCT:
			case SWITCH:
			case THIS:
			case THROW:
			case TIME:
			case TRUE:
			case TRY:
			case VIRTUAL:
			case VOID:
			case WHILE:
			case WHERE:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				keyword();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				operator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001S\u0173\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000W\b\u0000\u0001\u0001\u0004\u0001Z\b\u0001\u000b\u0001\f\u0001"+
		"[\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003e\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005y\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006~\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0086\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u009a\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u009f\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00ab\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00b4\b\u0012\n\u0012"+
		"\f\u0012\u00b7\t\u0012\u0003\u0012\u00b9\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u00bf\b\u0013\n\u0013\f\u0013\u00c2"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0003\u0015\u00cb\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00d2\b\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00da"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00e0"+
		"\b\u0016\n\u0016\f\u0016\u00e3\t\u0016\u0003\u0016\u00e5\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u00ed\b\u0017\u0001\u0018\u0001\u0018\u0004\u0018\u00f1\b\u0018"+
		"\u000b\u0018\f\u0018\u00f2\u0001\u0018\u0001\u0018\u0004\u0018\u00f7\b"+
		"\u0018\u000b\u0018\f\u0018\u00f8\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0004\u0018\u0102\b\u0018\u000b"+
		"\u0018\f\u0018\u0103\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u010a\b\u0018\u0001\u0019\u0003\u0019\u010d\b\u0019\u0001\u0019"+
		"\u0003\u0019\u0110\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u0115\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0119\b\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0004\u001a\u011e\b\u001a\u000b\u001a\f"+
		"\u001a\u011f\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0125\b\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0003\u001d\u012d\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0137\b\u001e"+
		"\n\u001e\f\u001e\u013a\t\u001e\u0003\u001e\u013c\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0003\u001f\u0141\b\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0005 \u0149\b \n \f \u014c\t \u0001"+
		" \u0001 \u0001!\u0003!\u0151\b!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u015d\b\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0005#\u0163\b#\n#\f#\u0166\t#\u0001#\u0001#\u0001$\u0001$\u0001"+
		"%\u0001%\u0001&\u0001&\u0001&\u0003&\u0171\b&\u0001&\u0000\u0000\'\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJL\u0000\u0005\u0005\u0000\u0006\u0006\u0014"+
		"\u0014\u001a\u001a%%66\u0001\u0000,.\u0003\u0000\u0002\u0002++>>\u0003"+
		"\u0000\u0004\u0004\u0010\u001022\u0007\u0000\u0002\u0003\u0005\f\u000e"+
		"\u000f\u0011\u0011\u0013\u0016\u001813A\u0177\u0000V\u0001\u0000\u0000"+
		"\u0000\u0002Y\u0001\u0000\u0000\u0000\u0004]\u0001\u0000\u0000\u0000\u0006"+
		"d\u0001\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\nx\u0001\u0000\u0000"+
		"\u0000\f}\u0001\u0000\u0000\u0000\u000e\u0085\u0001\u0000\u0000\u0000"+
		"\u0010\u0087\u0001\u0000\u0000\u0000\u0012\u008d\u0001\u0000\u0000\u0000"+
		"\u0014\u008f\u0001\u0000\u0000\u0000\u0016\u0099\u0001\u0000\u0000\u0000"+
		"\u0018\u009e\u0001\u0000\u0000\u0000\u001a\u00a0\u0001\u0000\u0000\u0000"+
		"\u001c\u00a2\u0001\u0000\u0000\u0000\u001e\u00a4\u0001\u0000\u0000\u0000"+
		" \u00aa\u0001\u0000\u0000\u0000\"\u00ac\u0001\u0000\u0000\u0000$\u00af"+
		"\u0001\u0000\u0000\u0000&\u00bc\u0001\u0000\u0000\u0000(\u00c5\u0001\u0000"+
		"\u0000\u0000*\u00d9\u0001\u0000\u0000\u0000,\u00db\u0001\u0000\u0000\u0000"+
		".\u00ec\u0001\u0000\u0000\u00000\u0109\u0001\u0000\u0000\u00002\u010c"+
		"\u0001\u0000\u0000\u00004\u011d\u0001\u0000\u0000\u00006\u0121\u0001\u0000"+
		"\u0000\u00008\u0128\u0001\u0000\u0000\u0000:\u012c\u0001\u0000\u0000\u0000"+
		"<\u0132\u0001\u0000\u0000\u0000>\u0140\u0001\u0000\u0000\u0000@\u0146"+
		"\u0001\u0000\u0000\u0000B\u0150\u0001\u0000\u0000\u0000D\u015c\u0001\u0000"+
		"\u0000\u0000F\u015e\u0001\u0000\u0000\u0000H\u0169\u0001\u0000\u0000\u0000"+
		"J\u016b\u0001\u0000\u0000\u0000L\u0170\u0001\u0000\u0000\u0000NO\u0005"+
		"\"\u0000\u0000OP\u0005\u0015\u0000\u0000PQ\u0005\"\u0000\u0000QR\u0005"+
		"\u0015\u0000\u0000RW\u0005N\u0000\u0000ST\u0005\"\u0000\u0000TU\u0005"+
		"\u0015\u0000\u0000UW\u0005N\u0000\u0000VN\u0001\u0000\u0000\u0000VS\u0001"+
		"\u0000\u0000\u0000W\u0001\u0001\u0000\u0000\u0000XZ\u0005S\u0000\u0000"+
		"YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\\u0003\u0001\u0000\u0000\u0000]^\u0003"+
		"\u0000\u0000\u0000^\u0005\u0001\u0000\u0000\u0000_e\u0003\u0004\u0002"+
		"\u0000`a\u0005H\u0000\u0000ab\u0003\u0004\u0002\u0000bc\u0005I\u0000\u0000"+
		"ce\u0001\u0000\u0000\u0000d_\u0001\u0000\u0000\u0000d`\u0001\u0000\u0000"+
		"\u0000e\u0007\u0001\u0000\u0000\u0000fg\u0005.\u0000\u0000gh\u0005\u000b"+
		"\u0000\u0000hi\u0003\u0002\u0001\u0000ij\u0005H\u0000\u0000jk\u0003\u0006"+
		"\u0003\u0000kl\u0005I\u0000\u0000l\t\u0001\u0000\u0000\u0000mn\u0005 "+
		"\u0000\u0000no\u0003\u0002\u0001\u0000op\u0003$\u0012\u0000pq\u0003\u000e"+
		"\u0007\u0000qy\u0001\u0000\u0000\u0000rs\u0005 \u0000\u0000st\u0003\u0002"+
		"\u0001\u0000tu\u0003$\u0012\u0000uv\u0003\"\u0011\u0000vw\u0003\u000e"+
		"\u0007\u0000wy\u0001\u0000\u0000\u0000xm\u0001\u0000\u0000\u0000xr\u0001"+
		"\u0000\u0000\u0000y\u000b\u0001\u0000\u0000\u0000z~\u0003\n\u0005\u0000"+
		"{~\u0003(\u0014\u0000|~\u0003\b\u0004\u0000}z\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000~\r\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0005H\u0000\u0000\u0080\u0086\u0005I\u0000\u0000\u0081"+
		"\u0082\u0005H\u0000\u0000\u0082\u0083\u0003\u0004\u0002\u0000\u0083\u0084"+
		"\u0005I\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u007f\u0001"+
		"\u0000\u0000\u0000\u0085\u0081\u0001\u0000\u0000\u0000\u0086\u000f\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005 \u0000\u0000\u0088\u0089\u0003\u0002"+
		"\u0001\u0000\u0089\u008a\u0005K\u0000\u0000\u008a\u008b\u0005L\u0000\u0000"+
		"\u008b\u008c\u0003\u000e\u0007\u0000\u008c\u0011\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005\u0001\u0000\u0000\u008e\u0013\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0007\u0000\u0000\u0000\u0090\u0015\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0003\u0014\n\u0000\u0092\u0093\u0003\u0002\u0001\u0000\u0093"+
		"\u009a\u0001\u0000\u0000\u0000\u0094\u0095\u0003\u0014\n\u0000\u0095\u0096"+
		"\u0003\u0002\u0001\u0000\u0096\u0097\u0005J\u0000\u0000\u0097\u0098\u0003"+
		"\u0012\t\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0091\u0001\u0000"+
		"\u0000\u0000\u0099\u0094\u0001\u0000\u0000\u0000\u009a\u0017\u0001\u0000"+
		"\u0000\u0000\u009b\u009f\u0003\u0012\t\u0000\u009c\u009f\u0003\u0002\u0001"+
		"\u0000\u009d\u009f\u0005R\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u0019\u0001\u0000\u0000\u0000\u00a0\u00a1\u0007\u0001\u0000\u0000"+
		"\u00a1\u001b\u0001\u0000\u0000\u0000\u00a2\u00a3\u0007\u0002\u0000\u0000"+
		"\u00a3\u001d\u0001\u0000\u0000\u0000\u00a4\u00a5\u0007\u0003\u0000\u0000"+
		"\u00a5\u001f\u0001\u0000\u0000\u0000\u00a6\u00ab\u0003\u001a\r\u0000\u00a7"+
		"\u00a8\u0003\u001a\r\u0000\u00a8\u00a9\u0003\u001c\u000e\u0000\u00a9\u00ab"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a6\u0001\u0000\u0000\u0000\u00aa\u00a7"+
		"\u0001\u0000\u0000\u0000\u00ab!\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005"+
		"M\u0000\u0000\u00ad\u00ae\u0003\u0014\n\u0000\u00ae#\u0001\u0000\u0000"+
		"\u0000\u00af\u00b8\u0005K\u0000\u0000\u00b0\u00b5\u0003\u0016\u000b\u0000"+
		"\u00b1\u00b2\u0005G\u0000\u0000\u00b2\u00b4\u0003\u0016\u000b\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005L\u0000\u0000\u00bb%\u0001"+
		"\u0000\u0000\u0000\u00bc\u00c0\u0005H\u0000\u0000\u00bd\u00bf\u0003\b"+
		"\u0004\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0005I\u0000\u0000\u00c4\'\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0005)\u0000\u0000\u00c6\u00c7\u0003\u0002\u0001\u0000"+
		"\u00c7\u00c8\u0003&\u0013\u0000\u00c8)\u0001\u0000\u0000\u0000\u00c9\u00cb"+
		"\u0003 \u0010\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd\u0003"+
		"\u0014\n\u0000\u00cd\u00ce\u0003\u0002\u0001\u0000\u00ce\u00cf\u0005N"+
		"\u0000\u0000\u00cf\u00da\u0001\u0000\u0000\u0000\u00d0\u00d2\u0003 \u0010"+
		"\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003\u0014\n\u0000"+
		"\u00d4\u00d5\u0003\u0002\u0001\u0000\u00d5\u00d6\u0005P\u0000\u0000\u00d6"+
		"\u00d7\u0003\u0018\f\u0000\u00d7\u00d8\u0005N\u0000\u0000\u00d8\u00da"+
		"\u0001\u0000\u0000\u0000\u00d9\u00ca\u0001\u0000\u0000\u0000\u00d9\u00d1"+
		"\u0001\u0000\u0000\u0000\u00da+\u0001\u0000\u0000\u0000\u00db\u00e4\u0005"+
		"B\u0000\u0000\u00dc\u00e1\u0003\u0014\n\u0000\u00dd\u00de\u0005G\u0000"+
		"\u0000\u00de\u00e0\u0003\u0014\n\u0000\u00df\u00dd\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00dc\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0005C\u0000\u0000\u00e7-\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0005;\u0000\u0000\u00e9\u00ed\u0003\u0002\u0001\u0000\u00ea\u00eb\u0005"+
		"%\u0000\u0000\u00eb\u00ed\u0003\u0002\u0001\u0000\u00ec\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed/\u0001\u0000\u0000"+
		"\u0000\u00ee\u00f0\u0005K\u0000\u0000\u00ef\u00f1\u0003\u0016\u000b\u0000"+
		"\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005G\u0000\u0000\u00f5"+
		"\u00f7\u0003\u0016\u000b\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0003.\u0017\u0000\u00fb\u00fc\u0005L\u0000\u0000\u00fc\u010a\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0005K\u0000\u0000\u00fe\u0101\u0003\u0016"+
		"\u000b\u0000\u00ff\u0100\u0005G\u0000\u0000\u0100\u0102\u0003\u0016\u000b"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000"+
		"\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0106\u0005G\u0000\u0000"+
		"\u0106\u0107\u0003.\u0017\u0000\u0107\u0108\u0005L\u0000\u0000\u0108\u010a"+
		"\u0001\u0000\u0000\u0000\u0109\u00ee\u0001\u0000\u0000\u0000\u0109\u00fd"+
		"\u0001\u0000\u0000\u0000\u010a1\u0001\u0000\u0000\u0000\u010b\u010d\u0003"+
		" \u0010\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u0110\u0005\u0004"+
		"\u0000\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0005/\u0000"+
		"\u0000\u0112\u0114\u0003\u0002\u0001\u0000\u0113\u0115\u0003,\u0016\u0000"+
		"\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u00030\u0018\u0000\u0117"+
		"\u0119\u0003\"\u0011\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0118\u0119"+
		"\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0003\u000e\u0007\u0000\u011b3\u0001\u0000\u0000\u0000\u011c\u011e\u0003"+
		"\u0018\f\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000"+
		"\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000"+
		"\u0000\u0000\u01205\u0001\u0000\u0000\u0000\u0121\u0122\u0003\u0002\u0001"+
		"\u0000\u0122\u0124\u0005K\u0000\u0000\u0123\u0125\u00034\u001a\u0000\u0124"+
		"\u0123\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125"+
		"\u0126\u0001\u0000\u0000\u0000\u0126\u0127\u0005L\u0000\u0000\u01277\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0005H\u0000\u0000\u0129\u012a\u0005I\u0000"+
		"\u0000\u012a9\u0001\u0000\u0000\u0000\u012b\u012d\u0003 \u0010\u0000\u012c"+
		"\u012b\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u00057\u0000\u0000\u012f\u0130"+
		"\u0003\u0002\u0001\u0000\u0130\u0131\u00038\u001c\u0000\u0131;\u0001\u0000"+
		"\u0000\u0000\u0132\u013b\u0005H\u0000\u0000\u0133\u0138\u0003\u0002\u0001"+
		"\u0000\u0134\u0135\u0005G\u0000\u0000\u0135\u0137\u0003\u0002\u0001\u0000"+
		"\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000"+
		"\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"+
		"\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000"+
		"\u013b\u0133\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000"+
		"\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0005I\u0000\u0000\u013e"+
		"=\u0001\u0000\u0000\u0000\u013f\u0141\u0003 \u0010\u0000\u0140\u013f\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142\u0001"+
		"\u0000\u0000\u0000\u0142\u0143\u0005\u0016\u0000\u0000\u0143\u0144\u0003"+
		"\u0002\u0001\u0000\u0144\u0145\u0003<\u001e\u0000\u0145?\u0001\u0000\u0000"+
		"\u0000\u0146\u014a\u0005H\u0000\u0000\u0147\u0149\u0003\u0014\n\u0000"+
		"\u0148\u0147\u0001\u0000\u0000\u0000\u0149\u014c\u0001\u0000\u0000\u0000"+
		"\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000"+
		"\u014b\u014d\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000"+
		"\u014d\u014e\u0005I\u0000\u0000\u014eA\u0001\u0000\u0000\u0000\u014f\u0151"+
		"\u0003 \u0010\u0000\u0150\u014f\u0001\u0000\u0000\u0000\u0150\u0151\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0153\u0005"+
		"\u0018\u0000\u0000\u0153\u0154\u0003\u0002\u0001\u0000\u0154\u0155\u0003"+
		"@ \u0000\u0155C\u0001\u0000\u0000\u0000\u0156\u015d\u0003*\u0015\u0000"+
		"\u0157\u015d\u0003\n\u0005\u0000\u0158\u015d\u0003\b\u0004\u0000\u0159"+
		"\u015d\u0003:\u001d\u0000\u015a\u015d\u0003>\u001f\u0000\u015b\u015d\u0003"+
		"B!\u0000\u015c\u0156\u0001\u0000\u0000\u0000\u015c\u0157\u0001\u0000\u0000"+
		"\u0000\u015c\u0158\u0001\u0000\u0000\u0000\u015c\u0159\u0001\u0000\u0000"+
		"\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015c\u015b\u0001\u0000\u0000"+
		"\u0000\u015dE\u0001\u0000\u0000\u0000\u015e\u015f\u0005H\u0000\u0000\u015f"+
		"\u0164\u0003\u0002\u0001\u0000\u0160\u0161\u0005G\u0000\u0000\u0161\u0163"+
		"\u0003\u0002\u0001\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0163\u0166"+
		"\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0164\u0165"+
		"\u0001\u0000\u0000\u0000\u0165\u0167\u0001\u0000\u0000\u0000\u0166\u0164"+
		"\u0001\u0000\u0000\u0000\u0167\u0168\u0005L\u0000\u0000\u0168G\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0007\u0004\u0000\u0000\u016aI\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016cK\u0001\u0000\u0000\u0000"+
		"\u016d\u0171\u0003\u0002\u0001\u0000\u016e\u0171\u0003H$\u0000\u016f\u0171"+
		"\u0003J%\u0000\u0170\u016d\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000"+
		"\u0000\u0000\u0170\u016f\u0001\u0000\u0000\u0000\u0171M\u0001\u0000\u0000"+
		"\u0000%V[dx}\u0085\u0099\u009e\u00aa\u00b5\u00b8\u00c0\u00ca\u00d1\u00d9"+
		"\u00e1\u00e4\u00ec\u00f2\u00f8\u0103\u0109\u010c\u010f\u0114\u0118\u011f"+
		"\u0124\u012c\u0138\u013b\u0140\u014a\u0150\u015c\u0164\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}