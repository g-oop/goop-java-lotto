package calculator.alu;

public class Alu {

    public int add(int mainOperand, int subOperand, String operator) {
        if ("+".equals(operator)) {
            return mainOperand + subOperand;
        }
        throw new IllegalArgumentException("덧셈 연산자 불일치: " + operator);
    }

    public int sub(int mainOperand, int subOperand, String operator) {
        if ("-".equals(operator)) {
            return mainOperand - subOperand;
        }
        throw new IllegalArgumentException("뺄셈 연산자 불일치: " + operator);
    }

    public int multiple(int mainOperand, int subOperand, String operator) {
        if ("*".equals(operator)) {
            return mainOperand * subOperand;
        }
        throw new IllegalArgumentException("곱셈 연산자 불일치: " + operator);
    }

    public int division(int mainOperand, int subOperand, String operator) {
        if ("/".equals(operator)) {
            validationDivision(mainOperand, subOperand);
            return mainOperand / subOperand;
        }
        throw new IllegalArgumentException("나눗셈 연산자 불일치: " + operator);
    }

    private void validationDivision(int mainOperand, int subOperand) {
        if (mainOperand % subOperand != 0) {
            throw new IllegalArgumentException("나눗셈 나머지 존재: " + mainOperand + "/" + subOperand);
        }
    }
}
