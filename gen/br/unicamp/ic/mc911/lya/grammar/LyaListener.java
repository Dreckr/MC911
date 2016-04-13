// Generated from /home/diegorocha/Documents/MC911/src/main/java/br/unicamp/ic/mc911/lya/grammar/Lya.g4 by ANTLR 4.5.1
package br.unicamp.ic.mc911.lya.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LyaParser}.
 */
public interface LyaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LyaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LyaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LyaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LyaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LyaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#declaration_statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_statement(LyaParser.Declaration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#declaration_statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_statement(LyaParser.Declaration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_list(LyaParser.Declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_list(LyaParser.Declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LyaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LyaParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#initialization}.
	 * @param ctx the parse tree
	 */
	void enterInitialization(LyaParser.InitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#initialization}.
	 * @param ctx the parse tree
	 */
	void exitInitialization(LyaParser.InitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_list(LyaParser.Identifier_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_list(LyaParser.Identifier_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#synonym_statement}.
	 * @param ctx the parse tree
	 */
	void enterSynonym_statement(LyaParser.Synonym_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#synonym_statement}.
	 * @param ctx the parse tree
	 */
	void exitSynonym_statement(LyaParser.Synonym_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#synonym_list}.
	 * @param ctx the parse tree
	 */
	void enterSynonym_list(LyaParser.Synonym_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#synonym_list}.
	 * @param ctx the parse tree
	 */
	void exitSynonym_list(LyaParser.Synonym_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#synonym_definition}.
	 * @param ctx the parse tree
	 */
	void enterSynonym_definition(LyaParser.Synonym_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#synonym_definition}.
	 * @param ctx the parse tree
	 */
	void exitSynonym_definition(LyaParser.Synonym_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expression(LyaParser.Constant_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expression(LyaParser.Constant_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#newmode_statement}.
	 * @param ctx the parse tree
	 */
	void enterNewmode_statement(LyaParser.Newmode_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#newmode_statement}.
	 * @param ctx the parse tree
	 */
	void exitNewmode_statement(LyaParser.Newmode_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#newmode_list}.
	 * @param ctx the parse tree
	 */
	void enterNewmode_list(LyaParser.Newmode_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#newmode_list}.
	 * @param ctx the parse tree
	 */
	void exitNewmode_list(LyaParser.Newmode_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#mode_definition}.
	 * @param ctx the parse tree
	 */
	void enterMode_definition(LyaParser.Mode_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#mode_definition}.
	 * @param ctx the parse tree
	 */
	void exitMode_definition(LyaParser.Mode_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#modo}.
	 * @param ctx the parse tree
	 */
	void enterModo(LyaParser.ModoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#modo}.
	 * @param ctx the parse tree
	 */
	void exitModo(LyaParser.ModoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#discrete_mode}.
	 * @param ctx the parse tree
	 */
	void enterDiscrete_mode(LyaParser.Discrete_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#discrete_mode}.
	 * @param ctx the parse tree
	 */
	void exitDiscrete_mode(LyaParser.Discrete_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#integer_mode}.
	 * @param ctx the parse tree
	 */
	void enterInteger_mode(LyaParser.Integer_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#integer_mode}.
	 * @param ctx the parse tree
	 */
	void exitInteger_mode(LyaParser.Integer_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#boolean_mode}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_mode(LyaParser.Boolean_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#boolean_mode}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_mode(LyaParser.Boolean_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#character_mode}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_mode(LyaParser.Character_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#character_mode}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_mode(LyaParser.Character_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#discrete_mode_name}.
	 * @param ctx the parse tree
	 */
	void enterDiscrete_mode_name(LyaParser.Discrete_mode_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#discrete_mode_name}.
	 * @param ctx the parse tree
	 */
	void exitDiscrete_mode_name(LyaParser.Discrete_mode_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#literal_range}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_range(LyaParser.Literal_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#literal_range}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_range(LyaParser.Literal_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#upper_bound}.
	 * @param ctx the parse tree
	 */
	void enterUpper_bound(LyaParser.Upper_boundContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#upper_bound}.
	 * @param ctx the parse tree
	 */
	void exitUpper_bound(LyaParser.Upper_boundContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#lower_bound}.
	 * @param ctx the parse tree
	 */
	void enterLower_bound(LyaParser.Lower_boundContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#lower_bound}.
	 * @param ctx the parse tree
	 */
	void exitLower_bound(LyaParser.Lower_boundContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#reference_mode}.
	 * @param ctx the parse tree
	 */
	void enterReference_mode(LyaParser.Reference_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#reference_mode}.
	 * @param ctx the parse tree
	 */
	void exitReference_mode(LyaParser.Reference_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#composite_mode}.
	 * @param ctx the parse tree
	 */
	void enterComposite_mode(LyaParser.Composite_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#composite_mode}.
	 * @param ctx the parse tree
	 */
	void exitComposite_mode(LyaParser.Composite_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#string_mode}.
	 * @param ctx the parse tree
	 */
	void enterString_mode(LyaParser.String_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#string_mode}.
	 * @param ctx the parse tree
	 */
	void exitString_mode(LyaParser.String_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#string_length}.
	 * @param ctx the parse tree
	 */
	void enterString_length(LyaParser.String_lengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#string_length}.
	 * @param ctx the parse tree
	 */
	void exitString_length(LyaParser.String_lengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#array_mode}.
	 * @param ctx the parse tree
	 */
	void enterArray_mode(LyaParser.Array_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#array_mode}.
	 * @param ctx the parse tree
	 */
	void exitArray_mode(LyaParser.Array_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#index_mode}.
	 * @param ctx the parse tree
	 */
	void enterIndex_mode(LyaParser.Index_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#index_mode}.
	 * @param ctx the parse tree
	 */
	void exitIndex_mode(LyaParser.Index_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#element_mode}.
	 * @param ctx the parse tree
	 */
	void enterElement_mode(LyaParser.Element_modeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#element_mode}.
	 * @param ctx the parse tree
	 */
	void exitElement_mode(LyaParser.Element_modeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(LyaParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(LyaParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#simple_location}.
	 * @param ctx the parse tree
	 */
	void enterSimple_location(LyaParser.Simple_locationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#simple_location}.
	 * @param ctx the parse tree
	 */
	void exitSimple_location(LyaParser.Simple_locationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#location_name}.
	 * @param ctx the parse tree
	 */
	void enterLocation_name(LyaParser.Location_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#location_name}.
	 * @param ctx the parse tree
	 */
	void exitLocation_name(LyaParser.Location_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#dereferenced_reference}.
	 * @param ctx the parse tree
	 */
	void enterDereferenced_reference(LyaParser.Dereferenced_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#dereferenced_reference}.
	 * @param ctx the parse tree
	 */
	void exitDereferenced_reference(LyaParser.Dereferenced_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#string_element}.
	 * @param ctx the parse tree
	 */
	void enterString_element(LyaParser.String_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#string_element}.
	 * @param ctx the parse tree
	 */
	void exitString_element(LyaParser.String_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#start_element}.
	 * @param ctx the parse tree
	 */
	void enterStart_element(LyaParser.Start_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#start_element}.
	 * @param ctx the parse tree
	 */
	void exitStart_element(LyaParser.Start_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#string_slice}.
	 * @param ctx the parse tree
	 */
	void enterString_slice(LyaParser.String_sliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#string_slice}.
	 * @param ctx the parse tree
	 */
	void exitString_slice(LyaParser.String_sliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#string_location}.
	 * @param ctx the parse tree
	 */
	void enterString_location(LyaParser.String_locationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#string_location}.
	 * @param ctx the parse tree
	 */
	void exitString_location(LyaParser.String_locationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#left_element}.
	 * @param ctx the parse tree
	 */
	void enterLeft_element(LyaParser.Left_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#left_element}.
	 * @param ctx the parse tree
	 */
	void exitLeft_element(LyaParser.Left_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#right_element}.
	 * @param ctx the parse tree
	 */
	void enterRight_element(LyaParser.Right_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#right_element}.
	 * @param ctx the parse tree
	 */
	void exitRight_element(LyaParser.Right_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#array_element}.
	 * @param ctx the parse tree
	 */
	void enterArray_element(LyaParser.Array_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#array_element}.
	 * @param ctx the parse tree
	 */
	void exitArray_element(LyaParser.Array_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(LyaParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(LyaParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#array_slice}.
	 * @param ctx the parse tree
	 */
	void enterArray_slice(LyaParser.Array_sliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#array_slice}.
	 * @param ctx the parse tree
	 */
	void exitArray_slice(LyaParser.Array_sliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#array_location}.
	 * @param ctx the parse tree
	 */
	void enterArray_location(LyaParser.Array_locationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#array_location}.
	 * @param ctx the parse tree
	 */
	void exitArray_location(LyaParser.Array_locationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#array_location_range}.
	 * @param ctx the parse tree
	 */
	void enterArray_location_range(LyaParser.Array_location_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#array_location_range}.
	 * @param ctx the parse tree
	 */
	void exitArray_location_range(LyaParser.Array_location_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#primitive_value}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_value(LyaParser.Primitive_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#primitive_value}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_value(LyaParser.Primitive_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LyaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LyaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#integer_literal}.
	 * @param ctx the parse tree
	 */
	void enterInteger_literal(LyaParser.Integer_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#integer_literal}.
	 * @param ctx the parse tree
	 */
	void exitInteger_literal(LyaParser.Integer_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#digit_sequence}.
	 * @param ctx the parse tree
	 */
	void enterDigit_sequence(LyaParser.Digit_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#digit_sequence}.
	 * @param ctx the parse tree
	 */
	void exitDigit_sequence(LyaParser.Digit_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(LyaParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(LyaParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#character_literal}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_literal(LyaParser.Character_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#character_literal}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_literal(LyaParser.Character_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#empty_literal}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_literal(LyaParser.Empty_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#empty_literal}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_literal(LyaParser.Empty_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#character_string_literal}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_string_literal(LyaParser.Character_string_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#character_string_literal}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_string_literal(LyaParser.Character_string_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#value_array_element}.
	 * @param ctx the parse tree
	 */
	void enterValue_array_element(LyaParser.Value_array_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#value_array_element}.
	 * @param ctx the parse tree
	 */
	void exitValue_array_element(LyaParser.Value_array_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#value_array_slice}.
	 * @param ctx the parse tree
	 */
	void enterValue_array_slice(LyaParser.Value_array_sliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#value_array_slice}.
	 * @param ctx the parse tree
	 */
	void exitValue_array_slice(LyaParser.Value_array_sliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#array_primitive_value_complement}.
	 * @param ctx the parse tree
	 */
	void enterArray_primitive_value_complement(LyaParser.Array_primitive_value_complementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#array_primitive_value_complement}.
	 * @param ctx the parse tree
	 */
	void exitArray_primitive_value_complement(LyaParser.Array_primitive_value_complementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#array_primitive_value}.
	 * @param ctx the parse tree
	 */
	void enterArray_primitive_value(LyaParser.Array_primitive_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#array_primitive_value}.
	 * @param ctx the parse tree
	 */
	void exitArray_primitive_value(LyaParser.Array_primitive_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#parenthesized_expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesized_expression(LyaParser.Parenthesized_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#parenthesized_expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesized_expression(LyaParser.Parenthesized_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LyaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LyaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional_expression(LyaParser.Conditional_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional_expression(LyaParser.Conditional_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expression(LyaParser.Boolean_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expression(LyaParser.Boolean_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#then_expression}.
	 * @param ctx the parse tree
	 */
	void enterThen_expression(LyaParser.Then_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#then_expression}.
	 * @param ctx the parse tree
	 */
	void exitThen_expression(LyaParser.Then_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#else_expression}.
	 * @param ctx the parse tree
	 */
	void enterElse_expression(LyaParser.Else_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#else_expression}.
	 * @param ctx the parse tree
	 */
	void exitElse_expression(LyaParser.Else_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#elsif_expression}.
	 * @param ctx the parse tree
	 */
	void enterElsif_expression(LyaParser.Elsif_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#elsif_expression}.
	 * @param ctx the parse tree
	 */
	void exitElsif_expression(LyaParser.Elsif_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#operand0}.
	 * @param ctx the parse tree
	 */
	void enterOperand0(LyaParser.Operand0Context ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#operand0}.
	 * @param ctx the parse tree
	 */
	void exitOperand0(LyaParser.Operand0Context ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#operator1}.
	 * @param ctx the parse tree
	 */
	void enterOperator1(LyaParser.Operator1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#operator1}.
	 * @param ctx the parse tree
	 */
	void exitOperator1(LyaParser.Operator1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(LyaParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(LyaParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#membership_operator}.
	 * @param ctx the parse tree
	 */
	void enterMembership_operator(LyaParser.Membership_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#membership_operator}.
	 * @param ctx the parse tree
	 */
	void exitMembership_operator(LyaParser.Membership_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#operand1}.
	 * @param ctx the parse tree
	 */
	void enterOperand1(LyaParser.Operand1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#operand1}.
	 * @param ctx the parse tree
	 */
	void exitOperand1(LyaParser.Operand1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#operator2}.
	 * @param ctx the parse tree
	 */
	void enterOperator2(LyaParser.Operator2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#operator2}.
	 * @param ctx the parse tree
	 */
	void exitOperator2(LyaParser.Operator2Context ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#arithmetic_additive_operator}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_additive_operator(LyaParser.Arithmetic_additive_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#arithmetic_additive_operator}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_additive_operator(LyaParser.Arithmetic_additive_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#string_concatenation_operator}.
	 * @param ctx the parse tree
	 */
	void enterString_concatenation_operator(LyaParser.String_concatenation_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#string_concatenation_operator}.
	 * @param ctx the parse tree
	 */
	void exitString_concatenation_operator(LyaParser.String_concatenation_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#operand2}.
	 * @param ctx the parse tree
	 */
	void enterOperand2(LyaParser.Operand2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#operand2}.
	 * @param ctx the parse tree
	 */
	void exitOperand2(LyaParser.Operand2Context ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#arithmetic_multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_multiplicative_operator(LyaParser.Arithmetic_multiplicative_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#arithmetic_multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_multiplicative_operator(LyaParser.Arithmetic_multiplicative_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#operand3}.
	 * @param ctx the parse tree
	 */
	void enterOperand3(LyaParser.Operand3Context ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#operand3}.
	 * @param ctx the parse tree
	 */
	void exitOperand3(LyaParser.Operand3Context ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#monadic_operator}.
	 * @param ctx the parse tree
	 */
	void enterMonadic_operator(LyaParser.Monadic_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#monadic_operator}.
	 * @param ctx the parse tree
	 */
	void exitMonadic_operator(LyaParser.Monadic_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#operand4}.
	 * @param ctx the parse tree
	 */
	void enterOperand4(LyaParser.Operand4Context ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#operand4}.
	 * @param ctx the parse tree
	 */
	void exitOperand4(LyaParser.Operand4Context ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#referenced_location}.
	 * @param ctx the parse tree
	 */
	void enterReferenced_location(LyaParser.Referenced_locationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#referenced_location}.
	 * @param ctx the parse tree
	 */
	void exitReferenced_location(LyaParser.Referenced_locationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#action_statement}.
	 * @param ctx the parse tree
	 */
	void enterAction_statement(LyaParser.Action_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#action_statement}.
	 * @param ctx the parse tree
	 */
	void exitAction_statement(LyaParser.Action_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#label_id}.
	 * @param ctx the parse tree
	 */
	void enterLabel_id(LyaParser.Label_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#label_id}.
	 * @param ctx the parse tree
	 */
	void exitLabel_id(LyaParser.Label_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(LyaParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(LyaParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#bracketed_action}.
	 * @param ctx the parse tree
	 */
	void enterBracketed_action(LyaParser.Bracketed_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#bracketed_action}.
	 * @param ctx the parse tree
	 */
	void exitBracketed_action(LyaParser.Bracketed_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#assignment_action}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_action(LyaParser.Assignment_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#assignment_action}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_action(LyaParser.Assignment_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#assigning_operator}.
	 * @param ctx the parse tree
	 */
	void enterAssigning_operator(LyaParser.Assigning_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#assigning_operator}.
	 * @param ctx the parse tree
	 */
	void exitAssigning_operator(LyaParser.Assigning_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#closed_dyadic_operator}.
	 * @param ctx the parse tree
	 */
	void enterClosed_dyadic_operator(LyaParser.Closed_dyadic_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#closed_dyadic_operator}.
	 * @param ctx the parse tree
	 */
	void exitClosed_dyadic_operator(LyaParser.Closed_dyadic_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#assignment_symbol}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_symbol(LyaParser.Assignment_symbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#assignment_symbol}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_symbol(LyaParser.Assignment_symbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#if_action}.
	 * @param ctx the parse tree
	 */
	void enterIf_action(LyaParser.If_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#if_action}.
	 * @param ctx the parse tree
	 */
	void exitIf_action(LyaParser.If_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#then_clause}.
	 * @param ctx the parse tree
	 */
	void enterThen_clause(LyaParser.Then_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#then_clause}.
	 * @param ctx the parse tree
	 */
	void exitThen_clause(LyaParser.Then_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void enterElse_clause(LyaParser.Else_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void exitElse_clause(LyaParser.Else_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#do_action}.
	 * @param ctx the parse tree
	 */
	void enterDo_action(LyaParser.Do_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#do_action}.
	 * @param ctx the parse tree
	 */
	void exitDo_action(LyaParser.Do_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#control_part}.
	 * @param ctx the parse tree
	 */
	void enterControl_part(LyaParser.Control_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#control_part}.
	 * @param ctx the parse tree
	 */
	void exitControl_part(LyaParser.Control_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#for_control}.
	 * @param ctx the parse tree
	 */
	void enterFor_control(LyaParser.For_controlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#for_control}.
	 * @param ctx the parse tree
	 */
	void exitFor_control(LyaParser.For_controlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterIteration(LyaParser.IterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitIteration(LyaParser.IterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#step_enumeration}.
	 * @param ctx the parse tree
	 */
	void enterStep_enumeration(LyaParser.Step_enumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#step_enumeration}.
	 * @param ctx the parse tree
	 */
	void exitStep_enumeration(LyaParser.Step_enumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#loop_counter}.
	 * @param ctx the parse tree
	 */
	void enterLoop_counter(LyaParser.Loop_counterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#loop_counter}.
	 * @param ctx the parse tree
	 */
	void exitLoop_counter(LyaParser.Loop_counterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#start_value}.
	 * @param ctx the parse tree
	 */
	void enterStart_value(LyaParser.Start_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#start_value}.
	 * @param ctx the parse tree
	 */
	void exitStart_value(LyaParser.Start_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#step_value}.
	 * @param ctx the parse tree
	 */
	void enterStep_value(LyaParser.Step_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#step_value}.
	 * @param ctx the parse tree
	 */
	void exitStep_value(LyaParser.Step_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#end_value}.
	 * @param ctx the parse tree
	 */
	void enterEnd_value(LyaParser.End_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#end_value}.
	 * @param ctx the parse tree
	 */
	void exitEnd_value(LyaParser.End_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#range_enumeration}.
	 * @param ctx the parse tree
	 */
	void enterRange_enumeration(LyaParser.Range_enumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#range_enumeration}.
	 * @param ctx the parse tree
	 */
	void exitRange_enumeration(LyaParser.Range_enumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#while_control}.
	 * @param ctx the parse tree
	 */
	void enterWhile_control(LyaParser.While_controlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#while_control}.
	 * @param ctx the parse tree
	 */
	void exitWhile_control(LyaParser.While_controlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#call_action}.
	 * @param ctx the parse tree
	 */
	void enterCall_action(LyaParser.Call_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#call_action}.
	 * @param ctx the parse tree
	 */
	void exitCall_action(LyaParser.Call_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#procedure_call}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_call(LyaParser.Procedure_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#procedure_call}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_call(LyaParser.Procedure_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(LyaParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(LyaParser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(LyaParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(LyaParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#exit_action}.
	 * @param ctx the parse tree
	 */
	void enterExit_action(LyaParser.Exit_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#exit_action}.
	 * @param ctx the parse tree
	 */
	void exitExit_action(LyaParser.Exit_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#return_action}.
	 * @param ctx the parse tree
	 */
	void enterReturn_action(LyaParser.Return_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#return_action}.
	 * @param ctx the parse tree
	 */
	void exitReturn_action(LyaParser.Return_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#result_action}.
	 * @param ctx the parse tree
	 */
	void enterResult_action(LyaParser.Result_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#result_action}.
	 * @param ctx the parse tree
	 */
	void exitResult_action(LyaParser.Result_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(LyaParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(LyaParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#builtin_call}.
	 * @param ctx the parse tree
	 */
	void enterBuiltin_call(LyaParser.Builtin_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#builtin_call}.
	 * @param ctx the parse tree
	 */
	void exitBuiltin_call(LyaParser.Builtin_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#builtin_name}.
	 * @param ctx the parse tree
	 */
	void enterBuiltin_name(LyaParser.Builtin_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#builtin_name}.
	 * @param ctx the parse tree
	 */
	void exitBuiltin_name(LyaParser.Builtin_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#procedure_name}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_name(LyaParser.Procedure_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#procedure_name}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_name(LyaParser.Procedure_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#procedure_statement}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_statement(LyaParser.Procedure_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#procedure_statement}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_statement(LyaParser.Procedure_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#procedure_definition}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_definition(LyaParser.Procedure_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#procedure_definition}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_definition(LyaParser.Procedure_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#formal_parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterFormal_parameter_list(LyaParser.Formal_parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#formal_parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitFormal_parameter_list(LyaParser.Formal_parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#formal_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFormal_parameter(LyaParser.Formal_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#formal_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFormal_parameter(LyaParser.Formal_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#parameter_spec}.
	 * @param ctx the parse tree
	 */
	void enterParameter_spec(LyaParser.Parameter_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#parameter_spec}.
	 * @param ctx the parse tree
	 */
	void exitParameter_spec(LyaParser.Parameter_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#parameter_attribute}.
	 * @param ctx the parse tree
	 */
	void enterParameter_attribute(LyaParser.Parameter_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#parameter_attribute}.
	 * @param ctx the parse tree
	 */
	void exitParameter_attribute(LyaParser.Parameter_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#result_spec}.
	 * @param ctx the parse tree
	 */
	void enterResult_spec(LyaParser.Result_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#result_spec}.
	 * @param ctx the parse tree
	 */
	void exitResult_spec(LyaParser.Result_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link LyaParser#result_attribute}.
	 * @param ctx the parse tree
	 */
	void enterResult_attribute(LyaParser.Result_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LyaParser#result_attribute}.
	 * @param ctx the parse tree
	 */
	void exitResult_attribute(LyaParser.Result_attributeContext ctx);
}