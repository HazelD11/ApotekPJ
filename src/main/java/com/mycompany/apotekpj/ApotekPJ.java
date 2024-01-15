  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apotekpj;

/**
 *
 * @author victus
 */

import java.util.Scanner;
import java.util.Date;
public class ApotekPJ {

    public static void main(String[] args) {      

        Scanner scanner = new Scanner (System.in);
        Scanner scanner1 = new Scanner (System.in);
        Scanner scanner2 = new Scanner (System.in);
        Scanner scanner3 = new Scanner (System.in);
        String currentUsername = "";
        String currentPassword = "";
        String currentName = "";
        
        System.out.print("Masukkan Username : ");
        String Username = scanner.nextLine();
        
        System.out.print("Masukkan Password : ");
        String Password = scanner.nextLine();
        
            if(login(Username,Password)){
                currentUsername = Username;
                currentPassword = Password;
                System.out.println("Login Berhasil\n");
            }else{
                System.out.println("Login Gagal");
                System.exit(0);

            }
        int option;

            for(uKasir kasir : Kasir.users){
                if(currentUsername.equals(kasir.username)&&currentPassword.equals(kasir.password)){
                   currentName = kasir.nama;
                   break;
                }
            }
            System.out.println("Selamat Datang, "+currentName);
        int counterIdT = 0;
        do{
            counterIdT++;
            System.out.println("==========================");
            System.out.println("Pilih Opsi :");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Tambah Obat");
            System.out.println("3. Cek Kasir");
            System.out.println("4. Exit");
            System.out.println("==========================");
            System.out.print("Pilihan : ");
            option = scanner.nextInt();
            System.out.println("==========================");

            switch (option){
                case 1:
                    String dtBeliLagi,idDetail,nmObat = "";
                    int counterIdDetailTransaksi = 0;
                    double hrgObat = 0;
                    boolean medCheck = false;
                    double grand = 0;
                    String idT = "T"+counterIdT;
                    
                    do{
                    counterIdDetailTransaksi++;
                    for(med obat : Obat.meds){
                        System.out.println(
                                "ID Obat : "+obat.id+"|"+
                                "Nama Obat : "+obat.nama+"|"+
                                "Harga Obat : "+obat.harga+"|"+
                                "Jenis Obat : "+obat.jenis
                        );
                    }
                    idDetail = "DT"+counterIdDetailTransaksi;
                    System.out.print("Masukkan ID Obat yang ingin dibeli :");
                    String dtObat = scanner1.nextLine(); 
                    
                    for(med Obat : Obat.meds){
                        if(dtObat.equals(Obat.id)){
                           nmObat = Obat.nama;
                           hrgObat = Obat.harga;
                           medCheck = true;
                           break;
                        }
                    }
                    
                    if(medCheck == true){
                        System.out.print("Jumlah :");
                        int dtJumlah = scanner1.nextInt();
                        scanner1.nextLine();
                        detail tambahItem = new detail(idDetail,idT,nmObat,hrgObat,dtJumlah);
                        DetailTransaksi.tambahData(tambahItem);
                        System.out.print("Pesanan berhasil ditambahkan!\n");
                        System.out.print("=============================\n");
                        System.out.print("List Pesanan : \n");
                        System.out.print("=============================\n");
                        grand = Transaksi.grandTotal();
                        for(detail items : DetailTransaksi.details){
                            System.out.println(
                                    "ID Detail : "+items.id+"|"+
                                    "ID Transaksi : "+items.idTransaksi+"|"+
                                    "Nama Obat : "+items.nama+"|"+
                                    "Harga Obat : "+items.harga+"|"+
                                    "Jumlah : "+items.jumlah+"|"+
                                    "Total Harga: " + items.harga*items.jumlah
                            );
                        medCheck = false;
                        }
                        
                    }else{
                        System.out.println("Obat Tidak Tersedia!");
                        counterIdDetailTransaksi--;
                        
                    }
                    System.out.print("=============================\n");
                    System.out.print("Beli lagi?"+"("+"Y/N"+")");
                    dtBeliLagi = scanner1.nextLine(); 
                    System.out.print("=============================\n");
                    }while(dtBeliLagi.equals("Y"));
                    Transaksi.transaksi tr = new Transaksi.transaksi(idT, currentName, new Date());
                    Transaksi.cetakTransaksi(tr);

                    System.out.println("Grand Total : "+ grand);
                    System.out.println("===============================");
                    
                    DetailTransaksi.clearDetails();
                    break;
                    
                case 2:
                    String id_obat = "";
                    for(int i = 0; i<Obat.meds.length;i++){
                    id_obat = "A"+(i+2);
                    }
                    
                    System.out.print("Nama Obat :");
                    String n_obat = scanner1.nextLine(); 
                    System.out.print("Jenis Obat :");
                    String j_obat = scanner2.nextLine();
                    System.out.print("Harga Obat :");
                    double h_obat = scanner3.nextDouble();


                    med tambahObat = new med(id_obat,n_obat,h_obat,j_obat);
                    Obat.tambahData(tambahObat);
                    System.out.print("Obat berhasil ditambahkan!\n");
                    for(med obat : Obat.meds){
                        System.out.println(
                                "ID Obat : "+obat.id+"|"+
                                "Nama Obat : "+obat.nama+"|"+
                                "Harga Obat : "+obat.harga+"|"+
                                "Jenis Obat : "+obat.jenis
                        );
                    }
                    break;
                    
                case 3:
                    for(uKasir kasir : Kasir.users){
                        System.out.println(
                                "Nama : "+kasir.nama+"|"+
                                "Username : "+kasir.username+"|"+
                                "Password : "+kasir.password
                        );
                    }
//                    
                    break;
                    
                case 4:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Maaf Opsi Tidak Tersedia!");
                    

            }
        }while(option != 4);
        
        scanner.close();
    }

    private static boolean login(String Username, String Password){
        for(uKasir user : Kasir.users){
           if(Username.equals(user.username)&&Password.equals(user.password)){
               return true;
               
               
           }
        }
        return false;
    }
}
