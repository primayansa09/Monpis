package com.example.monpiss.KCP;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monpiss.KC.KC;
import com.example.monpiss.KC.KCAdapter;
import com.example.monpiss.LayoutKCP;
import com.example.monpiss.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KCPAdapter extends RecyclerView.Adapter<KCPAdapter.KCPViewHolder> implements Filterable {
    private ArrayList<KCP> listkcp ;
    ArrayList<KCP> searchList;
    private AlphaAnimation animButtom = new AlphaAnimation(1F, 0.8F);

    public KCPAdapter(ArrayList<KCP> list){
        this.listkcp = list;
        this.searchList = new ArrayList<>(list);
    }

    public KCPAdapter(Context context, List<KC> listkc) {
    }

    @NonNull
    @Override
    public KCPViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kcp, viewGroup, false);
        return new KCPViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KCPViewHolder holder, int i) {
        KCP kcp = listkcp.get(i);

        holder.tvKCP.setText(kcp.getNameKCP());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mKCp = new Intent(holder.itemView.getContext(), LayoutKCP.class);
                mKCp.putExtra(LayoutKCP.NAME_KCP, (Parcelable) listkcp.get(i));
                mKCp.putExtra(KCPParkirFragment.KODE_UKER7, (Parcelable) listkcp.get(i));
                mKCp.putExtra(KCPEksteriorFragment.KODE_UKER9, (Parcelable) listkcp.get(i));
                mKCp.putExtra(KCPAtmFragment.KODE_UKER8, (Parcelable) listkcp.get(i));
                mKCp.putExtra(KCPBankingHall.KODE_UKER10, (Parcelable) listkcp.get(i));
                mKCp.putExtra(KCPToiletFragment.KODE_UKER11, (Parcelable) listkcp.get(i));
                mKCp.putExtra(KCPKerjaArsipPantry.KODE_UKER12, (Parcelable) listkcp.get(i));
                holder.itemView.getContext().startActivity(mKCp);
                v.startAnimation(animButtom);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listkcp.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<KCP> filterdata = new ArrayList<>();

            if (constraint.toString().isEmpty()){
                filterdata.addAll(searchList);
            }else {
                for (KCP item : searchList){
                    if (item.getNameKCP().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filterdata.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filterdata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listkcp.clear();
            listkcp.addAll((Collection<? extends KCP>) results.values);
            notifyDataSetChanged();

        }
    };

    public class KCPViewHolder extends RecyclerView.ViewHolder {
        TextView tvKCP;

        public KCPViewHolder(@NonNull View itemView) {
            super(itemView);

            tvKCP = itemView.findViewById(R.id.item_kcp);
        }
    }
}
