
package Logic;

import Gui.ekran1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class Klavye implements KeyListener{

    
    ekran1 klv;

    public Klavye(ekran1 klv) {
        this.klv = klv;
    }
    
    public void hareketsol(){
        if((klv.marioX >= 225 && klv.marioX <= 635 && klv.marioY == 550) || (klv.marioY <= 665 || klv.marioY >= 650 ) || (klv.marioX >= 45 && klv.marioX <= 145 && klv.marioY == 550) || (klv.marioX >= 270 && klv.marioX <= 505 && klv.marioY == 400)  || (klv.marioX >= 490 && klv.marioY <= 635 && klv.marioY == 350) || (klv.marioX >= 490 && klv.marioX <= 635 && klv.marioY == 85) || (klv.marioX >= -5 && klv.marioX <= 35 && klv.marioY == 400) || (klv.marioX >= 0 && klv.marioX <= 290) &&(klv.marioY == 85 || klv.marioY == 195 ) ){
            klv.marioX += -klv.mariodirX;

        }
    }
    public void hareketyukari(){
        if((klv.marioY <= 660 && klv.marioY >= 555 && klv.marioX >= 355 && klv.marioX <= 375) || (klv.marioY <= 560 && klv.marioY >= 90 && klv.marioX <= 505 && klv.marioX >= 485) || (klv.marioX <= 290 && klv.marioX >= 265 && klv.marioY <= 400 && klv.marioY >= 90) || (klv.marioX >= 0 && klv.marioX <= 20 && klv.marioY <= 400 && klv.marioY >= 90)){
            klv.marioY -= klv.mariodirY;
        }
    }
    
    public void hareketsag(){
        if((klv.marioX >= 215 && klv.marioX <= 635 && klv.marioY == 550) || (klv.marioY == 660 ) || (klv.marioY <= 665 || klv.marioY >= 650 )  || (klv.marioX >= 40 && klv.marioX <= 140 && klv.marioY == 550) || (klv.marioX >= 265 && klv.marioX <= 500 && klv.marioY == 400) || (klv.marioX >= 490 && klv.marioX <= 635 && klv.marioY == 350 ) || (klv.marioX >= 480 && klv.marioX <= 635 && klv.marioY == 85) || (klv.marioX >= -5 && klv.marioX <= 30 && klv.marioY == 400) ||(klv.marioX >= -5 && klv.marioX <= 285) &&(klv.marioY == 85 || klv.marioY == 195 )){
            klv.marioX += klv.mariodirX;
        }
    }
    
    public void hareketasagi(){
        if((klv.marioY <= 660 && klv.marioY >= 550 && klv.marioX >= 355 && klv.marioX <= 375) || (klv.marioY <= 545  && klv.marioY >= 85 && klv.marioX <= 505 && klv.marioX >= 485)  || (klv.marioX <= 290 && klv.marioX >= 265 && klv.marioY <= 395 && klv.marioY >= 85) || (klv.marioX >= 0 && klv.marioX <= 20 && klv.marioY <= 395 && klv.marioY >= 85)){
            {
                klv.marioY += klv.mariodirY;
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int c = ke.getKeyCode();
        
        if (c == KeyEvent.VK_SPACE) {
            if(klv.oyunDurumu == true){
                klv.b = true;
            }
        }
        if(c == KeyEvent.VK_RIGHT){
            klv.foto = false;
            if(klv.foto == false){
                try {
                klv.mario1 = ImageIO.read(new FileImageInputStream(new File("mario.png")));
            } catch (Exception e) {
                
            }
                
            }
            
            if(klv.marioX >= 635){
                klv.marioX = 635;
            }
            else{
                hareketsag();
            }
        }
        if(c == KeyEvent.VK_LEFT){
            klv.foto = true;
            if(klv.foto == true){
                try {
                   klv.mario1 = ImageIO.read(new FileImageInputStream(new File("mario2.png")));
                } catch (Exception e) {
                }
            }
            if(klv.marioX <= 0){
                klv.marioX = 0;
            }
            else{
                hareketsol();
                }
        }
        
        if(c == KeyEvent.VK_UP){
            if(klv.marioY <= 0){
                klv.marioY = 0;
            }
            else {
                hareketyukari();
            }
        }
        if(c == KeyEvent.VK_DOWN){
            if(klv.marioY >= 660)
            {
                klv.marioY = 660;
            }
            else{
                hareketasagi();
            }
        }
    }
    

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
