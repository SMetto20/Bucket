package com.example.bucket.adapters;

import android.content.Context;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bucket.R;
import com.example.bucket.models.Bucket;
import com.example.bucket.utils.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class BucketAdapter extends RecyclerView.Adapter<BucketAdapter.Viewholder> {

    private Context context;
    private List<Bucket> bucketArrayList;

    // Constructor
    public BucketAdapter(Context context, List<Bucket> bucketList) {
        this.context = context;
        this.bucketArrayList = bucketList;
    }

    @NonNull
    @Override
    public BucketAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        Bucket model = bucketArrayList.get(position);
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.isCompleted.setText(model.getIsCompleted());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // to delete the item from recycler view
                ServiceLocator.getInstance().getBucketDao().deleteBucket(model);
                bucketArrayList.remove(model);
                notifyDataSetChanged();
                return true;
            }
        });

       holder.isCompleted.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // to update the item from recycler view
               ServiceLocator.getInstance().getBucketDao().updateBucket(model);
               notifyDataSetChanged();
           }
       });

    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return bucketArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView title, description, isCompleted;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            isCompleted = itemView.findViewById(R.id.chip);
        }
    }
}