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
public class Pairs extends Criterion{
    private int amount;

    public Pairs(Category category, int amount) {        
        super(category);
        this.amount = amount;
    }

    @Override
    public int getScore() {
        int score = 0; 
        for (int i=6; i>0; i--) {
            if (count[i]>1) {
                score += i*2;
                amount--;
                if (amount==0) {
                    return score;
                }                
            }
        }
        return 0;        
    }
    
}
