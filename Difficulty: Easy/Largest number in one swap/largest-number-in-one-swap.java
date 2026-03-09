class Solution {
    public String largestSwap(String s) {
        // code here
        boolean p=false;
        int idx=-1;
        
        for(int i=0;i<s.length()-1;i++){
             if(s.charAt(i)<s.charAt(i+1)){
                 idx=i+1;
                 p=true;
                 break;
             }
        }
        if(!p)return s;
        
        char c='0';
        int si=-1;
        
        for(int i=idx;i<s.length();i++){
             if(s.charAt(i)>=c){
                 c=s.charAt(i);
                 si=i;
             }
        }
       // System.out.println(si+" "+c);
        
        StringBuilder sb=new StringBuilder(s);
        
        for(int i=0;i<idx;i++){
            if(c>s.charAt(i)){
                sb.setCharAt(i,s.charAt(si));
                sb.setCharAt(si,s.charAt(i));
                break;
            }
        }
        
        return sb.toString();
    }
}