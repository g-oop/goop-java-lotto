package calculator.controller;

import java.util.List;

import calculator.calculator.Calculator;
import calculator.calculator.MathIngredient;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {

    private final Calculator calculator = new Calculator();

    public void start() {
        List<MathIngredient> mathIngredients = InputView.inputStringEquation();
        ResultView.display(calculator.calculate(mathIngredients));
    }
}
