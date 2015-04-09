/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.ui;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import yatzy.Noppa;
import yatzy.scoreboard.Category;
import yatzy.scoreboard.Chance;
import yatzy.scoreboard.Criterion;
import yatzy.scoreboard.FullHand;
import yatzy.scoreboard.Pairs;
import yatzy.scoreboard.SameValues;
import yatzy.scoreboard.ScoreboardLogic;
import yatzy.scoreboard.Straight;
import yatzy.scoreboard.ValueCount;

/**
 *
 * @author Markus_2
 */

public class CategoryLine {

    private final JRadioButton button;
    private final JLabel currScore;
    private final JLabel savedScore;
    private final ScoreboardLogic logic;
    private final Criterion criterion;
    
    public CategoryLine (Category category, ScoreboardLogic logic) {
        button = new JRadioButton(category.toString());
        currScore = new JLabel("0");
        savedScore = new JLabel("0");
        this.criterion = getCriterion(category);
        this.logic = logic;
    }

    public JRadioButton getButton() {
        return button;
    }

    public JLabel getCurrScore() {
        return currScore;
    }

    public JLabel getSavedScore() {
        return savedScore;
    }
    
    public void update(List<Noppa> nopat) {
        criterion.asetaNopat(nopat);
        logic.setScore(criterion);
        savedScore.setText(String.valueOf(logic.getScore(criterion.getCategory())));
    }
    
    public Criterion getCriterion(Category category) throws IllegalArgumentException{
        if (category == Category.ONES) {
            return new ValueCount(category,1);
        } else if (category == Category.TWOS) {
            return new ValueCount(category,2);    
        } else if (category == Category.THREES) {
            return new ValueCount(category,3);    
        } else if (category == Category.FOURS) {
            return new ValueCount(category,4);    
        } else if (category == Category.FIVES) {
            return new ValueCount(category,5);    
        } else if (category == Category.SIXES) {
            return new ValueCount(category,6);    
        } else if (category == Category.PAIR) {
            return new Pairs(category,1);    
        } else if (category == Category.TWOPAIRS) {
            return new Pairs(category,2);    
        } else if (category == Category.THREESAME) {
            return new SameValues(category,3);    
        } else if (category == Category.FOURSAME) {
            return new SameValues(category,4);    
        } else if (category == Category.YATZY) {
            return new SameValues(category,5);    
        } else if (category == Category.CHANCE) {
            return new Chance(category);    
        } else if (category == Category.FULLHAND) {
            return new FullHand(category);    
        } else if (category == Category.LARGESTRAIGHT || category == Category.SMALLSTRAIGHT) {
            return new Straight(category);    
        } else  {
            throw new IllegalArgumentException();    
        }
    }

    Category getCategory() {
        return criterion.getCategory();
    }
}
