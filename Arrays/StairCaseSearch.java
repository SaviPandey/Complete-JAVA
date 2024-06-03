public class StairCaseSearch {
    public static boolean stairCaseSearch(int matrix[][], int key){
        int row=0, col = matrix[0].length-1;
        while(row < matrix.length && col >= 0 ){
            if(matrix[row][col] == key){
                System.out.print("Found at ("+row+","+col+") location.");
                return true;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.print("Key not found in the matrix!");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50} };
        int key =33;
        stairCaseSearch(matrix, key);   // Time complexity = O(n+m)
    }
}
