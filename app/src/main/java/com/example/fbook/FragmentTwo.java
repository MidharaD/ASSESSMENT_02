package com.example.fbook;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fbook.database.myDb;

import static com.example.fbook.database.myDb.DB_NAME;
import static com.example.fbook.database.myDb.DB_VERSION;
public class FragmentTwo extends Fragment {


    myDb mydb;
    SearchView searchView;
    TextView name,age,mark;
    String result;

    private static com.example.fbook.FragmentOne instance = null;

    public  static Fragment newInstance()
    {
        FragmentTwo fragmentTwo=new FragmentTwo();
        return fragmentTwo;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_two,container,  false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mydb = new myDb(getContext(), DB_NAME, null, DB_VERSION);

        searchView = view.findViewById(R.id.searchView);
        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        mark = view.findViewById(R.id.mark);

        result = searchView.toString();

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor rs = mydb.getAll();

                if((rs.getCount())==0){

                    return;
                }



                while(rs.moveToNext()){
                    if((rs.getString(1))==(view.findViewById(R.id.searchView).toString())){
                        name.setText(rs.getString(1));
                        age.setText(rs.getString(2));
                        mark.setText(rs.getString(3));
                    }
                }
            }
        });


    }

}



