package com.binar.academy.service;

import java.util.Map;
import java.util.Set;

public class ResultString {

    private static StringBuilder stringBuilder;

    public static String resultStringMenu1(CountService countService){
        stringBuilder = new StringBuilder();
        stringBuilder.append("Berikut Hasil Pengolahan Nilai\n\n");
        for (int i = 0; i < countService.getNamaKelas().size(); i++) {
            stringBuilder.append(countService.getNamaKelas().get(i)).append(" : \n");
            stringBuilder.append("-----------------------------\n");
            stringBuilder.append( "|Nilai           | Frekuensi|\n");
            stringBuilder.append("-----------------------------\n");
            Map<Integer,Integer> temp = countService.getDataFrekuensi().get(i);
            Set<Map.Entry<Integer, Integer>> entries = temp.entrySet();
            int lessThanSix = 0;
            for (var entry: entries) {
                if (entry.getKey() < 6 ) lessThanSix += entry.getValue();
            }
            stringBuilder.append(String.format("|Kurang dari 6   | %-9d|", lessThanSix)).append("\n");
            for (var entry: entries) {
                if (entry.getKey() >= 6)
                    stringBuilder.append(String.format("|%-15d | %-9d|", entry.getKey(), entry.getValue())).append("\n");
            }
            stringBuilder.append("-----------------------------\n\n");
        }
        return stringBuilder.toString();
    }
    public static String resultStringMenu2(CountService countService){
        stringBuilder = new StringBuilder();
        stringBuilder.append("Berikut Hasil Pengolahan Nilai\n\n");
        stringBuilder.append( "Berikut hasil sebaran data nilai\n");
        stringBuilder.append("----------------------------------------\n");
        for (int i = 0; i < countService.getNamaKelas().size(); i++) {
            stringBuilder.append(countService.getNamaKelas().get(i)).append("\n");
            stringBuilder.append("Mean   : ").append(String.format("%.2f", countService.getDataMean().get(i))).append("\n");
            stringBuilder.append("Median : ").append(countService.getDataMedian().get(i).toString()).append("\n");
            stringBuilder.append("Modus  : ").append(countService.getDataModus().get(i).toString()).append("\n\n");
        }
        return stringBuilder.toString();
    }
}
