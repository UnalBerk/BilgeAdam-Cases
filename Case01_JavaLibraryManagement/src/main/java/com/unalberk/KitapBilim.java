package com.unalberk;

public class KitapBilim extends Kitap{
    public KitapBilim(String ad, String yazar) {
        super(ad, yazar);
    }
    @Override
    public String tur() {
        return "Bilim";
    }
}
