package com.unalberk;

import java.util.ArrayList;
import java.util.List;

public class Kutuphane {
    private List<Kitap> kitaplar;
    private List<Uye> uyeler;

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
        this.uyeler = new ArrayList<>();
    }

    public void kitapEkle(Kitap kitap) {
        kitaplar.add(kitap);
    }

    public void uyeEkle(Uye uye) {
        uyeler.add(uye);
    }

    public void katalogGoruntule() {
        System.out.println("Kütüphane Kataloğu:");
        for (Kitap kitap : kitaplar) {
            System.out.println(kitap.ad + " - " + kitap.tur() + " - Durum: " + kitap.getDurum());
        }
    }

    public void uyeleriGoruntule() {
        System.out.println("Kütüphane Üyeleri:");
        for (Uye uye : uyeler) {
            System.out.println(uye.ad);
        }
    }
}
