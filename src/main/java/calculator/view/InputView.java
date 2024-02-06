package calculator.view;

import java.util.*;

import calculator.alu.MethIngredient;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<MethIngredient> inputStringEquation() {
        display();
        return splitMethIngredients(userStringInput());
    }

    private static void display() {
        System.out.println("""
            수식을 입력하세요.
            조건1) 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열
            조건2) 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정
            """);
    }

    private static String userStringInput() {
        return SCANNER.nextLine();
    }

    private static List<MethIngredient> splitMethIngredients(String text) {
        return Arrays
            .stream(text.split(" "))
            .map(MethIngredient::new)
            .toList();
    }
}
