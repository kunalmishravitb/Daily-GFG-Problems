class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
        List<Integer> array = new ArrayList<>();
        int idx = 0;
        
        while(idx < arr.length)
        {
            if (!array.isEmpty() && (
                (array.get(array.size() - 1) >= 0 && 
                arr[idx] < 0) || 
                (array.get(array.size() - 1) < 0 && 
                arr[idx] >= 0))) array.removeLast();
                
            else array.add(arr[idx]);
            
            idx++;
        }
        
        return array;
    }
}
