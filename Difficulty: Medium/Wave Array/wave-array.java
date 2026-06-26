class Solution {
    public void sortInWaveBrute(int arr[]) {
    // sort and swap odd with even index
        Arrays.sort(arr);  //O(n*logn)
        for(int i=1; i<arr.length ; i+=2){
           int temp=arr[i];
           arr[i]=arr[i-1];
           arr[i-1]=temp;
        }
    }
    public void sortInWave(int arr[]) {  //O(n)
    // we want dip/ low on odd indices in array for wave like structure
    // if increasing is scene, swap that with behind one
    // if decreasing is scene, swap tha with forward one
      for(int i=1; i<arr.length ; i+=2){
        if(arr[i-1]<arr[i]){
           int temp=arr[i];
           arr[i]=arr[i-1];
           arr[i-1]=temp; 
        }
      }
    }
}
