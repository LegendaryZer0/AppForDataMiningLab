package org.example;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Task2Simple {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> resul = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\xsolla\\Desktop\\DataMining\\src\\main\\java\\org\\example\\transactions.csv"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\xsolla\\Desktop\\DataMining\\src\\main\\java\\org\\example\\result.csv"))) {
            reader.readLine();

            writer.write("PROD_CODE;COUNT\n");

            final int[] sum = {0};
            while (reader.ready()) {
                String[] line = reader.readLine().split(";");
                if (map.containsKey(line[0])) map.put(line[0], map.get(line[0]) + 1);
                else map.put(line[0], 1);
                sum[0] += 1;
            }

            final double[] procent = {100};
            map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach((x) -> {
                if (procent[0] >= 75) {
                    procent[0] -= (x.getValue() * 100.) / sum[0];
                    resul.put(x.getKey(), x.getValue());
                }
            });

            resul.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).forEach((x) -> {
                try {
                    writer.write(x.getKey() + ";" + x.getValue() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
