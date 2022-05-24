package com.example.bucket.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bucket.MainActivity;
import com.example.bucket.R;
import com.example.bucket.adapters.BucketAdapter;
import com.example.bucket.dao.BucketDao;
import com.example.bucket.databinding.FragmentHomeBinding;
import com.example.bucket.interfaces.IBucket;
import com.example.bucket.models.Bucket;
import com.example.bucket.utils.ServiceLocator;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        List<Bucket> buckets = ServiceLocator.getInstance().getBucketDao().getAllBuckets();

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        BucketAdapter bucketAdapter = new BucketAdapter(getContext(), buckets);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL, false);

        if(buckets.size()>0) {
            binding.recyclerView.setLayoutManager(linearLayoutManager);
            binding.recyclerView.setAdapter(bucketAdapter);
        }else{
            binding.textHome.setText("No list");
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}