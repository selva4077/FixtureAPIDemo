package com.test.apidemo.apidemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.test.apidemo.apidemo.adapters.FixtureListAdapter;
import com.test.apidemo.apidemo.gsonhelper.FixturesDetail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity {

    public static final String BASE_URL = "http://api.football-data.org/";
    public static final String PROGRESS_HEADER = "Fetching Data";
    public static final String PROGRESS_MESSAGE = "Please wait...";
    public static final String CACHE_FILE = "fixtures.txt";

    private ListView fixtureList = null;
    private FixtureListAdapter fixtureListAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fixtureList = (ListView)findViewById(R.id.fixtureList);
        FixturesDetail data = (FixturesDetail) readObjectFromFile(this,CACHE_FILE);
        if(data == null)
          callService();
        else {
            setResultToList(data);
        }
    }

    private void callService() {
        final ProgressDialog progressDialog = ProgressDialog.show(this, PROGRESS_HEADER, PROGRESS_MESSAGE, false, false);
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(retrofit.GsonConverterFactory.create())
                .build();
        FixturesService fixturesService = adapter.create(FixturesService.class);
        Call<FixturesDetail> call = fixturesService.getFixturesDetail();
        call.enqueue(new Callback<FixturesDetail>() {
            @Override
            public void onResponse(Response<FixturesDetail> response, Retrofit retrofit) {
                progressDialog.dismiss();
                final FixturesDetail data = response.body();
                setResultToList(data);
                Thread writeToFile = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        writeObjectToFile(MainActivity.this,data,CACHE_FILE);
                    }
                });
                writeToFile.start();
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
            }
        });
    }

    private void setResultToList(FixturesDetail data)
    {
        fixtureListAdapter = new FixtureListAdapter(data);
        fixtureList.setAdapter(fixtureListAdapter);
    }

    private void writeObjectToFile(Context context, Object object, String filename) {

        ObjectOutputStream objectOut = null;
        try {

            FileOutputStream fileOut = context.openFileOutput(filename, Activity.MODE_PRIVATE);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            fileOut.getFD().sync();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOut != null) {
                try {
                    objectOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object readObjectFromFile(Context context, String filename) {

        ObjectInputStream objectIn = null;
        Object object = null;
        try {

            FileInputStream fileIn = context.getApplicationContext().openFileInput(filename);
            objectIn = new ObjectInputStream(fileIn);
            object = objectIn.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectIn != null) {
                try {
                    objectIn.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
        }

        return object;
    }
}
