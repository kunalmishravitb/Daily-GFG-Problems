/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        if(head==null) return 0;
        Node temp=head;
        int count=0, i=-1;
        while(temp.data>0){
            if(temp.data<0) break;
            if(temp.next==null) return 0;
            temp.data=i;
            temp=temp.next;
            count++;
            i--;
        }
        return count-Math.abs(temp.data)+1;
    }
}