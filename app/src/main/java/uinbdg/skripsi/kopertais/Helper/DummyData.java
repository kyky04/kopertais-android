package uinbdg.skripsi.kopertais.Helper;

import java.util.ArrayList;
import java.util.List;

import uinbdg.skripsi.kopertais.Model.Dosen;
import uinbdg.skripsi.kopertais.Model.Pegawai;

/**
 * Created by Comp on 2/11/2018.
 */

public class DummyData {
    public static List<Dosen> listDosen() {
        List<Dosen> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Dosen("Rizki", "42342342", "32131231"));
        }
        return list;
    }

//    public static List<Pegawai> listMahawasiswa() {
//        List<Pegawai> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            list.add(new Pegawai("Rizki", "42342342", "Infromatika", "Bandung"));
//        }
//        return list;
//    }
}
