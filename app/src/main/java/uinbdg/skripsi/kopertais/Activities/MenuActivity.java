package uinbdg.skripsi.kopertais.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skripsi.kopertais.Activities.baru.MasterPerjalananDinasActivity;
import uinbdg.skripsi.kopertais.Activities.baru.MasterRekomendasiActivity;
import uinbdg.skripsi.kopertais.MainActivity;
import uinbdg.skripsi.kopertais.R;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_rekomendasi)
    RelativeLayout btnRekomendasi;
    @BindView(R.id.btn_estimasi)
    RelativeLayout btnEstimasi;
    @BindView(R.id.btn_perjalanan)
    RelativeLayout btnPerjalanan;
    @BindView(R.id.btn_exit)
    RelativeLayout btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_rekomendasi, R.id.btn_estimasi, R.id.btn_perjalanan, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rekomendasi:
                startActivity(new Intent(this, MasterRekomendasiActivity.class));
                break;
            case R.id.btn_estimasi:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_perjalanan:
                startActivity(new Intent(this, MasterPerjalananDinasActivity.class));
                break;
            case R.id.btn_exit:
                break;
        }
    }
}
