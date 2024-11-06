package com.codegym;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class App {

    public void usarApacheCommonsMatematicas() throws IllegalStateException {
        double[] values = new double[] { 65, 51 , 16, 11 , 6519, 191 ,0 , 98, 19854, 1, 32 };
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (double v : values) {
            descriptiveStatistics.addValue(v);
        }

        double mean = descriptiveStatistics.getMean();
        double median = descriptiveStatistics.getPercentile(50);
        double standardDeviation = descriptiveStatistics.getStandardDeviation();

        System.out.println("Media: " + mean);
        System.out.println("Mediana: " + median);
        System.out.println("Desviacion standard: " + standardDeviation);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new App().usarApacheCommonsMatematicas();
    }
}
