// I started implementing FilterPanel but got stuck and had to move on, didn't have the time to come back and
// finish it unfortunately...

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterPanel extends JPanel {
    TablePanel tablePanel;
    JComboBox<String> religionComboBox;
    JButton applyFilterButton;

    public FilterPanel(TablePanel tablePanel, DetailsPanel detailsPanel) {
        this.setPreferredSize(new Dimension(1100, 50));
        this.setBackground(Color.LIGHT_GRAY);
        this.tablePanel = tablePanel;

        // Filter criteria
        religionComboBox = new JComboBox<>(new String[] {"All", "Christian", "Jewish", "Muslim", "Buddhist", "Hindu", "Other"});
        applyFilterButton = new JButton("Apply Filter");

        add(new JLabel("Filter by Religion:"));
        add(religionComboBox);
        add(applyFilterButton);

        // Applies filter on button click
        applyFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilter();
            }
        });
    }

    private void applyFilter() {
        String selectedReligion = (String) religionComboBox.getSelectedItem();

        if (!selectedReligion.equals("All")) {
            RowFilter<Object, Object> religionFilter = RowFilter.regexFilter(selectedReligion, 1); // Use the correct column index
            tablePanel.setFilter(religionFilter);
        } else {
            tablePanel.setFilter(null); // Removes the filter
        }
    }
}
