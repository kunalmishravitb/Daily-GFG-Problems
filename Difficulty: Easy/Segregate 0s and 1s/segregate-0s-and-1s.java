class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int left=0,right=arr.length-1;
        while(left<=right){
            if(arr[left]==1 && arr[right]==0){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            if(arr[left]==0){
                left++;
            }
            if(arr[right]==1){
                right--;
            }
        }
    }
}