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
        if (methIngredient.isOperand() && !mustOperator) {
            progressOperand(methIngredient);
            return;
        }
        if (methIngredient.isOperator() && mustOperator) {
            progressOperator(methIngredient);
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 인자 : " + methIngredient.getIngredient());
    }

    private void progressOperand(MethIngredient methIngredient) {
        calculateOneOperand(Integer.parseInt(methIngredient.getIngredient()));
        mustOperator = true;
    }

    private void progressOperator(MethIngredient methIngredient) {
        currentOperator = methIngredient.getIngredient();
        mustOperator = false;
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
