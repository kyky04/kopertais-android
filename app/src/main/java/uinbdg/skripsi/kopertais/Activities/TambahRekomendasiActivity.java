package uinbdg.skripsi.kopertais.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

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
import uinbdg.skripsi.kopertais.Model.DataItemPegawai;
import uinbdg.skripsi.kopertais.Model.DataItemUniversitas;
import uinbdg.skripsi.kopertais.Model.PegawaiResponse;
import uinbdg.skripsi.kopertais.Model.PerjalananResponse;
import uinbdg.skripsi.kopertais.Model.RekomendasiRequest;
import uinbdg.skripsi.kopertais.Model.RekomendasiResponse;
import uinbdg.skripsi.kopertais.Model.UniversitasResponse;
import uinbdg.skripsi.kopertais.R;

public class TambahRekomendasiActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.sp_pegawai)
    Spinner spPegawai;
    @BindView(R.id.sp_tujuan)
    Spinner spTujuan;
    @BindView(R.id.et_tanggal_berangkat)
    AppCompatEditText etTanggalBerangkat;
    @BindView(R.id.et_tgl_kembali)
    AppCompatEditText etTglKembali;
    @BindView(R.id.et_lama_perjalanan)
    AppCompatEditText etLamaPerjalanan;
    @BindView(R.id.ajukan)
    Button ajukan;

    List<String> listUniv;
    List<String> listPegawai;
    List<DataItemUniversitas> itemUniversitasList;
    List<DataItemPegawai> itemPagawaiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_rekomendasi);
        ButterKnife.bind(this);

        listUniv = new ArrayList<>();
        itemUniversitasList = new ArrayList<>();
        listPegawai = new ArrayList<>();
        itemPagawaiList = new ArrayList<>();

        getAllUni();
        getAllPegawai();
    }

    @OnClick({R.id.et_tanggal_berangkat, R.id.et_tgl_kembali, R.id.et_lama_perjalanan, R.id.ajukan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_tanggal_berangkat:
                CommonUtil.dialogTanggal(this, etTanggalBerangkat);
                break;
            case R.id.et_tgl_kembali:
                CommonUtil.dialogTanggal(this, etTglKembali);
                break;
            case R.id.et_lama_perjalanan:
                break;
            case R.id.ajukan:
                postPerjalanan();
                break;
        }
    }

    void getAllUni() {
        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi service = retrofit.create(KopertaisApi.class);
        service.getAllUniv().enqueue(new Callback<UniversitasResponse>() {
            @Override
            public void onResponse(Call<UniversitasResponse> call, Response<UniversitasResponse> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        listUniv.add(response.body().getData().get(i).getNama());
                        itemUniversitasList.add(response.body().getData().get(i));
                    }

                    ArrayAdapter adapter = new ArrayAdapter(TambahRekomendasiActivity.this, android.R.layout.simple_list_item_1,listUniv);
                    spTujuan.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<UniversitasResponse> call, Throwable t) {

            }
        });
    }

    void getAllPegawai() {
        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi service = retrofit.create(KopertaisApi.class);
        service.getAllPegawai().enqueue(new Callback<PegawaiResponse>() {
            @Override
            public void onResponse(Call<PegawaiResponse> call, Response<PegawaiResponse> response) {
                for (int i = 0; i < response.body().getData().size(); i++) {
                    listPegawai.add(response.body().getData().get(i).getNama());
                    itemPagawaiList.add(response.body().getData().get(i));
                }

                ArrayAdapter adapter = new ArrayAdapter(TambahRekomendasiActivity.this, android.R.layout.simple_list_item_1,listPegawai);
                spPegawai.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PegawaiResponse> call, Throwable t) {

            }
        });
    }

    void postPerjalanan() {
        RekomendasiRequest rekomendasiRequest = new RekomendasiRequest();
        rekomendasiRequest.setIdUser(itemPagawaiList.get(spPegawai.getSelectedItemPosition()).getId());
        rekomendasiRequest.setIdUniv(itemUniversitasList.get(spTujuan.getSelectedItemPosition()).getId());
        rekomendasiRequest.setLamaPejalanan(Integer.parseInt(etLamaPerjalanan.getText().toString()));
        rekomendasiRequest.setTanggalKembali(etTglKembali.getText().toString());
        rekomendasiRequest.setTanggalBerangkat(etTanggalBerangkat.getText().toString());

        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi api = retrofit.create(KopertaisApi.class);
        api.postRekomendasi(rekomendasiRequest).enqueue(new Callback<RekomendasiResponse>() {
            @Override
            public void onResponse(Call<RekomendasiResponse> call, Response<RekomendasiResponse> response) {
                if(response.code() == 200){
                    CommonUtil.dialogSucces(TambahRekomendasiActivity.this,"Data berhasil ditambahkan");
                }
            }

            @Override
            public void onFailure(Call<RekomendasiResponse> call, Throwable t) {

            }
        });
    }
}
