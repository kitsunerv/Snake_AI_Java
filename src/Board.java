public class Board {
    int[][] board;
    Boolean status;
    Direction currDir;
    int width;
    int height;
    Apple apple;
    Snake snake;
    int score;

    public Board(int height,int width,int length){
        this.status = true;
        this.height = height;
        this.width = width;
        this.snake = new Snake(width,height,length);
        this.board = new int[height][width];
        this.currDir = this.snake.dir;
        this.score=0;
        this.fillBoard1();
        this.apple = new Apple(width,height,this);
        this.fillBoard1();

    }

    public void fillBoard(){
        for(int i=0;i<this.height;i++){
            for(int j=0;j<this.width;j++){
                this.board[i][j]=0;
            }
        }
        this.board[this.apple.coord[0]][this.apple.coord[1]]=9;
        this.board[this.snake.snake.get(0)[0]][this.snake.snake.get(0)[1]]=1;
        for(int k=1;k<this.snake.length;k++){
            this.board[this.snake.snake.get(k)[0]][this.snake.snake.get(k)[1]]=2;
        }
    }

    public void fillBoard1(){
        for(int i=0;i<this.height;i++){
            for(int j=0;j<this.width;j++){
                this.board[i][j]=0;
            }
        }
        this.board[this.snake.snake.get(0)[0]][this.snake.snake.get(0)[1]]=1;
        for(int k=1;k<this.snake.length;k++){
            this.board[this.snake.snake.get(k)[0]][this.snake.snake.get(k)[1]]=2;
        }
    }

    public String toString(){
        String res="";
        for(int i=0;i<this.height;i++){
            for(int j=0;j<this.width;j++){
                if(this.board[i][j]==0){
                    res+="  ";
                }else if(this.board[i][j]==9){
                    res+="CD";
                }else if(this.board[i][j]==1){
                    if(this.currDir==Direction.U){
                        res+="..";
                    }else if(this.currDir==Direction.D){
                        res+="\'\'";
                    }else if(this.currDir==Direction.L){
                        res+=":[";
                    }else if(this.currDir==Direction.R){
                        res+="]:";
                    }
                }else if(this.board[i][j]==2){
                    res+="[]";
                } 
            }
            res+="|\n";
        }
        for(int j=0;j<this.width;j++){
            res+="--";
        }
        res+="/";
        return res;
    }

    public void gameOver(){
        this.status=false;
    }


}
