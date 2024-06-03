import java.util.*;
public class Array2D{
    public static boolean search(int matrix[][] , int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.println(key+" found at "+"("+i+","+j+") location.");
                    return true;
                }
            }    
        }
        System.out.println("Not found!");
        return false;
    }

    public static void maxValue(int matrix[][]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
                else{
                    continue;
                }
            }
        }
        System.out.println("Max Value : "+max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        int n= matrix.length;  //row size
        int m= matrix[0].length;  //column size

        int key =5; 
        //input
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        //print
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
        search(matrix, key);
        maxValue(matrix);

        sc.close();
    }
}