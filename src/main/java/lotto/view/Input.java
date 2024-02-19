package lotto.view;

import java.util.*;

public class Input {

    private static final Scanner VALUE_INPUT = new Scanner(System.in);
    private static final String REGEX = ",\\s*";

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int totalAmount = VALUE_INPUT.nextInt();
        VALUE_INPUT.nextLine();
        return calculateLottoCount(totalAmount);
    }

    private static int calculateLottoCount(int totalAmount){
        if(totalAmount < 0){
            throw new IllegalArgumentException("구입금액은 음수가 될 수 없습니다.");
        }
        return totalAmount / 1000;
    }

    public static List<Integer> inputLastWeeksWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lastWeeksWinningNumbers = new ArrayList<>();
        String input = VALUE_INPUT.nextLine().trim();
        String[] arr = input.split(REGEX);
        for (String num : arr) {
            lastWeeksWinningNumbers.add(Integer.parseInt(num));
        }
        return lastWeeksWinningNumbers;
    }
}
