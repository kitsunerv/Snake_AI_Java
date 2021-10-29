import java.util.ArrayList;

public class Snake{
    int length;
    ArrayList<int[]> snake;
    Direction dir;

    public Snake(int width,int height,int length){
        this.length=length;
        this.snake=new ArrayList<>();
        for (int i=0;i<length;i++){
            int[] pos=new int[2];
            pos[0]=(height/2)+i;
            pos[1]=(width/2);
            this.snake.add(pos);
        }
        this.dir=Direction.U;
    }

    public void move(Direction d,Board b){
        ArrayList<int[]> res=new ArrayList<>();
        int[] resh=new int[2];
        if(d==Direction.U){
            resh[0]=this.snake.get(0)[0]+1;
            resh[1]=this.snake.get(0)[1];
        }else if(d==Direction.D){
            resh[0]=this.snake.get(0)[0]-1;
            resh[1]=this.snake.get(0)[1];
        }else if(d==Direction.L){
            resh[0]=this.snake.get(0)[0];
            resh[1]=this.snake.get(0)[1]-1;
        }else if(d==Direction.R){
            resh[0]=this.snake.get(0)[0];
            resh[1]=this.snake.get(0)[1]+1;
        }
        if((resh[0]==b.apple.coord[0])&&(resh[1]==b.apple.coord[1])){
            this.length+=1;
            b.score+=100000;
            b.apple.placeNew(b.width,b.height,b);
        }
        if ((this.snake.contains(resh))||(resh[0]>=b.height)||(resh[0]<0)||(resh[1]>=b.width)||(resh[1]<0)||(b.board[resh[0]][resh[1]]==2)){//get this one in the main(pc iut) (shoul i put it on git? it could be a good idea, i'll have to think about that)
            b.gameOver();
        }else{
            res.add(resh);
            for (int i =0;i < this.length-1;i++){
                res.add(this.snake.get(i));
            }
            this.dir=d;
            this.snake.clear();
            this.snake=res;
        }
    }
}