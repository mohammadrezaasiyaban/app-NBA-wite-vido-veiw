package com.example.nbaapk.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbaapk.R;
import com.example.nbaapk.databinding.FragmentEasternBinding;
import com.example.nbaapk.recyaceler.MyAdapter;
import com.example.nbaapk.recyaceler.News;

import java.util.ArrayList;

public class EasternFragment extends Fragment {
    private FragmentEasternBinding binding;
    private ArrayList<News> newsArrayList;
    private String[] newsHeding;
    private int[] imageResourceID;
    private RecyclerView recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentEasternBinding.inflate(inflater,container,false);
        return binding.getRoot();



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();
        recyclerview = view.findViewById(R.id.recyclerview_teams);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(),newsArrayList);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        newsArrayList= new ArrayList<>();
        newsHeding= new String[]{

                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
                getString(R.string.app_name),
        };

        imageResourceID= new int[]{
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,

        };
        for (int i = 0; i < newsHeding.length; i++) {
            News news = new News(newsHeding[i],imageResourceID[i]);
            newsArrayList.add(news);
        }




    }
}