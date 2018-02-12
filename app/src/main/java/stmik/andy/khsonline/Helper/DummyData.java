package stmik.andy.khsonline.Helper;

import java.util.ArrayList;
import java.util.List;

import stmik.andy.khsonline.Model.Dosen;
import stmik.andy.khsonline.Model.Mahasiswa;

/**
 * Created by Comp on 2/11/2018.
 */

public class DummyData {
    public static List<Dosen> listDosen(){
        List<Dosen> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Dosen("Rizki","42342342","32131231"));
        }
        return list;
    } public static List<Mahasiswa> listMahawasiswa(){
        List<Mahasiswa> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Mahasiswa("Rizki","42342342","Infromatika","Bandung"));
        }
        return list;
    }
}
