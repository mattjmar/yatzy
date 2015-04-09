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
public class SameValues extends Criterion{
    private final int amount;

    public SameValues(Category category, int amount) {
        super(category);
        this.amount = amount;
    }

    @Override
    public int getScore() {
        for (int i=6; i>0; i--) {
            if (count[i] >= amount) {
                if (amount == 5) {
                    return 50;
                } else {
                    return i * amount;
                }
            }
        }
        return 0;
    }
    
}
