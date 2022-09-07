package com.binar.academy;

import java.io.IOException;
import static com.binar.academy.controller.MenuControl.*;

public class Main {
    public static void main(String[] args) {
        try {
            onStart();
        }catch (NullPointerException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}