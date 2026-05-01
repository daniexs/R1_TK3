
public class PlaylistRekursif {

  // atribut playlist
  static Lagu[] playlist;

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
    System.out.println("Total durasi: ");

    // fungsi cariDurasiTerpanjang
    System.out.println("Lagu terpanjang: ");
    System.out.println();

    // ganti loop dengan fungsi tampilkanMundur
    for (int i = 0; i < playlist.length; i++) {
      System.out.print((i + 1) + ". ");
      playlist[i].tampilkanInfo();
    }

    // fungsi rekursif
    System.out.println("\nExecution Time (totalDurasi): " + " ms");
    System.out.println("Execution Time (tampilkanMundur): " + " ms");
    System.out.println("Execution Time (cariDurasiTerpanjang): " + " ms");

  }
}
