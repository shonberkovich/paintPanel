import java.awt.*;
import java.util.Random;

public class Obstacle {

   private Point pointOfObstacle;
   private  int hight;
    private  int  widht;
    private Random random;

    public Point getPointOfObstacle() {
        return pointOfObstacle;
    }
    public void print (){
        System.out.println("shai");
    }


    public int getHight() {
        return hight;
    }

    public int getWidht() {
        return widht;
    }

    public Obstacle() {
        random = new Random();
        pointOfObstacle = new Point();
        this.pointOfObstacle.y = random.nextInt(0,Constant.WINDOW_HIGHT);
        this.pointOfObstacle.x= random.nextInt(0,Constant.WINDOW_WIDE);
        this.hight = random.nextInt(5,80);
        this.widht = random.nextInt(5,60);
    }
}
