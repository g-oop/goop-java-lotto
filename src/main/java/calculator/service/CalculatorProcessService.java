package calculator.service;

import calculator.data.type.Operation;

public class CalculatorProcessService {


    public static int processCalculator(String[] inputs) {
        int result = Integer.parseInt(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            Operation operation = Operation.identifyOperations(inputs[i]);
            int num2 = Integer.parseInt(inputs[i + 1]);
            result = operation.apply(result, num2);
        }
        return result;
    }

}
