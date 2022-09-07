package com.binar.academy.service;

import java.util.List;
import java.util.Map;

public interface BaseCount {
    List<Double> mean();
    List<Double> median();
    List<Integer> modus();
    List<Map<Integer,Integer>> modusFrekuensi();
}
