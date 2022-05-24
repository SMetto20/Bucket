package com.example.bucket.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bucket.R;
import com.example.bucket.adapters.BucketAdapter;
import com.example.bucket.databinding.FragmentHomeBinding;
import com.example.bucket.models.Bucket;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private ArrayList<Bucket> buckets;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buckets = new ArrayList<>();

        buckets.add(new Bucket("Title 1", "Description 1", "Completed"));
        buckets.add(new Bucket("Title 2", "Description 2", "Pending"));
        buckets.add(new Bucket("Title 3", "Description 3", "Rewind"));
        buckets.add(new Bucket("Title 4", "Description 4", "Pending"));
        buckets.add(new Bucket("Title 3", "Description 3", "Rewind"));
        buckets.add(new Bucket("Title 4", "Description 4", "Pending"));
        buckets.add(new Bucket("Title 3", "Description 3", "Rewind"));
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        BucketAdapter bucketAdapter = new BucketAdapter(getContext(), buckets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        System.out.println(bucketAdapter.getItemCount());
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(bucketAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}