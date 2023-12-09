// Generated from d:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/boop.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class boopParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LOWER=2, UPPER=3, DIGIT=4, SPECIAL=5, MATH=6, ABSTRACT=7, ALIAS=8, 
		BASE=9, BOOL=10, BREAK=11, CASE=12, CATCH=13, CHAR=14, CLASS=15, CONST=16, 
		CONSTANT=17, CONTINUE=18, DEFAULT=19, DICT=20, DICTIONARY=21, DO=22, DOUBLE=23, 
		ELSE=24, ENUM=25, ENUMERATION=26, EVENT=27, FALSE=28, FLOAT=29, FOR=30, 
		FOREACH=31, FORMAT=32, FOR_TIME=33, FROM=34, FUNC=35, GET=36, IF=37, IMPORT=38, 
		INHERIT=39, INT=40, INTERFACE=41, LIST=42, MILLISEC=43, MODULE=44, NULL=45, 
		OVERRIDE=46, PRIVATE=47, PROTECTED=48, PUBLIC=49, RECUR=50, REF=51, RETURN=52, 
		SECOND=53, SET=54, STATIC=55, STRING=56, STRUCT=57, SWITCH=58, THIS=59, 
		THROW=60, TIME=61, TRUE=62, TRY=63, VIRTUAL=64, VOID=65, WHILE=66, WHERE=67, 
		ANGLD_L=68, ANGLD_R=69, BRCKT_L=70, BRCKT_R=71, COLON=72, COMMA=73, CURLY_L=74, 
		CURLY_R=75, EQUALS=76, PAREN_L=77, PAREN_R=78, RET_TYPE=79, SEMICOLON=80, 
		END_STMNT=81, UNDERSCORE=82, OP_EQUALITY=83, INHERITS=84, CHARACTER=85, 
		Identifier_Start_Character=86, Identifier_Character=87;
	public static final int
		RULE_identifier = 0, RULE_modifiers = 1, RULE_access_modifier = 2, RULE_data_primitive = 3, 
		RULE_data_ref = 4, RULE_dataType = 5, RULE_value = 6, RULE_constant = 7, 
		RULE_varDeclaration = 8, RULE_statement = 9, RULE_expression = 10, RULE_block = 11, 
		RULE_functionParam = 12, RULE_functionParams = 13, RULE_functionBody = 14, 
		RULE_typeParameters = 15, RULE_functionHeading = 16, RULE_functionArgs = 17, 
		RULE_functionCall = 18, RULE_classBody = 19, RULE_classHeading = 20, RULE_interfaceSignature = 21, 
		RULE_moduleBody = 22, RULE_moduleHeading = 23, RULE_keyword = 24, RULE_operator = 25, 
		RULE_token = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier", "modifiers", "access_modifier", "data_primitive", "data_ref", 
			"dataType", "value", "constant", "varDeclaration", "statement", "expression", 
			"block", "functionParam", "functionParams", "functionBody", "typeParameters", 
			"functionHeading", "functionArgs", "functionCall", "classBody", "classHeading", 
			"interfaceSignature", "moduleBody", "moduleHeading", "keyword", "operator", 
			"token"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'s'", null, null, null, null, "'\\u00E2\\u02C6\\u0161'", "'abstract'", 
			"'alias'", "'base'", "'bool'", "'break'", "'case'", "'catch'", "'char'", 
			"'class'", "'const'", "'constant'", "'continue'", "'default'", "'dict'", 
			"'dictionary'", "'do'", "'double'", "'else'", "'enum'", "'enumeration'", 
			"'event'", "'false'", "'float'", "'for'", "'foreach'", "'format'", "'fortime'", 
			"'from'", "'func'", "'get'", "'if'", "'import'", "'inherit'", "'int'", 
			"'interface'", "'list'", "'millisec'", "'module'", "'null'", "'override'", 
			"'private'", "'protected'", "'public'", "'recur'", "'ref'", "'return'", 
			"'second'", "'set'", "'static'", "'string'", "'struct'", "'switch'", 
			"'this'", "'throw'", "'time'", "'true'", "'try'", "'virtual'", "'void'", 
			"'while'", "'where'", "'<'", "'>'", "'['", "']'", "':'", "','", "'{'", 
			"'}'", "'='", "'('", "')'", "'->'", "';'", null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "LOWER", "UPPER", "DIGIT", "SPECIAL", "MATH", "ABSTRACT", 
			"ALIAS", "BASE", "BOOL", "BREAK", "CASE", "CATCH", "CHAR", "CLASS", "CONST", 
			"CONSTANT", "CONTINUE", "DEFAULT", "DICT", "DICTIONARY", "DO", "DOUBLE", 
			"ELSE", "ENUM", "ENUMERATION", "EVENT", "FALSE", "FLOAT", "FOR", "FOREACH", 
			"FORMAT", "FOR_TIME", "FROM", "FUNC", "GET", "IF", "IMPORT", "INHERIT", 
			"INT", "INTERFACE", "LIST", "MILLISEC", "MODULE", "NULL", "OVERRIDE", 
			"PRIVATE", "PROTECTED", "PUBLIC", "RECUR", "REF", "RETURN", "SECOND", 
			"SET", "STATIC", "STRING", "STRUCT", "SWITCH", "THIS", "THROW", "TIME", 
			"TRUE", "TRY", "VIRTUAL", "VOID", "WHILE", "WHERE", "ANGLD_L", "ANGLD_R", 
			"BRCKT_L", "BRCKT_R", "COLON", "COMMA", "CURLY_L", "CURLY_R", "EQUALS", 
			"PAREN_L", "PAREN_R", "RET_TYPE", "SEMICOLON", "END_STMNT", "UNDERSCORE", 
			"OP_EQUALITY", "INHERITS", "CHARACTER", "Identifier_Start_Character", 
			"Identifier_Character"
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
	public String getGrammarFileName() { return "boop.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public boopParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier_Start_Character() { return getToken(boopParser.Identifier_Start_Character, 0); }
		public List<TerminalNode> Identifier_Character() { return getTokens(boopParser.Identifier_Character); }
		public TerminalNode Identifier_Character(int i) {
			return getToken(boopParser.Identifier_Character, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(Identifier_Start_Character);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier_Character) {
				{
				{
				setState(55);
				match(Identifier_Character);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class ModifiersContext extends ParserRuleContext {
		public List<Access_modifierContext> access_modifier() {
			return getRuleContexts(Access_modifierContext.class);
		}
		public Access_modifierContext access_modifier(int i) {
			return getRuleContext(Access_modifierContext.class,i);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_modifiers);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				access_modifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				access_modifier();
				setState(63);
				access_modifier();
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
	public static class Access_modifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(boopParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(boopParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(boopParser.PROTECTED, 0); }
		public Access_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_modifier; }
	}

	public final Access_modifierContext access_modifier() throws RecognitionException {
		Access_modifierContext _localctx = new Access_modifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_access_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) ) {
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
	public static class Data_primitiveContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(boopParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(boopParser.CHAR, 0); }
		public TerminalNode FLOAT() { return getToken(boopParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(boopParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(boopParser.STRING, 0); }
		public Data_primitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_primitive; }
	}

	public final Data_primitiveContext data_primitive() throws RecognitionException {
		Data_primitiveContext _localctx = new Data_primitiveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data_primitive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 72058694094831616L) != 0)) ) {
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
	public static class Data_refContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Data_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_ref; }
	}

	public final Data_refContext data_ref() throws RecognitionException {
		Data_refContext _localctx = new Data_refContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_data_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			identifier();
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
		public Data_primitiveContext data_primitive() {
			return getRuleContext(Data_primitiveContext.class,0);
		}
		public Data_refContext data_ref() {
			return getRuleContext(Data_refContext.class,0);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dataType);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				data_primitive();
				}
				break;
			case Identifier_Start_Character:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				data_ref();
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
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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
	public static class ConstantContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			value();
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
	public static class VarDeclarationContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode END_STMNT() { return getToken(boopParser.END_STMNT, 0); }
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode OP_EQUALITY() { return getToken(boopParser.OP_EQUALITY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDeclaration);
		int _la;
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) {
					{
					setState(81);
					modifiers();
					}
				}

				setState(84);
				dataType();
				setState(85);
				identifier();
				setState(86);
				match(END_STMNT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) {
					{
					setState(88);
					modifiers();
					}
				}

				setState(91);
				dataType();
				setState(92);
				identifier();
				setState(93);
				match(OP_EQUALITY);
				setState(94);
				expression();
				setState(95);
				match(END_STMNT);
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
	public static class StatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				expression();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==Identifier_Start_Character );
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
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				constant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				functionCall();
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
	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
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
	public static class FunctionParamContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			dataType();
			setState(112);
			identifier();
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
	public static class FunctionParamsContext extends ParserRuleContext {
		public List<FunctionParamContext> functionParam() {
			return getRuleContexts(FunctionParamContext.class);
		}
		public FunctionParamContext functionParam(int i) {
			return getRuleContext(FunctionParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(boopParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(boopParser.COMMA, i);
		}
		public FunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParams; }
	}

	public final FunctionParamsContext functionParams() throws RecognitionException {
		FunctionParamsContext _localctx = new FunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			functionParam();
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				match(COMMA);
				setState(116);
				functionParam();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
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
		public TerminalNode CURLY_L() { return getToken(boopParser.CURLY_L, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CURLY_R() { return getToken(boopParser.CURLY_R, 0); }
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(CURLY_L);
			setState(122);
			block();
			setState(123);
			match(CURLY_R);
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
		public TerminalNode ANGLD_L() { return getToken(boopParser.ANGLD_L, 0); }
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public TerminalNode ANGLD_R() { return getToken(boopParser.ANGLD_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(boopParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(boopParser.COMMA, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ANGLD_L);
			setState(126);
			dataType();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(127);
				match(COMMA);
				setState(128);
				dataType();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			match(ANGLD_R);
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
		public TerminalNode FUNC() { return getToken(boopParser.FUNC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public FunctionParamsContext functionParams() {
			return getRuleContext(FunctionParamsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public FunctionHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionHeading; }
	}

	public final FunctionHeadingContext functionHeading() throws RecognitionException {
		FunctionHeadingContext _localctx = new FunctionHeadingContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionHeading);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) {
				{
				setState(136);
				modifiers();
				}
			}

			setState(139);
			match(FUNC);
			setState(140);
			identifier();
			setState(141);
			typeParameters();
			setState(142);
			functionParams();
			setState(143);
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
	public static class FunctionArgsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(145);
				expression();
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==Identifier_Start_Character );
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
		public TerminalNode PAREN_L() { return getToken(boopParser.PAREN_L, 0); }
		public TerminalNode PAREN_R() { return getToken(boopParser.PAREN_R, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			identifier();
			setState(151);
			match(PAREN_L);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==Identifier_Start_Character) {
				{
				setState(152);
				functionArgs();
				}
			}

			setState(155);
			match(PAREN_R);
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
		public TerminalNode CURLY_L() { return getToken(boopParser.CURLY_L, 0); }
		public TerminalNode CURLY_R() { return getToken(boopParser.CURLY_R, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(CURLY_L);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 73043856513318912L) != 0) || _la==Identifier_Start_Character) {
				{
				{
				setState(158);
				varDeclaration();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			match(CURLY_R);
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
		public TerminalNode CLASS() { return getToken(boopParser.CLASS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode INHERITS() { return getToken(boopParser.INHERITS, 0); }
		public InterfaceSignatureContext interfaceSignature() {
			return getRuleContext(InterfaceSignatureContext.class,0);
		}
		public ClassHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHeading; }
	}

	public final ClassHeadingContext classHeading() throws RecognitionException {
		ClassHeadingContext _localctx = new ClassHeadingContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classHeading);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) {
				{
				setState(166);
				modifiers();
				}
			}

			setState(169);
			match(CLASS);
			setState(170);
			identifier();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(171);
				match(INHERITS);
				setState(172);
				identifier();
				}
			}

			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PAREN_L) {
				{
				setState(175);
				interfaceSignature();
				}
			}

			setState(178);
			classBody();
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
		public TerminalNode PAREN_L() { return getToken(boopParser.PAREN_L, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode PAREN_R() { return getToken(boopParser.PAREN_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(boopParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(boopParser.COMMA, i);
		}
		public InterfaceSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceSignature; }
	}

	public final InterfaceSignatureContext interfaceSignature() throws RecognitionException {
		InterfaceSignatureContext _localctx = new InterfaceSignatureContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_interfaceSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(PAREN_L);
			setState(181);
			identifier();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(182);
				match(COMMA);
				setState(183);
				identifier();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
			match(PAREN_R);
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
		public TerminalNode CURLY_L() { return getToken(boopParser.CURLY_L, 0); }
		public TerminalNode CURLY_R() { return getToken(boopParser.CURLY_R, 0); }
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
	}

	public final ModuleBodyContext moduleBody() throws RecognitionException {
		ModuleBodyContext _localctx = new ModuleBodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(CURLY_L);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418520064L) != 0)) {
				{
				{
				setState(192);
				classHeading();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			match(CURLY_R);
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
		public TerminalNode MODULE() { return getToken(boopParser.MODULE, 0); }
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
	}

	public final ModuleHeadingContext moduleHeading() throws RecognitionException {
		ModuleHeadingContext _localctx = new ModuleHeadingContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_moduleHeading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(MODULE);
			setState(201);
			identifier();
			setState(202);
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
	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(boopParser.ABSTRACT, 0); }
		public TerminalNode ALIAS() { return getToken(boopParser.ALIAS, 0); }
		public TerminalNode BASE() { return getToken(boopParser.BASE, 0); }
		public TerminalNode BOOL() { return getToken(boopParser.BOOL, 0); }
		public TerminalNode BREAK() { return getToken(boopParser.BREAK, 0); }
		public TerminalNode CASE() { return getToken(boopParser.CASE, 0); }
		public TerminalNode CATCH() { return getToken(boopParser.CATCH, 0); }
		public TerminalNode CHAR() { return getToken(boopParser.CHAR, 0); }
		public TerminalNode CLASS() { return getToken(boopParser.CLASS, 0); }
		public TerminalNode CONST() { return getToken(boopParser.CONST, 0); }
		public TerminalNode CONSTANT() { return getToken(boopParser.CONSTANT, 0); }
		public TerminalNode CONTINUE() { return getToken(boopParser.CONTINUE, 0); }
		public TerminalNode DEFAULT() { return getToken(boopParser.DEFAULT, 0); }
		public TerminalNode DICT() { return getToken(boopParser.DICT, 0); }
		public TerminalNode DICTIONARY() { return getToken(boopParser.DICTIONARY, 0); }
		public TerminalNode DO() { return getToken(boopParser.DO, 0); }
		public TerminalNode DOUBLE() { return getToken(boopParser.DOUBLE, 0); }
		public TerminalNode ELSE() { return getToken(boopParser.ELSE, 0); }
		public TerminalNode ENUM() { return getToken(boopParser.ENUM, 0); }
		public TerminalNode ENUMERATION() { return getToken(boopParser.ENUMERATION, 0); }
		public TerminalNode EVENT() { return getToken(boopParser.EVENT, 0); }
		public TerminalNode FALSE() { return getToken(boopParser.FALSE, 0); }
		public TerminalNode FLOAT() { return getToken(boopParser.FLOAT, 0); }
		public TerminalNode FOR() { return getToken(boopParser.FOR, 0); }
		public TerminalNode FOREACH() { return getToken(boopParser.FOREACH, 0); }
		public TerminalNode FORMAT() { return getToken(boopParser.FORMAT, 0); }
		public TerminalNode FOR_TIME() { return getToken(boopParser.FOR_TIME, 0); }
		public TerminalNode FROM() { return getToken(boopParser.FROM, 0); }
		public TerminalNode FUNC() { return getToken(boopParser.FUNC, 0); }
		public TerminalNode GET() { return getToken(boopParser.GET, 0); }
		public TerminalNode IF() { return getToken(boopParser.IF, 0); }
		public TerminalNode IMPORT() { return getToken(boopParser.IMPORT, 0); }
		public TerminalNode INHERIT() { return getToken(boopParser.INHERIT, 0); }
		public TerminalNode INT() { return getToken(boopParser.INT, 0); }
		public TerminalNode INTERFACE() { return getToken(boopParser.INTERFACE, 0); }
		public TerminalNode LIST() { return getToken(boopParser.LIST, 0); }
		public TerminalNode MILLISEC() { return getToken(boopParser.MILLISEC, 0); }
		public TerminalNode MODULE() { return getToken(boopParser.MODULE, 0); }
		public TerminalNode NULL() { return getToken(boopParser.NULL, 0); }
		public TerminalNode OVERRIDE() { return getToken(boopParser.OVERRIDE, 0); }
		public TerminalNode PRIVATE() { return getToken(boopParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(boopParser.PROTECTED, 0); }
		public TerminalNode PUBLIC() { return getToken(boopParser.PUBLIC, 0); }
		public TerminalNode RECUR() { return getToken(boopParser.RECUR, 0); }
		public TerminalNode REF() { return getToken(boopParser.REF, 0); }
		public TerminalNode RETURN() { return getToken(boopParser.RETURN, 0); }
		public TerminalNode SECOND() { return getToken(boopParser.SECOND, 0); }
		public TerminalNode SET() { return getToken(boopParser.SET, 0); }
		public TerminalNode STATIC() { return getToken(boopParser.STATIC, 0); }
		public TerminalNode STRING() { return getToken(boopParser.STRING, 0); }
		public TerminalNode STRUCT() { return getToken(boopParser.STRUCT, 0); }
		public TerminalNode SWITCH() { return getToken(boopParser.SWITCH, 0); }
		public TerminalNode THIS() { return getToken(boopParser.THIS, 0); }
		public TerminalNode THROW() { return getToken(boopParser.THROW, 0); }
		public TerminalNode TIME() { return getToken(boopParser.TIME, 0); }
		public TerminalNode TRUE() { return getToken(boopParser.TRUE, 0); }
		public TerminalNode TRY() { return getToken(boopParser.TRY, 0); }
		public TerminalNode VIRTUAL() { return getToken(boopParser.VIRTUAL, 0); }
		public TerminalNode VOID() { return getToken(boopParser.VOID, 0); }
		public TerminalNode WHILE() { return getToken(boopParser.WHILE, 0); }
		public TerminalNode WHERE() { return getToken(boopParser.WHERE, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !(((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 2305843009213693951L) != 0)) ) {
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
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_operator);
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
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_token);
		try {
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier_Start_Character:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
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
			case CONSTANT:
			case CONTINUE:
			case DEFAULT:
			case DICT:
			case DICTIONARY:
			case DO:
			case DOUBLE:
			case ELSE:
			case ENUM:
			case ENUMERATION:
			case EVENT:
			case FALSE:
			case FLOAT:
			case FOR:
			case FOREACH:
			case FORMAT:
			case FOR_TIME:
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
				setState(209);
				keyword();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
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
		"\u0004\u0001W\u00d6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0005\u00009\b\u0000\n\u0000\f\u0000<\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001B\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0003\u0005L\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0003\bS\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"Z\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bb\b\b\u0001"+
		"\t\u0004\te\b\t\u000b\t\f\tf\u0001\n\u0001\n\u0001\n\u0003\nl\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0004"+
		"\rv\b\r\u000b\r\f\rw\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0082\b\u000f\n"+
		"\u000f\f\u000f\u0085\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0003"+
		"\u0010\u008a\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0004\u0011\u0093\b\u0011\u000b\u0011\f"+
		"\u0011\u0094\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u009a\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0005\u0013\u00a0\b\u0013"+
		"\n\u0013\f\u0013\u00a3\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0003"+
		"\u0014\u00a8\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00ae\b\u0014\u0001\u0014\u0003\u0014\u00b1\b\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u00b9\b\u0015\n\u0015\f\u0015\u00bc\t\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u00c2\b\u0016\n\u0016\f\u0016\u00c5\t\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u00d4\b\u001a\u0001\u001a\u0000\u0000\u001b\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.024\u0000\u0003\u0001\u0000/1\u0005\u0000\u000e\u000e\u0017"+
		"\u0017\u001d\u001d((88\u0001\u0000\u0007C\u00d0\u00006\u0001\u0000\u0000"+
		"\u0000\u0002A\u0001\u0000\u0000\u0000\u0004C\u0001\u0000\u0000\u0000\u0006"+
		"E\u0001\u0000\u0000\u0000\bG\u0001\u0000\u0000\u0000\nK\u0001\u0000\u0000"+
		"\u0000\fM\u0001\u0000\u0000\u0000\u000eO\u0001\u0000\u0000\u0000\u0010"+
		"a\u0001\u0000\u0000\u0000\u0012d\u0001\u0000\u0000\u0000\u0014k\u0001"+
		"\u0000\u0000\u0000\u0016m\u0001\u0000\u0000\u0000\u0018o\u0001\u0000\u0000"+
		"\u0000\u001ar\u0001\u0000\u0000\u0000\u001cy\u0001\u0000\u0000\u0000\u001e"+
		"}\u0001\u0000\u0000\u0000 \u0089\u0001\u0000\u0000\u0000\"\u0092\u0001"+
		"\u0000\u0000\u0000$\u0096\u0001\u0000\u0000\u0000&\u009d\u0001\u0000\u0000"+
		"\u0000(\u00a7\u0001\u0000\u0000\u0000*\u00b4\u0001\u0000\u0000\u0000,"+
		"\u00bf\u0001\u0000\u0000\u0000.\u00c8\u0001\u0000\u0000\u00000\u00cc\u0001"+
		"\u0000\u0000\u00002\u00ce\u0001\u0000\u0000\u00004\u00d3\u0001\u0000\u0000"+
		"\u00006:\u0005V\u0000\u000079\u0005W\u0000\u000087\u0001\u0000\u0000\u0000"+
		"9<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;\u0001\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=B\u0003"+
		"\u0004\u0002\u0000>?\u0003\u0004\u0002\u0000?@\u0003\u0004\u0002\u0000"+
		"@B\u0001\u0000\u0000\u0000A=\u0001\u0000\u0000\u0000A>\u0001\u0000\u0000"+
		"\u0000B\u0003\u0001\u0000\u0000\u0000CD\u0007\u0000\u0000\u0000D\u0005"+
		"\u0001\u0000\u0000\u0000EF\u0007\u0001\u0000\u0000F\u0007\u0001\u0000"+
		"\u0000\u0000GH\u0003\u0000\u0000\u0000H\t\u0001\u0000\u0000\u0000IL\u0003"+
		"\u0006\u0003\u0000JL\u0003\b\u0004\u0000KI\u0001\u0000\u0000\u0000KJ\u0001"+
		"\u0000\u0000\u0000L\u000b\u0001\u0000\u0000\u0000MN\u0005\u0001\u0000"+
		"\u0000N\r\u0001\u0000\u0000\u0000OP\u0003\f\u0006\u0000P\u000f\u0001\u0000"+
		"\u0000\u0000QS\u0003\u0002\u0001\u0000RQ\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0003\n\u0005\u0000UV\u0003"+
		"\u0000\u0000\u0000VW\u0005Q\u0000\u0000Wb\u0001\u0000\u0000\u0000XZ\u0003"+
		"\u0002\u0001\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[\\\u0003\n\u0005\u0000\\]\u0003\u0000\u0000"+
		"\u0000]^\u0005S\u0000\u0000^_\u0003\u0014\n\u0000_`\u0005Q\u0000\u0000"+
		"`b\u0001\u0000\u0000\u0000aR\u0001\u0000\u0000\u0000aY\u0001\u0000\u0000"+
		"\u0000b\u0011\u0001\u0000\u0000\u0000ce\u0003\u0014\n\u0000dc\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000g\u0013\u0001\u0000\u0000\u0000hl\u0003\u000e\u0007"+
		"\u0000il\u0003\u0000\u0000\u0000jl\u0003$\u0012\u0000kh\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000l\u0015\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0017\u0001\u0000\u0000"+
		"\u0000op\u0003\n\u0005\u0000pq\u0003\u0000\u0000\u0000q\u0019\u0001\u0000"+
		"\u0000\u0000ru\u0003\u0018\f\u0000st\u0005I\u0000\u0000tv\u0003\u0018"+
		"\f\u0000us\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\u001b\u0001\u0000\u0000\u0000"+
		"yz\u0005J\u0000\u0000z{\u0003\u0016\u000b\u0000{|\u0005K\u0000\u0000|"+
		"\u001d\u0001\u0000\u0000\u0000}~\u0005D\u0000\u0000~\u0083\u0003\n\u0005"+
		"\u0000\u007f\u0080\u0005I\u0000\u0000\u0080\u0082\u0003\n\u0005\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000"+
		"\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000"+
		"\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005E\u0000\u0000\u0087\u001f\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0003\u0002\u0001\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0005#\u0000\u0000\u008c\u008d\u0003\u0000\u0000\u0000\u008d\u008e"+
		"\u0003\u001e\u000f\u0000\u008e\u008f\u0003\u001a\r\u0000\u008f\u0090\u0003"+
		"\u001c\u000e\u0000\u0090!\u0001\u0000\u0000\u0000\u0091\u0093\u0003\u0014"+
		"\n\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u0095#\u0001\u0000\u0000\u0000\u0096\u0097\u0003\u0000\u0000\u0000"+
		"\u0097\u0099\u0005M\u0000\u0000\u0098\u009a\u0003\"\u0011\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0005N\u0000\u0000\u009c%\u0001"+
		"\u0000\u0000\u0000\u009d\u00a1\u0005J\u0000\u0000\u009e\u00a0\u0003\u0010"+
		"\b\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005K\u0000\u0000\u00a5\'\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a8\u0003\u0002\u0001\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0005\u000f\u0000\u0000\u00aa\u00ad\u0003\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005T\u0000\u0000\u00ac\u00ae\u0003\u0000\u0000\u0000\u00ad"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00b0\u0001\u0000\u0000\u0000\u00af\u00b1\u0003*\u0015\u0000\u00b0\u00af"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003&\u0013\u0000\u00b3)\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0005M\u0000\u0000\u00b5\u00ba\u0003\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0005I\u0000\u0000\u00b7\u00b9\u0003\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005N\u0000\u0000\u00be+\u0001\u0000\u0000\u0000\u00bf\u00c3"+
		"\u0005J\u0000\u0000\u00c0\u00c2\u0003(\u0014\u0000\u00c1\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005K\u0000"+
		"\u0000\u00c7-\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005,\u0000\u0000\u00c9"+
		"\u00ca\u0003\u0000\u0000\u0000\u00ca\u00cb\u0003,\u0016\u0000\u00cb/\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0007\u0002\u0000\u0000\u00cd1\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf3\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d4\u0003\u0000\u0000\u0000\u00d1\u00d4\u00030\u0018\u0000"+
		"\u00d2\u00d4\u00032\u0019\u0000\u00d3\u00d0\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4"+
		"5\u0001\u0000\u0000\u0000\u0014:AKRYafkw\u0083\u0089\u0094\u0099\u00a1"+
		"\u00a7\u00ad\u00b0\u00ba\u00c3\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}