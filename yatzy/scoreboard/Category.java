/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.scoreboard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Markus_2
 */
public enum Category {
    ONES("Ykköset"), 
    TWOS("Kakkoset"), 
    THREES("Kolmoset"), 
    FOURS("Neloset"), 
    FIVES("Vitoset"), 
    SIXES("Kutoset"),
    PAIR("Pari"), 
    TWOPAIRS("Kaksi paria"), 
    THREESAME("Kolme samaa"), 
    FOURSAME("Neljä samaa"),
    SMALLSTRAIGHT("Pieni suora"), 
    LARGESTRAIGHT("Suuri suora"),
    FULLHAND("Täyskäsi"), 
    CHANCE("Sattuma"), 
    YATZY("Yatzy");  
    
    private final String name;
    
    private Category (String name) {
        this.name = name;
    }
    
    public static List<Category> topCategories() {
        List<Category> list = new ArrayList<>();
        list.add(Category.ONES);
        list.add(Category.TWOS);
        list.add(Category.THREES);
        list.add(Category.FOURS);
        list.add(Category.FIVES);
        list.add(Category.SIXES);
        return list;
    }
    
    public static List<Category> bottemCategories() {
        List<Category> list = new ArrayList<>();
        list.add(Category.PAIR);
        list.add(Category.TWOPAIRS);
        list.add(Category.THREESAME);
        list.add(Category.FOURSAME);
        list.add(Category.SMALLSTRAIGHT);
        list.add(Category.LARGESTRAIGHT);
        list.add(Category.FULLHAND);
        list.add(Category.CHANCE);
        list.add(Category.YATZY);
        return list;
    }
    
    public String toString() {
        return name;
    }
}
