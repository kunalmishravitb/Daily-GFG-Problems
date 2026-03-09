class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        
        double [][]ans=new double[val.length][2];
        
        for(int i=0;i<val.length;i++){
              double a=val[i];
              double b=wt[i];
              ans[i][0]=a/b;
              ans[i][1]=i;
        }
        
        Arrays.sort(ans,Comparator.comparing(o->o[0]));
        
        int i=ans.length-1;
        double answer=0;
        while(capacity>0 &&  i>=0){
               int idx=(int)ans[i][1];
               int  a=wt[idx];
               int  b=val[idx];
               if(capacity>=a){
                   answer+=b;
                   capacity=capacity-a;
               }
               else{
                   double c=capacity;
                   double d=a;
                   double e=c/d;
                   answer+=(e*b);
                   break;
               }
               i--;
        }
        
        return answer;
    }
}