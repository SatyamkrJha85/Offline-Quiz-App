package com.computer.offlinecomputerquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.computer.offlinecomputerquiz.databinding.FragmentBootomBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BootomFragment extends BottomSheetDialogFragment {

FragmentBootomBinding binding;
    public BootomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBootomBinding.inflate(getLayoutInflater());


        binding.gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "satyamkrjha85@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject text");
                getContext().startActivity(Intent.createChooser(emailIntent, null));

            }
        });

        //facebook

        binding.insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/satyam_kr_jha_/"));
                startActivity(intent);

            }
        });


        //facebook

        binding.game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.example1.tic_tac_toein2023"));
                startActivity(intent);

            }
        });


        //facebook

        binding.privicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sites.google.com/view/offlinequizapp/home"));
                startActivity(intent);

            }
        });


        //facebook

        binding.moreapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Satyam+Jha"));
                startActivity(intent);

            }
        });


        return binding.getRoot();
    }
}