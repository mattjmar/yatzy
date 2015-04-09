/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Markus_2
 */
public class UserInterface implements Runnable{

    private JFrame frame;
    
    public UserInterface () {
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        addListeners();
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(1,2));
        NoppaUI noppaUI = new NoppaUI();
        ScoreBoardUI scoreUI = new ScoreBoardUI(noppaUI, frame);
        container.add(noppaUI);
        container.add(scoreUI);
        noppaUI.connect(scoreUI);
        frame.setJMenuBar(new Menu(noppaUI, scoreUI).getMenuBar());
        frame.addWindowListener(scoreUI);
    }

    private void addListeners() {
        
    }

    public JFrame getFrame() {
        return frame;
    }

}