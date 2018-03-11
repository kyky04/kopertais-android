package uinbdg.skripsi.kopertais.Activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skripsi.kopertais.Model.DataItem;
import uinbdg.skripsi.kopertais.R;

public class DetailUnivActivity extends Activity {
    DataItem univ;
    @BindView(R.id.et_univ)
    EditText etUniv;
    @BindView(R.id.et_kota)
    EditText etKota;
    @BindView(R.id.et_alamat)
    EditText etAlamat;
    @BindView(R.id.et_penginapan)
    AppCompatEditText etPenginapan;
    @BindView(R.id.et_konsumsi)
    AppCompatEditText etKonsumsi;
    @BindView(R.id.et_jarak)
    AppCompatEditText etJarak;
    @BindView(R.id.btn_lihat_rute)
    ImageButton btnLihatRute;
    @BindView(R.id.ajukan)
    Button ajukan;
    private double myLong,myLat;

    DatePickerDialog datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_perjalanan);
        ButterKnife.bind(this);

        myLong = getIntent().getDoubleExtra("long", 0);
        myLat = getIntent().getDoubleExtra("lat", 0);

        Bundle data = getIntent().getExtras();
        univ = (DataItem) data.getParcelable("univ");

        etUniv.setText(univ.getNama());
        etAlamat.setText(univ.getAlamat());
        etKota.setText(univ.getKota().getNama());
        etPenginapan.setText("Rp. " + univ.getBiayaInap());
        etJarak.setText(univ.getBiayaInap() + " KM");
        etKonsumsi.setText("Rp. " + univ.getBiayaKonsumsi());



    }

    @OnClick({R.id.btn_lihat_rute, R.id.ajukan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_lihat_rute:
                Intent i = new Intent(this, MapsActivity.class);
                i.putExtra("lat",myLat);
                i.putExtra("long",myLong);
                startActivity(i);
                break;
            case R.id.ajukan:
                Intent intent = new Intent(this, PerjalananActivity.class);
                intent.putExtra("univ", univ);

                startActivity(intent);
                break;
        }
    }
}
