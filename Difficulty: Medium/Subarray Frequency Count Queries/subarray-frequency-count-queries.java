class Solution {

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {

        ArrayList<Integer>ans=new ArrayList<>();

        Map<Integer,List<Integer>>mpp=new HashMap<>();

        for(int i=0;i<arr.length;i++)

        mpp.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);

        for(int[]q:queries){

            List<Integer>idx=mpp.get(q[2]);

            if(idx==null) ans.add(0);

            else{

            int lb=lowerBound(idx,q[0]);

             

              int ub=upperBound(idx,q[1]);

              

              ans.add(ub-lb);

            }

        }

        return ans;

        }

    private int lowerBound(List<Integer>list,int target){

        int l=0,r=list.size();

        while(l<r){

        int mid=l+(r-l)/2;

        if(list.get(mid)<target)

        l=mid+1;

        else 

        r=mid;

        }

        return l;

    }

   private int upperBound(List<Integer>list,int target){

       int l=0,r=list.size();

       while(l<r){

           int mid=l+(r-l)/2;

           if(list.get(mid)<=target)

           l=mid+1;

           else

           r=mid;

       }

       return l;

   } 

    

}

