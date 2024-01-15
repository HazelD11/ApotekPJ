/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apotekpj;

/**
 *
 * @author victus
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi {

     public static double grandTotal() {
        double total = 0;
        for(detail items : DetailTransaksi.details){
                total += items.harga * items.jumlah;
        }
        return total;
}

    public static void cetakTransaksi(transaksi tr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println("===============================");
        System.out.println("ID Transaksi   : " + tr.id);
        System.out.println("Nama Kasir     : " + tr.namaKasir);
        System.out.println("Tanggal        : " + dateFormat.format(tr.tanggal));
    }

    public static class transaksi {
        public String id;
        public String namaKasir;
        public Date tanggal;

        public transaksi(String id, String namaKasir, Date tanggal) {
            this.id = id;
            this.namaKasir = namaKasir;
            this.tanggal = tanggal;
        }
    }
}
