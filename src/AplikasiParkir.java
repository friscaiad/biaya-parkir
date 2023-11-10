import java.util.Scanner;

class Parkir {
    private static final double BIAYA_5_JAM_PERTAMA = 1.0;
    private static final double BIAYA_PER_JAM_SELANJUTNYA = 0.5;
    private static final double BIAYA_FLAT_24_JAM = 15.0;
    private static final int BATAS_WAKTU_FLAT_24_JAM = 24;

    private final int jamParkir;

    public Parkir(int jamParkir) {
        this.jamParkir = jamParkir;
    }

    public double hitungBiayaParkir() {
        if (jamParkir <= 5) {
            return BIAYA_5_JAM_PERTAMA;
        } else if (jamParkir < BATAS_WAKTU_FLAT_24_JAM) {
            return BIAYA_5_JAM_PERTAMA + (jamParkir - 5) * BIAYA_PER_JAM_SELANJUTNYA;
        } else if (jamParkir == BATAS_WAKTU_FLAT_24_JAM) {
            return BIAYA_FLAT_24_JAM;
        }else {
            return BIAYA_FLAT_24_JAM + ((jamParkir - 24) * BIAYA_PER_JAM_SELANJUTNYA);

        }
    }
}

public class AplikasiParkir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah jam parkir: ");
        int jamParkir = scanner.nextInt();

        // Membuat objek Parkir
        Parkir parkir = new Parkir(jamParkir);

        // Menghitung biaya parkir
        double biayaParkir = parkir.hitungBiayaParkir();

        // Menampilkan hasil
        System.out.println("Biaya parkir yang harus dibayar: $" + biayaParkir);

        // Menutup scanner
        scanner.close();
    }
}
