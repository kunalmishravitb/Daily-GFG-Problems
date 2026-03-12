class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        int n=arr.length;
        List<Integer>list=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(int i=1;i<=n;i++){
          if(map.containsKey(i)){
               list.add(map.get(i));
            }else{
                list.add(0);
            }
        }
        return list;
    }
}