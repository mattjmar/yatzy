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
public abstract class Criterion {
    
    private final Category category;
    protected int[] count = {0,0,0,0,0,0,0};

    public Criterion (Category category) {
        this.category = category;
    }
    
    public void asetaNopat (List<Noppa> nopat) {

        for (Noppa n : nopat) {
            count[n.getValue()]++;
        }
    }
    
    public Category getCategory() {
        return category;
    }
    
    public abstract int getScore();
}

