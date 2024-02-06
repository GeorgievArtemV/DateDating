package com.example.datedating.ui.screen.profile;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<String> profileGif;
    private static final int PERMISSION_REQUEST_CAMERA = 83854;
    public MutableLiveData<String> getProfileGif() {
        if (profileGif == null) {
            profileGif = new MutableLiveData<String>();
        }
        return profileGif;
    }
    public void openCamera(Context context, Activity activity){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CAMERA);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT,5);
            ContextCompat.startActivity(context,intent,null);
        }


    }
}
