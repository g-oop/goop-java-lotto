package calculator.calculator.dto;

import java.util.List;

import calculator.calculator.MathIngredient;
import calculator.calculator.OperatorType;

public class ProgressStatus {

    List<MathIngredient> mathIngredients;
    int lastOperand;
    int index;

    public ProgressStatus(List<MathIngredient> mathIngredients, int lastOperand, int index) {
        this.mathIngredients = mathIngredients;
        this.lastOperand = lastOperand;
        this.index = index;
    }

    public int getLastOperand() {
        return lastOperand;
    }

    public int getSubOperand() {
        return mathIngredients.get(index).getOperand();
    }

    public OperatorType getOperator() {
        return mathIngredients.get(index - 1).getOperator();
    }


    public static ProgressStatus startCalculate(List<MathIngredient> mathIngredients) {
        return new ProgressStatus(mathIngredients, mathIngredients.get(0).getOperand(), 0);
    }

    public ProgressStatus nextCalculate() {
        return this.nextCalculate(lastOperand);
    }

    public ProgressStatus nextCalculate(int lastOperand) {
        return new ProgressStatus(mathIngredients, lastOperand, index + 2);
    }

    public boolean isStart() {
        return index == 0;
    }

    public boolean isProgress() {
        return mathIngredients.size() - 1 > index;
    }
}
