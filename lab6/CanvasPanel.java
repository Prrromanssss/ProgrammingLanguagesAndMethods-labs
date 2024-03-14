package lab6;

import javax.swing.*;
import java.awt.*;


public class CanvasPanel extends JPanel {
    private int radius = 20;
    private int arcLength = 20;
    private boolean isColor = false;
    public void setRadius(int r) {
        radius = r;
        repaint();
    }

    public void setArcLength(int al) {
        arcLength = al;
        repaint();
    }

    public void setColor(boolean isColor) {
        this.isColor = isColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int centerX = panelWidth / 2;
        int centerY = panelHeight / 2;
        int angleRadians = arcLength / radius;

        if (isColor) {
            g2d.setColor(Color.RED);
            g2d.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius,
                    0, (int) Math.toDegrees(angleRadians));
        } else {
            g2d.drawArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius,
                    0, (int) Math.toDegrees(angleRadians));
        }

        int x1 = (int) (centerX + radius * Math.cos(0));
        int y1 = (int) (centerY + radius * Math.sin(0));
        int x2 = (int) (centerX + radius * Math.cos(2 * Math.PI - angleRadians));
        int y2 = (int) (centerY + radius * Math.sin(2 * Math.PI - angleRadians));

        g2d.drawLine(centerX, centerY, x1, y1);
        g2d.drawLine(centerX, centerY, x2, y2);
    }
}
