import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class GamePanel extends JPanel implements KeyListener  {
    private int rectX = 100;
    private int rectY = 100;
    private final int rectWidth = 50;
    private final int rectHeight = 50;
     private List<Point> pointList;
     private List<Obstacle>obstacleList;
    public GamePanel(){
       this.pointList = new ArrayList<>();
        setGamePanel();
       this.obstacleList=new ArrayList<>();
          for (int i = 0; i < 4; i++) {
            obstacleList.add(new Obstacle());

        }
    }
    public void setGamePanel(){
        this.setBackground(Color.cyan);
        this.setSize(Constant.WINDOW_WIDE,Constant.WINDOW_HIGHT);
        this.setVisible(true);
        this.setFocusable(true);  // Ensure panel can receive focus for key events
        this.requestFocusInWindow();  // Request focus so panel can immediately handle key events
        this.addKeyListener(this);
      // Obstacle obstacle1=new Obstacle();



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Obstacle obstacle: obstacleList){
            g.setColor(Color.PINK);
            g.fill3DRect(obstacle.getPointOfObstacle().x, obstacle.getPointOfObstacle().y, rectWidth, rectHeight, true);
       //     if (isCollision(obstacle,obstacle)) {

            }



      for (int i = 0; i < pointList.size()-1; i++) {
            g.setColor(Color.green);
            g.fill3DRect(pointList.get(i).x,pointList.get(i).y,50,50,true);


        }
        g.setColor(Color.BLACK);
        g.fill3DRect(rectX, rectY, rectWidth, rectHeight, true);

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int newRectX = rectX;
        int newRectY = rectY;

        // Adjust position based on key pressed
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            newRectX += 50;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            newRectX -= 50;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            newRectY -= 50;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            newRectY += 50;
        }

        // Check if the new position is within bounds
        if (isInBound(newRectX, newRectY) ){
            rectX = newRectX;
            rectY = newRectY;
            pointList.add(new Point(rectX,rectY));
            repaint();  // Repaint the panel to reflect the new position
        }
    }



        // Not used in this example


    @Override
    public void keyReleased(KeyEvent e) {
        // Not used in this example
    }

    private boolean isInBound(int x, int y) {
        boolean isInBound=false;
        if (x >= 0 && x + rectWidth +30 < getWidth() &&
                y >= 0 && y + rectHeight <= getHeight()- 10  ){
            isInBound=true;
        }

        return isInBound;
    }
    private boolean isCollision(Rectangle r1, Rectangle r2) {
        return r1.intersects(r2);
    }
}



