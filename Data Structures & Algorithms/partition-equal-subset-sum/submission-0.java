class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int need = sum / 2;
        boolean[] dp = new boolean[need + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = need; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[need];
    }
}
