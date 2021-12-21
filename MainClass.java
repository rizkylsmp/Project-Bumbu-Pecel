package com.company;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        // inisialisasi user input
        Scanner in = new Scanner(System.in);

        /*
        inisialisasi objek Sistem Pecel
         */
        SistemPecel sistemPecel = new SistemPecel();

        System.out.println("""
                1. Sistem Konsol
                2. Sistem GUI
                Pilih : """);

        /*
        pemilihan kode berdasarkan angka 1 atau 2
        1 -> program profit pecel berbasis konsol
        2 -> program profit pecel berbasis GUI
         */
        String kode = in.next();
        if (kode.equals("1")) {
            new InputKonsol(sistemPecel);
        }
        if (kode.equals("2")) {
            new ProfitPecelGUI(sistemPecel);
        }

    }
}
