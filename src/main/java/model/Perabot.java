/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TUF
 */
public final class Perabot extends Barang {
    private final String bahan;
    
    public Perabot(int id, String nama, int stok, String bahan){
        super(id, nama, stok);
        this.bahan = bahan;
    }

    public String getBahan() {
        return bahan;
    }
    
    @Override
    public void tampilkanBarang(){
        System.out.println("ID: " + getId() + ", Nama: " + getNama() + ", Stok: " + getStok() + ", Jenis: Perabot, Bahan: " + bahan);
    }
}
