package calculator.alu;

public enum IngredientType {
    OPERAND, OPERATOR;

    public boolean isOperand() {
        return OPERAND.equals(this);
    }

    public boolean isOperator() {
        return OPERATOR.equals(this);
    }
}
