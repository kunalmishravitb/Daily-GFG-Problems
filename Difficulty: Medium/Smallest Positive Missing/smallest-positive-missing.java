class Solution {
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length + 1; 

        
        for (int i = 0; i < arr.length; ) {
            int correctIndex = arr[i] - 1;
            if (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
             
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }

    
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n;
    }
}