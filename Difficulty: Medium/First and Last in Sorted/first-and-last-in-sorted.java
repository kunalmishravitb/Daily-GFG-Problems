class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int firstIdx=-1;
        boolean findfirstIdx=false;
        int lastIdx=-1;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                if(findfirstIdx==false){
                    firstIdx=i;
                    findfirstIdx=true;
                }
                lastIdx=i;
            }
        }
        list.add(firstIdx);
        list.add(lastIdx);
        return list;
    }
}
