package proje1_manav;

import proje1_manav.Odeme;
import proje1_manav.PojoClass;
import proje1_manav.Secimler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static proje1_manav.Manav.urunSecim;

public class Market {
    static Scanner scan = new Scanner(System.in);

    public static void urunler() {
        List<String> marketUrunler = new ArrayList<>();
        List<Double> marketFiyat = new ArrayList<>();
        String[] urunlerArr = {"İkram", "Cips", "Tutku"
                , "Nutella", "Hobby", "Albeni", "BenimO", "Çekirde"
                , "Dondurm", "Jelibon", "Tadelle"};
        double[] fiyatArr = {4.20, 9.10, 5.50, 25.80, 3.10
                , 3.20, 3.80, 6.00, 12.50, 5.70, 8.40};
        PojoClass.urunListle(marketUrunler,marketFiyat,urunlerArr,fiyatArr);
        List<String> sepet = Secimler.sepet;
        if (Secimler.secim == 3){
            urunSecim = PojoClass.getUrunSecim(marketUrunler,marketFiyat);
            if (urunSecim > 0 && urunSecim<=marketUrunler.size()){
                PojoClass.sepet(marketUrunler,marketFiyat,sepet,urunSecim);
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
                PojoClass.geri(marketUrunler,urunSecim);
            }
        }
    }
}