public class Main {

    public static void main(String[] args){
        Board b = new Board(40, 80, 4);
        while(b.status){
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            b.fillBoard();
            System.out.println(b);
            System.out.println(b.score);
            b.snake.move(AI.IA(b), b);
            b.currDir=b.snake.dir;
            b.fillBoard();
            if(!b.status){
                break;
            }
            b.score+=1;
            try{
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println("sleep failed");
            }
        }
        System.out.println("welp it died but hey here's the score (please tell me it's not so bad): "+b.score);
    }
}
