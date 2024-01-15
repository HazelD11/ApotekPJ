/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apotekpj;

/**
 *
 * @author victus
 */


public class DetailTransaksi {
    public static detail[] details = {};

    public static void tambahData(detail tambahItem) {
        detail[] tambahItems = new detail[details.length + 1];
        System.arraycopy(details, 0, tambahItems, 0, details.length);
        tambahItems[details.length] = tambahItem;
        details = tambahItems;
    }
    
     public static void clearDetails() {
        details = new detail[0]; // Create a new array to clear the details
    }
}

class detail{
    public String id;   
    public String idTransaksi;
    public String nama;
    public double harga;
    public int jumlah;
    
    public detail(String id,String idTransaksi,String nama, double harga, int jumlah) {
        this.id = id;
        this.idTransaksi = idTransaksi;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }
}