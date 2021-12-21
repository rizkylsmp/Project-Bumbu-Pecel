package com.company;

import java.time.LocalDate;

public class ProfitPecel {
    LocalDate hari;
    public String namaToko;
    public int pesananKecil;
    public int pesananBesar;
    public int laba;

    public ProfitPecel(String namaToko, int pesananKecil, int pesananBesar, int laba) {
        this.hari = LocalDate.now();
        this.namaToko = namaToko;
        this.pesananKecil = pesananKecil;
        this.pesananBesar = pesananBesar;
        this.laba = laba;
    }
}
