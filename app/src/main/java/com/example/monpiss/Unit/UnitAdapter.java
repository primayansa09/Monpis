package com.example.monpiss.Unit;

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
import com.example.monpiss.R;
import java.util.ArrayList;
import java.util.Collection;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> implements Filterable {
    private ArrayList<Unit> listUnit;
    public ArrayList<Unit> searchList;
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);
    public UnitAdapter(ArrayList<Unit> list){
        this.listUnit = list;
        this.searchList = new ArrayList<>(list);
    }

    public UnitAdapter() {

    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_unit, viewGroup, false);
        return new UnitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, int i) {
            Unit unit = listUnit.get(i);

            holder.tvUnit.setText(unit.getNameUnit());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent mUnit = new Intent(holder.itemView.getContext(), LayoutUnit.class);
                    mUnit.putExtra(LayoutUnit.NAME_UNIT, (Parcelable) listUnit.get(i));
                    mUnit.putExtra(UnitParkirFragment.KODE_UKER13, (Parcelable) listUnit.get(i));
                    mUnit.putExtra(UnitEksteriorFragment.KODE_UKER14, (Parcelable) listUnit.get(i));
                    mUnit.putExtra(UnitATMFragment.KODE_UKER15, (Parcelable) listUnit.get(i));
                    mUnit.putExtra(UnitBangkingHall.KODE_UKER16, (Parcelable) listUnit.get(i));
                    mUnit.putExtra(UnitToiletFragment.KODE_UKER17, (Parcelable) listUnit.get(i));
                    mUnit.putExtra(UnitKerjaArsipPantry.KODE_UKER18, (Parcelable) listUnit.get(i));
                    holder.itemView.getContext().startActivity(mUnit);
                    v.startAnimation(animButton);
                }
            });
    }

    @Override
    public int getItemCount() {
        return listUnit.size();
    }

    @Override
    public Filter getFilter() {

        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Unit> filterdata = new ArrayList<>();

            if (constraint.toString().isEmpty()){
                filterdata.addAll(searchList);
            }else {
                for (Unit item : searchList){
                    if (item.getNameUnit().toLowerCase().contains(constraint.toString().toLowerCase())){
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
            listUnit.clear();
            listUnit.addAll((Collection<? extends Unit>) results.values);
            notifyDataSetChanged();

        }
    };

    public class UnitViewHolder extends RecyclerView.ViewHolder {
        TextView tvUnit;

        public UnitViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUnit = itemView.findViewById(R.id.item_unit);
        }
    }
}
