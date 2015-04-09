/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.scoreboard;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Markus_2
 */
public class HiScoreList {

    private final List<ScoreboardLogic> scores;
    private boolean modified;
    
    public HiScoreList() {        
        scores = new ArrayList<>();
        modified = false;
    }
    
    public void load(String file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException ex) {
            return;
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (isCorrectFormat(line)) {
                ScoreboardLogic sl = new ScoreboardLogic(line); 
                scores.add(sl);
            }
        }
    }
    
    public void save(String fileName) {
        if (!modified) {
            return;
        }
        
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(fileName));

            for (ScoreboardLogic logic : scores) {
                writer.write(logic.toString());
            }
            writer.close();
        } catch (IOException ex) {
            return;
        }        
        modified = false;
    }
    
    public void add(ScoreboardLogic logic) {
        scores.add(logic);
        modified = true;
    }

    public boolean isEmpty() {
        return scores.isEmpty();
    }

    private boolean isCorrectFormat(String line) {
        if (line == null || line.isEmpty()) {
            return false;
        } else if (line.split(":").length != 16  ) {
            return false;
        }
        return true;
    }
    
    public JPanel getHiscorePanel() {
        scores.sort(null);
        JPanel panel = new JPanel();
        panel.setMinimumSize(new Dimension(200,200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i=0; i< scores.size(); i++) {
            panel.add(new JLabel(scores.get(i).toPanelString(i+1)));
        }    
        return panel;
    }    
}
