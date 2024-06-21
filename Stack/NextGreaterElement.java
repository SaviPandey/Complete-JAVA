import java.util.*;
public class NextGreaterElement {
    public static void nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int nextGreater[] = new int[n];
        
        //for last element in array , nextGreater would be -1
        nextGreater[n-1] = -1;
        s.push(n - 1); //Push last index into stack

        for(int i = n-2; i>= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        //Print next greater array
        for(int i =0; i<n; i++) {
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {6, 8, 0, 1, 3};
        nextGreater(arr);

        for(int i =0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
