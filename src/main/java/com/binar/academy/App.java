package com.binar.academy;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException {
//        Map<String, List<Integer>> tampungData = new TreeMap<>();
//        String extension= "csv";
//        String url = "C://temp//direktori/data_sekolah."+extension;
//        String line;
//        if (extension.equalsIgnoreCase("csv")) {
//            File file = new File(url);
//            FileReader fileReader = new FileReader(file);
//            BufferedReader br = new BufferedReader(fileReader);
//            List<String> kelas = new LinkedList<>();
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(";");
//                kelas.add(values[0]);
//                List<Integer> tamp = new LinkedList<>();
//                for (int i = 1; i < values.length; i++) {
//                    tamp.add(Integer.parseInt(values[i]));
//                }
//                tampungData.put(values[0], tamp);
//            }
//            br.close();
//        }else {
//            throw new IOException("File tidak ditemukan, Pastikan File disimpan di C://temp//direktori/");
//        }

//        String extension= "csv";
//        String url = "C://temp//direktori/data_sekolah."+extension;
//        String line;
//        if (extension.equalsIgnoreCase("csv")) {
//            Stream<String> rows = Files.lines(Path.of(url));
//            rows.forEach(x -> {
//                List<String> nama = Arrays.asList(x.split(";"));
//                Map<String, List<Integer>> map = new HashMap<>();
//                List<Integer> value = nama.stream()
//                        .flatMap(s -> {
//                    try {
//                        return Integer.parseInt(s);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    return null;
//                }).collect(Collectors.toList());
//            });
//
////            Map<String, List<Integer>> map = new HashMap<>();
////            map = rows
////                    .map(x -> x.split(";"))
////                    .collect((Collectors.toMap(
////                            (x) -> x[0],
////                            (x) -> {
////                                for (int i = 1; i < x.length ; i++) {
////                                    Integer.parseInt(Arrays.stream(x).collect(Collectors.joining()))
////                                }
////                            })));
////            rows.close();
////            map.forEach((key, value) -> {
////                System.out.println(key + " => " + value);
////            });
//        }else {
//            throw new IOException("File tidak ditemukan, Pastikan File disimpan di C://temp//direktori/");
//        }

//        AtomicInteger i= new AtomicInteger(1);
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(5);
//        numbers.add(9);
//        numbers.add(8);
//        numbers.add(1);
//        Consumer<Integer> method = System.out::println;
//        numbers.forEach( method );


        Map<String, List<Integer>> dataNilaiKelas = new HashMap<>();
        dataNilaiKelas.put("KelasA", List.of(7,7,8,9,4,5,6));
        List<Double> tempMean = new ArrayList<>();
        Set<Map.Entry<String, List<Integer>>> entries = dataNilaiKelas.entrySet();
        for (var entry: entries) {
            List<Double> nilaiPerkelas = new ArrayList<>();
            for (var value: dataNilaiKelas.get(entry.getKey())) {
                nilaiPerkelas.add(Double.valueOf(value));
            }
            double temp = nilaiPerkelas.stream()
                    .mapToDouble(Double::doubleValue)
                            .average().orElse(Double.NaN);
            System.out.println(temp);
        }


        List<Double> tempMedian = new ArrayList<>();
        for (var entry: entries) {
            List<Double> nilaiPerkelas = new ArrayList<>();
            double temp = 0;
            for (var value : dataNilaiKelas.get(entry.getKey())) {
                nilaiPerkelas.add(Double.valueOf(value));
            }
            temp = nilaiPerkelas.stream()
                    .mapToDouble(Double::doubleValue)
                    .filter(value -> nilaiPerkelas.size() % 2 == 1)
                    .count();
//                    .average(value -> nilaiPerkelas.get(nilaiPerkelas.size()/2))
//                    .orElse(Double.NaN);
            System.out.println(temp);
//            for (var ignored :
//                    nilaiPerkelas) {
//                if (nilaiPerkelas.size() % 2 == 1) {
//                    temp = nilaiPerkelas.get(nilaiPerkelas.size() / 2);
//                } else {
//                    temp = (nilaiPerkelas.get(nilaiPerkelas.size() / 2) + nilaiPerkelas.get(nilaiPerkelas.size() / 2)) / 2;
//                }
//            }
//            tempMedian.add(temp);
//            System.out.println(tempMedian);
        }
    }
}
