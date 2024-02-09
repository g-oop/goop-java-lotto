package calculator.data.type;


import java.util.Arrays;

public enum Operation {
    ADDITION("+") {
        @Override
        public int apply(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int apply(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int apply(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVISION("/") {
        @Override
        public int apply(int num1, int num2) {
            if (num2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            int result = num1 / num2;
            if (num1 % num2 != 0) {
                throw new IllegalArgumentException("나눗셈 결과가 정수로 떨어지지 않습니다.");
            }
            return result;
        }
    };

    private final String operator;

    Operation(String operator) {
        this.operator = operator;
    }

    public abstract int apply(int num1, int num2);

    public static Operation identifyOperations(String inputOperator) {
        return Arrays.stream(Operation.values())
            .filter(operation -> operation.operator.equals(inputOperator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다." + inputOperator));
    }
}
