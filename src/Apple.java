import java.util.Random;
public class Apple {

    public int[] coord;

    public Apple(int w,int h,Board b){
        this.coord=new int[2];
        this.placeNew(w,h,b);
    }

    public void placeNew(int width,int height,Board b){
        Random rd = new Random();
        this.coord[0] = rd.nextInt(height);
        this.coord[1] = rd.nextInt(width);
        while(b.board[this.coord[0]][this.coord[1]]!=0){
            this.coord[0] = rd.nextInt(height);
            this.coord[1] = rd.nextInt(width);
        }

    }


}
