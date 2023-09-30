package com.computer.offlinecomputerquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.computer.offlinecomputerquiz.Adapter.HomeAdapter;
import com.computer.offlinecomputerquiz.Model.HomeModel;
import com.computer.offlinecomputerquiz.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

FragmentHomeBinding binding;
HomeAdapter adapter;
ArrayList<HomeModel> list=new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentHomeBinding.inflate(getLayoutInflater());
        loaddata();

        // Bottom Fragment

        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BootomFragment bottomFragment=new BootomFragment();
                bottomFragment.show(getActivity().getSupportFragmentManager(), bottomFragment.getTag());

            }
        });


        return binding.getRoot();
    }

    private void loaddata() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("Mathematics","Basic Math Questions"));
        list.add(new HomeModel("Physics","Basic Physics Questions"));
        list.add(new HomeModel("Computer","Basic Computer Questions"));
        list.add(new HomeModel("History","Basic History Questions"));
        list.add(new HomeModel("Biology","Basic Biology Questions"));
        list.add(new HomeModel("Chemistry","Basic Chemistry Questions"));
        list.add(new HomeModel("Reasoning","Basic Reasoning Questions"));
        list.add(new HomeModel("English","Basic English Questions"));


        adapter=new HomeAdapter(getContext(),list);
        binding.rcv.setAdapter(adapter);



    }

}