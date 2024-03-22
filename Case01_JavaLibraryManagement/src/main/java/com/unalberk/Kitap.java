package com.unalberk;

abstract class Kitap {
    String ad;
     String yazar;
     Durum durum;
    public Kitap(String ad, String yazar) {
        this.ad = ad;
        this.yazar = yazar;
        this.durum = Durum.MEVCUT;
    }
    public abstract String tur();

    public Durum getDurum() {
        return durum;
    }

    public void setDurum(Durum durum) {
        this.durum = durum;
    }
}

