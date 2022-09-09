package com.binar.academy.service;

import java.util.*;

import com.binar.academy.repository.DataKelas;

public class CountService extends DataKelas implements BaseCount {

    public CountService(Map<String, List<Integer>> dataNilaiKelas) throws NullPointerException{
        super(dataNilaiKelas);
//        Jika menggunakan Optional
        /*Optional<Map<String, List<Integer>>> dataKelas = Optional.ofNullable(super.dataNilaiKelas);
        if (dataKelas.isPresent()){
            mean();
            median();
            modus();
            modusFrekuensi();
        }
        */

        if (dataNilaiKelas.isEmpty()){
            throw new NullPointerException("file yang dibaca kosong, Cek kembali file tesebut");
        }
        else {
            mean();
            median();
            modusFrekuensi();
            modus();
        }
    }
    @Override
    public List<Double> mean() {
        List<Double> tempMean = new ArrayList<>();
        super.dataNilaiKelas.entrySet().stream()
                .map(keys -> keys.getValue())
                .forEach(integers -> {
                    List<Integer> nilai = new ArrayList<>(integers);
                    double temp = nilai.stream()
                            .mapToDouble(value -> value)
                            .average().orElse(Double.NaN);
                    tempMean.add(temp);
                });
//        Set<Map.Entry<String, List<Integer>>> entries = super.dataNilaiKelas.entrySet();
//        for (var entry: entries) {
//            List<Double> nilaiPerkelas = new ArrayList<>();
//            for (var value: super.dataNilaiKelas.get(entry.getKey())) {
//                nilaiPerkelas.add(Double.valueOf(value));
//            }
////            menggunakan Stream
//            double temp = nilaiPerkelas.stream()
//                    .mapToDouble(Double::doubleValue)
//                    .average().orElse(Double.NaN);
//            tempMean.add(temp);
//        }
        super.setDataMean(tempMean);
        return super.getDataMean();
    }

    @Override
    public List<Double> median() {
        List<Double> tempMedian = new ArrayList<>();
        super.dataNilaiKelas.entrySet().stream()
                .map(keys -> keys.getValue())
                .forEach(integers -> {
                    List<Integer> nilai = new ArrayList<>(integers);
                    double temp=0;
                    double size = nilai.stream().mapToDouble(value -> value).count();
                    temp = (size % 2 == 1)?
                            nilai.get((int) (size/2)):(nilai.get((int) (size/2)) + nilai.get((int) (size/2)))/2;
                    tempMedian.add(temp);
                });
//        Set<Map.Entry<String, List<Integer>>> entries = super.dataNilaiKelas.entrySet();
//        for (var entry: entries) {
//            List<Double> nilaiPerkelas = new ArrayList<>();
//            double temp=0;
//            for (var value: super.dataNilaiKelas.get(entry.getKey())) {
//                nilaiPerkelas.add(Double.valueOf(value));
//            }
//            for (var ignored :
//                 nilaiPerkelas) {
//                if (nilaiPerkelas.size() % 2 ==1){
//                    temp = nilaiPerkelas.get(nilaiPerkelas.size()/2);
//                }else {
//                    temp = (nilaiPerkelas.get(nilaiPerkelas.size()/2) + nilaiPerkelas.get(nilaiPerkelas.size()/2))/2;
//                }
//            }
//        }
//            tempMedian.add(temp);
        super.setDataMedian(tempMedian);
        return super.getDataMedian();
    }

    @Override
    public List<Integer> modus() {
        List<Integer> tempModus = new ArrayList<>();
        Set<Map.Entry<String, List<Integer>>> entries = super.dataNilaiKelas.entrySet();
        int result = 0;
        int h = 0;
        int j = 0;
        int max =0;
//        super.getDataFrekuensi().stream()
//                .forEach(value -> {
//                    int jumlah =0;
//                    int nilai=0;
//                    Map<Integer, Integer> cb = new HashMap<>(value);
//                    int maxx = cb.entrySet().stream().map(keys -> keys.getValue())
//                            .filter()
//                });
//        super.dataNilaiKelas.entrySet().stream()
//                .map(keys -> keys.getValue())
//                .forEach(integers -> {
//                    List<Integer> nilai = new ArrayList<>(integers);
//                    int result = 0;
//                    int h= 0;
//                    int j = 0;
//                    int max =0;
//                    int has = nilai.stream()
//                            .mapToInt(value -> {
//                                if (value == j){
//                                    h++;
//                                    if (h>max){
//                                        max = h;
//                                        result = j;
//                                    }
//                                }else {
//                                    j = value;
//                                    h = 1;
//                                }
//                                return result;
//                            });
//                });
        for (var entry: entries) {
            List<Integer> nilaiPerkelas = new ArrayList<>(super.dataNilaiKelas.get(entry.getKey()));
            int[] dataArray = new int[nilaiPerkelas.size()];
            for (int i = 0; i < nilaiPerkelas.size(); i++) {
                dataArray[i] = nilaiPerkelas.get(i);
            }
            for (int i:
                    dataArray) {
                if (i == j){
                    h++;
                    if (h>max){
                        max = h;
                        result = j;
                    }
                }else {
                    j = i;
                    h = 1;
                }
            }
            tempModus.add(result);
        }
        super.setDataModus(tempModus);
        return super.getDataModus();
    }

    @Override
    public List<Map<Integer, Integer>> modusFrekuensi() {
        List<Map<Integer, Integer>> modusfrekuensi = new ArrayList<>();
        super.dataNilaiKelas.entrySet().stream()
                .map(keys -> keys.getValue())
                .forEach(integers -> {
                    HashMap<Integer, Integer> frequency = new HashMap<>();
                    List<Integer> nilai = new ArrayList<>(integers);
                    nilai.stream().forEach(integer -> {
                                frequency.merge(integer, 1, Integer::sum);
                            });
                    modusfrekuensi.add(frequency);
                });
//        Set<Map.Entry<String, List<Integer>>> entries = super.dataNilaiKelas.entrySet();
//        for (var entry: entries) {
//            HashMap<Integer, Integer> frequency = new HashMap<>();
//            List<Integer> nilaiPerkelas = new ArrayList<>(super.dataNilaiKelas.get(entry.getKey()));
//            int[] dataArray = new int[nilaiPerkelas.size()];
//            for (int i = 0; i < nilaiPerkelas.size(); i++) {
//                dataArray[i] = nilaiPerkelas.get(i);
//            }
//            for (Integer ch : dataArray) {
//                frequency.merge(ch, 1, Integer::sum);
//            }
//            modusfrekuensi.add(frequency);
//        }
        super.setDataFrekuensi(modusfrekuensi);
        return super.getDataFrekuensi();
    }
}