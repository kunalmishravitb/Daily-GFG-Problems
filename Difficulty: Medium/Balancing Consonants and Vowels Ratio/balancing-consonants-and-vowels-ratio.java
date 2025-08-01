class Solution {
    public int countBalanced(String[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum=0;
        int n = arr.length;
        int ans=0;
        map.put(0,1); // for "" string.
        for(int i=0; i<n; i++){
             for(char ch: arr[i].toCharArray()){
                 if(isVowel(ch))
                 preSum++;
                 else
                 preSum--;
                 
             }
             if(map.containsKey(preSum))
             ans+= map.getOrDefault(preSum,0);
             
           map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
    boolean isVowel(char ch){
        return ch=='a' || ch=='e' ||  ch=='i' || ch=='o' || ch=='u';
    }
}