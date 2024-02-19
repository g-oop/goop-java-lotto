package lotto.view;

import java.util.List;

public class Output {


    public static void getPurchasedLottoCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printGeneratedLottoNumbers(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i += 6) {
            List<Integer> singleTicket = lottoNumbers.subList(i, i + 6);
            System.out.println(singleTicket);
        }
    }
    public static void printWinningStatistics(int[] matchCounts) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, getPrizeAmount(i), matchCounts[i]);
        }
    }

    public static void printProfitRate(double profitRate) {
        if(profitRate > 1){
            System.out.printf("총 수익률은 %.2f입니다. (기준이 1보다 크기 때문에 결과적으로 이득)\n", profitRate);
            return;
        }
        System.out.printf("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", profitRate);
    }

    private static int getPrizeAmount(int matchCount) {
        return switch (matchCount) {
            case 3 -> 5000;
            case 4 -> 50000;
            case 5 -> 1500000;
            case 6 -> 2000000000;
            default -> 0;
        };
    }



}
