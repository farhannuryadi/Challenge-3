package com.binar.academy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        String extension= "csv";
        String url = "C://temp//direktori/data_sekolah."+extension;
        String line;
        if (extension.equalsIgnoreCase("csv")) {
            Stream<String> rows = Files.lines(Path.of(url));
            rows.forEach(x -> {
                List<String> nama = Arrays.asList(x.split(";"));
                Map<String, List<Integer>> map = new HashMap<>();
                List<Integer> value = nama.stream()
                        .flatMap(s -> {
                    try {
                        return Integer.parseInt(s);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
            });

//            Map<String, List<Integer>> map = new HashMap<>();
//            map = rows
//                    .map(x -> x.split(";"))
//                    .collect((Collectors.toMap(
//                            (x) -> x[0],
//                            (x) -> {
//                                for (int i = 1; i < x.length ; i++) {
//                                    Integer.parseInt(Arrays.stream(x).collect(Collectors.joining()))
//                                }
//                            })));
//            rows.close();
//            map.forEach((key, value) -> {
//                System.out.println(key + " => " + value);
//            });
        }else {
            throw new IOException("File tidak ditemukan, Pastikan File disimpan di C://temp//direktori/");
        }
    }
}
