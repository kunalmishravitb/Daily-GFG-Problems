// User function Template for Java

class Solution {
    static int palPartition(String s) {
        // code here
        int n = s.length();
        //create a palindrome table
        boolean [][] ispalindrome = new boolean[n][n];
        for(int i = 0; i < n; i++)
        {
            ispalindrome[i][i] = true; // for 0,0 / 1,1 / 2,2 / 3,3 all are true
        }
        //for length 2 and more
        for(int len = 2; len <= n; len++)
        {
            for(int i = 0; i + len - 1 < n; i++)
            {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && (len == 2 || ispalindrome[i+1][j-1]))
                {
                    ispalindrome[i][j] = true;
                }
            }
        }
        
        //create a  dp for cut count
        int dp[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            dp[i] = n;
        }
        
        dp[0] = 0; //single char need no cut
        for(int i = 1; i < n; i++)
        {
            if(ispalindrome[0][i])
            {
                dp[i] = 0;
            }
            else
            {
                ///cut at position
                for(int j = i; j >= 1; j--)
                {
                    if(ispalindrome[j][i])
                    {
                        dp[i] = Math.min(dp[i] , 1 + dp[j-1]);
                    }
                }
            }
        }
        return dp[n-1];
    }
}