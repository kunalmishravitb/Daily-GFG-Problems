class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> arr1= new ArrayList<>();
        if(arr.length == 0){
            return arr1;
        }
         arr1.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                arr1.add(arr[i]);
            }
        }
        return arr1;
    }
}