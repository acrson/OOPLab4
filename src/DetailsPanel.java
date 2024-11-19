import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DetailsPanel extends JPanel {
    public List<JLabel> detailLabels; // Unchanged
    Data data;                        // Unchanged
    Color darkRed = new Color(124, 0, 0); // Unchanged

    public DetailsPanel() {
        // Unchanged initialization logic
        this.setPreferredSize(new Dimension(400, 750));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new FlowLayout());

        detailLabels = new ArrayList<>();

        JLabel defaultPanel = new JLabel("Details - No Cell Selected");
        defaultPanel.setFont(new Font("Arial", Font.BOLD, 20));
        add(defaultPanel);
    }

    // Updated method to include both rowData and selectedColumn
    public void updateDetails(Object[] rowData, int selectedColumn) {
        // Unchanged logic for clearing and resetting panel
        removeAll();
        detailLabels.clear();

        setLayout(new GridLayout(0, 4, 2, 2)); // Unchanged layout configuration

        data = new Data(); // Unchanged
        String[] columnName = data.getColumnNames(data); // Unchanged

        // Loop through each item in the row data (Unchanged logic with a new selectedColumn highlight)
        for (int i = 0; i < rowData.length; i++) {
            JLabel label = new JLabel(columnName[i] + ": ");
            label.setFont(new Font("Arial", Font.BOLD, 12));

            // Highlight specific column for the selected data
            if (i == 0) {
                label.setForeground(darkRed);
                label.setFont(new Font("Arial", 3, 20));
            }
            if (i == selectedColumn) {
                label.setOpaque(true);
                label.setBackground(Color.YELLOW);
            }

            JLabel valueLabel = new JLabel(String.valueOf(rowData[i]));
            valueLabel.setFont(new Font("Arial", Font.PLAIN, 12));

            // Highlight specific column for the selected data
            if (i == 0) {
                valueLabel.setForeground(darkRed);
                valueLabel.setFont(new Font("Arial", 1, 20));
            }
            if (i == selectedColumn) {
                valueLabel.setOpaque(true);
                valueLabel.setBackground(Color.YELLOW);
            }

            detailLabels.add(label);      // Unchanged
            detailLabels.add(valueLabel); // Unchanged

            add(label);      // Unchanged
            add(valueLabel); // Unchanged
        }

        // Revalidate and repaint to reflect the changes (Unchanged)
        revalidate();
        repaint();
    }
}
