package calculator.alu;

import java.util.List;

public class Calculator {

    public Integer calculate(List<MathIngredient> mathIngredients) {
        return progressCalculate(mathIngredients.get(0).getOperand(), mathIngredients, 0);
    }

    private Integer progressCalculate(int lastOperand, List<MathIngredient> mathIngredients, int index) {
        if(index == 0) {
            return progressCalculate(lastOperand, mathIngredients, index + 2);
        }
        if(mathIngredients.size() - 1 > index) {
            lastOperand = doCalculate(lastOperand, mathIngredients.get(index).getOperand(), mathIngredients.get(index -1).getOperator());
            return progressCalculate(lastOperand, mathIngredients, index + 2);
        }
        return doCalculate(lastOperand, mathIngredients.get(index).getOperand(), mathIngredients.get(index - 1).getOperator());
    }

    private int doCalculate(Integer lastOperand, Integer subOperand, OperatorType operator) {
        if (operator.isAdd()) {
            return lastOperand + subOperand;
        }

        if (operator.isSub()) {
            return lastOperand - subOperand;
        }

        if (operator.isMultiple()) {
            return lastOperand * subOperand;
        }

        if (operator.isDivision()) {
            validateDivision(lastOperand, subOperand);
            return lastOperand / subOperand;
        }
        throw new IllegalArgumentException("유효하지 않은 인자 : " + operator.getCode());
    }

    private void validateDivision(int mainOperand, int subOperand) {
        if (mainOperand % subOperand != 0) {
            throw new IllegalArgumentException("나눗셈 나머지 존재: " + mainOperand + "/" + subOperand);
        }
    }

}
