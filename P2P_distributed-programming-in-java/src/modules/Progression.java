package modules;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 * This class contain the progress bar dialogue when downloading a file
 */
public class Progression {

    private final JFrame frame = new JFrame();
    private final JDialog dialog = new JDialog(frame, "Download Progress", false);
    private final JProgressBar progressBar = new JProgressBar();

    public Progression() {

        frame.setBounds(0, 0, 1000, 100);
        dialog.setBounds(0, 0, 800, 80);
        frame.setUndecorated(true);


        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        progressBar.setForeground(new Color(210, 105, 030));

        progressBar.setPreferredSize(new Dimension(500, 20));

        progressBar.setUI(new ProgressUI());

        dialog.setUndecorated(true);


        dialog.getContentPane().add(progressBar);
        dialog.pack();
        dialog.setDefaultCloseOperation(0);


        Toolkit kit = dialog.getToolkit();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
        Dimension d = kit.getScreenSize();
        int max_width = (d.width - in.left - in.right);
        int max_height = (d.height - in.top - in.bottom);
        dialog.setLocation((int) (max_width - dialog.getWidth()) / 2, (int) (max_height - dialog.getHeight()) / 2);



        dialog.setVisible(true);
        progressBar.setVisible(true);
        dialog.setAlwaysOnTop(true);
    }

    public void showDialog() {
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
    }

    public void closeDialog() {
        if (dialog.isVisible()) {
            dialog.getContentPane().remove(progressBar);
            dialog.getContentPane().validate();
            dialog.setVisible(false);
        }
    }

    public void updateBar(int val) {
        progressBar.setValue(val);
    }

    public static class ProgressUI extends BasicProgressBarUI {

        private Rectangle r = new Rectangle();

        @Override
        protected void paintIndeterminate(Graphics g, JComponent c) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            r = getBox(r);
            g.setColor(progressBar.getForeground());
            g.fillOval(r.x, r.y, r.height, r.height);
        }
    }
}
