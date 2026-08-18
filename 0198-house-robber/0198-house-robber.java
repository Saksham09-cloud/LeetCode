class Solution {

   
 public int rob(int[] nums) {
    int n = nums.length;

    int[][] dp = new int[n][2];

    for (int i = 0; i < n; i++) {
        dp[i][0] = -1;
        dp[i][1] = -1;
    }

    return helper(nums, 0, 1, dp);
}

public int helper(int[] nums, int n, int free, int[][] dp) {

    if (n >= nums.length) {
        return 0;
    }

    if (dp[n][free] != -1) {
        return dp[n][free];
    }

    // free == 1 means we are allowed to rob this house
    if (free == 1) {

        int rob = nums[n] + helper(nums, n + 1, 0, dp);

        int skip = helper(nums, n + 1, 1, dp);

        dp[n][free] = Math.max(rob, skip);

    } else {

        // Previous house was robbed, so we cannot rob this one
        dp[n][free] = helper(nums, n + 1, 1, dp);
    }

    return dp[n][free];
}
}