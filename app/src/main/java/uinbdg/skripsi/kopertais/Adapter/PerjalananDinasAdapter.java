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
import uinbdg.skripsi.kopertais.Model.baru.DataItemPerjalananDinas;
import uinbdg.skripsi.kopertais.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class PerjalananDinasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataItemPerjalananDinas> items = new ArrayList<>();
    private OnLoadMoreListener onLoadMoreListener;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public PerjalananDinasAdapter(Context context, List<DataItemPerjalananDinas> items) {
        this.items = items;
        ctx = context;
    }

    public PerjalananDinasAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama)
        TextView tvNama;
        @BindView(R.id.tv_pangkat)
        TextView tvPangkat;
        @BindView(R.id.tv_jabatan)
        TextView tvJabatan;
        @BindView(R.id.tv_maksud_perjalanan)
        TextView tvMaksudPerjalanan;
        @BindView(R.id.tv_kendaraan)
        TextView tvKendaraan;
        @BindView(R.id.tv_tempat_berangkat)
        TextView tvTempatBerangkat;
        @BindView(R.id.tv_tujuan)
        TextView tvTujuan;
        @BindView(R.id.tv_lama_perjalanan)
        TextView tvLamaPerjalanan;
        @BindView(R.id.tv_lama_tanggal_keberangkatan)
        TextView tvLamaTanggalKeberangkatan;
        @BindView(R.id.tv_tanggal_kembali)
        TextView tvTanggalKembali;
        @BindView(R.id.tv_status)
        TextView tvStatus;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perjalanan_dinas, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        DataItemPerjalananDinas dosen = items.get(position);
        if (holder instanceof OriginalViewHolder) {
            ((OriginalViewHolder) holder).tvNama.setText("Nama : "+dosen.getNama());
            ((OriginalViewHolder) holder).tvJabatan.setText("Jabatan : "+dosen.getJabatan());
            ((OriginalViewHolder) holder).tvKendaraan.setText("Kendaraan : "+dosen.getKendaraan());
            ((OriginalViewHolder) holder).tvLamaPerjalanan.setText(dosen.getLamaPerjalanan()+" Hari");
            ((OriginalViewHolder) holder).tvLamaTanggalKeberangkatan.setText("Tanggal Berangkat : "+dosen.getTanggalKeberangkatan());
            ((OriginalViewHolder) holder).tvTanggalKembali.setText("Tanggal Kembali : "+dosen.getTanggalKembali());
            ((OriginalViewHolder) holder).tvMaksudPerjalanan.setText("Maksud : "+dosen.getMaksudPerjalanan());
            ((OriginalViewHolder) holder).tvPangkat.setText("Pangkat : "+dosen.getPangkat());
            ((OriginalViewHolder) holder).tvTujuan.setText("Tempat Tujuan : "+dosen.getTempatTujuan());
            ((OriginalViewHolder) holder).tvTempatBerangkat.setText("Tempat Berangkat : "+dosen.getTempatBerangkat());
            ((OriginalViewHolder) holder).tvStatus.setText("Status : "+dosen.getStatus());

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
