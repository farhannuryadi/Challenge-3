package com.binar.academy.controller;

import java.io.IOException;
import java.util.*;
import com.binar.academy.fileio.*;
import com.binar.academy.menu.Menu;
import com.binar.academy.service.CountService;
import static com.binar.academy.utility.Extension.*;
import static com.binar.academy.utility.Path.*;
import static com.binar.academy.service.ResultString.*;

public class MenuControl{
    private static boolean kondisi = true;
    public static void setKondisi(boolean kondisi) {
        MenuControl.kondisi = kondisi;
    }
    private static final Menu menu = new Menu();
    private static final IOFile ioFile = new IOFile();

    public static void onStart() throws InputMismatchException, IOException {
        CountService countService = new CountService(ioFile.read(FILEREADER,CSV.name().toLowerCase()));
        while (kondisi) {
            try {
                menu.mainMenu();
                switch (menu.getUserInputMainMenu()) {
                    case 0 -> menu.footer();
                    case 1 -> {
                        menu.header();
                        ioFile.write(resultStringMenu1(countService), FILEWRITERMODUS,TXT.name().toLowerCase());
                        menu.lastMenu();
                    }
                    case 2 -> {
                        menu.header();
                        ioFile.write(resultStringMenu2(countService), FILEWRITERMEANMEDIANMODUS,TXT.name().toLowerCase());
                        menu.lastMenu();
                    }
                    case 3 -> {
                        menu.header();
                        ioFile.write(resultStringMenu1(countService), FILEWRITERMODUS,TXT.name().toLowerCase());
                        ioFile.write(resultStringMenu2(countService), FILEWRITERMEANMEDIANMODUS,TXT.name().toLowerCase());
                        menu.lastMenu();
                    }
                    default -> System.out.println(" !!! - Salah Input Pilihan - !!! ");
                }
            }catch (InputMismatchException e){
                System.out.println(" !!! - Tolong Masukan Angka - !!! ");
                Menu.sc.next();
            }
        }
    }

    public static void onStop(){
        kondisi = false;
        System.exit(0);
    }
}