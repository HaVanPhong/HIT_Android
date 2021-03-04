package com.example.btvn5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class drinkAdapter extends RecyclerView.Adapter<drinkAdapter.ViewHolder> {
    List<drink> list;
    Context context;
    IOnclick iOnclick;


    public IOnclick getiOnclick() {
        return iOnclick;
    }

    public void setiOnclick(IOnclick iOnclick) {
        this.iOnclick = iOnclick;
    }

    public drinkAdapter(List<drink> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_drink, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        drink drink=list.get(position);
        holder.imgAvt.setImageResource(drink.getAvt());
        holder.tvNamedrink.setText(drink.getName()+"");
        holder.tvCore.setText(drink.getCore()+"");
        holder.tvSoLuong.setText(drink.getCount()+"");
        holder.tvTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnclick.iOnclickTru(drink);
                holder.tvSoLuong.setText(String.valueOf(Integer.parseInt(holder.tvSoLuong.getText()+"")-1));
            }
        });
        holder.tvCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnclick.iOnclickCong(drink);
                holder.tvSoLuong.setText(String.valueOf(Integer.parseInt(holder.tvSoLuong.getText()+"")+1));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamedrink, tvCore, tvSoLuong, tvCong, tvTru;
        ImageView imgAvt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamedrink = itemView.findViewById(R.id.tvNameDrink);
            tvSoLuong = itemView.findViewById(R.id.tvCount);
            tvCore = itemView.findViewById(R.id.tvCore);
            imgAvt = itemView.findViewById(R.id.imgAvt);
            tvCong=itemView.findViewById(R.id.tvCong);
            tvTru=itemView.findViewById(R.id.tvTru);
        }
    }
}
