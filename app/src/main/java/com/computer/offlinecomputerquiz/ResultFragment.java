package com.computer.offlinecomputerquiz;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.computer.offlinecomputerquiz.databinding.FragmentResultBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class ResultFragment extends Fragment {


FragmentResultBinding binding;
    int right;
    int allQuestion;
    String category;
    String title;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    public ResultFragment() {
        // Required empty public constructor
    }


    public ResultFragment(int right,int allQuestion,String category,String title) {
      this.allQuestion=allQuestion;
      this.right=right;
      this.category=category;
      this.title=title;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentResultBinding.inflate(getLayoutInflater());
        String rightscore=String.valueOf(right);
        String wrongscore=String.valueOf(allQuestion-right);
        String totalscore=String.valueOf(allQuestion);



        binding.correct.setText(rightscore+" Correct");
        binding.incorrect.setText(wrongscore+" Incorrect");
        binding.score.setText("You got the "+rightscore+" out of "+totalscore);


        binding.explorebtn.setOnClickListener(v->{
            if (mInterstitialAd != null) {
                mInterstitialAd.show(getActivity());
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
         //   AppCompatActivity activity=(AppCompatActivity) v.getContext();
        //    activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new SubFragment(category)).commit();

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new SubFragment(category)).commit();
        });



  /*      // Error in this code Not call back
        binding.explorebtn.setOnClickListener(v -> {
            // Get the activity context.
            Context context = v.getContext();

            // Check if the context is an AppCompatActivity.
            if (context instanceof AppCompatActivity) {
                // Cast the context to an AppCompatActivity.
                AppCompatActivity activity = (AppCompatActivity) context;

                // Replace the current fragment with a new SubFragment.
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.wrapper, new SubFragment(category))
                        .commit();
            }
        });

   */


        // Add

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(getContext(),"ca-app-pub-3388221262538162/8584337143", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });




        binding.replay.setOnClickListener(v->{
            if (mInterstitialAd != null) {
                mInterstitialAd.show(getActivity());
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            AppCompatActivity activity=(AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new QuizFragment(category,title)).commit();
        });

        return binding.getRoot();
    }
}