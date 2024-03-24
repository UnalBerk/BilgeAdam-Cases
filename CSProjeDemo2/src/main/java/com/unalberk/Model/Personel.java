package com.unalberk.Model;

public abstract class Personel {
    private String ad;
    private String soyad;
    private int calismaSaati;

    public Personel(String ad, String soyad, int calismaSaati) {
        this.ad = ad;
        this.soyad = soyad;
        this.calismaSaati = calismaSaati;
    }
    public abstract double maasHesapla();

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getCalismaSaati() {
        return calismaSaati;
    }
    }


