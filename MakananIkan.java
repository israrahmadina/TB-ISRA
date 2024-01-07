class MakananIkan implements Item {
    private String nama;
    private double harga;
    private int jumlah;   // Menambahkan variabel jumlah

    public MakananIkan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = 0;   // Inisialisasi jumlah dengan 0
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public double getHarga() {
        return harga;
    }

    @Override
    public int getJumlah() {
        return jumlah;
    }

    @Override
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}

class SalmonTeriyaki extends MakananIkan {
    public SalmonTeriyaki() {
        super("Salmon Teriyaki       ", 25000);
    }
}

class IkanGoreng extends MakananIkan {
    public IkanGoreng() {
        super("Ikan Goreng", 20000);
    }
}

class Sushi extends MakananIkan {
    public Sushi() {
        super("Sushi", 30000);
    }
}