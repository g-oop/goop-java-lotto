package calculator.alu;

public enum IngredientType {
    OPERAND, OPERATOR;

    public boolean isOperand() {
        return this == OPERAND;
    }

    public boolean isOperator() {
        return this == OPERATOR;
    }
}
