package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DetailsPanel extends JPanel {
    public List<JLabel> detailLabels;
    Data data;

    public DetailsPanel() {
        this.setPreferredSize(new Dimension(400, 750));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new FlowLayout());

        detailLabels = new ArrayList<>();

        JLabel defaultPanel = new JLabel("Details - No Cell Selected");
        defaultPanel.setFont(new Font("Arial", Font.BOLD, 20));
        add(defaultPanel);
    }

    // Method to update details based on selected row data
    public void updateDetails(Object[] rowData, int selectedColumn) {
        // Clear previous labels from the panel
        removeAll();
        detailLabels.clear();

        setLayout(new GridLayout(0, 4, 2, 2)); // Rows, Columns, Horizontal Gap, Vertical Gap

        data = new Data();
        String[] columnName = data.getColumnNames(data);
        Color darkRed = new Color(124, 0, 0);

        // Loop through each item in the row data
        for (int i = 0; i < rowData.length; i++) {
            // Create and add the label for each piece of data
            JLabel label = new JLabel( columnName[i] + ": ");
            label.setFont(new Font("Arial", Font.BOLD, 12));
            // Makes the year information appear dark red
            if (i == 0) {
                label.setForeground(darkRed);
                label.setFont(new Font("Arial", 3, 20));
            }
            // Highlight the selected row!!
            if (i == selectedColumn) {
                label.setOpaque(true);
                label.setBackground(Color.YELLOW);
            }

            JLabel valueLabel = new JLabel(String.valueOf(rowData[i]));
            valueLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            // Makes the year information appear dark red
            if (i == 0) {
                valueLabel.setForeground(darkRed);
                valueLabel.setFont(new Font("Arial", 1, 20));
            }
            // Highlight the selected row!!!
            if (i == selectedColumn) {
                valueLabel.setOpaque(true);
                valueLabel.setBackground(Color.YELLOW);
            }
            detailLabels.add(label);
            detailLabels.add(valueLabel);

            add(label);
            add(valueLabel);
        }

        // Revalidate and repaint to reflect the changes immediately
        revalidate();
        repaint();
    }
}
