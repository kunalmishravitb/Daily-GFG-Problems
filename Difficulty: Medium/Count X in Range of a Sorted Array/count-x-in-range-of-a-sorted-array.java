class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
    ArrayList<Integer> result = new ArrayList<>();
    for(int[] q : queries){
        int count = getCount(arr, q[0], q[1], q[2]);
        result.add(count);
    }
    return result;
}

private int getCount(int[] arr, int L, int R, int x) {
    int first = firstOccurrence(arr, L, R, x);
    if(first == -1 || first > R) return 0;
    int last = lastOccurrence(arr, L, R, x);
    return last - first + 1;
}

private int firstOccurrence(int[] arr, int L, int R, int x) {
    int result = -1;
    while(L <= R){
        int mid = L + (R - L)/2;
        if(arr[mid] == x){
            result = mid;
            R = mid - 1;  // Look left for earlier occurrence
        } else if(arr[mid] < x){
            L = mid + 1;
        } else {
            R = mid - 1;
        }
    }
    return result;
}

private int lastOccurrence(int[] arr, int L, int R, int x) {
    int result = -1;
    while(L <= R){
        int mid = L + (R - L)/2;
        if(arr[mid] == x){
            result = mid;
            L = mid + 1;  // Look right for later occurrence
        } else if(arr[mid] < x){
            L = mid + 1;
        } else {
            R = mid - 1;
        }
    }
    return result;
}


}