package uinbdg.skripsi.kopertais.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
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
import uinbdg.skripsi.kopertais.Adapter.PerjalananAdapter;
import uinbdg.skripsi.kopertais.Helper.ApiClient;
import uinbdg.skripsi.kopertais.Helper.KopertaisApi;
import uinbdg.skripsi.kopertais.Helper.Session;
import uinbdg.skripsi.kopertais.Model.DataItemPerjalanan;
import uinbdg.skripsi.kopertais.Model.PerjalananResponse;
import uinbdg.skripsi.kopertais.R;

public class MasterPerjalananActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    Session session;


    PerjalananAdapter adapter;

    List<DataItemPerjalanan> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_perjalanan);
        ButterKnife.bind(this);
        session = new Session(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        getAllPerjalanan();

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

    void getAllPerjalanan() {
        Retrofit retrofit = ApiClient.newInstance();
        KopertaisApi service = retrofit.create(KopertaisApi.class);
        service.getAllPerjalanan().enqueue(new Callback<PerjalananResponse>() {
            @Override
            public void onResponse(Call<PerjalananResponse> call, Response<PerjalananResponse> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        list.add(response.body().getData().get(i));
                    }
                    adapter = new PerjalananAdapter(MasterPerjalananActivity.this, list);
                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickListener(new PerjalananAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            if(session.getEmail().equals("keuangan@gmail.com") || session.getEmail().equals("pimpinan@gmail.com")){
                            setujui(list.get(position));
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<PerjalananResponse> call, Throwable t) {

            }
        });
    }

    void setujui(DataItemPerjalanan itemPerjalanans){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Setujui Perjalanan ? "+ itemPerjalanans.getNama() + " ke "+itemPerjalanans.getUniversitas().getNama() +" Pada Tanggal " + itemPerjalanans.getWaktu());
        builder.setPositiveButton("Setuju", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MasterPerjalananActivity.this, "Perjalanan di setujui", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Tidak Setuju", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MasterPerjalananActivity.this, "Perjalanan Tidak di setujui", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
