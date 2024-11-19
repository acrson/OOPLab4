import javax.swing.*;
import java.awt.*;

// Serves as the main for GUI
public class DataVisual {
    public static TablePanel tablePanel;
    public static DetailsPanel detailsPanel;
    public static FilterPanel filterPanel;
    public static StatsPanel statsPanel;
    public static ChartPanel chartPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Global Religion Data Analysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(2000, 900));
        mainPanel.setBackground(Color.BLACK);

        detailsPanel = new DetailsPanel();
        statsPanel = new StatsPanel();
        tablePanel = new TablePanel(detailsPanel, statsPanel);
        filterPanel = new FilterPanel(tablePanel, detailsPanel);
        chartPanel = new ChartPanel();

        frame.add(mainPanel, BorderLayout.CENTER);
        tablePanel.setBounds(240, 65, 1100, 280);
        detailsPanel.setBounds(1350, 5, 400, 750);
        filterPanel.setBounds(240, 5, 1100, 50);
        statsPanel.setBounds(240, 355, 545, 400);
        chartPanel.setBounds(795, 355, 545, 400);

        mainPanel.add(tablePanel);
        mainPanel.add(detailsPanel);
        mainPanel.add(filterPanel);
        mainPanel.add(statsPanel);
        mainPanel.add(chartPanel);

        frame.setPreferredSize(new Dimension(2000, 900));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);
    }
}
