// Generated from d:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/boop/grammar/declarations.gn4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link declarationsParser}.
 */
public interface declarationsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link declarationsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(declarationsParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(declarationsParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(declarationsParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(declarationsParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(declarationsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(declarationsParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(declarationsParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(declarationsParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#classHeading}.
	 * @param ctx the parse tree
	 */
	void enterClassHeading(declarationsParser.ClassHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#classHeading}.
	 * @param ctx the parse tree
	 */
	void exitClassHeading(declarationsParser.ClassHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#functionHeading}.
	 * @param ctx the parse tree
	 */
	void enterFunctionHeading(declarationsParser.FunctionHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#functionHeading}.
	 * @param ctx the parse tree
	 */
	void exitFunctionHeading(declarationsParser.FunctionHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#programStatement}.
	 * @param ctx the parse tree
	 */
	void enterProgramStatement(declarationsParser.ProgramStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#programStatement}.
	 * @param ctx the parse tree
	 */
	void exitProgramStatement(declarationsParser.ProgramStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(declarationsParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(declarationsParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(declarationsParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(declarationsParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(declarationsParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(declarationsParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(declarationsParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(declarationsParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(declarationsParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(declarationsParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(declarationsParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(declarationsParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(declarationsParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(declarationsParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#secondaryModifier}.
	 * @param ctx the parse tree
	 */
	void enterSecondaryModifier(declarationsParser.SecondaryModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#secondaryModifier}.
	 * @param ctx the parse tree
	 */
	void exitSecondaryModifier(declarationsParser.SecondaryModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#functionModifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionModifier(declarationsParser.FunctionModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#functionModifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionModifier(declarationsParser.FunctionModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(declarationsParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(declarationsParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturn(declarationsParser.FunctionReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturn(declarationsParser.FunctionReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(declarationsParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(declarationsParser.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#moduleBody}.
	 * @param ctx the parse tree
	 */
	void enterModuleBody(declarationsParser.ModuleBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#moduleBody}.
	 * @param ctx the parse tree
	 */
	void exitModuleBody(declarationsParser.ModuleBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#moduleHeading}.
	 * @param ctx the parse tree
	 */
	void enterModuleHeading(declarationsParser.ModuleHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#moduleHeading}.
	 * @param ctx the parse tree
	 */
	void exitModuleHeading(declarationsParser.ModuleHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(declarationsParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(declarationsParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(declarationsParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(declarationsParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#recurLastParameter}.
	 * @param ctx the parse tree
	 */
	void enterRecurLastParameter(declarationsParser.RecurLastParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#recurLastParameter}.
	 * @param ctx the parse tree
	 */
	void exitRecurLastParameter(declarationsParser.RecurLastParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#recurParameters}.
	 * @param ctx the parse tree
	 */
	void enterRecurParameters(declarationsParser.RecurParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#recurParameters}.
	 * @param ctx the parse tree
	 */
	void exitRecurParameters(declarationsParser.RecurParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#recurHeading}.
	 * @param ctx the parse tree
	 */
	void enterRecurHeading(declarationsParser.RecurHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#recurHeading}.
	 * @param ctx the parse tree
	 */
	void exitRecurHeading(declarationsParser.RecurHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(declarationsParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(declarationsParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(declarationsParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(declarationsParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#structBody}.
	 * @param ctx the parse tree
	 */
	void enterStructBody(declarationsParser.StructBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#structBody}.
	 * @param ctx the parse tree
	 */
	void exitStructBody(declarationsParser.StructBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#structHeading}.
	 * @param ctx the parse tree
	 */
	void enterStructHeading(declarationsParser.StructHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#structHeading}.
	 * @param ctx the parse tree
	 */
	void exitStructHeading(declarationsParser.StructHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(declarationsParser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(declarationsParser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#enumHeading}.
	 * @param ctx the parse tree
	 */
	void enterEnumHeading(declarationsParser.EnumHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#enumHeading}.
	 * @param ctx the parse tree
	 */
	void exitEnumHeading(declarationsParser.EnumHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#eventBody}.
	 * @param ctx the parse tree
	 */
	void enterEventBody(declarationsParser.EventBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#eventBody}.
	 * @param ctx the parse tree
	 */
	void exitEventBody(declarationsParser.EventBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#eventHeading}.
	 * @param ctx the parse tree
	 */
	void enterEventHeading(declarationsParser.EventHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#eventHeading}.
	 * @param ctx the parse tree
	 */
	void exitEventHeading(declarationsParser.EventHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#classBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclarations(declarationsParser.ClassBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#classBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclarations(declarationsParser.ClassBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#interfaceSignature}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceSignature(declarationsParser.InterfaceSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#interfaceSignature}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceSignature(declarationsParser.InterfaceSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(declarationsParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(declarationsParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(declarationsParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(declarationsParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link declarationsParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(declarationsParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link declarationsParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(declarationsParser.TokenContext ctx);
}