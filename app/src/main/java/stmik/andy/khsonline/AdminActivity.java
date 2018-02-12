package stmik.andy.khsonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import stmik.andy.khsonline.Activities.MasterDosenActivity;
import stmik.andy.khsonline.Activities.MasterMahasiswaActivity;
import stmik.andy.khsonline.Model.Dosen;

public class AdminActivity extends AppCompatActivity {

    @BindView(R.id.btn_admin)
    RelativeLayout btnAdmin;
    @BindView(R.id.btn_mahasiswa)
    RelativeLayout btnMahasiswa;
    @BindView(R.id.btn_kelas)
    RelativeLayout btnKelas;
    @BindView(R.id.btn_kuliah)
    RelativeLayout btnKuliah;
    @BindView(R.id.btn_dosen)
    RelativeLayout btnDosen;
    @BindView(R.id.btn_tentang)
    RelativeLayout btnTentang;
    @BindView(R.id.btn_bantuan)
    RelativeLayout btnBantuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_admin, R.id.btn_mahasiswa, R.id.btn_kelas, R.id.btn_kuliah, R.id.btn_dosen, R.id.btn_tentang, R.id.btn_bantuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_admin:
                break;
            case R.id.btn_mahasiswa:
                startActivity(new Intent(this, MasterMahasiswaActivity.class));
                break;
            case R.id.btn_kelas:
                break;
            case R.id.btn_kuliah:
                break;
            case R.id.btn_dosen:
                startActivity(new Intent(this, MasterDosenActivity.class));
                break;
            case R.id.btn_tentang:
                break;
            case R.id.btn_bantuan:
                break;
        }
    }
}
