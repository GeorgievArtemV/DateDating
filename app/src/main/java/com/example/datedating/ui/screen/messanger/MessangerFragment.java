package com.example.datedating.ui.screen.messanger;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datedating.databinding.FragmentMessangerBinding;
import com.example.datedating.model.Partner;
import com.example.datedating.ui.screen.messanger.adapter.MessangerAdapter;

import java.util.List;

public class MessangerFragment extends Fragment {




    private static String namePartner;
    private MessangerViewModel mViewModel;
    private FragmentMessangerBinding binding;
    private MessangerAdapter messangerAdapter;
    private String[] qwe = {"Сосочка-девочка, почему одна, щас будет два. Не стесняйся давай, полчасика на подмыться и жду на своём одноместном кабриолете телесного цвета. Букет тебе.","П-п-п-пррривет Ме-ме-меня зовут умгмг. Мммм… А вот… ну, как бы ч-ч-чем занимаешься? кхм, пук, нууу, я вот люблю в доту играть… а, тебе пора? ну ладно….",""};

    private int[] lenght = {1,2};


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMessangerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        RecyclerView recyclerView = binding.messengerList;
        Bundle bundle = this.getArguments();
        if (bundle != null){
            namePartner = bundle.getString("peredacha");
        }
        messangerAdapter = new MessangerAdapter(qwe,namePartner,/*qaz,true,*/ lenght);
        binding.textItemMessagesTitle.setText(namePartner);
        recyclerView.setAdapter(messangerAdapter);

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}