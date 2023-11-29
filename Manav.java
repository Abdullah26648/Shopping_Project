package proje1_manav;

import org.w3c.dom.Node;
import proje1_manav.Odeme;
import proje1_manav.PojoClass;
import proje1_manav.Secimler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manav {
    static Scanner scan = new Scanner(System.in);
    static int urunSecim;

    public static void urunler() {
        List<String> manavUrunler = new ArrayList<>();
        List<Double> manavFiyat = new ArrayList<>();
        String[] urunlerArr = {"Domates", "Patates", "Biber"
                , "Soğan", "Havuç", "Elma", "Kayisi", "Çilek"
                , "Kavun", "Üzüm", "Limon"};
        double[] fiyatArr = {2.10, 3.20, 1.50, 2.30, 3.10
                , 1.20, 1.90, 6.10, 4.30, 2.70, 0.50};
        PojoClass.urunListle(manavUrunler,manavFiyat,urunlerArr,fiyatArr);
        List<String> sepet = Secimler.sepet;
        if (Secimler.secim == 1){
            urunSecim = PojoClass.getUrunSecim(manavUrunler,manavFiyat);
            if (urunSecim > 0 && urunSecim<=manavUrunler.size()){
                PojoClass.sepet(manavUrunler,manavFiyat,sepet,urunSecim);
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
                PojoClass.geri(manavUrunler,urunSecim);
            }
        }
    }
}