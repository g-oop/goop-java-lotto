package calculator.alu;

import java.util.List;

public class MethIngredient {

    private static final List<String> VALID_OPERATORS = List.of("+", "-", "*", "/");

    private final String ingredient;
    private final IngredientType type;

    public MethIngredient(String ingredient) {
        validationBlank(ingredient);
        this.type = determinationIngredient(ingredient);
        this.ingredient = ingredient;
    }

    private void validationBlank(String ingredient) {
        if (ingredient.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 인자 : blank");
        }
    }

    private IngredientType determinationIngredient(String ingredient) {
        if (validOperand(ingredient)) {
            return IngredientType.OPERAND;
        }
        if (validOperator(ingredient)) {
            return IngredientType.OPERATOR;
        }
        throw new IllegalArgumentException("유효하지 않은 인자 : " + ingredient);
    }

    private boolean validOperand(String methIngredient) {
        try {
            Integer.parseInt(methIngredient);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean validOperator(String methIngredient) {
        return VALID_OPERATORS.contains(methIngredient);
    }

    public String getIngredient() {
        return ingredient;
    }

    public boolean isOperand() {
        return type.isOperand();
    }

    public boolean isOperator() {
        return type.isOperator();
    }
}
