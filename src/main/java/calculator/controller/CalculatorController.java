package calculator.controller;

import java.util.List;

import calculator.alu.Calculator;
import calculator.alu.MethIngredient;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {

    private final Calculator calculator = new Calculator();

    public void start() {
        List<MethIngredient> methIngredients = InputView.inputStringEquation();
        ResultView.display(calculator.calculate(methIngredients));
    }
}
