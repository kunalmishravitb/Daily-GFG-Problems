class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        
        // point to first 0 element
        int zero = 0;
        while(zero<n && arr[zero]!=0) zero++;
        
        int non = zero; // point to first non-zero, after getting zero
        while(non<n && arr[non]==0) non++;
        
        while(non<n){
            // swap
            arr[zero] = arr[non];
            arr[non] = 0;
            
            while(zero<n && arr[zero]!=0) zero++; // point to next zero
            while(non<n && arr[non]==0) non++; // point to next non-zero
        }
    }
}