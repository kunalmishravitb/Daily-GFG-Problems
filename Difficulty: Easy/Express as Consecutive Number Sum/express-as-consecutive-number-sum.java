class Solution {
    public boolean isSumOfConsecutive(int n) {
        // code here
        if(n>=3 && (n&(n-1))!=0){
            return true;
        }
    return false;
    }
}
