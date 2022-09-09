package com.binar.academy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountServiceTest {

    CountService countService;

    @BeforeEach
    void setUp() {
        List<Integer> nilai1 = new ArrayList<>(List.of(4, 5, 6, 7, 7, 8, 9));

        Map<String, List<Integer>> data = new HashMap<>();
        data.put("KelasA", nilai1);

        countService = new CountService(data);
    }

    @Test
    @DisplayName("Cek Apakah hasil mean yang keluar sama dengan 6.57")
    void testMeanEqualsSixPointFiftySeven() {
        List<Double> result = countService.mean();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        assertEquals("6.57", decimalFormat.format(result.get(0)));
    }

    @Test
    @DisplayName("Cek Apakah hasil median yang keluar sama dengan 7")
    void testMedianEqualsSeven() {
//        countService.median();
        List<Double> result = countService.median();
        assertEquals(7, result.get(0));
    }

    @Test
    @DisplayName("Cek Apakah hasil modus yang keluar sama dengan 7")
    void testModusEqualsSeven() {
       List<Integer> result = countService.modus();
       assertEquals(7, result.get(0));
    }

    @Test
    @DisplayName("Cek Apakah hasil frekuensi yang keluar sama dengan [{4=1, 5=1, 6=1, 7=2, 8=1, 9=2}]")
    void testModusFrekuensi() {
        Map<Integer, Integer> numberFrekuensi = new HashMap<>();
        numberFrekuensi.put(4,1);
        numberFrekuensi.put(5,1);
        numberFrekuensi.put(6,1);
        numberFrekuensi.put(7,2);
        numberFrekuensi.put(8,1);
        numberFrekuensi.put(9,1);

        List<Map<Integer,Integer>> result = countService.modusFrekuensi();
        assertEquals(List.of(numberFrekuensi), result);
    }

    @Test
    @DisplayName("Cek Apakah jika data yang dibaca kosong akan melemparkan NullpointerException")
    void testNegatifIfvalueEmpty(){
        Map<String, List<Integer>> empty = new HashMap<>();
        Exception e = assertThrows(NullPointerException.class, ()-> new CountService(empty));
        assertEquals("file yang dibaca kosong, Cek kembali file tesebut", e.getMessage());

//        pengecekan jika menggunakan Optional
        /*countService = new CountService(empty);
        System.out.println(countService.getDataFrekuensi());
        assertNotNull(countService);
         */
    }
}