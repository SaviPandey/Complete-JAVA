public class ShortestPath {
    public static float getPath(String path){
        int y=0, x=0;
        for(int i=0; i<path.length(); i++){
            
            char dir = path.charAt(i);
            //South    
            if(dir == 'S'){
                y--;
            }
            else if(dir == 'N'){
                y++;
            }
            else if(dir == 'W'){
                x--;
            }
            else{
                x++;
            }
        }
        // using formula sqrt[(x2 - x1)^2 + (y2 - y1)^2 ]
        int X2 = x*x;  // x1 =0 
        int Y2 = y*y; // y1 = 0
        return ((float) Math.sqrt(X2 + Y2));

        
    } 
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getPath(path));;
    }
}
