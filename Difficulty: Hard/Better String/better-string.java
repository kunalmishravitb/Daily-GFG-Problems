// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        int n = str1.length(), m = str2.length();  
        long[] dp1 = new long[n + 1];
        long[] dp2 = new long[m + 1];
        int[] last1 = new int[26];
        int[] last2 = new int[26];

        for(int i=0;i<26;i++)last1[i]=last2[i]=-1;
        dp1[0]=dp2[0]=1;
        for(int i=1;i<=n;i++){
            dp1[i]=2*dp1[i-1];
            if(last1[str1.charAt(i-1)-'a']!=-1)
                dp1[i]-=dp1[last1[str1.charAt(i-1)-'a']];
            last1[str1.charAt(i-1)-'a']=i-1;
        }
        for(int i=1;i<=m;i++){
            dp2[i]=2*dp2[i-1];
            if(last2[str2.charAt(i-1)-'a']!=-1)
                dp2[i]-=dp2[last2[str2.charAt(i-1)-'a']];
            last2[str2.charAt(i-1)-'a']=i-1;
        }
        if(dp1[n]>=dp2[m])return str1;
        return str2;
    }
}
