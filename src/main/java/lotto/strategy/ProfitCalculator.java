package lotto.strategy;

public class ProfitCalculator {
    public static double calculateProfit(int totalPrize, int totalTickets) {
        int totalSpent = totalTickets * 1000;
        return ((double) totalPrize - totalSpent) / totalSpent;
    }
}
