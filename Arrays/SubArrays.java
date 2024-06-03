public class SubArrays{
    public static void subArrays(int numbers[]){
        int total =0;
        for(int i=0 ; i<numbers.length ; i++){
            for(int j=i ; j<numbers.length ; j++ ){
                for(int k=i ; k<=j ; k++){
                    System.out.print(numbers[k]+" ");
                }
                total++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total :"+total);
    }
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5};
        subArrays(numbers);
    }
}