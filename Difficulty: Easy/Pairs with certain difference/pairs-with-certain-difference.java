class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        
        int maxPairSum = 0;
        int n = arr.length;
        int i = n - 1;
        while(i >= 0){
            
            if(i >= 0 && (i-1) >= 0 && (arr[i] - arr[i-1] < k)){
                maxPairSum += arr[i] + arr[i-1];
                i -= 2;
            }else{
                i--;
            }
        }
        return maxPairSum;
    }
}
