/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apotekpj;

/**
 *
 * @author victus
 */
public class Kasir {
    public static uKasir[] users = {
        new uKasir("admin1","admin","Budi"),
        new uKasir("admin2","123","Siti"),
    };
}

class uKasir{
    public String username;
    public String password;
    public String nama;
    
    public uKasir(String username, String password, String nama) {
        this.username = username;
        this.password = password;
        this.nama = nama;
    }
    
}