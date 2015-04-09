/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author Markus_2
 */
public class Noppa extends JPanel{
    private int arvo;
    private final Random random;
    private final JCheckBox checkBox;
    
    public Noppa () {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        checkBox = (new JCheckBox("Lukitse"));
        this.add(Box.createVerticalGlue());
        this.add(checkBox);

        random = new Random();
        arvo = random.nextInt(6) + 1;
    }
    
    public void lukitse(boolean arvo) {
        checkBox.setSelected(arvo);
    }
    
    public void heita () {
        if (!onLukittu()) {
            arvo = random.nextInt(6) + 1;
        }
    } 
    
    public int getValue() {
        return arvo;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int koko;
        int offsetY = 10;
        
        if (this.getWidth() < this.getHeight()-checkBox.getHeight()-offsetY) {
            koko = this.getWidth()-10;
        } else {
            koko = this.getHeight()-checkBox.getHeight()-offsetY - 5;
        }
        
        graphics.drawRect(0, offsetY, koko, koko);

        switch (arvo) {
            case 1:
                graphics.fillOval(koko/2 - koko/16, offsetY + koko/2 - koko/16, koko/8, koko/8);
                break;
            case 2:
                graphics.fillOval(koko/4 - koko/16, offsetY + koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                break;
            case 3:
                graphics.fillOval(koko/4 - koko/16, offsetY + koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(koko/2 - koko/16, offsetY + koko/2 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                break;
            case 4:
                graphics.fillOval(koko/4 - koko/16 , offsetY + koko / 4 - koko/16, koko/8, koko/8);
                graphics.fillOval(koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                break;
            case 5:
                graphics.fillOval(koko/2 - koko/16, offsetY + koko/2 - koko/16, koko/8, koko/8);
                graphics.fillOval(koko/4 - koko/16 , offsetY + koko / 4 - koko/16, koko/8, koko/8);
                graphics.fillOval(koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                break;                
            case 6:
                graphics.fillOval(koko/4 - koko/16 , offsetY + koko / 4 - koko/16, koko/8, koko/8);
                graphics.fillOval(koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + 3*koko/4 - koko/16, koko/8, koko/8);
                graphics.fillOval(koko/4 - koko/16, offsetY + koko/2 - koko/16, koko/8, koko/8);
                graphics.fillOval(3*koko/4 - koko/16, offsetY + koko/2 - koko/16, koko/8, koko/8);
                break;                
        }  
    }

    private boolean onLukittu() {
        return checkBox.isSelected();
    }
         
}
