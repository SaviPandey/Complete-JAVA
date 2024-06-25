import java.util.*;
public class ChocolaProblem {
    public static void main(String[] args) {
        // int n = 4, m = 6;   //Number of Rows and Columns of the chocolate
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        //SOrt in decending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        //Initialize
        int h = 0, v = 0; //Pointers to iterate on arrays
        int hp = 1, vp = 1; //Number of pieces initilly are only 1
        int totalCost = 0;

        while(h < costHor.length && v < costVer.length) {
            if(costVer[v] >= costHor[h]) { //Maximum cost cut first : Vertical Cut
                totalCost += (costVer[v]) * hp; // cost = verCutCost * number Of Horizontal Pieces
                vp++;
                v++;     
            } else {                                //Horizontal Cut
                totalCost += (costHor[h]) * vp;
                hp++;
                h++;
            }
        }
        //For remaining cut' in arrays
        //Horizontal
        while(h < costHor.length) {
            totalCost += (costHor[h]) * vp;
            hp++;
            h++;
        }
        //Vertical
        while(v < costVer.length) {
            totalCost += (costVer[v]) * hp; 
            vp++;
            v++;
        }
        System.out.println("Minimum Cost of Cuts : "+totalCost);
    }
}
