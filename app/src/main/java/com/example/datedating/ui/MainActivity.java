package com.example.datedating.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.datedating.R;
import com.example.datedating.databinding.ActivityMainBinding;
import com.example.datedating.ui.screen.authorization.LoginFragment;
import com.example.datedating.ui.screen.core.CoreFragment;
import com.example.datedating.ui.screen.messages.MessagesFragment;
import com.example.datedating.ui.screen.profile.ProfileFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private MainViewModel vm;
    ActivityMainBinding binding;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        vm = new ViewModelProvider(this).get(MainViewModel.class);
        mAuth = FirebaseAuth.getInstance();


        getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, new CoreFragment()).commit();

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, new ProfileFragment()).addToBackStack("qwe").commit();
            }else if (itemId == R.id.core) {
                getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, new CoreFragment()).addToBackStack("qwe").commit();
            }else if (itemId == R.id.messages) {

                getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder,new MessagesFragment()).addToBackStack("qwe").commit();

            }
            return true;
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        /*FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, new CoreFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, new LoginFragment()).commit();
        }*/
    }
}