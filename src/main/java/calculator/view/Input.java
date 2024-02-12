package calculator.view;


public class Input {


    public static String[] getInput(String inputString) throws IllegalArgumentException {
        validate(inputString);
        return input.split(" ");
    }

    private static void validate(String inputString) {
        if(inputString == null || inputString.isBlank()){
            throw new IllegalArgumentException("입력 값이 Null이거나 빈 공백 문자입니다.");
        }
    }

}
