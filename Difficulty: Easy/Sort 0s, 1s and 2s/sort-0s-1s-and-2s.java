//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

class Solution {
    void swap(int i,int j, int arr[]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sort012(int[] arr) {
      int n=arr.length;
      int left=0;
      int mid=0;
      int right=n-1;
      while(mid<=right){
          if(arr[mid]==0){
             swap(left,mid,arr);
             left++; 
             mid++;
          }else if(arr[mid]==1){
              mid++;
          }else {
              swap(mid,right,arr);
              right--;            
          }
      }
    }
}


//{ Driver Code Starts.
// } Driver Code Ends