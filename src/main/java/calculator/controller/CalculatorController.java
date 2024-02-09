package calculator.controller;

import java.util.List;

import calculator.alu.Calculator;
import calculator.alu.MathIngredient;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {

    private final Calculator calculator = new Calculator();

    public void start() {
        List<MathIngredient> mathIngredients = InputView.inputStringEquation();
        ResultView.display(calculator.calculate(mathIngredients));
    }
}
