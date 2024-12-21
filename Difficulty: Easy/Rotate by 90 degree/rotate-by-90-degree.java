//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    public static void swap(int[][] mat,int i,int j){
        int t=mat[i][j];
        mat[i][j]=mat[j][i];
        mat[j][i]=t;
        return;
        
    }
    
    
    public static void doTranspose(int[][] mat){
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(mat,i,j);
                
            }
            
        }
        return;
    }
    
    public static void doColumnReverse(int[][] mat){
        int n=mat.length;
        for(int i=0;i<n;i++){
            int l=0,h=n-1;
            while(l<h){
                int t=mat[l][i];
                mat[l][i]=mat[h][i];
                mat[h][i]=t;
                l++;
                h--;
                
            }
            
        }
        return;
        
    }
    
    
    static void rotateby90(int mat[][]) {
        // code here
        doTranspose(mat);
        doColumnReverse(mat);
        return;
    }
}
