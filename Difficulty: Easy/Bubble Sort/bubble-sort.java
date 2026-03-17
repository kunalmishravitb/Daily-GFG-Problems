class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            int didswap =0;
            for(int j=0;j<=i-1;j++){
                if(arr[j] > arr[j+1]){
                     int t = arr[j+1];
                     arr[j+1] = arr[j];
                     arr[j] = t;
                     didswap =1;
                }
               if(didswap < 0){
                   break;
               }
            }
        }
    }
}