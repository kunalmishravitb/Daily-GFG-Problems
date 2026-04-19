class Solution {
    public boolean isPower(int x, int y) {
        // code here
        long num=1;
        if(x==1){
            return (y==1);
        }
        while(num<y){
            num*=x;
        }
        return (num==y);
    }
}