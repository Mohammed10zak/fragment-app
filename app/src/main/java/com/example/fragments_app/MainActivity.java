package com.example.fragments_app;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragments_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnContinueButtonClickListener {

    private int currentFragment = 1;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.fragments_app.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new Fragment1()).commit();

        binding.continueBtn.setOnClickListener(view -> {
            if (currentFragment == 1) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment2())
                        .addToBackStack(null)
                        .commit();
                currentFragment = 2;
            } else {

                if (!TextUtils.isEmpty(Fragment2.fragment2Binding.name.getText().toString())) {
                    name = Fragment2.fragment2Binding.name.getText().toString();
                    Fragment3 fragment3 = Fragment3.newInstance(name);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment3)
                            .addToBackStack(null)
                            .commit();
                } else {
                    Toast.makeText(MainActivity.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }


}
