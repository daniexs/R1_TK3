import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlaylistRekursif {

  // atribut playlist
  static Lagu[] playlist;

  // fungsi rekursif buat mindahin urutan tampil lagu ke belakang dulu (mundur)
  //
  // tujuan fungsi:
  // nge-print info lagu dari index yang diminta sampe ke index 0, jadi yang
  // tampil kebalik urutan maju biasa

  // base case:
  // kalo index udah < 0 artinya ga ada lagu lagi yang valid, langsung stop
  // (return)

  // recursive case:
  // cetak lagu di list[index], abis itu panggil lagi tampilkanMundur dengan
  // index-1

  // kompleksitas:
  // waktu O(n) -- n disini banyaknya lagu yang dicetak (sejajar sama index awal +
  // 1)
  // ruang O(n) juga karena tiap panggilan rekursif nyimpen stack frame sampe
  // semuanya selesai
  static void tampilkanMundur(Lagu[] list, int index) {
    if (index < 0) {
      return;
    }
    list[index].tampilkanInfo();
    tampilkanMundur(list, index - 1);
  }

  static double totalDurasi(Lagu[] list, int n) {
    if ((n - 1) < 0) {
      return 0;
    }
    return list[n - 1].getDurasi() + totalDurasi(list, n - 1);
  }

  static double ukurWaktuTampilkanMundur(Lagu[] list, int n) {
    PrintStream asli = System.out;
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
    try {
      long mulai = System.nanoTime();
      tampilkanMundur(list, n - 1);
      long selesai = System.nanoTime();
      return (selesai - mulai) / 1_000_000.0;
    } finally {
      System.setOut(asli);
    }
  }

  static double ukurWaktuTotalDurasi(Lagu[] list, int n) {
    PrintStream asli = System.out;
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
    try {
      long mulai = System.nanoTime();
      double total = totalDurasi(list, n);
      long selesai = System.nanoTime();
      return (selesai - mulai) / 1_000_000.0;
    } finally {
      System.setOut(asli);
    }
  }

  public static void main(String[] args) {

    // inisialisasi 10 lagu
    playlist = new Lagu[] {
        new Lagu("Perfect", "Ed Sheeran", 4.23),
        new Lagu("Shivers", "Ed Sheeran", 3.50),
        new Lagu("Fix You", "Coldplay", 4.52),
        new Lagu("Yellow", "Coldplay", 4.10),
        new Lagu("Viva La Vida", "Coldplay", 4.52),
        new Lagu("Photograph", "Ed Sheeran", 4.18),
        new Lagu("Shape of You", "Ed Sheeran", 3.53),
        new Lagu("A Sky Full of Stars", "Coldplay", 4.28),
        new Lagu("Paradise", "Coldplay", 4.12),
        new Lagu("Thinking Out Loud", "Ed Sheeran", 4.41)
    };

    System.out.println("=== ANALISIS REKURSIF PLAYLIST ===");
    System.out.println("Jumlah lagu: " + playlist.length);

    // fungsi totalDurasi
    double totalDurasiLagu = totalDurasi(playlist, playlist.length);
    System.out.printf("Total durasi = %.2f menit\n", totalDurasiLagu);

    System.out.println();
    System.out.println("Daftar lagu (Terbalik):");

    tampilkanMundur(playlist, playlist.length - 1);
    // fungsi cariDurasiTerpanjang
    System.out.println("Lagu terpanjang: ");
    System.out.println();

    System.out.println("\nExecution Time (tampilkanMundur): ");
    int[] ukuranN = { 3, 5, 10 };
    for (int n : ukuranN) {
      double ms = ukurWaktuTampilkanMundur(playlist, n);
      System.out.printf("n = %d lagu -> %.6f ms%n", n, ms);
    }

    System.out.println("\nExecution Time (totalDurasi): ");
    for (int n : ukuranN) {
      double ms = ukurWaktuTotalDurasi(playlist, n);
      System.out.printf("n = %d lagu -> %.6f ms%n", n, ms);
    }
  }
}
