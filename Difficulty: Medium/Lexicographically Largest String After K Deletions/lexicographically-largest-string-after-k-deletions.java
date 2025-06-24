class Solution {
    public static String maxSubseq(String s, int k) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()-'0'<ch-'0'){
                st.pop();
                k-- ; 
            }
            
            st.push(s.charAt(i));
        }
        
        while(k>0){
            k-- ; 
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}