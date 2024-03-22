package com.unalberk;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Kutuphane kutuphane = new Kutuphane();


        Kitap kitap1 = new KitapBilim("Bilim Kitabı 1", "Bilim Adamı 1");
        Kitap kitap2 = new KitapRoman("Roman Kitabı 1", "Yazar 1");
        Kitap kitap3 = new KitapTarih("Tarih Kitabı 1", "Tarihçi 1");


        kutuphane.kitapEkle(kitap1);
        kutuphane.kitapEkle(kitap2);
        kutuphane.kitapEkle(kitap3);


        Uye uye1 = new Uye("Üye 1");
        Uye uye2 = new Uye("Üye 2");


        kutuphane.uyeEkle(uye1);
        kutuphane.uyeEkle(uye2);


        kutuphane.katalogGoruntule();


        uye1.kitapOduncAl(kitap1);
        uye2.kitapOduncAl(kitap2);


        kutuphane.katalogGoruntule();


        uye1.oduncAlinanKitaplariGoruntule();
        uye2.oduncAlinanKitaplariGoruntule();
    }
}