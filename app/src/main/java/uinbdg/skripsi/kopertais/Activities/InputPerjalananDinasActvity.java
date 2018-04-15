package uinbdg.skripsi.kopertais.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skripsi.kopertais.CommonUtil;
import uinbdg.skripsi.kopertais.Helper.ApiClient;
import uinbdg.skripsi.kopertais.Helper.KopertaisApi;
import uinbdg.skripsi.kopertais.Model.DataItemPerjalananDinas;
import uinbdg.skripsi.kopertais.Model.PerjalananDinasResponse;
import uinbdg.skripsi.kopertais.R;

public class InputPerjalananDinasActvity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_nama_pegawai)
    AppCompatEditText tvNamaPegawai;
    @BindView(R.id.et_tanggal_berangkat)
    AppCompatEditText etTanggalBerangkat;
    @BindView(R.id.et_tgl_kembali)
    AppCompatEditText etTglKembali;
    @BindView(R.id.et_lama_perjalanan)
    AppCompatEditText etLamaPerjalanan;
    @BindView(R.id.et_tampat_berangkat)
    AppCompatEditText etTampatBerangkat;
    @BindView(R.id.et_tujuan)
    AppCompatEditText etTujuan;
    @BindView(R.id.et_maksud_perjalanan)
    AppCompatEditText etMaksudPerjalanan;
    @BindView(R.id.et_kendaraan_dinas)
    AppCompatEditText etKendaraanDinas;
    @BindView(R.id.et_status)
    AppCompatEditText etStatus;
    @BindView(R.id.ajukan)
    Button ajukan;

    String pegawai, tujuan, berangkat, kembali, lama;
    @BindView(R.id.et_jabatan)
    AppCompatEditText etJabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_perjalanan_dinas);
        ButterKnife.bind(this);

        pegawai = getIntent().getStringExtra("pegawai");
        tujuan = getIntent().getStringExtra("tujuan");
        berangkat = getIntent().getStringExtra("berangkat");
        kembali = getIntent().getStringExtra("kembali");
        lama = getIntent().getStringExtra("lama");

        tvNamaPegawai.setText(pegawai);
        etTujuan.setText(tujuan);
        etTanggalBerangkat.setText(berangkat);
        etTglKembali.setText(kembali);
        etLamaPerjalanan.setText(lama);
    }

    @OnClick(R.id.ajukan)
    public void onViewClicked() {
        postPerjalanan();
    }

    void postPerjalanan() {
        DataItemPerjalananDinas perjalananDinas = new DataItemPerjalananDinas();
        perjalananDinas.setNama(tvNamaPegawai.getText().toString());
        perjalananDinas.setTempatTujuan(etTujuan.getText().toString());
        perjalananDinas.setTanggalKeberangkatan(etTanggalBerangkat.getText().toString());
        perjalananDinas.setTanggalKembali(etTglKembali.getText().toString());
        perjalananDinas.setLamaPerjalanan(Integer.parseInt(etLamaPerjalanan.getText().toString()));
        perjalananDinas.setStatus(etStatus.getText().toString());
        perjalananDinas.setTempatBerangkat(etTampatBerangkat.getText().toString());
        perjalananDinas.setMaksudPerjalanan(etMaksudPerjalanan.getText().toString());
        perjalananDinas.setKendaraan(etKendaraanDinas.getText().toString());
        perjalananDinas.setPangkat("GOLONGAN I");
        perjalananDinas.setJabatan(etJabatan.getText().toString());

        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi api = retrofit.create(KopertaisApi.class);
        api.postPerjalananDinas(perjalananDinas).enqueue(new Callback<PerjalananDinasResponse>() {
            @Override
            public void onResponse(Call<PerjalananDinasResponse> call, Response<PerjalananDinasResponse> response) {
                CommonUtil.dialogSucces(InputPerjalananDinasActvity.this, "Data berhasil ditambahkan");
            }

            @Override
            public void onFailure(Call<PerjalananDinasResponse> call, Throwable t) {

            }
        });
    }
}
