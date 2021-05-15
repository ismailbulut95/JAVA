
package Gui;


import Logic.Klavye;
import Logic.Olaylar;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ekran1 extends JPanel{

    Olaylar a;
    Klavye k;
    
    public Image arkaplan,zafer,gameover;
    public  boolean oyunDurumu = true;
    public boolean b= false;
    public int yukseklik = 0;
    public int gecenSure=0;
    public BufferedImage mario1,dusman,prenses;
    public int can = 3;
    public int prensesX = 160;
    public int prensesY = 560;
    public int dusmanX = 42;
    public int dusmanY = 190;
    public int dusmanX1 = 42;
    public int dusmanY1 = 80;
    public int dusmanX2 = 80;
    public int dusmanY2 = 400;
    public int dusmanX3 = 220;
    public int dusmanY3 = 550;
    public int dusmanX4 = 465;
    public int dusmanY4 = 395;
    public int dusmandirX = 2;
    public int dusmandirX1 = 1;
    public int dusmandirX2 = 1;
    public int dusmandirX3 = 1;
    public int dusmandirX4 = 1;
    public int marioX=0;
    public int marioY=655;
    public int mariodirX=5;
    public int mariodirY=5;
    public  boolean foto = false;
    
    public ekran1() {

       
        arkaplan = new ImageIcon("background.jpg").getImage();
        zafer = new ImageIcon("zafer.png").getImage();
        gameover = new ImageIcon("indir.png").getImage();
        try {
            dusman = ImageIO.read(new FileImageInputStream(new File("dusman.png")));
            mario1 = ImageIO.read(new FileImageInputStream(new File("mario.png")));
            prenses = ImageIO.read(new FileImageInputStream(new File("prenses.png")));
        } catch (IOException ex) {
            Logger.getLogger(ekran1.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.WHITE);
        addActionListener(getA());
        addKeyListener(getK());
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        gecenSure += 5;
        g.setColor(Color.RED); 
        g.drawImage(mario1, marioX, marioY,mario1.getWidth()/2,mario1.getHeight()/2, this);
        g.drawImage(prenses,prensesX,prensesY,prenses.getWidth()/3,prenses.getHeight()/3,this);
        g.drawImage(dusman, dusmanX, dusmanY, this);
        g.drawImage(dusman, dusmanX1, dusmanY1, this);
        g.drawImage(dusman, dusmanX2, dusmanY2, this);
        g.drawImage(dusman, dusmanX3, dusmanY3, this);
        g.drawImage(dusman, dusmanX4, dusmanY4, this);
        
        if(oyunDurumu == false)
        {
            g.drawImage(gameover, 0, 0, 700, 800, this);
            
        }
        if(oyunDurumu == true && a.carpismaPrenses()){
            g.drawImage(zafer, 0, 0, 700, 800, this);
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        int baslangicX = 0;
        int baslangicY = 80;
        int bitisX=693;
        int bitisY=662;
        grphcs.drawImage(arkaplan,baslangicX,baslangicY,bitisX,bitisY,this);
    }
    
    public Olaylar getA() {
        if(a==null){
            a = new Olaylar(this);
        }
        return a;
    }

    public void setA(Olaylar a) {
        this.a = a;
    }

    public Klavye getK() {
        if(k==null){
            k = new Klavye(this);
        }
        return k;
    }

    public void setK(Klavye k) {
        this.k = k;
    }
}
