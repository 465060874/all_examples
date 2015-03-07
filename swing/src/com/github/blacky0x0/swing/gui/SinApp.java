package com.github.blacky0x0.swing.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * User: blacky
 * Date: 07.03.15
 */
public class SinApp extends JFrame {

    private final Canvas canvas = new SinCanvas();
    private final BorderLayout statusLayout = new BorderLayout();
    private final Container statusPane = new Container();
    private final JLabel mouseLabel = new JLabel("Mouse coordinates: ");
    private final JLabel coordinates = new JLabel("");

    private void init() {

        statusPane.setLayout(statusLayout);
        statusPane.add(mouseLabel, BorderLayout.WEST);
        statusPane.add(coordinates, BorderLayout.CENTER);

        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                coordinates.setText(e.getPoint().toString());
            }
        });

        this.add(canvas, BorderLayout.CENTER);
        this.add(statusPane, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SinApp app = new SinApp();
        app.init();
    }
}
