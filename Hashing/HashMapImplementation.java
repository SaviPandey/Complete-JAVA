import java.util.*;
public class HashMapImplementation{
    static class HashMap<K, V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n
        private int N;
        private LinkedList<Node> buckets[]; //N : buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4 ;
            this.buckets = new LinkedList[4];
            for(int i=0; i < 4; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for(int i=0; i < N; i++){
                buckets[i] = new LinkedList<>();
            }
            //nodes ---> add in bucket
            for(int i=0; i < oldBuckets.length; i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0; j < ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i=0; i < ll.size(); i++){
                Node node = ll.get(i);
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }

        public void put(K key, V value){   //O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);    //If not present then -1

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double)n / N;
            if(lambda > 2.0){
                reHash();
            }
        }

        public boolean containsKey(K key){   //O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            return di != -1;
        }

        public V get(K key){  //O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key){  // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--; 
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
    }
    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("USA", 200);
        hm.put("China", 300);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys){
            System.out.print(key+" ");
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
        System.out.println(hm.isEmpty());
    }
}
