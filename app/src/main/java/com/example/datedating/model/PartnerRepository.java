package com.example.datedating.model;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class PartnerRepository {
    MutableLiveData<List<Partner>> partnerListLiveData;
    FirebaseFirestore mFireStore;
    MutableLiveData<Partner> mutableLiveData;

    public PartnerRepository() {
        this.partnerListLiveData = new MutableLiveData<>();
        mFireStore = FirebaseFirestore.getInstance();
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Partner>> getPartnerListLiveData() {
        mFireStore.collection("partner").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                List<Partner> partnerList = new ArrayList<>();
                for (QueryDocumentSnapshot doc : value) {
                    if (doc != null) {
                        partnerList.add(doc.toObject(Partner.class));
                    }
                }
                partnerListLiveData.postValue(partnerList);
            }

        });
        return partnerListLiveData;
    }
}
