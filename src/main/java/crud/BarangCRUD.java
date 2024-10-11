/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import model.*;
import java.util.*;
/**
 *
 * @author Fadhiil
 */
public class BarangCRUD implements ICRUD {
    // Static ArrayList untuk menampung daftar barang
    private static final ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    
    private int totalBarang; // Menyimpan total barang
    private String lastAction; // Menyimpan aksi terakhir
    private boolean isUpdated; // Menyimpan status update

    // Constructor
    public BarangCRUD() {
        this.totalBarang = 0;
        this.lastAction = "";
        this.isUpdated = false; // Menginisialisasi status update
    }

    public BarangCRUD(String adminName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Method untuk menambah barang
    @Override
    public void tambahBarang() {
        try {
            System.out.println("Pilih Jenis Barang: ");
            System.out.println("1. Elektronik");
            System.out.println("2. Perabot");
            System.out.print("Masukkan Pilihan Anda: ");
            int jenis = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukkan ID Barang: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            if (idSudahAda(id)){
                System.out.println("Error: ID Barang sudah ada. Gunakan ID lain!");
                return;
            }
            
            System.out.print("Masukkan Nama Barang: ");
            String nama = scanner.nextLine();
            
            System.out.print("Masukkan Stok Barang: ");
            int stok = scanner.nextInt();
            scanner.nextLine();
            
            if (id <= 0 || stok < 0){
                System.out.println("Error: ID harus lebih dari 0 dan stok tidak boleh negatif");
                return;
            }
            
            Barang barangBaru = null;
            
            if (jenis == 1) {
                System.out.print("Masukkan Daya Listrik (dalam watt): ");
                int dayaListrik = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline
                barangBaru = new Elektronik(id, nama, stok, dayaListrik);
            } else if (jenis == 2) {
                System.out.print("Masukkan Bahan Perabot: ");
                String bahan = scanner.nextLine();
                barangBaru = new Perabot(id, nama, stok, bahan);
            } else {
                System.out.println("Jenis barang tidak valid.");
                return;
            }
            
            daftarBarang.add(barangBaru);
            totalBarang++;
            lastAction = "Menambahkan barang ID: " + id;
            isUpdated = true;
            System.out.println("Barang Berhasil Ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Input tidak valid. Pastikan ID dan stok adalah angka.");
            scanner.nextLine(); // Bersihkan input yang salah
        }
    }

    // Method untuk mengecek apakah ID sudah ada
    private boolean idSudahAda(int id) {
        for (Barang barang : daftarBarang) {
            if (barang.getId() == id) {
                return true; // ID sudah ada
            }
        }
        return false; // ID belum ada
    }

    // Method untuk mengupdate stok barang
    @Override
    public void updateBarang() {
        try {
            System.out.print("Masukkan ID Barang yang ingin diupdate: ");
            int id = scanner.nextInt();

            System.out.print("Masukkan Stok Baru: ");
            int stokBaru = scanner.nextInt();

            if (stokBaru < 0) {
                System.out.println("Error: Stok tidak boleh negatif.");
                return;
            }

            boolean barangDitemukan = false;
            for (Barang barang : daftarBarang) {
                if (barang.getId() == id) {
                    barang.setStok(stokBaru);
                    System.out.println("Stok barang berhasil diupdate.");
                    barangDitemukan = true;
                    lastAction = "Mengupdate barang ID: " + id; // Update aksi terakhir
                    isUpdated = true; // Update status
                    break;
                }
            }

            if (!barangDitemukan) {
                System.out.println("Barang dengan ID " + id + " tidak ditemukan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input tidak valid. Pastikan ID dan stok adalah angka.");
            scanner.nextLine(); // Bersihkan input yang salah
        }
    }

    // Method untuk menghapus barang
    @Override
    public void hapusBarang() {
        try {
            System.out.print("Masukkan ID Barang yang ingin dihapus: ");
            int id = scanner.nextInt();

            boolean barangDitemukan = daftarBarang.removeIf(barang -> barang.getId() == id);

            if (barangDitemukan) {
                totalBarang--; // Update total barang
                lastAction = "Menghapus barang ID: " + id; // Update aksi terakhir
                isUpdated = true; // Update status
                System.out.println("Barang berhasil dihapus.");
            } else {
                System.out.println("Barang dengan ID " + id + " tidak ditemukan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input tidak valid. Pastikan ID adalah angka.");
            scanner.nextLine(); // Bersihkan input yang salah
        }
    }

    // Method untuk menampilkan seluruh barang
    @Override
    public void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang dalam inventaris.");
        } else {
            System.out.println("Daftar Barang dalam Inventaris:");
            for(Barang barang : daftarBarang){
                barang.tampilkanBarang();
            }
        }
    }

    // Metode untuk mendapatkan total barang
    public int getTotalBarang() {
        return totalBarang;
    }

    // Metode untuk mengecek apakah ada pembaruan
    public boolean isUpdated() {
        return isUpdated;
    }
}
