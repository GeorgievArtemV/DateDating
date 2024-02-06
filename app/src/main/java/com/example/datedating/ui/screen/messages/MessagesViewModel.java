package com.example.datedating.ui.screen.messages;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datedating.model.Partner;
import com.example.datedating.model.PartnerRepository;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MessagesViewModel extends ViewModel {
    private MutableLiveData<List<Partner>> mutableLiveData;
    private PartnerRepository partnerRepository;
    private FirebaseFirestore firebaseFirestore;

    public MessagesViewModel() {
        partnerRepository = new PartnerRepository();
        mutableLiveData = partnerRepository.getPartnerListLiveData();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }
    public  MutableLiveData<List<Partner>> getLivePartnerData() {
        return mutableLiveData;
    }






    @Override
    protected void onCleared() {
        super.onCleared();
    }

}