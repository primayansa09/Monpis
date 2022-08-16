package com.example.monpiss.KC;

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

import com.example.monpiss.ActivityFileKC;
import com.example.monpiss.LayoutKC;
import com.example.monpiss.R;

import java.util.ArrayList;
import java.util.Collection;

public class KCAdapter extends RecyclerView.Adapter<KCAdapter.KCViewHolder> implements Filterable{

    ArrayList<KC> listKC;
    ArrayList<KC> searchList;
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);

    public KCAdapter(ArrayList<KC> list) {
        this.listKC = list;
        this.searchList = new ArrayList<>(list);
    }


    @NonNull
    @Override
    public KCViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kc, viewGroup, false);
        return new KCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KCViewHolder holder, int i) {
        KC kc = listKC.get(i);

        holder.tvKC.setText(kc.getKCname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mKC =new Intent(holder.itemView.getContext(), LayoutKC.class);
                mKC.putExtra(LayoutKC.NAME_KC, (Parcelable) listKC.get(i));
                mKC.putExtra(ParkirFragment.KODE_UKER1, (Parcelable) listKC.get(i));
                mKC.putExtra(EksteriorFragment.KODE_UKER2, (Parcelable) listKC.get(i));
                mKC.putExtra(ATMFragment.KODE_UKER3, (Parcelable) listKC.get(i));
                mKC.putExtra(BankingHallFragment.KODE_UKER4, (Parcelable) listKC.get(i));
                mKC.putExtra(ToiletFragment.KODE_UKER5, (Parcelable) listKC.get(i));
                mKC.putExtra(ArsipPantryKerjaFragment.KODE_UKER6, (Parcelable) listKC.get(i));
                holder.itemView.getContext().startActivity(mKC);
                v.startAnimation(animButton);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listKC.size();
    }

    @Override
    public Filter getFilter() {

        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<KC> filterreddata = new ArrayList<>();

            if(constraint.toString().isEmpty()){
                filterreddata.addAll(searchList);
            }else {
                for (KC item : searchList){
                    if (item.getKCname().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filterreddata.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterreddata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                listKC.clear();
                listKC.addAll((Collection<? extends KC>) results.values);
                notifyDataSetChanged();
        }
    };


    public class KCViewHolder extends RecyclerView.ViewHolder {
        TextView tvKC;

        public KCViewHolder(@NonNull View itemView) {
            super(itemView);

            tvKC = itemView.findViewById(R.id.item_kc);
        }
    }
}
