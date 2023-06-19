package Theo.GeometrischeAlgorithmen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class GiftWarpping extends JPanel implements MouseListener {
    private static List<Point> points;
    private List<Point> convexHull;
    private int currentPointIndex;

    public GiftWarpping() {
        points = new ArrayList<>();
        points.add(new Point(200, 20));
        points.add(new Point(400, 250));
        points.add(new Point(350, 50));
        convexHull = new ArrayList<>();
        currentPointIndex = 0;

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Zeichne die Punkte
        for (Point point : points) {
            g2d.setColor(Color.BLACK);
            g2d.fillOval(point.x - 3, getHeight() - point.y - 3, 6, 6);
        }

        // Zeichne die bisherige konvexe Hülle
        int n = convexHull.size();
        for (int i = 0; i < n; i++) {
            Point current = convexHull.get(i);
            Point next = convexHull.get((i + 1) % n);

            g2d.setColor(Color.RED);
            g2d.drawLine(current.x, getHeight() - current.y, next.x, getHeight() - next.y);
        }

        // Zeichne die nächste Linie, falls vorhanden
        // Eventuell auskommentieren
         if(currentPointIndex < points.size()) {
            Point currentPoint = points.get(currentPointIndex +1);
            Point nextPoint = points.get((currentPointIndex +2));

            g2d.setColor(Color.BLUE);
            g2d.drawLine(currentPoint.x, getHeight() - currentPoint.y, nextPoint.x, getHeight() - nextPoint.y);
        }
    }

    public List<Point> findConvexHull(List<Point> points) {
        int n = points.size();
        if (n < 3) {
            return null; // Nicht genug Punkte, um eine konvexe Hülle zu bilden
        }

        List<Point> convexHull = new ArrayList<>();

        // Finde den Punkt mit der minimalen x-Koordinate (linkester Punkt)
        int leftPointIndex = 0;
        for (int i = 1; i < n; i++) {
            if (points.get(i).x < points.get(leftPointIndex).x) {
                leftPointIndex = i;
            }
        }

        int currentPoint = leftPointIndex;

        do {
            convexHull.add(points.get(currentPoint));
            int nextPoint = (currentPoint + 1) % n;

            for (int i = 0; i < n; i++) {
                // Überprüfe, ob der i-te Punkt weiter "links" liegt als der nächste Punkt
                if (orientation(points.get(currentPoint), points.get(i), points.get(nextPoint)) < 0) {
                    nextPoint = i;
                }
            }

            currentPoint = nextPoint;
        } while (currentPoint != leftPointIndex);

        return convexHull;
    }

    private int orientation(Point p, Point q, Point r) {
        int value = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (value == 0) {
            return 0; // Vielfache voneinander
        }
        return (value > 0) ? 1 : -1; // Uhrzeigersinn oder gegen den Uhrzeigersinn
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = getHeight() - e.getY();

        points.add(new Point(x, y));
        convexHull = findConvexHull(points);
        currentPointIndex++;

        repaint();
    }

    // Unbenutzte Methoden des MouseListener-Interfaces
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Gift Wrapping Algorithm");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            GiftWarpping giftWrapping = new GiftWarpping();
            frame.add(giftWrapping);
            frame.setVisible(true);
        });
    }
}