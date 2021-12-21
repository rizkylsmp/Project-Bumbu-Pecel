package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/*
inisialisasi semua komponen UI
yang diperlukan
 */
public class ProfitPecelGUI {
    private DefaultTableModel modelTabel;
    private JTextField fieldNamaToko;
    private JTextField fieldHargaPecel;
    private JTextField fieldKecil;
    private JTextField fieldBesar;
    private JTextField fieldTotal;
    private JTextField fieldPendapatan;
    private int untung;
    private JTextField fieldLaba;

    SistemPecel sistemPecel;

    /*
    inisialisasi pembuatan frame UI
     */
    public ProfitPecelGUI(SistemPecel sistemPecel) {
        this.sistemPecel = sistemPecel;
        this.modelTabel = new DefaultTableModel();

        JFrame frame = new JFrame("Profit Pecel");
        frame.setSize(500, 600);
        frame.setResizable(false);

        tambahPanel(frame);
    }

    /*
    fungsi penambahan panel ke frame
     */
    public void tambahPanel(JFrame frame) {
        JPanel panelUtama = new JPanel();
        panelUtama.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.add(panelUtama);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JScrollPane pane = new JScrollPane();
        JPanel panel9 = new JPanel();

        panelUtama.add(panel2);
        panelUtama.add(panel1);
        panelUtama.add(panel3);
        panelUtama.add(panel4);
        panelUtama.add(panel5);
        panelUtama.add(panel6);
        panelUtama.add(panel7);
        panelUtama.add(panel8);
        panelUtama.add(pane);
        panelUtama.add(panel9);

        setFrameKeTengahLayar(frame);
        hargaPecel(panel2);
        hari(panel1);
        namaToko(panel3);
        jumlahPesananKecil(panel4);
        jumlahPesananBesar(panel5);
        totalPesanan(panel6);
        jumlahPendapatan(panel7);
        labaKotor(panel8);
        buttonSimpan(panel9);
        createTable(pane);
        tampilkanFrame(frame);
    }

    /*
    fungsi untuk membuat
    frame UI ke tengah layar laptop
     */
    public void setFrameKeTengahLayar(JFrame frame) {
        Dimension laptop = Toolkit.getDefaultToolkit().getScreenSize();
        int x = laptop.width/2 - frame.getWidth()/2;
        int y = laptop.height/2 - frame.getHeight()/2;
        frame.setLocation(x, y);
    }

    /*
    pembuatan label dan field text
    untuk mengisi harga pecel perkilo
     */
    public void hargaPecel(JPanel panel2) {
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        fieldHargaPecel = new JTextField(7);
        fieldHargaPecel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panel2.add(new JLabel("Harga Pecel per KG       "));
        panel2.add(fieldHargaPecel);
    }

    /*
    pembuatan label hari
    */
    public void hari(JPanel panel1) {
        LocalDate hari = LocalDate.now();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelHari = new JLabel("                                                        " + hari);

        panel1.add(labelHari);
    }

    public void namaToko(JPanel panel3) {
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        fieldNamaToko = new JTextField(7);
        fieldNamaToko.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panel3.add(new JLabel("Nama Toko Pemesan    "));
        panel3.add(fieldNamaToko);
    }

    /*
    pembuatan field untuk mengisi
    jumlah pesanan kecil per kilo
     */
    public void jumlahPesananKecil(JPanel panel4) {
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

        fieldKecil = new JTextField(7);
        fieldKecil.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panel4.add(new JLabel("Jumlah Pesanan Kecil  "));
        panel4.add(fieldKecil);
        panel4.add(new JLabel("(kilogram)"));
    }

    /*
    pembuatan field untuk mengisi
    jumlah pesanan besar per kilo
     */
    public void jumlahPesananBesar(JPanel panel5) {
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

        fieldBesar = new JTextField(7);
        fieldBesar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panel5.add(new JLabel("Jumlah Pesanan Besar"));
        panel5.add(fieldBesar);
        panel5.add(new JLabel("(kilogram)"));
    }

    /*
    fungsi menghitung seluruh jumlah pesanan
     */
    public void totalPesanan(JPanel panel6) {
        panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

        fieldTotal = new JTextField(7);
        fieldTotal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        fieldTotal.setEditable(false);

        JButton buttonTotal = new JButton("Total");
        buttonTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int kecil = Integer.parseInt(fieldKecil.getText());
                int besar = Integer.parseInt(fieldBesar.getText());
                int totalPesanan = kecil + besar;

                fieldTotal.setText("" + totalPesanan);
            }
        });

        panel6.add(new JLabel("Total Pesanan Pecel     "));
        panel6.add(fieldTotal);
        panel6.add(buttonTotal);
    }

    /*
    pembuatan field dan button untuk
    menghitung jumlah pendapatan
    jumlah pendapatan = harga pecel perkilo * jumlah total pesanan
     */
    public void jumlahPendapatan(JPanel panel7) {
        panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

        fieldPendapatan = new JTextField(7);
        fieldPendapatan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        fieldPendapatan.setEditable(false);

        JButton buttonPendapatan = new JButton("Hitung");
        buttonPendapatan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int hargaPecel = Integer.parseInt(fieldHargaPecel.getText());
                int jumlahPesanan = Integer.parseInt(fieldTotal.getText());
                int total = hargaPecel * jumlahPesanan;

                fieldPendapatan.setText("" + total);
            }
        });

        panel7.add(new JLabel("Pendapatan Masuk       "));
        panel7.add(fieldPendapatan);
        panel7.add(buttonPendapatan);
    }

    /*
    pembuatan field dan button untuk menghitung
    laba kotor yang diperoleh
     */
    public void labaKotor(JPanel panel8) {
        panel8.setLayout(new FlowLayout(FlowLayout.LEFT));

        fieldLaba = new JTextField(7);
        fieldLaba.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JButton buttonPendapatan = new JButton("Pendapatan");
        buttonPendapatan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String namaToko = fieldNamaToko.getText();

                int pecelKecil = Integer.parseInt(fieldKecil.getText());
                int pecelBesar = Integer.parseInt(fieldBesar.getText());
                int totalPesanan = pecelKecil + pecelBesar;

                int pendapatanJualPecel = Integer.parseInt(String.valueOf(fieldPendapatan.getText()));

                if (totalPesanan > 22) {
                    untung = pendapatanJualPecel -
                            (sistemPecel.totalModal() + ((sistemPecel.hargaBahan()/22)*(totalPesanan-22)));
                }
                if (totalPesanan == 22) {
                    untung = pendapatanJualPecel - sistemPecel.totalModal();
                }
                if (totalPesanan < 22) {
                    untung = pendapatanJualPecel - ((sistemPecel.totalModal()/22) * totalPesanan);
                }

                fieldLaba.setText("" + untung);

                sistemPecel.bramPecel.add(new ProfitPecel(namaToko, pecelKecil, pecelBesar, untung));
            }
        });

        panel8.add(new JLabel("Laba Kotor                       "));
        panel8.add(fieldLaba);
        panel8.add(buttonPendapatan);
    }

    /*
    button simpan untuk menyimpan semua
    perolehan dan data ke dalam database
     */
    public void buttonSimpan(JPanel panel9) {
        panel9.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton simpan = new JButton("Simpan");
        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String namaToko = fieldNamaToko.getText();
                int pesananKecil = Integer.parseInt(fieldKecil.getText());
                int pesananBesar = Integer.parseInt(fieldBesar.getText());
                int laba = Integer.parseInt(fieldLaba.getText());

                ProfitPecel profitPecel = new ProfitPecel(namaToko, pesananKecil, pesananBesar, laba);
                new Database(profitPecel);

                updateTable();

                fieldNamaToko.setText("");
                fieldKecil.setText("");
                fieldBesar.setText("");
                fieldPendapatan.setText("");
                fieldTotal.setText("");
                fieldLaba.setText("");
                fieldHargaPecel.setEditable(false);
                fieldNamaToko.requestFocus();
            }
        });

        panel9.add(simpan);
    }

    /*
    fungsi untuk pembuatan tabel UI
     */
    public void createTable(JScrollPane pane) {
        pane.setBorder(BorderFactory.createTitledBorder("Simpan Perolehan Laba"));

        String[] kolom = {"Hari", "Nama Toko", "Pecel Kecil", "Pecel Besar", "Laba"};
        String[][] isi = {};

        modelTabel = new DefaultTableModel(isi, kolom);
        JTable tabelKosong = new JTable(modelTabel);
        tabelKosong.setEnabled(false);
        tabelKosong.setPreferredScrollableViewportSize(new Dimension(465, 200));

        pane.setViewportView(tabelKosong);
    }

    /*
    fungsi mengisi data di dalam tabel
     */
    public void updateTable() {
        LocalDate hari = LocalDate.now();
        modelTabel.setRowCount(0);
        for (ProfitPecel profitPecel : sistemPecel.bramPecel) {
            String[] baris = {String.valueOf(hari), profitPecel.namaToko, String.valueOf(profitPecel.pesananKecil),
                    String.valueOf(profitPecel.pesananBesar), String.valueOf("Rp. " + profitPecel.laba)};
            modelTabel.addRow(baris);
        }
    }

    /*
    menunjukkan tampilan frame ke user
     */
    public void tampilkanFrame(JFrame frame) {
        frame.setVisible(true);
    }
}
