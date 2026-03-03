class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        TreeSet <Integer> set =  new TreeSet <>();
        for(int num : a) set.add(num);
        for(int num : b) set.add(num);
        return new ArrayList<>(set); 
    }
}