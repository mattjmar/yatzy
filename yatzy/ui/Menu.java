/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Markus_2
 */
public class Menu implements ActionListener{
//Where the GUI is created:
    private final JMenuBar menuBar;
    private final NoppaUI noppaUI;
    private final ScoreBoardUI scoreUI;

    public Menu(NoppaUI noppaUI, ScoreBoardUI scoreUI) {
        this.noppaUI = noppaUI;
        this.scoreUI = scoreUI;
        //Create the menu bar.
        menuBar = new JMenuBar();

        JMenu menu = new JMenu("Peli");
        //Build the first menu.
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
        menuBar.add(menu);
        //a group of JMenuItems
        JMenuItem menuItem = new JMenuItem("Aloita",
                         KeyEvent.VK_T);
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(
        //    KeyEvent.VK_1, ActionEvent.ALT_MASK));  
        menuItem.getAccessibleContext().setAccessibleDescription(
            "This doesn't really do anything");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Tulokset");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Lopeta");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
    }
    
    public JMenuBar getMenuBar() {
        return menuBar;
    }     

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        switch (item.getText()) {
            case "Aloita":
                noppaUI.restart();
                break;
            case "Lopeta":
                noppaUI.exit();
                System.exit(0);
                break;
            case "Tulokset":
                scoreUI.showHiscores();
                break;
        }
    }
}
