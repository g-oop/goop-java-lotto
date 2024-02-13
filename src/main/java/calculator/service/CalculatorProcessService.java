package calculator.service;

import calculator.data.type.Operation;

import java.util.List;

public class CalculatorProcessService {


    public static int processCalculator(List<String> inputs) {
        int result = Integer.parseInt(inputs.get(0));
        for (int i = 1; i < inputs.size(); i += 2) {
            Operation operation = Operation.identifyOperations(inputs.get(i));
            int num2 = Integer.parseInt(inputs.get(i + 1));
            result = operation.apply(result, num2);
        }
        return result;
    }

}
