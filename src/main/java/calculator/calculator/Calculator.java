package calculator.calculator;

import java.util.List;

import calculator.calculator.dto.ProgressStatus;

public class Calculator {

    public Integer calculate(List<MathIngredient> mathIngredients) {
        return progressCalculate(ProgressStatus.startCalculate(mathIngredients));
    }

    private Integer progressCalculate(ProgressStatus status) {
        if(status.isStart()) {
            return progressCalculate(status.nextCalculate());
        }

        if(status.isProgress()) {
            int lastOperand = doCalculate(status);
            return progressCalculate(status.nextCalculate(lastOperand));
        }

        return doCalculate(status);
    }

    private int doCalculate(ProgressStatus status) {
        int lastOperand = status.getLastOperand();
        int subOperand = status.getSubOperand();
        OperatorType operator = status.getOperator();

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
