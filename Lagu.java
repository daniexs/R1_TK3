public class Lagu {

  // atribut private (enkapsulasi)
  private String judul;
  private String artis;
  private double durasi;

  // constructor
  public Lagu(String judul, String artis, double durasi) {
    setJudul(judul);
    setArtis(artis);
    setDurasi(durasi);
  }

  // getter dan setter

  // getter untuk mengambil judul lagu
  public String getJudul() {
    return judul;
  }

  // setter untuk mengubah judul lagu + validasi input
  public void setJudul(String judul) {
    if (judul == null || judul.isBlank()) {
      throw new IllegalArgumentException("Silakan isi judul lagu");
    }
    this.judul = judul;
  }

  // getter untuk mengambil nama artis
  public String getArtis() {
    return artis;
  }

  // setter untuk mengubah nama artis + validasi input
  public void setArtis(String artis) {
    if (artis == null || artis.isBlank()) {
      throw new IllegalArgumentException("Silakan isi nama artis");
    }
    this.artis = artis;
  }

  // getter untuk mengambil durasi lagu
  public double getDurasi() {
    return durasi;
  }

  // setter untuk mengubah durasi + validasi agar tidak negatif
  public void setDurasi(double durasi) {
    if (durasi <= 0) {
      throw new IllegalArgumentException("Durasi minimal harus lebih dari 0");
    }
    this.durasi = durasi;
  }

  // method tampilkanInfo()
  public void tampilkanInfo() {
    System.out.println(judul + " - " + artis + " (" + durasi + " menit)");
  }
}