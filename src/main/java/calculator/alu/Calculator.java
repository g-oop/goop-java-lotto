package calculator.alu;

import java.util.List;

public class Calculator {

    private static final Alu ALU = new Alu();
    private int mainOperand = 0;
    private String currentOperator = "+";
    private boolean mustOperator = false;

    public Integer calculate(List<MethIngredient> methIngredients) {
        methIngredients.forEach(this::progressCalculate);
        return mainOperand;
    }

    private void progressCalculate(MethIngredient methIngredient) {
        String ingredient = methIngredient.getIngredient();
        if (methIngredient.isOperand() && !mustOperator) {
             calculateOneOperand(Integer.parseInt(ingredient));
             mustOperator = true;
             return;
        }

        if (methIngredient.isOperator() && mustOperator) {
            currentOperator = ingredient;
            mustOperator = false;
            return;
        }

        throw new IllegalArgumentException("유효하지 않은 인자 : " + ingredient);
    }

    private void calculateOneOperand(Integer subOperand) {
        if ("+".equals(currentOperator)) {
            mainOperand = ALU.add(mainOperand, subOperand, currentOperator);
        }

        if ("-".equals(currentOperator)) {
            mainOperand = ALU.sub(mainOperand, subOperand, currentOperator);
        }

        if ("*".equals(currentOperator)) {
            mainOperand = ALU.multiple(mainOperand, subOperand, currentOperator);
        }

        if ("/".equals(currentOperator)) {
            mainOperand = ALU.division(mainOperand, subOperand, currentOperator);
        }
    }

}
