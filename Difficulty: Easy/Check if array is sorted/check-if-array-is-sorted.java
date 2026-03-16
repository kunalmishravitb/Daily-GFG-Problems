class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        boolean val = true;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[i-1]){
                val = true;
            }
            else{
                val= false;
                break;
            }
        }
        return val;
    }
}