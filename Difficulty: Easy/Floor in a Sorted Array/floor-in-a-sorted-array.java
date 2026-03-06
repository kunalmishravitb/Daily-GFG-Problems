class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int n=arr.length;
        int low=0;
        int high=n-1;
        int result=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]<=x)
            {
                result=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return result;
    }
}