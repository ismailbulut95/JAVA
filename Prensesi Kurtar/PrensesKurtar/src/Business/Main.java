
package Business;

import Gui.ekran1;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args) {
        JFrame ekran = new JFrame();
        //Main ekran = new Main();
        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setSize(700, 777);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ekran1 e = new ekran1();
        e.setFocusable(true);
        ekran.add(e);
        ekran.setVisible(true);
    }
}
