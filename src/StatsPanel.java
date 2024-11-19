import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class StatsPanel extends JPanel {
    public List<JLabel> statLabels;
    Data data;
    Color darkRed = new Color(124, 0, 0);

    public StatsPanel() {
        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(darkRed);

        JLabel titleLabel = new JLabel("Data Statistics - No Cell Selected");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        statLabels = new ArrayList<>();
    }

    public void updateDetails(Object[] rowData, int selectedColumn) {
        // Clear previous labels from the panel
        removeAll();
        statLabels.clear();

        setLayout(new GridLayout(0, 2, 2, 2)); // Rows, Columns, Horizontal Gap, Vertical Gap

        data = new Data();
        String[] columnName = data.getColumnNames(data);
        String[] statName = {"Column Selected: ", "Maximum: ", "Minimum: ", "Mean: ", "Median: ", "Mode: ", "Range: "};

        ArrayList<Double> columnData = new ArrayList<Double>();
        for (int i = 0; i < 14; i++) {
            columnData.add(Double.parseDouble(data.getData(data)[i][selectedColumn].toString()));
        }

        double maxNum = getMax(columnData);
        double minNum = getMin(columnData);
        double meanNum = getMean(columnData);
        double medianNum = getMedian(columnData);
        double modeNum = getMode(columnData);
        double rangeNum = getRange(columnData);

        String maxString = Double.toString(maxNum);
        String minString = Double.toString(minNum);
        String meanString = Double.toString(meanNum);
        String medianString = Double.toString(medianNum);
        String modeString = Double.toString(modeNum);
        String rangeString = Double.toString(rangeNum);

        for (String s : statName) {
            JLabel label = new JLabel("  " + s);
            label.setFont(new Font("Arial", Font.BOLD, 12));
            if (s.equals("Column Selected: ")) {
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Arial", 3, 20));
            }
            else {
                label.setForeground(Color.BLACK);
                label.setFont(new Font("Arial", 0, 20));
            }

            JLabel valueLabel;
            if (s.equals("Column Selected: ")) {
                valueLabel = new JLabel(data.getColumnNames(data)[selectedColumn]);
            } else if (s.equals("Maximum: ")) {
                valueLabel = new JLabel(maxString);
            } else if (s.equals("Minimum: ")) {
                valueLabel = new JLabel(minString);
            } else if (s.equals("Mean: ")) {
                valueLabel = new JLabel(meanString);
            } else if (s.equals("Median: ")) {
                valueLabel = new JLabel(medianString);
            } else if (s.equals("Mode: ")) {
                valueLabel = new JLabel(modeString);
            } else {
                valueLabel = new JLabel(rangeString);
            }

            valueLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            valueLabel.setForeground(Color.BLACK);

            if (s.equals("Column Selected: ")) {
                valueLabel.setForeground(Color.WHITE);
                valueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            }

            statLabels.add(label);
            statLabels.add(valueLabel);

            add(label);
            add(valueLabel);
        }

        // Revalidate and repaint to reflect the changes immediately
        revalidate();
        repaint();
    }

    public double getMax(ArrayList<Double> dataList) {
        double max = dataList.get(0);
        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) > max) {
                max = dataList.get(i);
            }
        }
        return max;
    }

    public double getMin(ArrayList<Double> dataList) {
        double min = dataList.get(0);
        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) < min) {
                min = dataList.get(i);
            }
        }
        return min;
    }

    public double getMean(ArrayList<Double> dataList) {
        double sum = 0;
        for (Double value : dataList) {
            sum += value;
        }
        return sum / dataList.size();
    }

    public double getMedian(ArrayList<Double> dataList) {
        Collections.sort(dataList);
        int size = dataList.size();
        if (size % 2 == 0) {
            return (dataList.get(size / 2 - 1) + dataList.get(size / 2)) / 2;
        } else {
            return dataList.get(size / 2);
        }
    }

    public double getMode(ArrayList<Double> dataList) {
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (Double num : dataList) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        double mode = dataList.get(0);
        int maxCount = 1;
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    public double getRange(ArrayList<Double> dataList) {
        return getMax(dataList) - getMin(dataList);
    }
}
