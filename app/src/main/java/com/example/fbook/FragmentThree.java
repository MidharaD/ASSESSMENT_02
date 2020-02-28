package com.example.fbook;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.fbook.database.myDb;

import static com.example.fbook.database.myDb.DB_NAME;
import static com.example.fbook.database.myDb.DB_VERSION;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {

myDb myDatabase;

    private static com.example.fbook.FragmentThree instance = null;

    public static Fragment newInstance() {
        com.example.fbook.FragmentThree fragmentThree = new com.example.fbook.FragmentThree();
        return fragmentThree;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_three, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myDatabase = new myDb(getContext(), DB_NAME, null, DB_VERSION);

    }

}