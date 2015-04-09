/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

import javax.swing.SwingUtilities;
import yatzy.scoreboard.ScoreboardLogic;
import yatzy.ui.UserInterface;

/**
 *
 * @author Markus_2
 */
public class Main {
    public static void main(String[] args) {
        // test your program here
        //ScoreboardLogic logic = new ScoreboardLogic();
        //System.out.println(logic.toString());
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }   
}
