class Solution {
    public int longestSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int left=0,maxLength=Integer.MIN_VALUE,maxCount=Integer.MIN_VALUE;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            hm.put(c,hm.getOrDefault(c,0)+1);
            maxCount=Math.max(maxCount,hm.get(c));
            while((right-left+1)-maxCount>k){
                char ch=s.charAt(left);
                hm.put(ch,hm.get(ch)-1);
                left++;
            }
            maxLength=Math.max(maxLength,(right-left+1));
        }
        return maxLength;
    }
}
