package com.unalberk;

public class KitapTarih extends Kitap{
    public KitapTarih(String ad, String yazar) {
        super(ad, yazar);
    }

    @Override
    public String tur() {
        return "Tarih";
    }
}
