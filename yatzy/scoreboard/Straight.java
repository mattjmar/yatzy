/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.scoreboard;

import java.util.List;
import yatzy.Noppa;

/**
 *
 * @author Markus_2
 */
public class Straight extends Criterion{

    public Straight(Category category) {
        super(category);
    }

    @Override
    public int getScore() {
        if (this.getCategory()==Category.SMALLSTRAIGHT && count[1]==0) {
            return 0;
        } 
        if (this.getCategory()==Category.LARGESTRAIGHT && count[6]==0) {
            return 0;
        }        
        for (int i=2; i<6; i++) {
            if (count[i]==0) {
                return 0;
            }
        }
        if (this.getCategory()==Category.SMALLSTRAIGHT) {
            return 15;
        } else {
            return 20;
        }        
    }
    
}
