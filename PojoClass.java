package proje1_manav;

import proje1_manav.Sarkuteri;
import proje1_manav.Secimler;

import java.util.List;
import java.util.Scanner;

public class PojoClass {
    static Scanner scan=new Scanner(System.in);
    public static void urunListle(List<String> urunler, List<Double> fiyatlar, String[] urunlerArr, double[] fiyatArr) {
        for (int i = 0; i < urunlerArr.length; i++) {
            urunler.add(urunlerArr[i]);
            fiyatlar.add(fiyatArr[i]);
        }
    }

    public static int getUrunSecim(List<String> manavUrunler, List<Double> manavFiyat) {
        int urunSecim;
        System.out.println("lütfen ürün seçimini yapınız");
        for (int i = 0; i <= manavUrunler.size() - 1; i++) {
            System.out.println((i + 1) + "\t" + manavUrunler.get(i) + "\t\t" + manavFiyat.get(i) + "TL");
        }
        System.out.println(manavUrunler.size() + 1 + "\t" + "Geri");
        urunSecim = scan.nextInt();
        return urunSecim;
    }

    public static void sepet(List<String> manavUrunler, List<Double> manavFiyat, List<String> sepet, int urunSecim) {
        System.out.println("Ne kadar almak istiyorsunuz");
        int adet = scan.nextInt();
        Secimler.toplamFiyat += (adet * manavFiyat.get(urunSecim - 1));
        sepet.add(manavUrunler.get(urunSecim - 1));
        System.out.println(sepet);
        System.out.println("Toplam tutar : " + Secimler.toplamFiyat);
    }

    public static void geri(List<String> urunler, int urunSecim) {
        switch (Secimler.secim) {
            case 1:
                if (urunSecim == urunler.size() + 1) {
                    System.out.print("Kategori bolumune gitmek istediginize emin misiniz? T/F: ");
                    String cevap = scan.next();
                    if (cevap.equalsIgnoreCase("T")) {
                        Secimler.secim();
                    } else {
                        proje1_manav.Manav.urunler();
                    }
                } else {
                    System.out.println("Yanlis numara! Tekrar deneyiniz...");
                    proje1_manav.Manav.urunler();
                }
                break;
            case 2:
                if (urunSecim == urunler.size() + 1) {
                    System.out.print("Kategori bolumune gitmek istediginize emin misiniz? T/F: ");
                    String cevap = scan.next();
                    if (cevap.equalsIgnoreCase("T")) {
                        Secimler.secim();
                    } else {
                        Sarkuteri.urunler();
                    }
                } else {
                    System.out.println("Yanlis numara! Tekrar deneyiniz...");
                    Sarkuteri.urunler();
                }
                break;
            case 3:
                if (urunSecim == urunler.size() + 1) {
                    System.out.print("Kategori bolumune gitmek istediginize emin misiniz? T/F: ");
                    String cevap = scan.next();
                    if (cevap.equalsIgnoreCase("T")) {
                        Secimler.secim();
                    } else {
                        proje1_manav.Market.urunler();
                    }
                } else {
                    System.out.println("Yanlis numara! Tekrar deneyiniz...");
                    proje1_manav.Market.urunler();
                }
                break;
        }
    }
}
