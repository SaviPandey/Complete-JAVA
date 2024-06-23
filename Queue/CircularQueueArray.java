public class CircularQueueArray {
    static class Queue {
        int arr[];
        int front;
        int rear;
        int size;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear= -1;
            front = -1;
        }
        
        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public boolean isFull(){
            return (rear+1)%size == front;
        }
        public void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //Add 1st element
            if(front == -1){
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int res = arr[front];

            //Remove last element
            if(front == rear){
                front = rear = -1;
            } else {
                front = (front+1) % size;
            }
            
            return res;
        }
        public int peek(){
            return arr[front];
        }
    }
    public static void main(String args[]){
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
       System.out.println(q.remove());
       q.add(4);
       System.out.println(q.remove());
       q.add(5);

       while(!q.isEmpty()){
        System.out.print(q.peek()+" ");
        q.remove();
       }
    }
}
