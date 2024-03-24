package com.unalberk.Model;

public class Memur extends Personel {
    private static final double MIN_SAATLIK_UCRET = 500;
    private final double saatlikUcret;
    public Memur(String ad, String soyad, int calismaSaati) {
        super(ad, soyad, calismaSaati);
        this.saatlikUcret = MIN_SAATLIK_UCRET;

    }
    @Override
    public double maasHesapla() {
        double normalMaas = 0;
        if (getCalismaSaati() > 180) {
            normalMaas = 180 * MIN_SAATLIK_UCRET;
            double ekMesaiMaasi = (getCalismaSaati() - 180) * MIN_SAATLIK_UCRET * 1.5;
            return normalMaas + ekMesaiMaasi;
        } else {
            return getCalismaSaati() * MIN_SAATLIK_UCRET;
        }
    }
}
