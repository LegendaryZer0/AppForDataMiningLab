package org.example;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Task2InterpolationFailed {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
/*        double[] Y = new double[999999] ;
        ArrayList<Double> temp = new ArrayList<>();
        int q=0;*/
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\xsolla\\Desktop\\DataMining\\src\\main\\java\\org\\example\\transactions.csv")); BufferedWriter
        writer = new BufferedWriter(new FileWriter("C:\\Users\\xsolla\\Desktop\\DataMining\\src\\main\\java\\org\\example\\result.csv"))){
            reader.readLine();
            writer.write("PROD_CODE;COUNT\n");
            while(reader.ready()){

                String[] line = reader.readLine().split(";");
                if(map.containsKey(line[0])) {

                    map.put(line[0], map.get(line[0]) + 1);
                }else map.put(line[0], 1);


            }
            map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).forEach((x)->{   //or reverseOrder
                try{
                  /*  temp.add(Double.parseDouble(x.getValue().toString()));*/
                    writer.write(x.getKey()+";"+x.getValue()+"\n");
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
/*            for(int i =0;i<temp.size();i++){
                Y[q]=temp.get(i);
                q++;
            }
            double[] X = new double[Y.length];
            for(double i =0;i<X.length;i++){
                X[(int) i]=i;
            }
            UnivariateInterpolator interpolator = new SplineInterpolator();
            UnivariateFunction function = interpolator.interpolate (X, Y);
            System.out.println(function.toString());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
