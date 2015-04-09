/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.ui;

import javax.swing.JLabel;


/**
 *
 * @author Markus_2
 */
class ScoreLine {
    
    private final JLabel title;
    private final JLabel currScore;
    private final JLabel savedScore;
    
    public ScoreLine (String title) {
        this.title = new JLabel(title);
        currScore = new JLabel("");
        savedScore = new JLabel("0");
    }

    public JLabel getTitle() {
        return title;
    }

    public JLabel getCurrScore() {
        return currScore;
    }

    public JLabel getSavedScore() {
        return savedScore;
    }       
}
