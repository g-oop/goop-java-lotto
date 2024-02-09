package calculator.view;


public class Input {


    public static String[] getInput(String inputString) throws IllegalArgumentException {
        validate(inputString);
        return splitFromInput(inputString);
    }

    private static void validate(String inputString) {
        if(inputString == null || inputString.isEmpty()){
            throw new IllegalArgumentException("입력 값이 Null이거나 빈 공백 문자입니다.");
        }
    }

    private static String[] splitFromInput(String input) {
        return input.split(" ");
        }
}
