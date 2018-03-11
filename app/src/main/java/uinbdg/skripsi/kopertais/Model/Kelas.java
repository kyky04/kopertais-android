package uinbdg.skripsi.kopertais.Model;

/**
 * Created by Comp on 2/11/2018.
 */

public class Kelas {
    String namaKelas;
    String dosenId;
    String semester;

    public Kelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getDosenId() {
        return dosenId;
    }

    public void setDosenId(String dosenId) {
        this.dosenId = dosenId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
