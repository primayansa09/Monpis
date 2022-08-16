package com.example.monpiss.KC;

import java.util.ArrayList;

public class DataKC {
    private static String[] nameKC = {
            "E0230 Cut Mutiah",
            "E0345 Gunung Sahari",
            "E0332 Hayam Wuruk",
            "E0122 Jatinegara",
            "E0419 Kalimalang",
            "E0320 Kelapa Gading",
            "E0416 Artha Gading",
            "E0356 Kemayoran",
            "E0335 Kramat",
            "E0261 KREKOT",
            "E0346 Mangga Dua",
            "E0340 Otista",
            "E0415 Pluit",
            "E0378 Rasuna Said",
            "E0386 Rawamangun",
            "E0361 SENEN",
            "E0376 SUDIRMAN 1",
            "E0018 Tanah Abang",
            "E0186 TANJUNG PRIOK",
            "E0329 Veteran",
            "E0434 Cempaka Mas",
            "E0441 Sunter",
            "E0439 Gading Boulevard",
            "E0440 Pantai Indah Kapuk"

    };

    public static ArrayList<KC> getListData(){
        ArrayList<KC> list =new ArrayList<>();
        for (int i = 0; i < nameKC.length; i++){
            KC kc = new KC();
            kc.setKCname(nameKC[i]);
            list.add(kc);
        }
        return list;
    }

}
