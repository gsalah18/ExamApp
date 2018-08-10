package com.gsalah.ezz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText id_edt, name_edt, version_edt, api_edt;
    private DatabaseUtil databaseUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        databaseUtil = new DatabaseUtil(this);
    }

    private void initView() {
        id_edt = findViewById(R.id.id_edt);
        name_edt = findViewById(R.id.name_edt);
        version_edt = findViewById(R.id.version_edt);
        api_edt = findViewById(R.id.api_edt);
    }

    public void addClick(View view) {
        if (checkReqired()) {
            AndroidModel androidModel = new AndroidModel(
                    Long.parseLong(id_edt.getText().toString())
                    , name_edt.getText().toString()
                    , Double.parseDouble(version_edt.getText().toString())
                    , Double.parseDouble(api_edt.getText().toString())
            );
            databaseUtil.add(androidModel);
        } else {
            Toast.makeText(this, "All fields are Required", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteClick(View view) {
        if (!TextUtils.isEmpty(id_edt.getText().toString())) {
            databaseUtil.delete(Long.parseLong(id_edt.getText().toString()));
        } else {
            Toast.makeText(this, "Id field is Required", Toast.LENGTH_SHORT).show();
        }
    }

    public void showAllClick(View view) {
        startActivity(new Intent(getApplicationContext(),Main3Activity.class));

    }

    public void showONeClick(View view) {
        if (!TextUtils.isEmpty(id_edt.getText().toString())) {
            AndroidModel androidModel = databaseUtil.fetchOne(
                    Long.parseLong(id_edt.getText().toString())
            );
            if(androidModel!=null) {
                name_edt.setText(androidModel.getName());
                version_edt.setText(androidModel.getVersion().toString());
                api_edt.setText(androidModel.getApi().toString());
            }else{
                Toast.makeText(this, "No Model with this Id", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Id field is Required", Toast.LENGTH_SHORT).show();
        }
    }

    public void editClick(View view) {
        if (checkReqired()) {
            AndroidModel androidModel = new AndroidModel(
                    Long.parseLong(id_edt.getText().toString())
                    , name_edt.getText().toString()
                    , Double.parseDouble(version_edt.getText().toString())
                    , Double.parseDouble(api_edt.getText().toString())
            );
            databaseUtil.Update(androidModel);
        } else {
            Toast.makeText(this, "All fields are Required", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkReqired() {
        return !TextUtils.isEmpty(id_edt.getText().toString())
                && !TextUtils.isEmpty(name_edt.getText().toString())
                && !TextUtils.isEmpty(version_edt.getText().toString())
                && !TextUtils.isEmpty(api_edt.getText().toString());
    }

}
