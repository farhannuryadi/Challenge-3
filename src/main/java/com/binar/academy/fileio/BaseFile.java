package com.binar.academy.fileio;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface BaseFile {
    Map<String, List<Integer>> read(String path, String extension) throws IOException;
    void write(String wantWrite, String path, String extension)throws IOException;
    void sucses(String url);
    void failed();
}
