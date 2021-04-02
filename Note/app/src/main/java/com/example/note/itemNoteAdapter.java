package com.example.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemNoteAdapter extends RecyclerView.Adapter<itemNoteAdapter.ViewHolder> {
    Context context;
    List<itemNote> list;
    iOnclick iOnclick;

    public itemNoteAdapter(Context context, List<itemNote> list) {
        this.context = context;
        this.list = list;
    }

    public com.example.note.iOnclick getiOnclick() {
        return iOnclick;
    }

    public void setiOnclick(com.example.note.iOnclick iOnclick) {
        this.iOnclick = iOnclick;
    }

    @NonNull
    @Override
    public itemNoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_note, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemNoteAdapter.ViewHolder holder, int position) {
        itemNote itemNote=list.get(position);
        holder.tvDate.setText(itemNote.getTitle()+"");
        holder.tvTime.setText(itemNote.getDate()+"");
        holder.tvTitle.setText(itemNote.getContent()+"");
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnclick.Click(itemNote);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvTime, tvTitle;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate=itemView.findViewById(R.id.tvdate);
            tvTime=itemView.findViewById(R.id.tvtime);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            linearLayout=itemView.findViewById(R.id.item_note);
        }
    }
}
