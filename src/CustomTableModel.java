import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
    private Data data;

    public CustomTableModel(Data data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.getData(data).length;
    }

    @Override
    public int getColumnCount() {
        return data.getColumnNames(data).length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.getData(data)[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return data.getColumnNames(data)[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
