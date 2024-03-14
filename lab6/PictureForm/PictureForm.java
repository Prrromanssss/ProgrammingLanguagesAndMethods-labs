package lab6.PictureForm;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import lab6.CanvasPanel;

public class PictureForm {
    private JPanel mainPanel;
    private JSpinner radiusSpinner;
    private JSpinner arcLengthSpinner;
    private CanvasPanel canvasPanel;
    private JCheckBox checkbox;

    public PictureForm() {
        radiusSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged (ChangeEvent e) {
                int radius = (int)radiusSpinner.getValue();
                canvasPanel.setRadius(radius);
            }
        });
        arcLengthSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged (ChangeEvent e) {
                int length = (int)arcLengthSpinner.getValue();
                canvasPanel.setArcLength(length);
            }
        });
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                canvasPanel.setColor(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        radiusSpinner.setValue(20);
        arcLengthSpinner.setValue(20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Окружность");
        frame.setContentPane (new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.pack();
        frame.setVisible(true);
    }
}

