package com.example.fbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fbook.database.myDb;
import com.example.fbook.database.myDb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.fbook.database.myDb.DB_NAME;
import static com.example.fbook.database.myDb.DB_VERSION;
import static com.example.fbook.database.myDb.DB_NAME;
import static com.example.fbook.database.myDb.DB_VERSION;

public class FragmentOne extends Fragment {

    myDb dataBaseManager;

    private static FragmentOne instance = null;

    public  static FragmentOne newInstance()
    {
        FragmentOne fragmentOne =new FragmentOne();
        return fragmentOne;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBaseManager = new myDb(getContext(),
                DB_NAME,
                null,
                DB_VERSION);
    }
    private void insertStudent(String name,int age,int marks){
        dataBaseManager.insertstudent("Midhara", 23, 100);
    }
}
