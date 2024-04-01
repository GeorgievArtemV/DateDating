package com.example.datedating.ui.screen.messages;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datedating.R;
import com.example.datedating.databinding.FragmentMessagesBinding;
import com.example.datedating.ui.screen.messages.adapter.MessagesAdapter;
import com.example.datedating.ui.screen.messages.utilities.OnItemClick;
import com.example.datedating.ui.screen.messanger.MessangerFragment;

public class MessagesFragment extends Fragment implements OnItemClick {

    private MessagesViewModel mViewModel;
    private FragmentMessagesBinding binding;
    private MessagesAdapter messagesAdapter;


    public static MessagesFragment newInstance() {
        return new MessagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMessagesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        RecyclerView recyclerView = binding.messagesList;
        mViewModel = new ViewModelProvider(this).get(MessagesViewModel.class);

        mViewModel.getLivePartnerData().observe(getViewLifecycleOwner(), partners -> {
            messagesAdapter = new MessagesAdapter(partners,this);
            recyclerView.setAdapter(messagesAdapter);
        });


        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(0,ItemTouchHelper.END |ItemTouchHelper.START);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        helper.attachToRecyclerView(recyclerView);

        return view;
    }

    @Override
    public void onItemClick(int item) {
        mViewModel.getLivePartnerData().observe(getViewLifecycleOwner(), partnerList -> {
            Bundle bundle = new Bundle();
            bundle.putString("peredacha",partnerList.get(item).getNamePartner() );
            MessangerFragment messangerFragment = new MessangerFragment();
            messangerFragment.setArguments(bundle);

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, messangerFragment).addToBackStack("zxc").commit();
        });

    }
}