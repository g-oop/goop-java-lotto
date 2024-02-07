package calculator.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private static final Scanner STRING_INPUT = new Scanner(System.in);
    private static final String OPERATION_REGULAR = "^[+\\-*/\\\\d]*$";


    public static String getInput() throws IllegalArgumentException {

        System.out.println("문자열 입력 : ");
        String input = STRING_INPUT.nextLine();
        input = getString(input);
        if(input.isEmpty()){
            throw new IllegalArgumentException("입력 값이 Null이거나 빈 공백 문자입니다.");
        }

        if(!isMatchRegex(input)){
            throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
        }
        return input;
    }

    private static String getString(String input) {
        String[] parts = input.split(" ");
        input = String.join("", parts);
        return input;
    }

    private static boolean isMatchRegex(String input) {
        return Pattern.matches(OPERATION_REGULAR, input);
    }
}
