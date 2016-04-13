// Generated from /home/diegorocha/Documents/MC911/src/main/java/br/unicamp/ic/mc911/lya/grammar/Lya.g4 by ANTLR 4.5.1
package br.unicamp.ic.mc911.lya.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LyaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LyaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LyaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LyaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LyaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#declaration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_statement(LyaParser.Declaration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_list(LyaParser.Declaration_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LyaParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#initialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialization(LyaParser.InitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#identifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_list(LyaParser.Identifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#synonym_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynonym_statement(LyaParser.Synonym_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#synonym_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynonym_list(LyaParser.Synonym_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#synonym_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynonym_definition(LyaParser.Synonym_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_expression(LyaParser.Constant_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#newmode_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewmode_statement(LyaParser.Newmode_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#newmode_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewmode_list(LyaParser.Newmode_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#mode_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMode_definition(LyaParser.Mode_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#modo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModo(LyaParser.ModoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#discrete_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiscrete_mode(LyaParser.Discrete_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#integer_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_mode(LyaParser.Integer_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#boolean_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_mode(LyaParser.Boolean_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#character_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter_mode(LyaParser.Character_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#discrete_mode_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiscrete_mode_name(LyaParser.Discrete_mode_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#literal_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_range(LyaParser.Literal_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#upper_bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpper_bound(LyaParser.Upper_boundContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#lower_bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLower_bound(LyaParser.Lower_boundContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#reference_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference_mode(LyaParser.Reference_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#composite_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposite_mode(LyaParser.Composite_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#string_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_mode(LyaParser.String_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#string_length}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_length(LyaParser.String_lengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#array_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_mode(LyaParser.Array_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#index_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_mode(LyaParser.Index_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#element_mode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_mode(LyaParser.Element_modeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(LyaParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#simple_location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_location(LyaParser.Simple_locationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#location_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation_name(LyaParser.Location_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#dereferenced_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDereferenced_reference(LyaParser.Dereferenced_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#string_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_element(LyaParser.String_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#start_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_element(LyaParser.Start_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#string_slice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_slice(LyaParser.String_sliceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#string_location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_location(LyaParser.String_locationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#left_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_element(LyaParser.Left_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#right_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight_element(LyaParser.Right_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#array_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_element(LyaParser.Array_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(LyaParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#array_slice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_slice(LyaParser.Array_sliceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#array_location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_location(LyaParser.Array_locationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#array_location_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_location_range(LyaParser.Array_location_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#primitive_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_value(LyaParser.Primitive_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LyaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#integer_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_literal(LyaParser.Integer_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#digit_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit_sequence(LyaParser.Digit_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(LyaParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#character_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter_literal(LyaParser.Character_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#empty_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_literal(LyaParser.Empty_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#character_string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter_string_literal(LyaParser.Character_string_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#quote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote(LyaParser.QuoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#value_array_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_array_element(LyaParser.Value_array_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#value_array_slice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_array_slice(LyaParser.Value_array_sliceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#array_primitive_value_complement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_primitive_value_complement(LyaParser.Array_primitive_value_complementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#array_primitive_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_primitive_value(LyaParser.Array_primitive_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#parenthesized_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesized_expression(LyaParser.Parenthesized_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LyaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_expression(LyaParser.Conditional_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#boolean_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expression(LyaParser.Boolean_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#then_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen_expression(LyaParser.Then_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#else_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_expression(LyaParser.Else_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#elsif_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsif_expression(LyaParser.Elsif_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#operand0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand0(LyaParser.Operand0Context ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#operator1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator1(LyaParser.Operator1Context ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#relational_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_operator(LyaParser.Relational_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#membership_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembership_operator(LyaParser.Membership_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#operand1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand1(LyaParser.Operand1Context ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#operator2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator2(LyaParser.Operator2Context ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#arithmetic_additive_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_additive_operator(LyaParser.Arithmetic_additive_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#string_concatenation_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_concatenation_operator(LyaParser.String_concatenation_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#operand2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand2(LyaParser.Operand2Context ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#arithmetic_multiplicative_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_multiplicative_operator(LyaParser.Arithmetic_multiplicative_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#operand3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand3(LyaParser.Operand3Context ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#monadic_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonadic_operator(LyaParser.Monadic_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#operand4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand4(LyaParser.Operand4Context ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#referenced_location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenced_location(LyaParser.Referenced_locationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#action_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_statement(LyaParser.Action_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#label_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel_id(LyaParser.Label_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(LyaParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#bracketed_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketed_action(LyaParser.Bracketed_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#assignment_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_action(LyaParser.Assignment_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#assigning_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigning_operator(LyaParser.Assigning_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#closed_dyadic_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosed_dyadic_operator(LyaParser.Closed_dyadic_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#assignment_symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_symbol(LyaParser.Assignment_symbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#if_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_action(LyaParser.If_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#then_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen_clause(LyaParser.Then_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#else_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_clause(LyaParser.Else_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#do_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_action(LyaParser.Do_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#control_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_part(LyaParser.Control_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#for_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_control(LyaParser.For_controlContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration(LyaParser.IterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#step_enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep_enumeration(LyaParser.Step_enumerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#loop_counter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_counter(LyaParser.Loop_counterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#start_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_value(LyaParser.Start_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#step_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep_value(LyaParser.Step_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#end_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_value(LyaParser.End_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#range_enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange_enumeration(LyaParser.Range_enumerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#while_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_control(LyaParser.While_controlContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#call_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_action(LyaParser.Call_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#procedure_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_call(LyaParser.Procedure_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(LyaParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(LyaParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#exit_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_action(LyaParser.Exit_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#return_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_action(LyaParser.Return_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#result_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_action(LyaParser.Result_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(LyaParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#builtin_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin_call(LyaParser.Builtin_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#builtin_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin_name(LyaParser.Builtin_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#procedure_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_name(LyaParser.Procedure_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#procedure_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_statement(LyaParser.Procedure_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#procedure_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_definition(LyaParser.Procedure_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#formal_parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_parameter_list(LyaParser.Formal_parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#formal_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_parameter(LyaParser.Formal_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#parameter_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_spec(LyaParser.Parameter_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#parameter_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_attribute(LyaParser.Parameter_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#result_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_spec(LyaParser.Result_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link LyaParser#result_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_attribute(LyaParser.Result_attributeContext ctx);
}