package com.github.blacky0x0.swing.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * User: blacky
 * Date: 07.03.15
 */
public class SinApp extends JFrame {

    private final Canvas canvas = new SinCanvas();
    private final BorderLayout statusLayout = new BorderLayout();

    private final JPanel controlPanel = new JPanel();
    private final JButton longActionBtn = new JButton("Make a long action");
    private final JCheckBox gridCheckBox = new JCheckBox("Show a grid");

    private final Container statusPane = new Container();
    private final JLabel mouseLabel = new JLabel("Mouse coordinates: ");
    private final JLabel coordinates = new JLabel("");

    private final Dimension displayDimension = getMainDisplayDimension();
    private final Dimension appDimension = new Dimension(600, 200);
    private final Point appPoint = computeCenterPoint(displayDimension, appDimension);

    private void init() {

        controlPanel.add(longActionBtn, BorderLayout.CENTER);
        controlPanel.add(gridCheckBox, BorderLayout.SOUTH);


        longActionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                longActionBtn.setEnabled(false);

                // delegate large amount of work to a child of SwingWorker
                new LongActionWorker(longActionBtn).execute();
            }
        });

        statusPane.setLayout(statusLayout);
        statusPane.add(mouseLabel, BorderLayout.WEST);
        statusPane.add(coordinates, BorderLayout.CENTER);

        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                coordinates.setText(e.getPoint().toString());
            }
        });

        this.add(controlPanel, BorderLayout.WEST);
        this.add(canvas, BorderLayout.CENTER);
        this.add(statusPane, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(appDimension);
        this.setLocation(appPoint);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SinApp app = new SinApp();
                app.init();
            }
        });
    }

    /**
     * Return a dimension of default screen
     * @return
     */
    public static Dimension getMainDisplayDimension() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dm = gd.getDisplayMode();
        return new Dimension(dm.getWidth(), dm.getHeight());
    }

    /**
     * Compute center coordinates for window at display
     * @param display
     * @param window
     * @return
     */
    public static Point computeCenterPoint(Dimension display, Dimension window) {
        int x = (int)(display.getWidth() - window.getWidth()) / 2;
        int y = (int)(display.getHeight() - window.getHeight()) / 2;

        return new Point(x, y);
    }

    class LongActionWorker extends SwingWorker<Void, Void> {
        private JButton btn;

        public LongActionWorker(JButton btn) {
            this.btn = btn;
        }

        @Override
        protected Void doInBackground() throws Exception {

            // emulate a long-long action
            for (int i = 0; i < 20; i++) {
                try { Thread.sleep(100); }
                catch (InterruptedException e1) { e1.printStackTrace(); }
            }

            return null;
        }

        @Override
        protected void done() {
            btn.setEnabled(true);
        }
    }
}
