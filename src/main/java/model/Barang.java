package model;

// Kelas induk Barang
public abstract class Barang {
    private final int id;
    private final String nama;
    private int stok;

    // Constructor
    public Barang(int id, String nama, int stok) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Method untuk menampilkan detail barang (abstrak)
    public abstract void tampilkanBarang();
}
