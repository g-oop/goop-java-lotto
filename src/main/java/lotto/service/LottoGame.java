package lotto.service;

import java.util.List;

import lotto.data.PrizeAmount;
import lotto.entity.Lotto;
import lotto.strategy.ProfitCalculator;
import lotto.view.Output;


public class LottoGame {


    public static void calculateWinningStatistics(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        int[] matchCounts = new int[7];
        int totalPrize = 0;

        for (int i = 0; i < lottoNumbers.size(); i += 6) {
            List<Integer> singleTicket = lottoNumbers.subList(i, i + 6);
            Lotto lotto = new Lotto(singleTicket);
            totalPrize = calculateMatchCountAndUpdateStatistics(winningNumbers,lotto, matchCounts, totalPrize);
        }

        Output.printWinningStatistics(matchCounts);
        double profitRate = ProfitCalculator.calculateProfit(totalPrize, lottoNumbers.size() / 6);
        Output.printProfitRate(profitRate);
    }

    private static int calculateMatchCountAndUpdateStatistics(List<Integer> winningNumbers,Lotto lotto, int[] matchCounts, int totalPrize) {
        int matchCount = lotto.calculateMatchCount(winningNumbers);
        if (matchCount >= 3 && matchCount <= 6) {
            matchCounts[matchCount]++;
            totalPrize += PrizeAmount.getPrizeAmount(matchCount);
        }
        return totalPrize;
    }
}
