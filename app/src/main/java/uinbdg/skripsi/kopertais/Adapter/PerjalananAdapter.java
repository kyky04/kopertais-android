package uinbdg.skripsi.kopertais.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.skripsi.kopertais.Model.DataItem;
import uinbdg.skripsi.kopertais.Model.DataItemPerjalanan;
import uinbdg.skripsi.kopertais.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class PerjalananAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<DataItemPerjalanan> items = new ArrayList<>();
    private OnLoadMoreListener onLoadMoreListener;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public PerjalananAdapter(Context context, List<DataItemPerjalanan> items) {
        this.items = items;
        ctx = context;
    }

    public PerjalananAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.et_univ)
        EditText etUniv;
        @BindView(R.id.et_tujuan)
        EditText etTujuan;
        @BindView(R.id.et_waktu)
        EditText etWaktu;
        @BindView(R.id.view_item)
        LinearLayout viewItem;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perjalanan, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        DataItemPerjalanan univ = items.get(position);
        if (holder instanceof OriginalViewHolder) {

            ((OriginalViewHolder) holder).etUniv.setText(univ.getNama());
            ((OriginalViewHolder) holder).etWaktu.setText(univ.getWaktu());
            ((OriginalViewHolder) holder).etTujuan.setText(univ.getUniversitas().getNama());


            OriginalViewHolder view = (OriginalViewHolder) holder;
            view.viewItem.setOnClickListener(new View.OnClickListener() {
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
