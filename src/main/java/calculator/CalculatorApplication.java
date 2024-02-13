package calculator;


import java.util.Arrays;
import java.util.List;

import static calculator.service.CalculatorProcessService.processCalculator;
import static calculator.view.Input.getInput;
import static calculator.view.Output.printResult;

public class CalculatorApplication {


    public static void main(String[] args) {
        String inputString = getInput();
        List<String> inputs = Arrays.asList(inputString.split(" "));
        int resultValue = processCalculator(inputs);
        printResult(resultValue);
    }
}
