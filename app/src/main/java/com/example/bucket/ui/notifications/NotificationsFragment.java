package com.example.bucket.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bucket.adapters.BucketAdapter;
import com.example.bucket.databinding.FragmentNotificationsBinding;
import com.example.bucket.models.Bucket;
import com.example.bucket.utils.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        List<Bucket> buckets = ServiceLocator.getInstance().getBucketDao().getAllBuckets();
        List<Bucket> pendingBuckets = new ArrayList<>();
        for (Bucket bucket : buckets) {
            if (bucket.getIsCompleted().equals("Pending")) {
                pendingBuckets.add(bucket);
            }
        }
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        BucketAdapter bucketAdapter = new BucketAdapter(getContext(), pendingBuckets);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL, false);
        if (pendingBuckets.size() > 0) {
            binding.recyclerView.setLayoutManager(linearLayoutManager);
            binding.recyclerView.setAdapter(bucketAdapter);
        } else {
            binding.textNotif.setText("No list");
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}