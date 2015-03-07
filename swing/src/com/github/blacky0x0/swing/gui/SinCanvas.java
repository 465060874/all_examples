package com.github.blacky0x0.swing.gui;

import javax.swing.*;
import java.awt.*;

/**
 * User: blacky
 * Date: 07.03.15
 */
public class SinCanvas extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int height = getHeight();
        int width = getWidth();
        int periods = 4;

        // TODO: fix the phase
        double k = 2 * Math.PI * periods / width;
        int sy = calcY(0, width, height, k);

        for (int i = 0; i < width; i++) {
            int nsy = calcY(i, width, height, k);
            g.drawLine(i - 1, sy, i, nsy);
            sy = nsy;
        }

    }

    private int calcY(int x, int width, int height, double k) {
        double dx = (x - width / 2.) * k;
        return (int) (height / 2. * (1 - Math.sin(dx)));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SinCanvas canvas = new SinCanvas();
        frame.add(canvas);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
