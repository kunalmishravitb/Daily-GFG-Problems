//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution { 

  // code here

// function to count number of occurances 
    int countFreq(int[] arr, int target) {
        int lo= lastOccurance(arr,target);
        int fo=  firstOccurance(arr,target);
        if(lo == -1 && fo==-1) return 0;
        return (lo-fo)+1;
    }
        // method to find the first occurance of the taregt elment 
        static int firstOccurance(int[] arr , int target){
        int start =0, end = arr.length-1,fo=-1;
        while(start<=end){
            int mid = start+(end - start)/2;
            if(arr[mid]==target){
                fo=mid;
                end = mid-1;
            }else if(arr[mid]>=target){
                end = mid-1;
            }else start=mid+1;
        }
        return fo;
    } 

         // method to find the last occurance of target 


        static int lastOccurance(int[] arr , int target){
        int start =0, end = arr.length-1,fo=-1;
        while(start<=end){
            int mid = start+(end - start)/2;
            if(arr[mid]==target){
                fo=mid;
                start = mid+1;
            }else if(arr[mid]>=target){
                end = mid-1;
            }else start=mid+1;
        }
        return fo;
    }
    
}
