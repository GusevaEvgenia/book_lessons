package com.android_lessons.belkin.crime;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Belkin on 21.04.2015.
 */
public class CriminalIntentJSONSerializer {

    private Context mContext;
    private String mFilename;

    public CriminalIntentJSONSerializer(Context c, String f) {
        mContext = c;
        mFilename = f;
    }

    public void saveCrimes(ArrayList<Crime> crimes) throws JSONException, IOException {
        // Построение массива в JSON
        JSONArray array = new JSONArray();
        for(Crime c : crimes){
            array.put(c.toJSON());
        }
        // Запись файла на диск
        Writer writer = null;
        try{
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE); //имя файла и режим. создает файл и открывает его для записи
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally{
            if(writer != null){
                writer.close();
            }
        }
    }
}
