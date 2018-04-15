package uinbdg.skripsi.kopertais.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skripsi.kopertais.Adapter.PerjalananDinasAdapter;
import uinbdg.skripsi.kopertais.Adapter.RekomendasiAdapter;
import uinbdg.skripsi.kopertais.Helper.ApiClient;
import uinbdg.skripsi.kopertais.Helper.KopertaisApi;
import uinbdg.skripsi.kopertais.Model.DataItemRekomendasi;
import uinbdg.skripsi.kopertais.Model.RekomendasiResponse;
import uinbdg.skripsi.kopertais.R;

public class MasterRekomendasiActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;


    RekomendasiAdapter adapter;

    List<DataItemRekomendasi> list;
    @BindView(R.id.btn_add_rekomendasi)
    FloatingActionButton btnAddRekomendasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_rekomendasi);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        getAllRekomendasi();

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllRekomendasi();
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

    void getAllRekomendasi() {
        refresh.setRefreshing(true);
        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi service = retrofit.create(KopertaisApi.class);
        service.getAllRekomendasi().enqueue(new Callback<RekomendasiResponse>() {
            @Override
            public void onResponse(Call<RekomendasiResponse> call, Response<RekomendasiResponse> response) {
                refresh.setRefreshing(false);
                if (response.isSuccessful()) {
                    list.clear();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body().getData().get(i));
                    }
                    adapter = new RekomendasiAdapter(MasterRekomendasiActivity.this, list);
                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickListener(new RekomendasiAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Intent i = new Intent(MasterRekomendasiActivity.this, InputPerjalananDinasActvity.class);
                            i.putExtra("tujuan", list.get(position).getUniversitas().getNama());
                            i.putExtra("pegawai", list.get(position).getPegawai().getNama());
                            i.putExtra("berangkat", list.get(position).getTanggalBerangkat());
                            i.putExtra("kembali", list.get(position).getTanggalKembali());
                            i.putExtra("lama", list.get(position).getLamaPejalanan());
                            startActivity(i);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<RekomendasiResponse> call, Throwable t) {
                refresh.setRefreshing(false);
            }
        });
    }

    @OnClick(R.id.btn_add_rekomendasi)
    public void onViewClicked() {
        startActivity(new Intent(this, TambahRekomendasiActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllRekomendasi();
    }
}
