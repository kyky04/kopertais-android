package uinbdg.skripsi.kopertais.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skripsi.kopertais.Adapter.PerjalananDinasAdapter;
import uinbdg.skripsi.kopertais.Helper.ApiClient;
import uinbdg.skripsi.kopertais.Helper.KopertaisApi;
import uinbdg.skripsi.kopertais.Model.DataItemPerjalananDinas;
import uinbdg.skripsi.kopertais.Model.PerjalananDinasResponse;
import uinbdg.skripsi.kopertais.R;

public class MasterPerjalananDinasActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;


    PerjalananDinasAdapter adapter;

    List<DataItemPerjalananDinas> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perjalanan_dinas);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        getAllPerjalananDinas();

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllPerjalananDinas();
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

    void getAllPerjalananDinas() {
        refresh.setRefreshing(true);
        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi service = retrofit.create(KopertaisApi.class);
        service.getAllPerjalananDinas().enqueue(new Callback<PerjalananDinasResponse>() {
            @Override
            public void onResponse(Call<PerjalananDinasResponse> call, Response<PerjalananDinasResponse> response) {
                refresh.setRefreshing(false);
                if (response.isSuccessful()) {
                    list.clear();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body().getData().get(i));
                    }
                    adapter = new PerjalananDinasAdapter(MasterPerjalananDinasActivity.this, list);
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<PerjalananDinasResponse> call, Throwable t) {
                refresh.setRefreshing(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllPerjalananDinas();
    }
}
