package br.unicamp.ic.mc911.lya.grammar.environment;

import java.util.*;
import java.util.List;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class Environment {

    private final Scope rootScope = new Scope(0);
    private final Stack<Scope> scopes = new Stack<Scope>();

    private final Map<String, Symbol> symbols = new HashMap<String, Symbol>();
    private final Map<Symbol, Type> types = new HashMap<Symbol, Type>();
    private final Map<Symbol, Location> locations = new HashMap<Symbol, Location>();
    private final Map<Symbol, Procedure> procedures = new HashMap<Symbol, Procedure>();

    private final Map<Symbol, Constant> constants = new HashMap<Symbol, Constant>();
    private final Map<Symbol, Variable> variables = new HashMap<Symbol, Variable>();
    private final Map<Symbol, Label> labels = new HashMap<Symbol, Label>();

    private final List<StringConstant> stringHeap = new ArrayList<StringConstant>();
    private final List<Instruction> instructions = new ArrayList<Instruction>();

    private Integer nextScopeIndex;
    private Integer nextLabelIndex;

    public Environment() {
        rootScope.put("int", PrimitiveType.INT.getName());
        rootScope.put("char", PrimitiveType.CHAR.getName());
        rootScope.put("bool", PrimitiveType.BOOL.getName());

        types.put(PrimitiveType.INT.getName(), PrimitiveType.INT);
        types.put(PrimitiveType.CHAR.getName(), PrimitiveType.CHAR);
        types.put(PrimitiveType.BOOL.getName(), PrimitiveType.BOOL);

        scopes.push(rootScope);
        nextScopeIndex = 1;
        nextLabelIndex = 1;
    }

    public Symbol lookup(String name) {
        Scope scope = null;

        for (Scope s : scopes) {
            if (s.containsKey(name)) {
                scope = s;
                break;
            }
        }

        if (scope != null) {
            return scope.get(name);
        }

        return null;
    }

    public void addSymbol(String name, Symbol symbol) {
        symbols.put(name, symbol);
        scopes.peek().put(name, symbol);
    }

    public Symbol findSymbol(String name) {
        return symbols.get(name);
    }

    public void addLocation(Location location) {
        locations.put(location.getName(), location);
    }

    public Location findLocation(String name) {
        Symbol symbol = findSymbol(name);

        if (symbol != null) {
            return findLocation(symbol);
        }

        return null;
    }

    public Location findLocation(Symbol name) {
        return locations.get(name);
    }

    public void addProcedure(Procedure procedure) {
        procedures.put(procedure.getName(), procedure);
    }

    public Procedure findProcedure(Symbol name) {
        return procedures.get(name);
    }

    public void addType(Type type) {
        types.put(type.getName(), type);
    }

    public Type findType(Symbol name) {
        return types.get(name);
    }

    public Scope enterScope() {
        return scopes.push(new Scope(nextScopeIndex++));
    }

    public Scope leaveScope() {
        return scopes.pop();
    }

    public Scope getCurrentScope() {
        return scopes.peek();
    }

    public void addConstant(Symbol name, Constant constant) {
        constants.put(name, constant);
    }

    public Constant findConstant(Symbol name) {
        return constants.get(name);
    }

    public void addVariable(Variable variable) {
        addSymbol(variable.getName().getValue(), variable.getName());
        variables.put(variable.getName(), variable);
    }

    public Variable findVariable(String name) {
        Symbol symbol = lookup(name);

        if (symbol != null) {
            return findVariable(symbol);
        }

        return null;
    }


    public Variable findVariable(Symbol name) {
        return variables.get(name);
    }

    public void addLable(Label label) {
        addSymbol(label.getName().getValue(), label.getName());
        labels.put(label.getName(), label);
    }

    public Label findLabel(Symbol name) {
        return labels.get(name);
    }

    public StringConstant addStringConstant(String string) {
        int index = stringHeap.size();
        StringConstant stringConstant = new StringConstant(index, string);

        stringHeap.add(stringConstant);

        return stringConstant;
    }

    public void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }

    public void resetScopeIndex() {
        nextScopeIndex = 1;
    }

    public Integer nextLabelIndex() {
        return nextLabelIndex++;
    }

    public Stack<Scope> getScopes() {
        return scopes;
    }

    public Scope getRootScope() {
        return rootScope;
    }

    public Map<Symbol, Type> getTypes() {
        return types;
    }

    public List<StringConstant> getStringHeap() {
        return stringHeap;
    }

    public Map<Symbol, Variable> getVariables() {
        return variables;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

}
