import java.util.*;
public class HeapOpr {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public boolean isEmpty() {
            return arr.size() == 0;
        }
        public void insert(int data) {
            //Add at last Index
            arr.add(data);

            //Fix Heap Order 
            int child = arr.size() - 1; //Last index
            int parent = (child - 1) / 2; 

            while(arr.get(child) < arr.get(parent) ) {
                //Swap
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                //Update child and Parent Pointers
                child = parent;
                parent = (child - 1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2  * i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if(minIdx != i) {
                //Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx); //Call for lower levels
            }
        }

        //Remove from Start
        public int remove() { 
            int data = arr.get(0);

            //Swap first and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            //Step-2 : Remove Last index
            arr.remove(arr.size() - 1);

            //Step-3 : Fix the Heap Order
            heapify(0);
            return data;
        }


    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(3);
        h.insert(4);
        h.insert(9);
        h.insert(5);

        while(!h.isEmpty()) {
            System.out.print(h.peek()+" ");
            h.remove();
        }
    }
}
