package com.unalberk;

public class KitapRoman extends Kitap{
    public KitapRoman(String ad, String yazar) {
        super(ad, yazar);
    }

    @Override
    public String tur() {
        return "Roman";
    }
}
