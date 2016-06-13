package br.unicamp.ic.mc911.lya.grammar.semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static br.unicamp.ic.mc911.lya.grammar.semantic.PrimitiveType.*;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class Environment {

    private final SymbolTable rootScope = new SymbolTable();
    private final Stack<SymbolTable> scopes = new Stack<SymbolTable>();

    private final Map<Symbol, Type> types = new HashMap<Symbol, Type>();
    private final Map<Symbol, Location> locations = new HashMap<Symbol, Location>();
    private final Map<Symbol, Procedure> procedures = new HashMap<Symbol, Procedure>();

    public Environment() {
        rootScope.put("int", INT.getName());
        rootScope.put("char", CHAR.getName());
        rootScope.put("string", STRING.getName());
        rootScope.put("bool", BOOL.getName());

        types.put(INT.getName(), INT);
        types.put(CHAR.getName(), CHAR);
        types.put(STRING.getName(), STRING);
        types.put(BOOL.getName(), BOOL);

        scopes.push(rootScope);
    }

    public Symbol lookup(String name) {
        SymbolTable symbolTable = null;

        for (SymbolTable s : scopes) {
            if (s.containsKey(name)) {
                symbolTable = s;
                break;
            }
        }

        if (symbolTable != null) {
            return symbolTable.get(name);
        }

        return null;
    }

    public void addSymbol(String name, Symbol symbol) {
        scopes.peek().put(name, symbol);
    }

    public void addLocation(Location location) {
        locations.put(location.getName(), location);
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

    public void enterScope() {
        scopes.push(new SymbolTable());
    }

    public void leaveScope() {
        scopes.pop();
    }

    public Stack<SymbolTable> getScopes() {
        return scopes;
    }

    public SymbolTable getRootScope() {
        return rootScope;
    }

    public Map<Symbol, Type> getTypes() {
        return types;
    }
}
