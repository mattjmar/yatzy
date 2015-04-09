/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.scoreboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Markus_2
 */
public class ScoreboardLogic implements Comparable<ScoreboardLogic>{
  
    private final Map<Category, Integer> scores;
    private Date date;
    
    public ScoreboardLogic() {
        scores = new HashMap<>();
        date = new Date();
    }
    
    public ScoreboardLogic(String savedData) {
        scores = new HashMap<>();
        date = new Date();
        
        String[] s = savedData.split(":");
        if (s.length > 15) {
            date.setTime(Long.valueOf(s[0]));
            int index = 1;
            for (Category c : Category.topCategories()) {
                scores.put(c, Integer.valueOf(s[index]));
                index++;
            }
            for (Category c : Category.bottemCategories()) {
                scores.put(c, Integer.valueOf(s[index]));
                index++;
            }
        }
    }
    
    public int getScore(Category category) {
        if (scores.containsKey(category)) {
            return scores.get(category);
        } else {
            return 0;
        }
    }
    
    public void setScore(Criterion criterion) {
        scores.putIfAbsent(criterion.getCategory(), criterion.getScore());
        date = new Date();
    }
    
    public int getBonusScore() {
        if (getUpperScore() > 62) {
            return 50;
        } else {
            return 0;
        }
    }
    
    public int getUpperScore() {
        return getScore(Category.ONES) + getScore(Category.TWOS)
             + getScore(Category.THREES) + getScore(Category.FOURS)  
             + getScore(Category.FIVES) + getScore(Category.SIXES);   
    }
    
    public int getTotalScore() {
        int score = 0;
        for (Category c : scores.keySet()) {
            score  += scores.get(c);
        }
        score += getBonusScore();
        return score;
    }
    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append (date.getTime());
        sb.append(":");
        for (Category c : Category.topCategories()) {
            sb.append(getScore(c));
            sb.append(":");
        }
        for (Category c : Category.bottemCategories()) {
            sb.append(getScore(c));
            sb.append(":");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

    @Override
    public int compareTo(ScoreboardLogic o) {
        return  o.getTotalScore() - getTotalScore();
    }

    String toPanelString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(". ");
        sb.append(this.getTotalScore());
        sb.append(" (");
        sb.append(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(date));
        sb.append(")");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

    public void reset() {
        scores.clear();
    }
}
