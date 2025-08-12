class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int min = 0,max = 0,n = prices.length;
        Arrays.sort(prices);
        int r = n-1,l=0;
        while(l<=r){
            min += prices[l++];
            r -= k;
        }
        r = n-1;
        l = 0;
        while(l<=r){
            max += prices[r--];
            l += k;
        }
        return new ArrayList<>(Arrays.asList(min,max));
    }
}
