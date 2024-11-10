package src;

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
            }
            else if (s.equals("Maximum: ")) {
                valueLabel = new JLabel(maxString);
            }
            else if (s.equals("Minimum: ")) {
                valueLabel = new JLabel(minString);
            }
            else if (s.equals("Mean: ")) {
                valueLabel = new JLabel(meanString);
            }
            else if (s.equals("Median: ")) {
                valueLabel = new JLabel(medianString);
            }
            else if (s.equals("Mode: ")) {
                valueLabel = new JLabel(modeString);
            }
            else {
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

    // Function to find the maximum value from the data in the selected column
    public double getMax(ArrayList<Double> columnData) {
        double max;
        max = Collections.max(columnData);
        return max;
    }

    // Function to find the minimum value from the data in the selected column
    public double getMin(ArrayList<Double> columnData) {
        double min;
        min = Collections.min(columnData);
        return min;
    }

    // Function to find the average of the values from the data in the selected column
    public double getMean(ArrayList<Double> columnData) {
        double mean = 0;
        for (Double value : columnData) {
            mean += value;
        }
        mean = mean / columnData.size();
        return mean;
    }

    // Function to find the median value from the data in the selected column
    public double getMedian(ArrayList<Double> columnData) {
        double median = 0;
        boolean even = true;
        columnData.sort(Collections.reverseOrder());

        if (columnData.size() % 2 == 1) {
            even  = false;
        }

        int middle = columnData.size() / 2;
        if (even) {
            median = (columnData.get(middle) + columnData.get(middle + 1)) / 2;
        }
        else {
            median = columnData.get(middle);
        }

        return median;
    }

    // Function to find the mode of the values from the data in the selected column
    public double getMode(ArrayList<Double> columnData) {
        Map<Double, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each number
        for (Double value : columnData) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        // Find the number with the highest frequency
        double mode = columnData.get(0);
        int maxCount = 0;

        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        return mode;
    }

    // Function to find the range of the values from the data in the selected column
    public double getRange(ArrayList<Double> columnData) {
        double max = getMax(columnData);
        double min = getMin(columnData);
        return max - min;
    }
}
