import java.util.*;

public class Mediator {
    private TablePanel tablePanel;
    private DetailsPanel detailsPanel;
    private StatsPanel statsPanel;

    public Mediator(TablePanel tablePanel, DetailsPanel detailsPanel, StatsPanel statsPanel) {
        this.tablePanel = tablePanel;
        this.detailsPanel = detailsPanel;
        this.statsPanel = statsPanel;
    }

    public void rowSelected(Object[] rowData, int selectedColumn) {
        // When a row is selected in the table, updates detailsPanel and statsPanel
        detailsPanel.updateDetails(rowData, selectedColumn);
        statsPanel.updateDetails(rowData, selectedColumn);
    }
}
