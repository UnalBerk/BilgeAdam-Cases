package com.unalberk.Util;

import com.unalberk.Model.Personel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DosyaOku {
    public static void main(String[] args) {
        try {

            InputStream inputStream = DosyaOku.class.getClassLoader().getResourceAsStream("personel.json");

            if (inputStream != null) {

                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                String jsonString = jsonBuilder.toString();

                JSONParser parser = new JSONParser();
                JSONArray personelListesi = (JSONArray) parser.parse(jsonString);

                List<Personel> personeller = new ArrayList<>();

                Scanner scanner = new Scanner(System.in);

                for (Object obj : personelListesi) {
                    JSONObject personelJSON = (JSONObject) obj;
                    String ad = (String) personelJSON.get("name");
                    String soyad = (String) personelJSON.get("surname");

                    System.out.println("Lütfen " + ad + " " + soyad + " için çalışma saati giriniz:");
                    int calismaSaati = scanner.nextInt();

                    System.out.println("Lütfen " + ad + " " + soyad + " için mesai saatini giriniz:");
                    int mesaiSaati = scanner.nextInt();

                    double saatlikUcret = 500;
                    double mesaiUcreti = 0;
                    if (mesaiSaati > 0) {
                        mesaiUcreti = mesaiSaati * saatlikUcret * 1.5;
                    }

                    JSONObject bordro = new JSONObject();
                    bordro.put("bordro", LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM yyyy")));

                    JSONObject personelDetay = new JSONObject();
                    personelDetay.put("ismi", ad);
                    personelDetay.put("calismaSaati", calismaSaati);

                    JSONObject odemeDetaylari = new JSONObject();
                    double anaOdeme = calismaSaati * saatlikUcret;
                    double toplamOdeme = anaOdeme + mesaiUcreti;

                    odemeDetaylari.put("anaOdeme", "TL" + String.format("%.1f", anaOdeme));
                    odemeDetaylari.put("mesai", "TL" + String.format("%.1f", mesaiUcreti));
                    odemeDetaylari.put("toplamOdeme", "TL" + String.format("%.1f", toplamOdeme));
                    personelDetay.put("odemeDetaylari", odemeDetaylari);

                    bordro.put("personel", personelDetay);

                    String klasorAdi = ad + "_" + soyad + "_bordrolar";
                    File klasor = new File(klasorAdi);
                    klasor.mkdirs();

                    try (FileWriter file = new FileWriter(klasorAdi + "/" + ad + "_" + soyad + "_bordro.json")) {
                        file.write(bordro.toJSONString());
                        System.out.println("JSON dosyası başarıyla oluşturuldu: " + ad + "_" + soyad + "_bordro.json");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Personel personel = new Personel(ad, soyad, calismaSaati) {
                        @Override
                        public double maasHesapla() {

                            return calismaSaati * saatlikUcret;
                        }
                    };
                    personeller.add(personel);
                }
                MaasBordro maasBordro = new MaasBordro(personeller);
                maasBordro.maaslariHesapla();

            } else {
                System.err.println("Dosya bulunamadı!");
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
