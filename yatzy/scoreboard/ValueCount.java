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
public class ValueCount extends Criterion{

    private final int value;
    
    public ValueCount(Category category, int value) {
        super(category);
        this.value = value;
    }

    @Override
    public int getScore() {
        return value * count[value];
    }
    
}
