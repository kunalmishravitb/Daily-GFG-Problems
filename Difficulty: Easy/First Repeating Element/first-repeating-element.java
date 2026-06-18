class Solution {
    public static int firstRepeated(int[] arr) {
        // code here
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int num : arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
      for (int i = 0; i < arr.length; i++) {
            if (mp.get(arr[i]) > 1) {
                return i+1;
            }
        }
        
        return -1;
    }
}
