/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    
    static Node reverse(Node head){
        Node prev = null , curr = head , next = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    static int length(Node head){
        int length = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
    
    static Node removeLeadingZeros(Node head){
        int length = length(head);
        while(head != null && head.data == 0){
            head = head.next;
        }
        return head;
    }
    
    static Node findLargest(Node head1 , Node head2){
        int len1 = length(head1);
        int len2 = length(head2);
        if(len1 > len2){
            return head1;
        } else if(len1 < len2){
            return head2;
        }
        Node temp1 = head1 , temp2 = head2;
        while(temp1 != null){
            if(temp1.data != temp2.data){
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1 == temp2){
            return null;
        }
        return temp1.data > temp2.data ? head1 : head2;
    }
    
    static Node subtractNodes(Node largest , Node smallest){
        int borrow = 0;
        Node temp1 = largest , temp2 = smallest;
        Node res = null , curr = null;
        while(temp2 != null){
            int val1 = temp1.data;
            int val2 = temp2.data;
            if(borrow > 0){
                if(val1 == 0){
                    val1 = 9;
                } else {
                    val1--;
                    borrow--;
                }
            }
            
            if(val1 < val2){
                val1 += 10;
                borrow++;
            }
            if(res == null){
                res = new Node(val1 - val2);
                curr = res;
            } else {
                curr.next = new Node(val1 - val2);
                curr = curr.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null){
            int val = temp1.data;
            if(borrow > 0){
                if(val == 0){
                    val = 9;
                } else {
                    val--;
                    borrow--;
                }
            }
            curr.next = new Node(val);
            curr = curr.next;
            temp1 = temp1.next;
        }
        
        return reverse(res);
    }
    
    static Node subLinkedList(Node head1, Node head2) {
        // code here
        //find largest among the two numbers
        //reverse those numbers
        //perform subtraction opertation
        //reverse the result
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);
        if(head1 == null){
            return head2;
        } else if(head2 == null){
            return head1;
        }
        
        Node largest = findLargest(head1 , head2);
        if(largest == null){
            return new Node(0);
        }
        Node smallest = null;
        if(largest == head1){
            smallest = head2;
        } else {
            smallest = head1;
        }
        Node result = subtractNodes(reverse(largest) , reverse(smallest));
        return removeLeadingZeros(result);
    }
}