package com.binar.academy.menu;

import java.util.Scanner;
import com.binar.academy.controller.MenuControl;
import static com.binar.academy.controller.MenuControl.onStop;

public class Menu {
    private int userInputMainMenu;
    private int userInputLastMenu;
    public static final Scanner sc = new Scanner(System.in);

    public int getUserInputMainMenu() {
        return userInputMainMenu;
    }

    public void setUserInputMainMenu(int userInputMainMenu) {
        this.userInputMainMenu = userInputMainMenu;
    }

    public int getUserInputLastMenu() {
        return userInputLastMenu;
    }

    public void setUserInputLastMenu(int userInputLastMenu) {
        this.userInputLastMenu = userInputLastMenu;
    }

    public void mainMenu(){
        header();
        System.out.println("1. Generate txt untuk menampilkan modus");
        System.out.println("2. Generate txt untuk menampilkan modus, mean, median");
        System.out.println("3. Generate txt kedua File");
        System.out.println("0. Exit");
        System.out.print("Pilih Menu : ");
        userInputMainMenu = sc.nextInt();
    }

    public void lastMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Kembali Kemenu utama");
        System.out.print("Pilih Menu : ");
        userInputLastMenu = sc.nextInt();
        footer();
    }

    public void header(){
        System.out.println();
        System.out.println("""
            ----------------------------------------------------------
            >>>>          Aplikasi Pengolah Nilai Siswa           <<<<
            ----------------------------------------------------------
            """);
    }

    public void footer(){
        if ( userInputMainMenu == 0 ||  userInputLastMenu == 0) {
            System.out.println("""
                                            
                    <><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
                            Terima Kasih Telah Menggunakan Aplikasi Ini\040
                                       -create@FarhanNuryadi-
                    """);
            onStop();
        }else if (userInputLastMenu == 1){
            MenuControl.setKondisi(true);
        }else {
            System.out.println("Salah Input Pilihan!!");
        }
    }
}