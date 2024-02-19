package lotto.data;

public enum PrizeAmount {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    private final int matchCount;
    private final int prizeAmount;

    PrizeAmount(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static int getPrizeAmount(int matchCount) {
        for (PrizeAmount prize : values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize.getPrizeAmount();
            }
        }
        return 0; // default
    }


}
