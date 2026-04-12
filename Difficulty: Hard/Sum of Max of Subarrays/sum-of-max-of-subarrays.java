class Solution {
    public int sumOfMax(int[] arr) {
        // code here
         int n = arr.length;
        int[] L = new int[n];
        int[] R = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            L[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            R[i] = (stack.isEmpty()) ? n - i : stack.peek() - i;
            stack.push(i);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i] * L[i] * R[i];
        }

        return result;
    }
}

