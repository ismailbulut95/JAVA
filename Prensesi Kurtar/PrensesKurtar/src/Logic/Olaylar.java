/*
marioyu klavye ile mi hareket ettiriyorsun evet abi
şimdi o zaman aşağıda tanımladığın düşmanlara mariyonun mevcut koordinatını da tanımlamamız lazım sonrasında da koordinatlar eşitse şartlı uygulatacağız mantıken dğeil mi
evet abi
ilk karşıma çıkan merdivenin başındaki düş bakaman kaç numara
*/
package Logic;

import Gui.ekran1;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Olaylar implements ActionListener{

    ekran1 o = null;
    public Timer timer = new Timer(10, this);
    
    public Olaylar(ekran1 o) {
        timer.start();
        this.o = o;
    }

    public ekran1 getO() {
        o=new ekran1();
        return o;
    }

    public void setO(ekran1 o) {
        this.o = o;
    }
    
    public boolean carpisma1(){
        if(new Rectangle(o.marioX,o.marioY,20,20).intersects(new Rectangle(o.dusmanX,o.dusmanY,20,20))){
            return true;
        }
        return false;
    }
    public boolean carpisma2(){
        if(new Rectangle(o.marioX,o.marioY,20,20).intersects(new Rectangle(o.dusmanX1,o.dusmanY1,20,20))){
            return true;
        }
        return false;
    }
    public boolean carpisma3(){
        if(new Rectangle(o.marioX,o.marioY,20,20).intersects(new Rectangle(o.dusmanX2,o.dusmanY2,20,20))){
            return true;
        }
        return false;
    }
    public boolean carpisma4(){
        if(new Rectangle(o.marioX,o.marioY,20,20).intersects(new Rectangle(o.dusmanX3,o.dusmanY3,20,20))){
            return true;
        }
        return false;
    }
    public boolean carpisma5(){
        if(new Rectangle(o.marioX,o.marioY,20,20).intersects(new Rectangle(o.dusmanX4,o.dusmanY4,20,20))){
            return true;
        }
        return false;
    }
    
    public boolean carpismaPrenses(){
        if(new Rectangle(o.marioX,o.marioY,20,20).intersects(new Rectangle(o.prensesX,o.prensesY,20,20))){
            
            return true;
        }
        return false;
    }
    public void dusmanBir(){
        
        o.dusmanX += o.dusmandirX;
        if(o.dusmanX > 230 || o.dusmanX < 40){
            o.dusmandirX = -o.dusmandirX;
        }
        if(carpisma1()){ 
            o.can -= 1;
            o.marioX = 0;
            o.marioY = 660;
            if(o.can == 0){
                o.oyunDurumu = false;
            }
        }
    }
    
    public void dusmanIki(){
        o.dusmanX1 += o.dusmandirX1;
        if(o.dusmanX1 > 230 || o.dusmanX1 < 40 ){
            o.dusmandirX1 = -o.dusmandirX1;
        }
        if(carpisma2()){ 
            o.can -= 1;
            o.marioX = 0;
            o.marioY = 660;
            if(o.can == 0){
                o.oyunDurumu = false;
            }
        }
    }
    
    public void dusmanUc(){
        o.dusmanX2 += o.dusmandirX2;
        if(o.dusmanX2 > 190 || o.dusmanX2 < 80){
            o.dusmandirX2 = -o.dusmandirX2;
        }
        if(carpisma3()){ 
            o.can -= 1;
            o.marioX = 0;
            o.marioY = 660;
            if(o.can == 0){
                o.oyunDurumu = false;
            }
        }
    }
    
    public void dusmanDort(){
        o.dusmanX3 += o.dusmandirX3;
        if(o.dusmanX3 > 635 || o.dusmanX3 < 220){
            o.dusmandirX3 = -o.dusmandirX3;
        }
        
        if(carpisma4()){
            o.can -= 1;
            o.marioX = 0;
            o.marioY = 660;
            if(o.can == 0){
                o.oyunDurumu = false;
            }
        }
        
    }
   
    public void dusmanBes(){
        o.dusmanX4 += o.dusmandirX4;
        if(o.dusmanX4 > 465 || o.dusmanX4 < 305){
            o.dusmandirX4 = -o.dusmandirX4;
        }
        if(carpisma5()){ 
            o.can -= 1;
            o.marioX = 0;
            o.marioY = 660;
            
            if(o.can == 0){
                o.oyunDurumu = false;
            }
        }
    }
    
    public void kazanim(){
        
        if(o.marioX >= 30 && o.marioX <= 40 && o.marioY == 400){
            o.marioX = 50;
            o.marioY = 550;
            try {
                o.arkaplan = ImageIO.read(new FileImageInputStream(new File("arkaplan2.png")));
            } catch (IOException e) {
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(o.b == true && o.yukseklik <= 15){
            o.yukseklik += 1;
            o.marioY = o.marioY- 2;
        }
        if(o.b == true &&  o.yukseklik == 15){
            o.b = false;
            
        }
        if(o.b == false && o.yukseklik >= 0){
            o.marioY = o.marioY + 2;
            o.yukseklik -= 1;
        }
        kazanim();
        carpismaPrenses();
        dusmanBir();
        dusmanIki();
        dusmanUc();
        dusmanDort();
        dusmanBes();
        
        o.repaint();
        
    }
    
}
