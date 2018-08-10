package com.gsalah.ezz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private SQLiteDatabase database;
    private Context context;

    public DatabaseUtil(Context context) {
        this.context = context;
        database = context.openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);

        database.execSQL("CREATE TABLE IF NOT EXISTS android (" +
                "id INT(11) PRIMARY KEY," +
                "name VARCHAR(50)," +
                "version DOUBLE," +
                "api DOUBLE)");
    }

    public void add(AndroidModel androidModel) {
        if(fetchOne(androidModel.getId())==null) {
            database.insert("android", null, androidModel.toContentValues());
            Toast.makeText(context, "Model Added", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(context, "The Id is Exists", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(Long id) {
        if (fetchOne(id) != null) {
            database.delete("android", "id='" + id + "'", null);
            Toast.makeText(context, "Model Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "No Model with this Id", Toast.LENGTH_SHORT).show();
        }
    }

    public void Update(AndroidModel androidModel) {
        if(fetchOne(androidModel.getId()) != null) {
            database.update("android", androidModel.toContentValues(), "id='" + androidModel.getId() + "'", null);
            Toast.makeText(context, "Model Updated", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "No Model with this Id", Toast.LENGTH_SHORT).show();
        }
    }

    public AndroidModel fetchOne(Long id) {
        Cursor cursor = database.rawQuery("SELECT * FROM android WHERE id='" + id + "'", null);
        AndroidModel androidModel = null;
        while (cursor.moveToNext()) {
            androidModel = new AndroidModel(
                    cursor.getLong(0)
                    , cursor.getString(1)
                    , cursor.getDouble(2)
                    , cursor.getDouble(3)
            );
        }
        return androidModel;
    }

    public List<AndroidModel> fetchAll() {
        Cursor cursor = database.rawQuery("SELECT * FROM android", null);
        List<AndroidModel> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            list.add(
                    new AndroidModel(
                            cursor.getLong(0)
                            , cursor.getString(1)
                            , cursor.getDouble(2)
                            , cursor.getDouble(3)
                    )
            );
        }
        return list;
    }

}
