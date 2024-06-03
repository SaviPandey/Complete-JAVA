public class DiagonalSum {
    public static void diagonalSum(int matrix[][]){

        //Brute force O(n^2)
        int sum=0;
        // for(int i=0 ; i< matrix.length; i++){
        //     for(int j=0; j< matrix[0].length; j++){
        //         if(i==j){                               //for primary diagonal sum
        //             sum += matrix[i][j];
        //         }
        //         else if(i+j == matrix.length-1){         //for secondary diagonal sum
        //             sum += matrix[i][j];
        //         } 

        //     }
        // }
        for(int i=0; i<matrix.length; i++){
            //pd
            sum += matrix[i][i];
            //sd
            if(i != matrix.length-1-i)
                System.out.println(i+" "+(matrix.length-1-i)); //Testing
                sum += matrix[i][matrix.length-i-1];   // if [i+j = n-1] then [j= n-1-i]
        }

        System.out.println(sum);
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        diagonalSum(matrix);
    }
}
