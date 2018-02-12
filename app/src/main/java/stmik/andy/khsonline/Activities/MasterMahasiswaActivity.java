package stmik.andy.khsonline.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import stmik.andy.khsonline.Adapter.DosenAdapter;
import stmik.andy.khsonline.Adapter.MahawasiswaAdapter;
import stmik.andy.khsonline.Helper.DummyData;
import stmik.andy.khsonline.R;

public class MasterMahasiswaActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.btn_add)
    FloatingActionButton btnAdd;

    MahawasiswaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_mahasiswa);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MahawasiswaAdapter(this, DummyData.listMahawasiswa());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MahawasiswaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String obj, int position) {
                Toast.makeText(MasterMahasiswaActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
