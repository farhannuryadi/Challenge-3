package com.binar.academy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class ResultStringTest {

    private CountService countService;
    @BeforeEach
    void setUp() {
        List<Integer> nilai1 = new ArrayList<>(List.of(4, 5, 6, 7, 7, 8, 9));
        Map<String, List<Integer>> data = new HashMap<>();
        data.put("KelasA", nilai1);
        countService = new CountService(data);
    }


    @Test
    @DisplayName("Cek apakah result string berhasil berjalan")
    void testResultStringSucses() {
        assertNotNull(ResultString.resultStringMenu1(countService));
        assertNotNull(ResultString.resultStringMenu2(countService));
    }

}