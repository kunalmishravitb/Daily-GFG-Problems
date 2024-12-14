//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int index = -1;
        while(i <= j){
            int mid = (i + j)/2;
            if(arr[mid] == key) return mid;
            if(arr[i] <= arr[j]){
                if(arr[i] <= key && key <= arr[j]){
                    if(arr[mid] < key) i = mid + 1;
                    else j = mid - 1;
                }else return -1;
            }else{ // arr[i] > arr[j]
                if(arr[mid] > arr[j]){ // sorted first part ( i -> mid)
                    if(arr[i] <= key && key <= arr[mid]) j = mid - 1;
                    else i = mid + 1;
                }else{  // sorted second part  (mid -> j)
                    if(arr[mid] <= key && key <= arr[j]) i = mid + 1;
                    else j = mid - 1;
                }
            }
        }
        
        return index;
    }
}
