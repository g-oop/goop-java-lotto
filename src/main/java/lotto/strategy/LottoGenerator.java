package lotto.strategy;

import java.util.*;

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers(int totalCount) {

        List<Integer> allTickets = new ArrayList<>();

        for (int ticketIndex = 0; ticketIndex < totalCount; ticketIndex++) {
            List<Integer> lottoNumbers = generateSingleLottoTicket();
            Collections.sort(lottoNumbers);
            allTickets.addAll(lottoNumbers);
        }


        return allTickets;
    }
    private static List<Integer> generateSingleLottoTicket() {
        List<Integer> numList = new ArrayList<>();
        for (int j = 1; j <= 45; j++) {
            numList.add(j);
        }
        Collections.shuffle(numList);
        return numList.subList(0, 6);
    }
}
