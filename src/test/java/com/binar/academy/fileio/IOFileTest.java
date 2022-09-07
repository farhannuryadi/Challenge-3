package com.binar.academy.fileio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class IOFileTest {

    IOFile ioFile;
    @BeforeEach
    void setUp() {
        ioFile = new IOFile();
    }

    @Test
    @DisplayName("Cek jika file tidak ada/tidak ditemukan maka akan menampilkan exception")
    void testNegatifIfReadFileNotFound() {
        String path = "";
        String extension = "cvs";
        Exception e = assertThrows(IOException.class, ()-> ioFile.read(path,extension));
        assertEquals("File tidak ditemukan, Pastikan File disimpan di C://temp//direktori/", e.getMessage());
    }

    @Test
    @DisplayName("Cek jika file dibuat tidak dengan format .txt maka akan mengalami exception")
    void testNegatifIfWriteNotTxtOrCsv() {
        String path = "c:/direktori/notPrint";
        String extensi = "pdf";
        Exception e = assertThrows(IOException.class, ()-> ioFile.write("print",path, extensi));
        assertEquals("File Gagal di generate, hanya dapat generate .txt", e.getMessage());
    }
}