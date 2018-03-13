package uinbdg.skripsi.kopertais;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skripsi.kopertais.Activities.MasterPerjalananActivity;
import uinbdg.skripsi.kopertais.Activities.MasterUnivActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_univ)
    RelativeLayout btnUniv;
    @BindView(R.id.btn_perjalanan)
    RelativeLayout btnPerjalanan;
    @BindView(R.id.btn_exit)
    RelativeLayout btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_univ, R.id.btn_perjalanan, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_univ:
                startActivity(new Intent(this, MasterUnivActivity.class));
                break;
            case R.id.btn_perjalanan:
                startActivity(new Intent(this, MasterPerjalananActivity.class));
                break;
            case R.id.btn_exit:
                break;
        }
    }
}
