class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        Arrays.sort(arr);
        boolean find=false;
        for(int i=0;i<arr.length;i++)
        {
            int search=arr[i]+x;
            int l,u;
            l=i+1;
            u=arr.length-1;
            
            while(l<=u)
            {
                int mid=(l+u)/2;
                
                if(search<arr[mid])
                    u=mid-1;
                else if(search>arr[mid])
                    l=mid+1;
                else
                {
                    find=true;
                    break;
                }
            }
        }
        return find;
    }
}
