package proje1_manav;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Odeme {
    public static void odeme() {
        Scanner scan = new Scanner(System.in);
        if (Secimler.sepet.isEmpty()) {
            System.out.println("Alisveris yapmadiniz !!!");
            Secimler.secim();
        } else {
            System.out.println("Nasil odemek istersiniz ?\n" + "1 Kapida nakit\n" + "2 Kredi karti");
            int odeme = scan.nextInt();
            System.out.println("Sepet = " + Secimler.sepet);
            System.out.println("Toplam tutar = " + Secimler.toplamFiyat);
            if (odeme == 1) {
                System.out.println("Siparisiniz alinmistir.\nTekrar bekleriz");
            } else if (odeme == 2) {
                scan.nextLine();
                System.out.println("Kartta yazan isim ve soyismi giriniz");
                String isim = scan.nextLine();
                for (int i = 0; i < 1; i++) {
                    System.out.println("Lutfen kart numaranizi giriniz");
                    String kartNo = scan.next();
                    if (kartNo.length() == 16) {
                        for (int j = 0; j < 1; j++) {
                            System.out.println("Lutfen kartinizin son kullanma tarihini giriniz. Ex:12-23");
                            String skt = scan.next();
                            YearMonth bugun = YearMonth.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yy");
                            YearMonth girilen = YearMonth.parse(skt, formatter);
                            int bugunYil = bugun.getYear();
                            int bugunAy = bugun.getMonthValue();
                            int girilenYil = girilen.getYear();
                            int girilenAy = girilen.getMonthValue();
                            if (bugunYil <= girilenYil && bugunAy < girilenAy) {
                                for (int k = 0; k < 1; k++) {
                                    System.out.println("Lutfen kartin arka yuzundeki cvc kodunu giriniz");
                                    String cvc = scan.next();
                                    if (cvc.length() == 3){
                                        System.out.println("Siparisiniz alindi. Tekrar bekleriz");
                                    } else {
                                        System.out.println("CvC kodunuz hatali tekrar deneyiniz");
                                        k--;
                                    }
                                }
                            } else {
                                System.out.println("Kartinizin suresi dolmus veya hatali girdiniz");
                                j--;
                            }
                        }
                    } else {
                        System.out.println("Kart numaraniz hatali");
                    }
                }

            }
        }
    }
}