package src;// Sigh. It would've been very cool to get to this.

import javax.swing.*;
import java.awt.*;

public class ChartPanel extends JPanel {
    public ChartPanel() {
        Color lightYellow = new Color(255, 255, 200);
        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(lightYellow);

        JLabel titleLabel = new JLabel("Chart of Statistics - Unfortunately unfinished :(");
        add(titleLabel);
    }
}
