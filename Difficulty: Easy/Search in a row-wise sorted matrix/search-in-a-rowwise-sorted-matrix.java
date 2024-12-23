//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchRowMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n=mat.length;
        int m=mat[0].length;
        int left=0;
        while(left<n){
           int row=0;
           int col=m-1;
            while(row<=col){
                int mid=row+(col-row)/2;
                if(mat[left][mid]<x){
                 row++;
                 }
              else if(mat[left][mid]>x){
                col--;
                }
            else{
                return true;
            }
            }
            left++;
        }
        return false;
    }
}
