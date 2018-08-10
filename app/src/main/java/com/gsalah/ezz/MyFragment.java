package com.gsalah.ezz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements View.OnClickListener{

    EditText user_edt,pass_edt;
    Button login_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initViews();
    }

    private void initViews() {
        user_edt=getView().findViewById(R.id.user_edt);
        pass_edt=getView().findViewById(R.id.pass_edt);
        login_btn=getView().findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user=user_edt.getText().toString()
                ,pass=pass_edt.getText().toString();
        if(user.length()>0&&pass.length()>0){
            if(user.equals("Admin")&&pass.equals("Admin")){
                startActivity(new Intent(getActivity(),Main2Activity.class));
            }
        }else{
            Toast.makeText(getActivity(), "Fields are Required", Toast.LENGTH_SHORT).show();
        }
    }
}
