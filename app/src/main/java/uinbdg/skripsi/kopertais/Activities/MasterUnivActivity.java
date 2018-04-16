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
import android.view.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skripsi.kopertais.Adapter.UniversitaAdapter;
import uinbdg.skripsi.kopertais.Helper.ApiClient;
import uinbdg.skripsi.kopertais.Helper.KopertaisApi;
import uinbdg.skripsi.kopertais.Model.DataItemUniversitas;
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

    List<DataItemUniversitas> list;

    private int distances[];

    private Queue<Integer> queue;

    private Set<Integer> settled;

    private int number_of_nodes;

    private int adjacencyMatrix[][];


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
                            i.putExtra("univ", (Parcelable) list.get(position));
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

    public void dijkstraQueue(int number_of_nodes)

    {

        this.number_of_nodes = number_of_nodes;

        distances = new int[number_of_nodes + 1];

        settled = new HashSet<Integer>();

        queue = new LinkedList<Integer>();

        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];

    }



    public void dijkstra_algorithm(int adjacency_matrix[][], int source)

    {

        int evaluationNode;

        for (int i = 1; i <= number_of_nodes; i++)

            for (int j = 1; j <= number_of_nodes; j++)

                adjacencyMatrix[i][j] = adjacency_matrix[i][j];



        for (int i = 1; i <= number_of_nodes; i++)

        {

            distances[i] = Integer.MAX_VALUE;

        }



        queue.add(source);

        distances[source] = 0;



        while (!queue.isEmpty())

        {

            evaluationNode = getNodeWithMinimumDistanceFromQueue();

            settled.add(evaluationNode);

            evaluateNeighbours(evaluationNode);

        }

    }



    private int getNodeWithMinimumDistanceFromQueue()

    {

        int min ;

        int node = 0;

        Iterator<Integer> iterator = queue.iterator();

        node = iterator.next();

        min = distances[node];



        for (int i = 1; i <= distances.length; i++)

        {

            if (queue.contains(i))

            {

                if (distances[i] <= min)

                {

                    min = distances[i];

                    node = i;

                }

            }

        }

        queue.remove(node);

        return node;

    }



    private void evaluateNeighbours(int evaluationNode)

    {

        int edgeDistance = -1;

        int newDistance = -1;



        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)

        {

            if (!settled.contains(destinationNode))

            {

                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)

                {

                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];

                    newDistance = distances[evaluationNode] + edgeDistance;

                    if (newDistance < distances[destinationNode])

                    {

                        distances[destinationNode] = newDistance;

                    }

                    queue.add(destinationNode);

                }

            }

        }

    }
}
