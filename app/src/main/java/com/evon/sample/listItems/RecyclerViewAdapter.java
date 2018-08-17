package com.evon.sample.listItems;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evon.sample.R;
import com.evon.sample.db.Model;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Model> modelList;
    private View.OnLongClickListener longClickListener;

    public RecyclerViewAdapter(List<Model> modelList, View.OnLongClickListener longClickListener) {
        this.modelList = modelList;
        this.longClickListener = longClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        Model model = modelList.get(position);
        holder.itemTextView.setText(model.getItemName());
        holder.nameTextView.setText(model.getPersonName());
      //  holder.dateTextView.setText(model.getDate().toLocaleString().substring(0, 11));
        holder.itemView.setTag(model);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void addItems(List<Model> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
        private TextView nameTextView;
        private TextView dateTextView;

        RecyclerViewHolder(View view) {
            super(view);
            itemTextView = view.findViewById(R.id.itemTextView);
            nameTextView = view.findViewById(R.id.nameTextView);
            dateTextView = view.findViewById(R.id.dateTextView);
        }
    }
}