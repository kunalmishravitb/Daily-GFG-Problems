class Solution {
    int stockBuySell(int arr[]) {
        // code here
        // longest increasing sequence
        int N = arr.length;
        int netProfit = 0;
        int profit = 0;
        int buyPrice = arr[0];
        for (int i = 1 ; i < N ; ++i) {
            if (arr[i] < arr[i-1]) {
                profit = arr[i-1] - buyPrice;
                buyPrice = arr[i];
                
                // System.out.println("profit : " + profit + " buyPrice: " + buyPrice);
                
                if (profit > 0){ 
                    netProfit += profit;
                    profit = 0;
                }
            }
        }
        netProfit += arr[N-1] - buyPrice;
        return netProfit;
    }
}
