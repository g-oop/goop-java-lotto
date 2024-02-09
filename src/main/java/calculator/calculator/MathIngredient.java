package calculator.calculator;


public class MathIngredient {

    private final String ingredient;
    private final IngredientType type;

    public MathIngredient(String ingredient) {
        validateBlank(ingredient);
        this.type = determinationIngredient(ingredient);
        this.ingredient = ingredient;
    }

    private void validateBlank(String ingredient) {
        if (ingredient.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 인자 : blank");
        }
    }

    private IngredientType determinationIngredient(String ingredient) {
        if (isValidOperand(ingredient)) {
            return IngredientType.OPERAND;
        }
        if (isValidOperator(ingredient)) {
            return IngredientType.OPERATOR;
        }
        throw new IllegalArgumentException("유효하지 않은 인자 : " + ingredient);
    }

    private boolean isValidOperand(String mathIngredient) {
        try {
            Integer.parseInt(mathIngredient);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isValidOperator(String methIngredient) {
        return OperatorType.isValidCode(methIngredient);
    }

    public Integer getOperand() {
        try{
            return Integer.parseInt(ingredient);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 인자 : " + ingredient);
        }
    }

    public OperatorType getOperator() {
        return OperatorType.valueOfCode(ingredient);
    }
}
