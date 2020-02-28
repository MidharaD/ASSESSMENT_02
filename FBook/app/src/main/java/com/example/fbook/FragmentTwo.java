package com.example.fbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private static com.example.fbook.FragmentOne instance = null;

    public  static Fragment newInstance()
    {
        com.example.fbook.FragmentTwo fragmentTwo =new com.example.fbook.FragmentTwo();
        return fragmentTwo;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_two,container,  false);
    }
}
