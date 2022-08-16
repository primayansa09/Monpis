package com.example.monpiss.KCP;

import java.util.ArrayList;

public class DataKCP {
    private static String[] KCPname = {
            "E1121 Menteng",
            "E0502 Cikini",
            "E1179 Pangeran Jayakarta",
            "E0526 Glodok",
            "E2004 Gajah Maja",
            "E2038 Lokasari Plaza",
            "E2039 Mangga Besar",
            "E0653 Jembatan Lima",
            "E1117 Klender",
            "E1206 Meester",
            "E0528 Pondok Kelapa",
            "E0652 Pangkalan Jati",
            "E1187 Radin Inten",
            "E1169 Jatibening",
            "E1123 Pramuka",
            "E1125 Manggarai",
            "E1148 BPKP",
            "E1183 Karang Anyar",
            "E2080 Pasar Baru",
            "E1196 Harco Mangga Dua",
            "E2102 Ps. Pagi Mangga Dua",
            "E0541 Muara Karang",
            "E2234 CDB Pluit",
            "E1171 Teluk Gong",
            "E2013 Kuningan Episentrum",
            "E2046 KCP Hybrid Kota Kasablanka",
            "E1194 Thamrin City",
            "E1195 Bendungan Hilir",
            "E0504 KCP Abdul Muis",
            "E0532 KCP Ps Tanah Abang",
            "E2006 Sarinah",
            "E2249 Blok B Pusat Grosir Tanah Abang",
            "E0433 T-Plaza Penjernihan",
            "E0535 KCP ADPEL",
            "E0507 Departemen Keuangan",
            "E0596 Lemhannas",
            "E0558 Pertamina",
            "E2020 Meneg BUMN",
            "E2079 Taspen",
            "E0522 Cempaka Putih Raya",
            "E0530 Sunan Giri",
            "E1192 Rawasari",
            "E2106 Pulo Gadung Trade Center",
            "E1815 Green Pramuka",
            "E0506 RSPAD",
            "E1115 Danau Sunter Utara",
            "E1188 Puri Mutiara",
            "E0540 Gading Elok",
            "E2022 Gading Boulevard Timur",
            "E1193 Cakung Tipar",
            "E0588 Penggilingan",
            "E1191 Kapuk Indah ",
            "E1767 City Park"

    };

    public static ArrayList<KCP> getListData(){
        ArrayList<KCP> list = new ArrayList<>();
        for (int i = 0; i < KCPname.length; i++){
            KCP kcp = new KCP();
            kcp.setNameKCP(KCPname[i]);
            list.add(kcp);
        }
        return list;
    }
}
