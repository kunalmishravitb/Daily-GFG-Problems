/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    
    public static void helper1(Node root,int[] sum){
        if(root == null) return ;
        sum[0]+=root.data;
        helper1(root.left,sum);
        helper1(root.right,sum);
        
    }
    public static void helper2(Node root,int[] sum){
        if(root == null) return ;
        helper2(root.left,sum);
        sum[0]-=root.data;
        root.data=sum[0];
        helper2(root.right,sum);
        
    }
    public static void transformTree(Node root) {
        // code here
        int[] sum=new int[1];
        helper1(root,sum);
        helper2(root,sum);
        
    }
}