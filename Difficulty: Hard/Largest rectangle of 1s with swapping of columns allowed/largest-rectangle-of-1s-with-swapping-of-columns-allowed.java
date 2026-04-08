// User function Template for Java

class Solution {
    int maxArea(boolean[][] mat, int r, int c) {
        // code here
        int Result = 0;
        int newarr[] = new int[mat[0].length];
        for(int a = 0; a < mat.length; a++){
            
            for(int j = 0; j < mat[a].length; j++){
                if(mat[a][j] == false) {
                    newarr[j] = 0;
                    continue;    
                }
                
                if(mat[a][j] == true)
                    newarr[j] += 1;
            }
            
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();
            
            int[] arr = newarr.clone();
            Arrays.sort(arr);
            // System.out.println(Arrays.toString(arr));
            
            for(int i = 0; i < arr.length; i++){
                
                if(set.contains(arr[i])) continue;
                
                for(int j = i; j < arr.length; j++){
                    if(!set.contains(arr[i])) {
                        
                        map.put(arr[i], arr[i]);  
                        set.add(arr[i]);
                        
                    } else if(set.contains(arr[i])){
                        
                        map.put(arr[i], map.get(arr[i]) + arr[i]);
                        
                    }
                }
            }
            
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
             if(entry.getValue() > Result) Result = entry.getValue();
            
        }
        
        return Result;
    }
}