package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class InputKonsol {

    public InputKonsol(SistemPecel sistemPecel) {
        Scanner in = new Scanner(System.in);

        /*
        perulangan program untuk
        menginputkan nama toko dan jumlah pesanan
         */
        while(true) {
            System.out.println("Nama Toko : ");
            String namaToko = in.next();

            System.out.println("Jumlah Pesanan Kecil (KG) : ");
            int pesananKecil = in.nextInt();

            System.out.println("Jumlah Pesanan Besar (KG) : ");
            int pesananBesar = in.nextInt();

            sistemPecel.hargaAlat(pesananKecil, pesananBesar);

            int totalPesanan = pesananKecil + pesananBesar;
            int laba = sistemPecel.labaKotor(totalPesanan);

            sistemPecel.bramPecel.add(new ProfitPecel(namaToko, pesananKecil, pesananBesar, laba));

            cetak(sistemPecel);

            System.out.println(" ");
        }
    }

    /*
    fungsi cetak data Profit Pecel
     */
    public void cetak(SistemPecel sistemPecel) {
        String format = "| %-15s | %-18s | %-25s | %-25s | %-17s |%n";
        String garis = "+-----------------+--------------------+---------------------------+---------------------------+-------------------+%n";

        System.out.format(garis);
        System.out.format(format, "Hari", "Nama Toko", "Pesanan Kecil", "Pesanan Besar", "Laba Kotor");
        System.out.format(garis);
        for (ProfitPecel pecel : sistemPecel.bramPecel) {
            System.out.format(format, pecel.hari, pecel.namaToko, pecel.pesananKecil, pecel.pesananBesar, "Rp. " + pecel.laba);
        }
        System.out.format(garis);
    }
}
