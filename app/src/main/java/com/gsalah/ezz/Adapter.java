package com.gsalah.ezz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<AndroidModel> {

    public Adapter(@NonNull Context context, @NonNull List<AndroidModel> objects) {
        super(context, R.layout.list_row, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.list_row,parent,false);
        AndroidModel androidModel=getItem(position);
        TextView id_txt=view.findViewById(R.id.id_txt),
                name_txt=view.findViewById(R.id.name_txt),
                version_txt=view.findViewById(R.id.version_txt),
                api_txt=view.findViewById(R.id.api_txt);

        id_txt.setText(androidModel.getId().toString());
        name_txt.setText(androidModel.getName());
        version_txt.setText(androidModel.getVersion().toString());
        api_txt.setText(androidModel.getApi().toString());

        return view;
    }

}
