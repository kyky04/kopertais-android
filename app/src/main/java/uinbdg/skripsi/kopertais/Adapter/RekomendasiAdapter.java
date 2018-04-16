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
import uinbdg.skripsi.kopertais.Model.baru.DataItemRekomendasi;
import uinbdg.skripsi.kopertais.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class RekomendasiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataItemRekomendasi> items = new ArrayList<>();
    private OnLoadMoreListener onLoadMoreListener;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public RekomendasiAdapter(Context context, List<DataItemRekomendasi> items) {
        this.items = items;
        ctx = context;
    }

    public RekomendasiAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_pegawai)
        TextView tvNamaPegawai;
        @BindView(R.id.tv_tanggal_berangkat)
        TextView tvTanggalBerangkat;
        @BindView(R.id.tv_tanggal_kembali)
        TextView tvTanggalKembali;
        @BindView(R.id.lay)
        LinearLayout lay;
        @BindView(R.id.tv_tujuan)
        TextView tvTujuan;
        @BindView(R.id.tv_lama)
        TextView tvLama;


        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rekomendasi, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        DataItemRekomendasi pegawai = items.get(position);
        if (holder instanceof OriginalViewHolder) {
            ((OriginalViewHolder) holder).tvNamaPegawai.setText(pegawai.getPegawai().getNama());
            ((OriginalViewHolder) holder).tvTanggalKembali.setText("Tanggal Kembali : " + pegawai.getTanggalKembali());
            ((OriginalViewHolder) holder).tvTanggalBerangkat.setText("Tanggal Berangkat : " + pegawai.getTanggalBerangkat());
            ((OriginalViewHolder) holder).tvTujuan.setText("Tujuan : "+pegawai.getUniversitas().getNama());
            ((OriginalViewHolder) holder).tvLama.setText(pegawai.getLamaPejalanan() + " Hari");

            OriginalViewHolder view = (OriginalViewHolder) holder;
            view.lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(position);
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
