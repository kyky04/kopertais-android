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
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skripsi.kopertais.Adapter.MahawasiswaAdapter;
import uinbdg.skripsi.kopertais.Adapter.UniversitaAdapter;
import uinbdg.skripsi.kopertais.Helper.ApiClient;
import uinbdg.skripsi.kopertais.Helper.DummyData;
import uinbdg.skripsi.kopertais.Helper.KopertaisApi;
import uinbdg.skripsi.kopertais.Model.DataItem;
import uinbdg.skripsi.kopertais.Model.UniversitasResponse;
import uinbdg.skripsi.kopertais.R;

public class MasterUnivActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;


    UniversitaAdapter adapter;

    List<DataItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_universita);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        getAllUni();

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

    void getAllUni() {
        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi service = retrofit.create(KopertaisApi.class);
        service.getAllUniv().enqueue(new Callback<UniversitasResponse>() {
            @Override
            public void onResponse(Call<UniversitasResponse> call, Response<UniversitasResponse> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body().getData().get(i));
                    }
                    adapter = new UniversitaAdapter(MasterUnivActivity.this, list);
                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickListener(new UniversitaAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, String obj, int position) {
                            Intent i = new Intent(MasterUnivActivity.this, DetailUnivActivity.class);
                            i.putExtra("univ", list.get(position));
                            i.putExtra("long",list.get(position).getLongitude());
                            i.putExtra("lat",list.get(position).getLatidude());
                            startActivity(i);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<UniversitasResponse> call, Throwable t) {

            }
        });
    }
}
