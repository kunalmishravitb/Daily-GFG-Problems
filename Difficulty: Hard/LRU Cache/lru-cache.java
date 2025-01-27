//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    // Constructor to initialize capacity of cache
    LRUCache(int cap) {
        this.capacity = cap;
        cache = new HashMap<>();
        
        // Initialize dummy head and tail nodes
        head = new Node(-1, -1); 
        tail = new Node(-1, -1);
        
        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }

        Node node = cache.get(key);
        
        // Move the accessed node to the front (most recent)
        remove(node);
        addToFront(node);
        
        return node.value;
    }

    // Function for storing key-value pair
    public void put(int key, int value) {
        // If the key is already in the cache, update the value and move it to the front
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            // If the cache is full, remove the least recently used node (tail's prev)
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            // Add the new key-value pair to the cache and the front of the list
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }

    // Helper function to add a node to the front of the list
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper function to remove a node from the list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}