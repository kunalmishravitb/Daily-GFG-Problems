// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int col=arr[0].length;
        int rows=arr.length;
        
        
        for(int i=0;i<col;i++){
            for(int j=0;j<rows;j++){
                if(arr[j][i]==1)
                    return j;
            }
        }
        return -1;
    }
}