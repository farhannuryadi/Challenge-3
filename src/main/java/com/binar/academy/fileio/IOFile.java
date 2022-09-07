package com.binar.academy.fileio;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IOFile implements BaseFile {
    private BufferedReader br;
    private BufferedWriter bwr;
    @Override
    public Map<String, List<Integer>> read(String path, String extension) throws IOException {
        Map<String, List<Integer>> tampungData = new TreeMap<>();
        String url = path+"."+extension;
        String line;
        if (extension.equalsIgnoreCase("csv")) {
            File file = new File(url);
            FileReader fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            List<String> kelas = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                kelas.add(values[0]);
                List<Integer> tamp = new LinkedList<>();
                for (int i = 1; i < values.length; i++) {
                    tamp.add(Integer.parseInt(values[i]));
                }
                tampungData.put(values[0], tamp);
            }
            br.close();
        }else {
            throw new IOException("File tidak ditemukan, Pastikan File disimpan di C://temp//direktori/");
        }
        return tampungData;
    }

    @Override
    public void write(String wantWrite, String path, String extension) throws IOException{
        String url = path+"."+extension;
        File file = new File(url);
        if (extension.equals("txt")){
            if (file.createNewFile()){
                sucses(url);
            }else {
                failed();
            }
            FileWriter fileWriter = new FileWriter(file);
            bwr = new BufferedWriter(fileWriter);
            bwr.write(wantWrite);
            bwr.newLine();
            bwr.flush();
            bwr.close();
        }
        else {
            throw new IOException("File Gagal di generate, hanya dapat generate .txt");
        }
    }

    @Override
    public void sucses(String url) {
        System.out.println("File telah di generate di \n" + url);
        System.out.println("Silahkan Dicek \n");
    }

    @Override
    public void failed() {
        System.out.println("File gagal dibuat, karena file sudah ada \n");
    }
}