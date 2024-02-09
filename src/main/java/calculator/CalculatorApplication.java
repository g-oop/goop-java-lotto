package calculator;


import java.util.Scanner;

import static calculator.service.CalculatorProcessService.processCalculator;
import static calculator.view.Input.getInput;
import static calculator.view.output.printResult;

public class CalculatorApplication {

    private static final Scanner STRING_INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("문자열 입력 : ");
        String[] inputs = getInput(STRING_INPUT.nextLine());
        int resultValue = processCalculator(inputs);
        printResult(resultValue);
    }
}
