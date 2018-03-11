package uinbdg.skripsi.kopertais.Activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skripsi.kopertais.Model.DataItem;
import uinbdg.skripsi.kopertais.R;

public class PerjalananActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_univ)
    AppCompatEditText etUniv;
    @BindView(R.id.et_pegawai_dinas)
    AppCompatEditText etPegawaiDinas;
    @BindView(R.id.et_penginapan)
    AppCompatEditText etPenginapan;
    @BindView(R.id.et_lama)
    AppCompatEditText etLama;
    @BindView(R.id.ajukan)
    Button ajukan;
    private DataItem univ;

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_perjalanan);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle data = getIntent().getExtras();
        univ = (DataItem) data.getParcelable("univ");

        etUniv.setText(univ.getNama());

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(PerjalananActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(i, i1, i2);
                etPenginapan.setText(dateFormat.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        etUniv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.ajukan)
    public void onViewClicked() {
        dialogAjukan();
    }


    void dialogAjukan() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_kalkulasi, null);
        dialogBuilder.setView(dialogView);

        final EditText edtHari = (EditText) dialogView.findViewById(R.id.et_lama_hari);
        final EditText edtInap = (EditText) dialogView.findViewById(R.id.et_biaya_inap);
        final EditText edtKonsumsi = (EditText) dialogView.findViewById(R.id.et_konsumsi);
        final EditText edtBensin = (EditText) dialogView.findViewById(R.id.et_bensin);
        final EditText edtTotal = (EditText) dialogView.findViewById(R.id.et_total);


        edtHari.setText(etLama.getText().toString() +" Hari");
        edtInap.setText(String.valueOf("Rp. " + univ.getBiayaInap()));
        edtKonsumsi.setText(String.valueOf("Rp. " + univ.getBiayaKonsumsi()));

        int hargaBensin = univ.getJarak() / 8 * 7600;
        edtBensin.setText("Rp. " + String.valueOf(hargaBensin));

        int total = univ.getBiayaInap() + univ.getBiayaKonsumsi() + hargaBensin;
        total = total * Integer.parseInt(etLama.getText().toString());

        edtTotal.setText(String.valueOf("Rp. " + total));


        dialogBuilder.setTitle("PERJALANAN");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                finish();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
