class Solution {

    public long cointcount(int i, int[] coins, int amount, long[][] dp) {

        if (amount == 0)
            return 0;

        if (i == coins.length)
            return Integer.MAX_VALUE;

        if (dp[i][amount] != -1)
            return dp[i][amount];

        long skip = cointcount(i + 1, coins, amount, dp);

        long pick = Integer.MAX_VALUE;

        if (coins[i] <= amount) {
            long result = cointcount(i, coins, amount - coins[i], dp);

            if (result != Integer.MAX_VALUE)
                pick = 1 + result;
        }

        return dp[i][amount] = Math.min(skip, pick);
    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        long[][] dp = new long[coins.length][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        long ans = cointcount(0, coins, amount, dp);

        if (ans == Integer.MAX_VALUE)
            return -1;

        return (int) ans;
    }
}