/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        dfsTraversal(root, hm , 0);
        ArrayList<Integer> al = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int key : hm.keySet()){
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        for(int i = min; i <= max; i++){
            al.add(hm.get(i));
        }
        return al;
        }
    public void dfsTraversal(Node node, HashMap<Integer, Integer> hm, int data){
        if(node == null)return;
        if(hm.containsKey(data))
            hm.put(data, hm.get(data) + node.data);
            else
            hm.put(data, node.data);
        dfsTraversal(node.left, hm, data-1);
        dfsTraversal(node.right, hm, data+1);
    }
}