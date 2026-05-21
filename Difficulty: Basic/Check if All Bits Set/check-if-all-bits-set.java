class Solution {
    public boolean isBitSet(int n) {
        // code here
        return !Integer.toBinaryString(n).contains("0");
    }
};       
