package lotto;


import java.util.List;

import lotto.service.LottoGame;
import lotto.strategy.LottoGenerator;

import static lotto.view.Input.inputLastWeeksWinningNumbers;
import static lotto.view.Input.inputPurchaseAmount;
import static lotto.view.Output.getPurchasedLottoCount;
import static lotto.view.Output.printGeneratedLottoNumbers;

public class LottoApplication {


    public static void main(String[] args) {
        int ticketCount = inputPurchaseAmount();
        getPurchasedLottoCount(ticketCount);
        List<Integer> lottoNumbers = LottoGenerator.generateLottoNumbers(ticketCount);
        printGeneratedLottoNumbers(lottoNumbers);
        List<Integer> winningNumbers = inputLastWeeksWinningNumbers();
        LottoGame.calculateWinningStatistics(lottoNumbers, winningNumbers);
    }
}

