// User function Template for Java

class Solution {
    int dp[][];
    public int minDifference(int arr[]) {
        // Your code goes here
        int sum=0;
        int n=arr.length;
        for(int ele:arr) sum+=ele;
        dp=new int[n+1][(sum/2)+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<(sum/2)+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<n+1;i++) {
            dp[i][0]=1;
        }
        for(int i=1;i<(n+1);i++){
            for(int j=1;j<(sum/2)+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] | dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int i=(sum/2);i>=0;i--){
            if(dp[n][i]==1){
                return sum-2*i;
            }
        }
        return 0;
    }
}