package com.unalberk.Model;

public class Yonetici extends Personel {
    private static final double MIN_SAATLIK_UCRET = 500;
    private double saatlikUcret = 0;

    private double bonus;

    public Yonetici(String ad, String soyad, int calismaSaati, double bonus) {
        super(ad, soyad, calismaSaati);
        this.bonus = bonus;
        this.saatlikUcret =MIN_SAATLIK_UCRET;
    }


    @Override
    public double maasHesapla() {
        double maas = getCalismaSaati() * saatlikUcret;
        if (saatlikUcret < 500) {
            saatlikUcret = 500;
        }
        return maas + bonus;
    }
}





