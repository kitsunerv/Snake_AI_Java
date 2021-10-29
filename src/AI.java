
public class AI {
    
    public static Direction IA(Board b){
        Direction res=b.currDir;
        int[] d = distance(b);
        if(Math.abs(d[0]) > Math.abs(d[1])){
            if(d[0]>0){
                d[0]=1;
                d[1]=0;
            }else{
                d[0]=(-1);
                d[1]=0;
            }
        }
        else{
            if(d[1]>0){
                d[0]=0;
                d[1]=1;
            }else{
                d[0]=0;
                d[1]=(-1);
            }
        }
        if (d[0]==1){
            res=Direction.U;
        }else if (d[0]==(-1)){
            res=Direction.D;
        }else if (d[1]==1){
            res=Direction.R;
        }else if (d[1]==(-1)){
            res=Direction.L;
        }
        try{
            int i =0;
            while(i<8&&
            (b.board[b.snake.snake.get(0)[0]+d[0]][b.snake.snake.get(0)[1]+d[1]]!=0)&&
            (b.board[b.snake.snake.get(0)[0]+d[0]][b.snake.snake.get(0)[1]+d[1]]!=9)){
                if(res==Direction.U){
                    res=Direction.R;
                    d[0]=0;
                    d[1]=1;
                }else if(res==Direction.R){
                    res=Direction.D;
                    d[0]=(-1);
                    d[1]=0;
                }else if(res==Direction.D){
                    res=Direction.L;
                    d[0]=0;
                    d[1]=(-1);
                }else if(res==Direction.L){
                    res=Direction.U;
                    d[0]=1;
                    d[1]=0;
                }
                i++;
            }
            if(i>7){
                b.gameOver();
            }
        }catch(Exception e){
            b.gameOver();
        }
        return res;
    }
    
    public static int[] distance(Board b){
        int[] res = new int[2];
        res[0]=b.apple.coord[0]-b.snake.snake.get(0)[0];
        res[1]=b.apple.coord[1]-b.snake.snake.get(0)[1];
        return res;
    }
    
}
