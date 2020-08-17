/*
 *
 * Ben Owen
 * 
 * This is the main GUI for the program
 *
 */

package com.bensuniverse.TBAAPIv3Client.Frames;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.bensuniverse.TBAAPIv3Client.Frames.Panels.APIKeyDataTypePanel;
import com.bensuniverse.TBAAPIv3Client.Frames.Panels.FileSelectPanel;
import com.bensuniverse.TBAAPIv3Client.Frames.Panels.FooterPanel;
import com.bensuniverse.TBAAPIv3Client.Frames.Panels.HeaderPanel;
import com.bensuniverse.TBAAPIv3Client.Frames.Panels.MatchIDPanel;
import com.bensuniverse.TBAAPIv3Client.Frames.Panels.OutputLogPanel;
import com.bensuniverse.TBAAPIv3Client.Frames.Panels.TeamNumberProgressBarPanel;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

    public MainWindow() {

        super("TBA APIv3 Client");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        // add panels
        this.add(new HeaderPanel());
        this.add(new APIKeyDataTypePanel());
        this.add(new FileSelectPanel());
        this.add(new MatchIDPanel());
        this.add(new TeamNumberProgressBarPanel());
        this.add(new OutputLogPanel());
        this.add(new FooterPanel());

        ImageIcon icon = new ImageIcon(getClass().getResource("/tba_logo.png"));
        this.setIconImage(icon.getImage());

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // box layout on y-axis
        this.pack();
        this.setLocationRelativeTo(null); // center window in screen
        this.setVisible(true);

        this.getRootPane().setDefaultButton(MatchIDPanel.getStartButton()); // set default button to start button (when hit enter key)

        try {

            Thread.sleep(100); // to avoid requesting 

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
        MatchIDPanel.focus(); // request focus to match ID text field

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}