public class BasicQueueArray {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty(){
            return rear == -1;
        }
        public void add(int data){
            if(rear == size-1){
                System.out.println("Queue is Full!");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty!");
                return -1;
            }
            int front = arr[0];
            //Shift all values one index behind
            for(int i = 0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;          //Bcoz rear also shift's one back
            return front;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty!");
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
