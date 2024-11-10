package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
    // Create a List sheet to hold the data in
    public static List<List<String>> sheet = new ArrayList<>();
    public static Object[][] data;

    public void extractData(){
        // CSV file path for data (relative path)
        String csvFilePath = "src/src/Data/Global Religion Dataset.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            sheet = br.lines()  // Converts lines to stream
                    .map(line -> {  // Maps each line to a list of values
                        String[] data = line.split(",");
                        List<String> row = new ArrayList<>();
                        for (String value : data) {
                            String newValue1 = value.replace(" ", "");
                            String newValue2 = newValue1.replace("\"", "");
                            row.add(newValue2);
                        }
                        return row; // Return the cleaned row
                    })
                    .collect(Collectors.toList());  // Collect into a List of Lists
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Returns the column names as an array of strings
    public String[] getColumnNames(Data data) {
        data.extractData();

        String[] columnNames = {
                "Year", "Protestant", "Catholic", "Orthodox", "Anglican", "Other Christians", "Total Christians",
                "Orthodox Jew", "Conservative Jew", "Reform Jew", "Other Jews", "Total Jews",
                "Sunni Muslim", "Shia Muslim", "Ibadi Muslim", "Nation of Islam", "Alawite Muslim",
                "Ahmadi Muslim", "Other Muslims", "Total Muslims",
                "Mahayana Buddhist", "Theravada Buddhist", "Other Buddhists", "Total Buddhists",
                "Zoroastrian", "Hindu", "Sikh", "Shinto", "Bahá'í", "Taoist", "Jain", "Confucian",
                "Syncretic", "Animist", "Non-Religious", "Other Religions",
                "Sum Religions", "Population", "World Population",
                "Protestant %", "Catholic %", "Orthodox %", "Anglican %", "Other Christians %",
                "Total Christians %", "Orthodox Jew %", "Conservative Jew %", "Reform Jew %", "Other Jews %",
                "Total Jews %", "Sunni %", "Shia %", "Ibadi %", "Nation of Islam %", "Alawite %",
                "Ahmadi %", "Other Muslims %", "Total Muslims %",
                "Mahayana %", "Theravada %", "Other Buddhists %", "Total Buddhists %",
                "Zoroastrian %", "Hindu %", "Sikh %", "Shinto %", "Bahá'í %",
                "Taoist %", "Jain %", "Confucian %", "Syncretic %", "Animist %",
                "Non-Religious %", "Other Religions %", "Sum %",
                "Total Population", "Version"
        };

        //return sheet.getFirst().toArray(new String[0]);
        return columnNames;
    }

    // Returns the data as a 2D array of strings
    public Object[][] getData(Data data) {
        data.extractData();

        Object[][] allData = new Object[sheet.size()-1][];

        for (int i = 1; i < sheet.size(); i++) {
            allData[i-1] = sheet.get(i).toArray();
        }

        return allData;
    }

    public static void main(String[] args) {
        Data data = new Data();

       /*  Print the CSV data
        for (List<String> row : sheet) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }*/

        String[] columnNames = data.getColumnNames(data);
        Object[][] theData = data.getData(data);

        for (String x : columnNames) {
            System.out.println(x);
        }
    }
}