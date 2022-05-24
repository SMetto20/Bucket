package com.example.bucket;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.bucket.models.Bucket;
import com.example.bucket.ui.home.HomeFragment;
import com.example.bucket.utils.ServiceLocator;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bucket.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private View customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        FragmentManager fragmentManager = getSupportFragmentManager();
        customView = getLayoutInflater().inflate(R.layout.input_view, null);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText title = ((EditText) customView
                        .findViewById(R.id.title_field));
                EditText description = ((EditText) customView.findViewById(R.id.description_field));

                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setView(customView)
                        .setTitle("Add Bucket")
                        .setMessage("Enter Bucket Details")
                        .setPositiveButton("Add", (dialog, which) -> {
                            ServiceLocator.getInstance()
                                    .getBucketDao()
                                    .addBucket(new Bucket(title.getText().toString(),
                                            description.getText().toString(), "Pending"));
                            dialog.dismiss();
                            recreate();
                        })
                        .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                        .show();
            }
        });
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}