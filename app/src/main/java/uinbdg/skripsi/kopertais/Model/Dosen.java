package uinbdg.skripsi.kopertais.Model;

/**
 * Created by Comp on 2/11/2018.
 */

public class Dosen {
    String nama;
    String no_hp;
    String nip;

    public Dosen() {
    }

    public Dosen(String nama, String no_hp, String nip) {
        this.nama = nama;
        this.no_hp = no_hp;
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
