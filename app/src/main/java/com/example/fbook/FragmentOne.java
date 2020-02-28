package com.example.fbook;

import android.database.Cursor;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.fbook.database.myDb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.fbook.database.myDb.DB_VERSION;


public class FragmentOne extends Fragment {

    myDb dataBaseManager;
    EditText name,age,marks;
    String nm,ag,mrk;
    Button submitBtn;


    public static FragmentOne newInstance(){
        FragmentOne fragmentOne=new FragmentOne();
        return fragmentOne;




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBaseManager = new myDb(getContext(),myDb.DB_NAME,null,DB_VERSION);




        submitBtn=view.findViewById(R.id.submitbtn);
        name=view.findViewById(R.id.nameText);
        age = view.findViewById(R.id.ageText);
        marks = view.findViewById(R.id.marksText);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm=name.getText().toString();
                ag=age.getText().toString();
                mrk=marks.getText().toString();

                boolean inserted = dataBaseManager.insertstudent(""+nm,""+ag,""+mrk);

                if (inserted==true){
                    Toast.makeText(getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }








}
