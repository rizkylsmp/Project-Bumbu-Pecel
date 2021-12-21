package com.company;

import java.util.ArrayList;

public class SistemPecel {
    private int totalBiayaBahan;
    private int totalBiayaAlat;
    private int total;
    private int labaKotor;

    // inisialisasi arraylist
    ArrayList<ProfitPecel> bramPecel;

    public SistemPecel() {
        bramPecel = new ArrayList<>();

        hargaBahan();
    }

    /*
    fungsi untuk list nama dan harga bahan baku
    untuk satu kali produski
     */
    public int hargaBahan() {
        int[] hargaBahanBaku = new int[14];
        hargaBahanBaku[0] = 240000;   // Harga Kacang 10 kg
        hargaBahanBaku[1] = 8000;    // Harga Cabe Kecil 4 ons
        hargaBahanBaku[2] = 35000;   // Harga Cabe Besar 1 kg
        hargaBahanBaku[3] = 18000;   // Harga Bawang Putih 1 kg
        hargaBahanBaku[4] = 13000;   // Harga Kencur 1 kg
        hargaBahanBaku[5] = 4400;    // Harga Daun Jeruk 4 ons
        hargaBahanBaku[6] = 55000;   // Harga Gula Merah 5 kg
        hargaBahanBaku[7] = 6000;    // Harga Asam Jawa 4 ons
        hargaBahanBaku[8] = 24000;   // Gula  Pasir 2 kg
        hargaBahanBaku[9] = 5000;    // Harga Garam
        hargaBahanBaku[10] = 1000;   // Harga Bio Miwon
        hargaBahanBaku[11] = 27000;  // Harga Minyak 1,5 liter
        hargaBahanBaku[12] = 10000;  // Harga Bensin 1x Produksi
        hargaBahanBaku[13] = 5900;   // Harga Gas 1x Produksi

        // total biaya bahan baku
        totalBiayaBahan = 0;
        for (Integer index : hargaBahanBaku) {
            totalBiayaBahan = index + totalBiayaBahan;
        }
        return totalBiayaBahan;
    }

    /*
    fungsi menghitung biaya alat
    dengan parameter jumlah pesanan
    kecil dan besar dari class konsol
     */
    public void hargaAlat(int pesananKecil, int pesananBesar) {
        int[] hargaPenggunaanAlat = new int[3];
        hargaPenggunaanAlat[0] = 105;
        hargaPenggunaanAlat[1] = 160;
        hargaPenggunaanAlat[2] = 65;

        int jumlahCupKecil = pesananKecil * 10;
        int jumlahCupBesar = pesananBesar * 4;
        int jumlahSealer = jumlahCupKecil + jumlahCupBesar;

        int hargaPenggunaanCupKecil = jumlahCupKecil * hargaPenggunaanAlat[0];
        int hargaPenggunaanCupBesar = jumlahCupBesar * hargaPenggunaanAlat[1];
        int hargaPenggunaanSealer = jumlahSealer * hargaPenggunaanAlat[2];

        totalBiayaAlat = hargaPenggunaanCupKecil + hargaPenggunaanCupBesar + hargaPenggunaanSealer;

        totalModal();
    }

    /*
    fungsi menghitung seluruh total modal
    dalam sekali produksi
     */
    public int totalModal() {
        total = totalBiayaBahan + totalBiayaAlat;
        return total;
    }

    /*
    fungsi perhitungan laba kotor yang diperoleh
     */
    public int labaKotor(int totalPesanan) {
        int pendapatanJualPecel = totalPesanan * 35000;
        int modalPerkilo = total/22;

        if (totalPesanan > 22) {
            int totalBaru = (((totalPesanan - 22) * modalPerkilo) + total);
            System.out.println("Total Modal 1x Produksi : Rp. " + totalBaru);
            labaKotor = pendapatanJualPecel - (((totalPesanan - 22) * modalPerkilo) + total);
        }
        if (totalPesanan == 22){
            int totalBaru = total;
            System.out.println("Total Modal 1x Produksi : Rp. " + totalBaru);
            labaKotor = pendapatanJualPecel - total;
        }
        if (totalPesanan < 22) {
            int totalBaru = (totalPesanan * modalPerkilo);
            System.out.println("Total Modal 1x Produksi : Rp. " + totalBaru);
            labaKotor = pendapatanJualPecel - (totalPesanan * modalPerkilo);
        }

        System.out.println("Pendapatan : Rp. " + pendapatanJualPecel);
        System.out.println("Laba Kotor : Ro. " + labaKotor);
        System.out.println(" ");

        return labaKotor;
    }
}
