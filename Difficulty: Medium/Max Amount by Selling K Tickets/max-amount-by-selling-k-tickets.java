class Solution {
    private static final int MOD = (int)1e9 + 7;
    
    public int maxAmount(int[] arr, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
            (p, q) -> Integer.compare(q, p)    
        );
        
        for (int a: arr) {
            pq.offer(a);
        }
        
        int res = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int price = pq.poll();
            res = (res + price) % MOD;
            if (price -1 > 0) pq.offer(price -1);
        }
        return res;
    }
}
