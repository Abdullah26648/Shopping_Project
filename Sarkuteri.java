package proje1_manav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static proje1_manav.Manav.urunSecim;

public class Sarkuteri {
    static Scanner scan = new Scanner(System.in);

    public static void urunler() {
        List<String> sarkuteriUrunler = new ArrayList<>();
        List<Double> sarkuteriFiyat = new ArrayList<>();
        String[] urunlerArr = {"Kiyma", "Kavurma", "Sosis"
                , "Sucuk", "Salam", "Tavuk", "Bonfile", "Köfte"
                , "Yumurta", "Zeytin", "Peynir"};
        double[] fiyatArr = {200.95, 125.30, 55.40, 152.95, 40.85
                , 65.90, 175.50, 85.40, 43.70, 32.80, 74.50};
        PojoClass.urunListle(sarkuteriUrunler,sarkuteriFiyat,urunlerArr,fiyatArr);
        List<String> sepet = Secimler.sepet;
        if (Secimler.secim == 2){
            urunSecim = PojoClass.getUrunSecim(sarkuteriUrunler,sarkuteriFiyat);
            if (urunSecim > 0 && urunSecim<=sarkuteriUrunler.size()){
                PojoClass.sepet(sarkuteriUrunler,sarkuteriFiyat,sepet,urunSecim);
                for (int i = 0 ; i<1 ; i++){
                    System.out.println("Devam etmek istiyormusunuz ? T/F");
                    String kcevap = scan.next();
                    if (kcevap.equalsIgnoreCase("T")){
                        for (int j = 0; j < 1; j++){
                            System.out.println("Ayni kategoride mi devam etmek istersin? T/F");
                            String cevap = scan.next();
                            if (cevap.equalsIgnoreCase("T")){
                                urunler();
                            } else if (cevap.equalsIgnoreCase("F")){
                                Secimler.secim();
                            } else {
                                System.out.println("Lutfen gecerli bir deger giriniz");
                                j--;
                            }
                        }
                    } else if (kcevap.equalsIgnoreCase("F")){
                        Odeme.odeme();
                    } else {
                        System.out.println("Lutfen gecerli bir deger giriniz");
                        i--;
                    }
                }
            } else {
                PojoClass.geri(sarkuteriUrunler,urunSecim);
            }
        }
    }
}
