class Solution {
    public boolean isAns(int[] nums, int k, double ans){
        int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]-prev>ans){
                k -= (int)Math.ceil(((double)nums[i]-prev)/ans)-1; // required station to make dist <= ans
            }
            prev = nums[i];
        }
        return k>=0; // dist balanced under available stations => true 
    }
    public double minMaxDist(int[] stations, int K) {
        int n = stations.length;
        double l = 0;
        double r = Double.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            // max dist b/w two stations
            r = Math.max(r, stations[i+1]-stations[i]);
        }
        
        while(r-l > 0.000001){ // as ques asked for value upto 6 decimal place
            double mid = l+(r-l)/2;
            if(isAns(stations, K, mid)){
                r = mid;
            }else{
                l = mid;
            }
        }
        return r;
    }
}
