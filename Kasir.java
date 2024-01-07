import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

class Kasir {
    private Scanner scanner;
    private ArrayList<Item> daftarPesanan;
    private int totalItemDibeli;
    private HashSet<String> namaPelangganSet;
    private int nomorPelanggan;
    private int nomorStruk;

    public Kasir() {
        scanner = new Scanner(System.in);
        daftarPesanan = new ArrayList<>();
        totalItemDibeli = 0;
        namaPelangganSet = new HashSet<>();
        nomorPelanggan = 1; // Nomor pelanggan dimulai dari 1
        nomorStruk = 1001; // Nomor struk dimulai dari 1001
    }

    public void tampilkanMenu() {
        System.out.println("===========Menu Makanan Ikan============");
        System.out.println("1. Salmon Teriyaki        :Rp 25.000");
        System.out.println("2. Ikan Goreng            :Rp 20.000 ");
        System.out.println("3. Sushi                  :Rp 30.000");
    }

    public void prosesPesanan() {
        try {
            // Menggunakan nomor pelanggan dan menaikkan setiap kali ada pelanggan baru
            String nomorPelangganStr = String.format("%03d", nomorPelanggan++);
            String nomorStrukStr = String.format("%04d", nomorStruk++);

            String namaPelanggan = "";
            String nomorTelepon = "";
            String alamatPelanggan = "";

            System.out.print("Masukkan Nama Pelanggan: ");
            namaPelanggan = scanner.nextLine();

            System.out.print("Masukkan Nomor Telepon Pelanggan: ");
            nomorTelepon = scanner.nextLine();

            System.out.print("Masukkan Alamat Pelanggan: ");
            alamatPelanggan = scanner.nextLine();

            // Menambahkan nama pelanggan ke HashSet
            namaPelangganSet.add(namaPelanggan);

            double totalBelanja = 0;

            do {
                tampilkanMenu();

                System.out.print("Silahkan Pilih Menu yang Tersedia (1-3): ");
                int pilihan = scanner.nextInt();

                Item item = null;
                switch (pilihan) {
                    case 1:
                        item = new SalmonTeriyaki();
                        break;
                    case 2:
                        item = new IkanGoreng();
                        break;
                    case 3:
                        item = new Sushi();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!!");
                        return;
                }

                System.out.print("Masukkan Jumlah Pesanan Anda : ");
                int jumlah = scanner.nextInt();

                if (jumlah <= 0) {
                    System.out.println("Jumlah pesanan harus lebih dari 0. Silakan masukkan jumlah yang valid.");
                    continue;
                }

                double totalHarga = item.getHarga() * jumlah;
                totalBelanja += totalHarga;

                item.setJumlah(jumlah);
                daftarPesanan.add(item);
                totalItemDibeli += jumlah;

                System.out.print("\nApakah Anda ingin memesan lagi? (ya/tidak): ");
            } while (scanner.next().equalsIgnoreCase("ya"));

            // Tampilkan struk belanja setelah selesai memesan
            System.out.println("\nStruk Belanja Anda");
            System.out.println("=================Resto IkanKU====================");
            System.out.println("        Jln Ikan no 37 Padang");
            System.out.println("email:RestoIkanku@gmail.com  contact :0297865432");
            System.out.println("================================================");

            // Format tanggal saat ini
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String tanggalStruk = dateFormat.format(new Date());
            System.out.println("Tanggal Transaksi  : " + tanggalStruk);
            System.out.println("Nomor Struk        : " + nomorStrukStr); // Menampilkan nomor struk
            System.out.println("Nomor Pelanggan    : " + nomorPelangganStr); // Menampilkan nomor pelanggan
            System.out.println("Pelanggan          : " + namaPelanggan);
            System.out.println("Nomor Telepon      : " + nomorTelepon); // Menampilkan nomor telepon
            System.out.println("Alamat Pelanggan   : " + alamatPelanggan); // Menampilkan alamat pelanggan
            System.out.println("Item yang dibeli  :");
            for (Item pesanan : daftarPesanan) {
                System.out.printf("%-25s x%-3d  Rp %10.2f\n", pesanan.getNama(), pesanan.getJumlah(), pesanan.getHarga());
            }
            System.out.println("\nTotal Item Dibeli : " + totalItemDibeli);
            System.out.println("Total Belanja      : Rp " + totalBelanja);
            System.out.println("            \nTerima kasih atas kunjungan Anda!");
            System.out.println("=================================================");

        } catch (InputMismatchException e) {
            System.out.println("Terjadi kesalahan input. Pastikan input yang dimasukkan sesuai");
        }
    }
}
