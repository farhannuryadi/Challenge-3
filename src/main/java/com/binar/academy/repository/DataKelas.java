package com.binar.academy.repository;

import java.util.*;

public abstract class DataKelas{
    private List<String> namaKelas;
    private List<Integer> dataModus;
    private List<Double> dataMedian;
    private List<Double> dataMean;
    protected Map<String, List<Integer>> dataNilaiKelas;
    private List<Map<Integer, Integer>> dataFrekuensi;

    public List<String> getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(List<String> namaKelas) {
        this.namaKelas = namaKelas;
    }

    public List<Integer> getDataModus() {
        return dataModus;
    }

    public void setDataModus(List<Integer> dataModus) {
        this.dataModus = dataModus;
    }

    public List<Double> getDataMedian() {
        return dataMedian;
    }

    public void setDataMedian(List<Double> dataMedian) {
        this.dataMedian = dataMedian;
    }

    public List<Double> getDataMean() {
        return dataMean;
    }

    public void setDataMean(List<Double> dataMean) {
        this.dataMean = dataMean;
    }

    public List<Map<Integer, Integer>> getDataFrekuensi() {
        return dataFrekuensi;
    }

    public void setDataFrekuensi(List<Map<Integer, Integer>> dataFrekuensi) {
        this.dataFrekuensi = dataFrekuensi;
    }

    protected DataKelas() {
    }

    protected DataKelas(Map<String, List<Integer>> dataNilaiKelas) {
        sortData(dataNilaiKelas);
        this.namaKelas = ambilKelas(dataNilaiKelas);
        this.dataNilaiKelas = dataNilaiKelas;
    }

    protected void sortData(Map<String, List<Integer>> dataNilaiKelas){
        Set<Map.Entry<String, List<Integer>>> entries = dataNilaiKelas.entrySet();
        for (var entry:
                entries) {
            Collections.sort(entry.getValue());
        }
    }

    protected List<String> ambilKelas(Map<String, List<Integer>> dataNilaiKelas){
        Set<Map.Entry<String, List<Integer>>> entries = dataNilaiKelas.entrySet();
        List<String> temp = new ArrayList<>();
        for (var entry:
                entries) {
            temp.add(entry.getKey());
        }
        return temp;
    }

}
