import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class TablePanel extends JPanel {
    Data data; // Creates a data object from the data class
    // Creates a JTable
    JTable table;
    DetailsPanel detailsPanel;
    StatsPanel statsPanel;
    TableRowSorter<TableModel> sorter;

    public TablePanel(DetailsPanel detailsPanel, StatsPanel statsPanel) {
        this.setPreferredSize(new Dimension(1100, 280));
        this.setBackground(Color.BLUE);
        this.detailsPanel = detailsPanel;
        this.statsPanel = statsPanel;

        Data data = new Data();

        table = new JTable(data.getData(data), data.getColumnNames(data));

        // Disables automatic column resizing to allow horizontal scrolling
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table); // Add the table to the scroll pane
        scrollPane.setPreferredSize(new Dimension(1100, 270)); // Set a preferred size for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        table.setFillsViewportHeight(true);

        add(scrollPane); // Add the scroll pane to the frame

        // Listener for row selection changes
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    handleSelectionChange();
                }
            }
        });

        // Listener for column selection changes
        table.getColumnModel().addColumnModelListener(new TableColumnModelListener() {
            @Override public void columnAdded(TableColumnModelEvent e) {}
            @Override public void columnRemoved(TableColumnModelEvent e) {}
            @Override public void columnMoved(TableColumnModelEvent e) {}
            @Override public void columnMarginChanged(ChangeEvent e) {}
            @Override
            public void columnSelectionChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Handle column change
                    handleSelectionChange();
                }
            }
        });
    }

    public void setFilter(RowFilter<Object, Object> filter) {
        sorter.setRowFilter(filter);
    }

    private void handleSelectionChange() {
        int selectedRow = table.getSelectedRow();
        int selectedColumn = table.getSelectedColumn();
        if (selectedRow >= 0) {
            Object[] rowData = new Object[table.getColumnCount()];
            for (int i = 0; i < table.getColumnCount(); i++) {
                rowData[i] = table.getValueAt(selectedRow, i);
            }
            detailsPanel.updateDetails(rowData, selectedColumn);
            statsPanel.updateDetails(rowData, selectedColumn);
        }
    }
}