package com.example.btvn6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> implements Filterable {
    List<Country> list;
    List<Country> listOld;
    Context context;

    public CountryAdapter(List<Country> list, Context context) {
        this.list = list;
        this.listOld=list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_item_country, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = list.get(position);
        holder.tvName.setText(country.getCountryName());
        holder.tvConfirm.setText(country.getConfirmed()+"");
        holder.tvDeaths.setText(country.getDeaths()+"");
        holder.tvRecovered.setText(country.getRecovered()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvConfirm, tvDeaths, tvRecovered;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvConfirm=itemView.findViewById(R.id.tvConfirm);
            tvDeaths=itemView.findViewById(R.id.tvDeaths);
            tvRecovered=itemView.findViewById(R.id.tvRecovered);
        }
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch =constraint.toString();
                if(strSearch.isEmpty() ){
                    list=listOld;
                }else{
                    List<Country> mlist=new ArrayList<>();
                    for (Country country: listOld){
                        if (country.getCountryName().toLowerCase().contains(strSearch.toLowerCase())){
                            mlist.add(country);
                        }
                    }
                    list =mlist;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list= (List<Country>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
