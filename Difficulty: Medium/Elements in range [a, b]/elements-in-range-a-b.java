class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> outputList = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for (int[] query : queries) {
            int a = query[0], b = query[1];
            int left = findLeft(arr, a, b);
            if (left == -1) {
                outputList.add(0);
                continue;
            }
            
            int right = findRight(arr, a, b);
            outputList.add(right - left + 1);
        }
        
        return outputList;
    }
    
    private int findLeft(int[] arr, int min, int max) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= min && arr[mid] <= max) {
                ans = mid;
                right = mid - 1;    
            } else if (arr[mid] > max) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    private int findRight(int[] arr, int min, int max) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= min && arr[mid] <= max) {
                ans = mid;
                left = mid + 1;    
            } else if (arr[mid] > max) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
}