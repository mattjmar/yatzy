/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.scoreboard;


/**
 *
 * @author Markus_2
 */
public class FullHand extends Criterion{

    public FullHand(Category category) {
        super(category);
    }

    @Override
    public int getScore() {
        int score = 0;
        int usedDices = 0;
        for (int i=6; i>0; i--) {
            if (count[i]==3) {
                score += i*3;
                if (usedDices==0) {
                    usedDices = 3;
                } else {
                    return score;
                }
            } else if (count[i]==2) {
                score += i*2;
                if (usedDices==0) {
                    usedDices = 2;
                } else {
                    return score;
                }
            } 
        }
        return 0;
    }
    
}
