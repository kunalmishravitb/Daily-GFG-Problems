// User function Template for Java

class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        List<Integer> arr=new ArrayList<>();
        int cnt=0;
        for(int i=0;i<N;i++) {
            if(Arrays.binarySearch(B,A[i])>=0) {
                if(arr.isEmpty()) {
                    arr.add(A[i]);
                    cnt=1;
                    continue;
                }
                if(arr.get(arr.size()-1)<A[i]) {
                    arr.add(A[i]);
                    cnt++;
                }
                else {
                    int idx=Collections.binarySearch(arr,A[i]);
                    if(idx<0) {
                        idx*=(-1);
                        idx--;
                    }
                    arr.set(idx,A[i]);
                }
            }
        }
        return (M-cnt)+(N-cnt);
    }
};