package uinbdg.skripsi.kopertais.Adapter;

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
import uinbdg.skripsi.kopertais.Model.Pegawai;
import uinbdg.skripsi.kopertais.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class PegawaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Pegawai> items = new ArrayList<>();
    private OnLoadMoreListener onLoadMoreListener;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, String obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public PegawaiAdapter(Context context, List<Pegawai> items) {
        this.items = items;
        ctx = context;
    }

    public PegawaiAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_mahasiswa)
        TextView tvNamaMahasiswa;
        @BindView(R.id.tv_nim)
        TextView tvNim;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pegawai, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Pegawai dosen = items.get(position);
        if (holder instanceof OriginalViewHolder) {
            ((OriginalViewHolder) holder).tvNamaMahasiswa.setText(dosen.getNama());
            ((OriginalViewHolder) holder).tvNim.setText(dosen.getTanggalLahir());

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
