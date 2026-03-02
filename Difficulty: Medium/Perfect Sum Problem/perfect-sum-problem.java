class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int num:nums){
            for(int sum=target;sum>=num;sum--){
                dp[sum]=dp[sum]+dp[sum-num];
            }
        }
        
        return dp[target];
    }
}