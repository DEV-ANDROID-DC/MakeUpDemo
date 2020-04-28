package com.debin.makeupdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.debin.makeupdemo.R;
import com.debin.makeupdemo.model.MakeUp;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MakeUpAdapter extends RecyclerView.Adapter<MakeUpAdapter.MyViewHolder> {

    List<MakeUp> makeUpList;

    public MakeUpAdapter(List<MakeUp> makeUpList) {
        this.makeUpList = makeUpList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         holder.bind(makeUpList.get(position));
    }

    @Override
    public int getItemCount() {
        return makeUpList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        TextView tvTitle, tvDes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_makeup);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDes = itemView.findViewById(R.id.tv_des);
        }

        public void bind(MakeUp makeUp) {
            Picasso.get().load(makeUp.getImageLink()).into(imgItem);
            tvTitle.setText(makeUp.getName());
            tvDes.setText(makeUp.getDescription());
        }
    }
}
