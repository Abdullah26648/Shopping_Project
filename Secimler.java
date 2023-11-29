package proje1_manav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Secimler {
    public static double toplamFiyat = 0.0;
    public static List<String> sepet = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int secim;

    public static void secim() {
        System.out.print("Lütfen kategori seçiniz\n"
                + "1 Manav\n" + "2 Sarkuteri\n" + "3 Market\n" + "4 Odeme\n" + "5 Cikis\n" + "Seciminiz: ");
        secim = scan.nextInt();
        if (secim == 1) {
            proje1_manav.Manav.urunler();
        } else if (secim == 2) {
            proje1_manav.Sarkuteri.urunler();
        } else if (secim == 3) {
            proje1_manav.Market.urunler();
        } else if (secim == 4) {
            proje1_manav.Odeme.odeme();
        } else if (secim == 5) {
            cikis();
        } else {
            System.out.println("\"Lutfen gecerli bir deger giriniz\" = " + "Lutfen gecerli bir deger giriniz");
            secim();
        }
    }
    public static void cikis() {
        System.out.println("Cikis yapildi ... \nTekrar bekleriz.");
    }
}