/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apotekpj;

/**
 *
 * @author victus
 */
public class Obat {
    public static med[] meds = {
        new med("A1","panadol",10000,"tablet"),
        new med("A2","OBH",20000,"syrup"),
        
    };
    
    public static void tambahData(med tambahObat){
        med[] tambahObats = new med[meds.length + 1];
        System.arraycopy(meds, 0, tambahObats, 0, meds.length);
        tambahObats[meds.length] = tambahObat;
        meds = tambahObats;
    }
    
}

class med{
    public String id;
    public String nama;
    public double harga;
    public String jenis;
    
    public med(String id,String nama, double harga, String jenis) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.jenis = jenis;
    }
}
