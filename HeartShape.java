package com.dome.day02;

import javax.swing.*;
import java.awt.*;

public class HeartShape extends JFrame {
    public static void main(String[] args) {
        HeartShape heart = new HeartShape();
        heart.setVisible(true);
    }

    public HeartShape() {
        setTitle("Heart Shape");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        int x, y, width, height;
        double[] cx = new double[100];
        double[] cy = new double[100];
        double[] r = new double[100];
        int[] x1 = new int[100];
        int[] y1 = new int[100];
        int counter = 0;
        for (int i = 0; i < 360; i += 3) {
            double t = i / 180 * Math.PI;
            cx[counter] = (16 * Math.pow(Math.sin(t), 3));
            cy[counter] = -(13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t));
            r[counter] = counter % 2 == 0 ? 20 : -20;
            counter++;
        }
        for (int i = 0; i < counter; i++) {
            x = (int) (cx[i] + 150);
            y = (int) (cy[i] + 150);
            width = (int) (10 * Math.cos(Math.toRadians((double) i / counter * 360)));
            height = (int) (10 * Math.sin(Math.toRadians((double) i / counter * 360)));
            x1[i] = x - width / 2;
            y1[i] = y - height / 2;
        }
        g2.setColor(Color.RED);
        g2.fillPolygon(x1, y1, counter);
    }
}
