package uinbdg.skripsi.kopertais;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skripsi.kopertais.Activities.MasterPerjalananActivity;
import uinbdg.skripsi.kopertais.Activities.MasterUnivActivity;
import uinbdg.skripsi.kopertais.Helper.Session;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_univ)
    RelativeLayout btnUniv;
    @BindView(R.id.btn_perjalanan)
    RelativeLayout btnPerjalanan;
    @BindView(R.id.btn_exit)
    RelativeLayout btnExit;

    Session session;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        session = new Session(this);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                session.logoutUser();
                break;
        }
        return super.onOptionsItemSelected(item);
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
