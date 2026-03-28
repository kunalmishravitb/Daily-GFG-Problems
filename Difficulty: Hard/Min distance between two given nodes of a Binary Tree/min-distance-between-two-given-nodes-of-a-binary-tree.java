// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int nx;
    int ny;
    Node getLCA(Node root, int a, int b) {
        if(root == null || root.data == a || root.data == b)
            return root;
        
        Node left = getLCA(root.left, a, b);
        Node right = getLCA(root.right, a, b);
        
        if(left != null && right != null) return root;
        
        return right == null ? left : right;
    }
    boolean dist(Node root, int target, int sum, boolean flag) {
        if(root == null) return false;
        if(root.data == target) {
            if(flag) nx = sum;
            else ny = sum;
            
            return true;
        }
        
        boolean left = dist(root.left, target, sum + 1, flag);
        if(left) return true;
        boolean right = dist(root.right, target, sum + 1, flag);
        if(right) return true;
        
        return false;
        
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node LCA = getLCA(root, a, b);
        dist(LCA, a, 0, true);
        dist(LCA, b, 0, false);
        return nx + ny;
    }
    
}