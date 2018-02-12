package stmik.andy.khsonline.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import stmik.andy.khsonline.Model.Mahasiswa;
import stmik.andy.khsonline.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class MahawasiswaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Mahasiswa> items = new ArrayList<>();
    private OnLoadMoreListener onLoadMoreListener;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, String obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public MahawasiswaAdapter(Context context, List<Mahasiswa> items) {
        this.items = items;
        ctx = context;
    }

    public MahawasiswaAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_mahasiswa)
        TextView tvNamaMahasiswa;
        @BindView(R.id.tv_nim)
        TextView tvNim;
        @BindView(R.id.tv_jurusan)
        TextView tvJurusan;
        @BindView(R.id.tv_alamat)
        TextView tvAlamat;
        @BindView(R.id.lay)
        LinearLayout lay;
        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Mahasiswa dosen = items.get(position);
        if (holder instanceof OriginalViewHolder) {
            ((OriginalViewHolder) holder).tvNamaMahasiswa.setText(dosen.getNama());
            ((OriginalViewHolder) holder).tvNim.setText(dosen.getNim());
            ((OriginalViewHolder) holder).tvAlamat.setText(dosen.getAlamat());
            ((OriginalViewHolder) holder).tvJurusan.setText(dosen.getJurusan());

            OriginalViewHolder view = (OriginalViewHolder) holder;
            view.lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position).getNama(), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int current_page);
    }


}
