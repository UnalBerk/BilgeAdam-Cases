package com.unalberk.Util;

import com.unalberk.Model.Personel;
import java.util.List;

public class MaasBordro {
    private List<Personel> personelListesi;
    public MaasBordro(List<Personel> personelListesi) {
        this.personelListesi = personelListesi;
    }
    public void maaslariHesapla() {
        for (Personel personel : personelListesi) {
            double normalMaas = personel.maasHesapla();
        }
    }
}

