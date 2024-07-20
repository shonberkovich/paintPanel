import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {


    public Window(){
        this.setSize(Constant.WINDOW_WIDE,Constant.WINDOW_HIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
      // this.setName("MY GAME");
        this.setLocationRelativeTo(null);
        this.add( new GamePanel ());
        this.setVisible(true);


    }
}
