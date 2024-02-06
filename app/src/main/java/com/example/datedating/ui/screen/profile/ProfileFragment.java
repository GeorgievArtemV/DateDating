package com.example.datedating.ui.screen.profile;


import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.datedating.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ProfileViewModel pViewModel;
    private MutableLiveData<String> profileGif;
    private static final int PERMISSION_REQUEST_CAMERA = 83854;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        pViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);



        final Observer<String> profileGifObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
               // Glide.with(binding.imageProfileProfile.getContext()).asGif().load().into(binding.imageProfileProfile);;
            }
        };
        //pViewModel.getProfileGif().observe(getViewLifecycleOwner(),profileGifObserver);
        binding.imageProfileProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pViewModel.openCamera(getContext(), getActivity());
            }
        });
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}