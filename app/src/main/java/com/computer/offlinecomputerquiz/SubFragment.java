package com.computer.offlinecomputerquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.computer.offlinecomputerquiz.Adapter.SubAdapter;
import com.computer.offlinecomputerquiz.Model.SubModel;
import com.computer.offlinecomputerquiz.databinding.FragmentHomeBinding;
import com.computer.offlinecomputerquiz.databinding.FragmentSubBinding;

import java.util.ArrayList;

public class SubFragment extends Fragment {

    FragmentSubBinding binding;
    SubAdapter adapter;
    ArrayList<SubModel> list=new ArrayList<>();
    String title1;
    public SubFragment() {
        // Required empty public constructor
    }

    public SubFragment(String title) {
        this.title1=title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSubBinding.inflate(getLayoutInflater());
        loaddata();


        return binding.getRoot();
    }
    private void loaddata() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();


       switch (title1) {

           case "Mathematics":
               list.add(new SubModel("Test 1", "Basic math test 1 lvl","Mathematics"));
               list.add(new SubModel("Test 2", "Basic math test 2 lvl","Mathematics"));
               list.add(new SubModel("Test 3", "Basic math test 3 lvl","Mathematics"));
               list.add(new SubModel("Test 4", "Basic math test 4 lvl","Mathematics"));
               list.add(new SubModel("Test 5", "Basic math test 5 lvl","Mathematics"));
               list.add(new SubModel("Test 6", "Basic math test 6 lvl","Mathematics"));
               list.add(new SubModel("Test 7", "Basic math test 7 lvl","Mathematics"));
               break;

           case "Physics":
            list.add(new SubModel("Physics Test 1", "Basic Physics test 1 lvl","Physics"));
            list.add(new SubModel("Physics Test 2", "Basic Physics test 2 lvl","Physics"));
            list.add(new SubModel("Physics Test 3", "Basic Physics test 3 lvl","Physics"));
            list.add(new SubModel("Physics Test 4", "Basic Physics test 4 lvl","Physics"));
            list.add(new SubModel("Physics Test 5", "Basic Physics test 5 lvl","Physics"));
            list.add(new SubModel("Physics Test 6", "Basic Physics test 6 lvl","Physics"));
            list.add(new SubModel("Physics Test 7", "Basic Physics test 7 lvl","Physics"));
            break;

           case "Computer":
               list.add(new SubModel("Computer Test 1", "Basic Computer test lvl 1","Computer"));
               list.add(new SubModel("Computer Test 2", "Basic Computer test lvl 2","Computer"));
               list.add(new SubModel("Computer Test 3", "Basic Computer test lvl 3","Computer"));
               list.add(new SubModel("Computer Test 4", "Basic Computer test lvl 4","Computer"));
               list.add(new SubModel("Computer Test 5", "Basic Computer test lvl 5","Computer"));
               list.add(new SubModel("Computer Test 6", "Basic Computer test lvl 6","Computer"));
               list.add(new SubModel("Computer Test 7", "Basic Computer test lvl 7","Computer"));
               break;

           case "History":
               list.add(new SubModel("History Test 1", "Basic History test 1 lvl","History"));
               list.add(new SubModel("History Test 2", "Basic History test 2 lvl","History"));
               list.add(new SubModel("History Test 3", "Basic History test 3 lvl","History"));
               list.add(new SubModel("History Test 4", "Basic History test 4 lvl","History"));
               list.add(new SubModel("History Test 5", "Basic History test 5 lvl","History"));
               list.add(new SubModel("History Test 6", "Basic History test 6 lvl","History"));
               list.add(new SubModel("History Test 7", "Basic History test 7 lvl","History"));
               break;

           case "Biology":
               list.add(new SubModel("Biology Test 1", "Basic Biology test 1 lvl","Biology"));
               list.add(new SubModel("Biology Test 2", "Basic Biology test 2 lvl","Biology"));
               list.add(new SubModel("Biology Test 3", "Basic Biology test 3 lvl","Biology"));
               list.add(new SubModel("Biology Test 4", "Basic Biology test 4 lvl","Biology"));
               list.add(new SubModel("Biology Test 5", "Basic Biology test 5 lvl","Biology"));
               list.add(new SubModel("Biology Test 6", "Basic Biology test 6 lvl","Biology"));
               list.add(new SubModel("Biology Test 7", "Basic Biology test 7 lvl","Biology"));
               break;

           case "Chemistry":
               list.add(new SubModel("Chemistry Test 1", "Basic Chemistry test 1 lvl","Chemistry"));
               list.add(new SubModel("Chemistry Test 2", "Basic Chemistry test 2 lvl","Chemistry"));
               list.add(new SubModel("Chemistry Test 3", "Basic Chemistry test 3 lvl","Chemistry"));
               list.add(new SubModel("Chemistry Test 4", "Basic Chemistry test 4 lvl","Chemistry"));
               list.add(new SubModel("Chemistry Test 5", "Basic Chemistry test 5 lvl","Chemistry"));
               list.add(new SubModel("Chemistry Test 6", "Basic Chemistry test 6 lvl","Chemistry"));
               list.add(new SubModel("Chemistry Test 7", "Basic Chemistry test 7 lvl","Chemistry"));
               break;

           case "Reasoning":
               list.add(new SubModel("Reasoning Test 1", "Basic Reasoning test 1 lvl","Reasoning"));
               list.add(new SubModel("Reasoning Test 2", "Basic Reasoning test 2 lvl","Reasoning"));
               list.add(new SubModel("Reasoning Test 3", "Basic Reasoning test 3 lvl","Reasoning"));
               list.add(new SubModel("Reasoning Test 4", "Basic Reasoning test 4 lvl","Reasoning"));
               list.add(new SubModel("Reasoning Test 5", "Basic Reasoning test 5 lvl","Reasoning"));
               list.add(new SubModel("Reasoning Test 6", "Basic Reasoning test 6 lvl","Reasoning"));
               list.add(new SubModel("Reasoning Test 7", "Basic Reasoning test 7 lvl","Reasoning"));
               break;

           case "English":
               list.add(new SubModel("English Test 1", "Basic English test 1 lvl","English"));
               list.add(new SubModel("English Test 2", "Basic English test 2 lvl","English"));
               list.add(new SubModel("English Test 3", "Basic English test 3 lvl","English"));
               list.add(new SubModel("English Test 4", "Basic English test 4 lvl","English"));
               list.add(new SubModel("English Test 5", "Basic English test 5 lvl","English"));
               list.add(new SubModel("English Test 6", "Basic English test 6 lvl","English"));
               list.add(new SubModel("English Test 7", "Basic English test 7 lvl","English"));
               break;
        }

        adapter=new SubAdapter(getContext(),list);
        binding.rcv.setAdapter(adapter);
    }
}