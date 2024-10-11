/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TUF
 */
public final class Elektronik extends Barang {
    private final int dayaListrik;
    
    public Elektronik(int id, String nama, int stok, int dayaListrik){
        super(id, nama, stok);
        this.dayaListrik = dayaListrik;
    }

    public int getDayaListrik() {
        return dayaListrik;
    }
    
    @Override
    public void tampilkanBarang(){
        System.out.println("ID:" + getId() + ", Nama: " + getNama() + ", Stok: " + getStok() + ", Jenis: Elektronik, Daya Listrik: " + dayaListrik + " watt");
    }
}
