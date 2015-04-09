/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import yatzy.Noppa;

/**
 *
 * @author Markus_2
 */
public class NoppaUI extends JPanel{
    
    private final List<Noppa> nopat;
    private final JButton pisteytysButton;
    private final JButton heittoButton;
    private int heitot;
    private ScoreBoardUI scoreUI;
    
    public NoppaUI() {
        super();
        nopat = new ArrayList<>();
        pisteytysButton = new JButton("Pisteytä");
        heittoButton = new JButton("Heitä(2)");
        create();
        heitot = 3;
        scoreUI = null;
    }
    
    private JPanel luoNopat()  {
        JPanel panel = new JPanel(new GridLayout(0,3));
        for (int i = 0; i< 5; i++) {
            Noppa n = new Noppa();
            nopat.add(n);
            panel.add(n);
        }
        return panel;
    }
    
    public List<Noppa> getNopat() {
        return nopat;
    }
    
    public void heitä() {
        for (Noppa n : getNopat()) {
            n.heita();
        }
        scoreUI.updateCurrent();
        heitot--;
        heittoButton.setText("Heitä ("+heitot+")");
        if (heitot == 0) {
            heittoButton.setEnabled(false);
        }
        repaint();         
    }
    
    public void nextTurn() {
        heitot += 3;
        heittoButton.setEnabled(true);  
        for (Noppa n : getNopat()) {
            n.lukitse(false);
        }
        heitä();
    }
    
    private JPanel luoNappulat(JPanel noppaPanel) {
        JPanel panel = new JPanel(new GridLayout(0,2));
        heittoButton.addActionListener(new HeittoListener());
        panel.add(heittoButton);
        panel.add(pisteytysButton);
        return panel;        
    }
    
    public void connect(ScoreBoardUI scoreUI) {
        this.scoreUI = scoreUI;
        pisteytysButton.addActionListener(new PisteytysListener());
        heitä();
    }
    
    private void create() {
        this.setLayout(new GridLayout(2,1));
        JPanel noppaPanel = luoNopat();
        add(noppaPanel);
        add(luoNappulat(noppaPanel));
    }

    public void restart() {
        pisteytysButton.setEnabled(true);
        scoreUI.reset();
        heitot = 3;
        heitä();
    }
    
    public void exit() {
        
    }
    // event listeners
    /**********************************************************/    
    private class HeittoListener implements ActionListener {
        public HeittoListener() {
            super();
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            heitä();
        }     
    }
    
    /**********************************************************/
    private class PisteytysListener implements ActionListener{
    
    public PisteytysListener () {
        super();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (scoreUI.updateTotal()) {
            nextTurn();
        } else {
            pisteytysButton.setEnabled(false);
        }
    }
    
}    
}
