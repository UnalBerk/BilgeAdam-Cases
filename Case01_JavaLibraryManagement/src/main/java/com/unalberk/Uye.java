package com.unalberk;

import java.util.ArrayList;
import java.util.List;

public class Uye implements IUye{


    String ad;
    private List<Kitap> oduncAlinanKitaplar;

    public Uye(String ad) {
        this.ad = ad;
        this.oduncAlinanKitaplar = new ArrayList<>();
    }
        @Override
        public void kitapOduncAl(Kitap kitap) {
            if (kitap.getDurum() == Durum.MEVCUT) {
                kitap.setDurum(Durum.ODUNC_ALINMIS);
                oduncAlinanKitaplar.add(kitap);
                System.out.println(ad + " adlı üye, " + kitap.ad + " adlı kitabı ödünç aldı.");
            } else {
                System.out.println("Kitap mevcut değil veya başka bir üye tarafından ödünç alınmış.");
            }
        }

        @Override
        public void kitapIadeEt(Kitap kitap) {
            if (oduncAlinanKitaplar.contains(kitap)) {
                kitap.setDurum(Durum.MEVCUT);
                oduncAlinanKitaplar.remove(kitap);
                System.out.println(ad + " adlı üye, " + kitap.ad + " adlı kitabı iade etti.");
            } else {
                System.out.println("Bu kitabı zaten ödünç almamışsınız.");
            }
        }

        @Override
        public void oduncAlinanKitaplariGoruntule() {
            if (oduncAlinanKitaplar.isEmpty()) {
                System.out.println("Ödünç alınmış kitap bulunmamaktadır.");
            } else {
                System.out.println(ad + " adlı üyenin ödünç aldığı kitaplar:");
                for (Kitap kitap : oduncAlinanKitaplar) {
                    System.out.println(kitap.ad + " - " + kitap.tur());
                }
            }
        }
    }

