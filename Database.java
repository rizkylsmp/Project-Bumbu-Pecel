package com.company;

import java.sql.*;

public class Database {
    ProfitPecel profitPecel;

    public Database(ProfitPecel profitPecel) {
        this.profitPecel = profitPecel;

        try {
            Connection koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/profit_pecel?user=root");
            Statement statement = koneksi.createStatement();

            statement.execute("INSERT INTO profit VALUES('" + profitPecel.hari+ "','" + profitPecel.namaToko +
                    "','" + profitPecel.pesananKecil + "','" +
                    profitPecel.pesananBesar + "', '" + profitPecel.laba + "')");
            System.out.println("Penyimpanan Berhasil!");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
