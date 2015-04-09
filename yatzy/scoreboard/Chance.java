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
public class Chance extends Criterion{

    public Chance(Category category) {
        super(category);
    }

    @Override
    public int getScore() {
        int score = 0;
        for (int i=1; i<7; i++) {
            score += i*count[i];
        }
        return score;
    }    
}
