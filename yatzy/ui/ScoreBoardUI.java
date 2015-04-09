/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.ui;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import yatzy.scoreboard.Category;
import yatzy.scoreboard.Criterion;
import yatzy.scoreboard.HiScoreList;
import yatzy.scoreboard.ScoreboardLogic;

/**
 *
 * @author Markus_2
 */
public class ScoreBoardUI extends JPanel implements WindowListener{
    
    private ScoreboardLogic logic;
    private final List<CategoryLine> categoryLines;
    private final List<ScoreLine> sumLines;
    private final NoppaUI noppaUI;
    private final HiScoreList hiscoreList;
    private final JFrame frame;
    
    public ScoreBoardUI(NoppaUI noppaUI, JFrame frame) {
        super(new GridLayout(0,3));
        logic = new ScoreboardLogic();
        categoryLines = new ArrayList<>();
        sumLines = new ArrayList<>();
        this.noppaUI = noppaUI;
        this.hiscoreList = new HiScoreList();
        this.frame = frame;
        hiscoreList.load("score.txt");
        create();
    }
    
    private void create() {     
        ButtonGroup buttonGroup = new ButtonGroup();
        for (Category category : Category.topCategories()) {
            CategoryLine line = new CategoryLine(category, logic); 
            categoryLines.add(line);
            buttonGroup.add(line.getButton());
            this.add(line.getButton());
            this.add(line.getCurrScore());
            this.add(line.getSavedScore());
        }
        String[] names2 = {"Yhteensä","Bonus"};
        for (String s : names2) {
            ScoreLine sumLine = new ScoreLine(s);
            sumLines.add(sumLine);
            this.add(sumLine.getTitle());
            this.add(sumLine.getCurrScore());
            this.add(sumLine.getSavedScore());
        }    

        for (Category category : Category.bottemCategories()) {            
            CategoryLine line = new CategoryLine(category, logic); 
            categoryLines.add(line);
            buttonGroup.add(line.getButton());
            this.add(line.getButton());
            this.add(line.getCurrScore());
            this.add(line.getSavedScore());
        }
        ScoreLine sumLine = new ScoreLine("Yhteensä");
        sumLines.add(sumLine);
        this.add(sumLine.getTitle());
        this.add(sumLine.getCurrScore());
        this.add(sumLine.getSavedScore());
        categoryLines.get(0).getButton().setSelected(true);
    }
    
    public boolean updateTotal () {
        boolean continues = false;
        for (CategoryLine line : categoryLines) {
            if (line.getButton().isSelected()) {
                line.update(noppaUI.getNopat());
                line.getButton().setEnabled(false);
                line.getCurrScore().setText("");
                break;
            }
        }
        for (CategoryLine line : categoryLines) {
            if (line.getButton().isEnabled()) {
                line.getButton().setSelected(true);
                continues = true;
                break;
            }
        }
        updateSums();
        if (!continues) {
            hiscoreList.add(logic);
        }
        return continues;
    }
    
    private void updateSums() {
        String s = String.valueOf(logic.getBonusScore());
        sumLines.get(1).getSavedScore().setText(String.valueOf(logic.getBonusScore()));
        s = String.valueOf(logic.getUpperScore());
        sumLines.get(0).getSavedScore().setText(String.valueOf(logic.getUpperScore()));        
        sumLines.get(2).getSavedScore().setText(String.valueOf(logic.getTotalScore()));
    }
    
    public void updateCurrent() {
        for (CategoryLine line : categoryLines) {
            if (line.getButton().isEnabled()) {
                Criterion criterion = line.getCriterion(line.getCategory());
                criterion.asetaNopat(noppaUI.getNopat());
                line.getCurrScore().setText(String.valueOf(criterion.getScore()));
            }
        }
    }

    void reset() {
        logic.reset();
        for (CategoryLine line : categoryLines) {
                line.getButton().setEnabled(true);
                line.getCurrScore().setText("");
                line.getSavedScore().setText("0");
        }
        updateSums();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (!hiscoreList.isEmpty()) {
            hiscoreList.save("score.txt");
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        if (!hiscoreList.isEmpty()) {
            hiscoreList.save("score.txt");
        }        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    void exit() {
        hiscoreList.save("score.txt");
    }

    void showHiscores() {
        JOptionPane.showMessageDialog(frame, hiscoreList.getHiscorePanel(),"Tulokset",JOptionPane.PLAIN_MESSAGE);        
    }
}
