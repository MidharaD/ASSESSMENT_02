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
    View view;
    String string1[];
    ListView list[];

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
        list = view.findViewById(R.id.viewAll);
        viewAll();
    }

    public void viewAll(){

        Cursor rs = myDatabase.getDetails();
        ArrayList<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,data);
        if((rs.getCount())==0){
            showMessage("Error","Not Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        while (rs.moveToNext()){
            buffer.append("Name: "+rs.getString(1)+"\n");
            buffer.append("Age : "+rs.getString(2)+"\n");
            buffer.append("Mark: "+rs.getString(3)+"\n\n");

        }
        string1 = buffer.toString().split("\n\n");
        for(int i=0;i<(string1.length);i++){
            data.add(string1[i]);
        }
        //list.(adapter);
        //showMessage("data",""+buffer.toString());
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



}