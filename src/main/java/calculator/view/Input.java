package calculator.view;


import java.util.Scanner;

public class Input {


    private static final Scanner STRING_INPUT = new Scanner(System.in);

    public static String getInput() throws IllegalArgumentException {
        System.out.println("문자열 입력 : ");
        String inputString = STRING_INPUT.nextLine();
        validate(inputString);
        return inputString;
    }

    private static void validate(String inputString) {
        if(inputString == null || inputString.isBlank()){
            throw new IllegalArgumentException("입력 값이 Null이거나 빈 공백 문자입니다.");
        }
    }

}
