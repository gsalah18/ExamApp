package com.gsalah.ezz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    private ListView listView;
    ArrayAdapter<AndroidModel>adapter;
    List<AndroidModel>data;
    DatabaseUtil databaseUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView=findViewById(R.id.listView);
        databaseUtil=new DatabaseUtil(this);
        data=databaseUtil.fetchAll();
        adapter=new Adapter(this,data);
        listView.setAdapter(adapter);
    }


}
