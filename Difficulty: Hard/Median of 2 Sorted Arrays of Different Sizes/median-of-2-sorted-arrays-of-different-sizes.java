class Solution {
    public double medianOf2(int a[], int b[]) {
        //take the array for storing both the arrays 
        int arr[]= new int[a.length+b.length];
        int i =0,j=0,k=0;
        // while loop to store the arrays in assending order in the main array
        while(i< a.length && j<b.length){
            if(a[i]>b[j])
                arr[k++] = b[j++];
            else
                arr[k++]=a[i++];
        }
        if(i<a.length)
            while(i<a.length)
                arr[k++]=a[i++];
        
        else
            while(j<b.length)
                arr[k++]=b[j++];
                
        //by finding the length we calculate meadian and return the answer.
        if(arr.length %2 != 0)
            return arr[arr.length/2];
        else{
            double v =arr[arr.length/2]+arr[(arr.length/2)-1];
            double val =v/2;
            return val;
        }
            
        
        
    }
}