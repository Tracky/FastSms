package com.example.fastsms.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class ConnectToDB extends AsyncTask<String, Void, DbHelper> {
    private ProgressDialog pd;
    private Context context;

    public ConnectToDB(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(context);
        pd.setTitle("Wait...");
        pd.setMessage("Loading...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setIndeterminate(true);
        pd.show();
    }

    @Override
    protected void onPostExecute(DbHelper dbHelper) {
        super.onPostExecute(dbHelper);
        pd.dismiss();
    }

    @Override
    protected DbHelper doInBackground(String... params) {
        DbHelper dbHelper = new DbHelper(context);
        return dbHelper;
    }
}