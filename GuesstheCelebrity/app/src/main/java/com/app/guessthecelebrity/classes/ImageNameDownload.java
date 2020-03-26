package com.app.guessthecelebrity.classes;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageNameDownload extends AsyncTask<String,Void,Map<String,Bitmap>> {


//    ProgressDialog dialog;

//    public ImageNameDownload(Activity A) {
//        dialog = new ProgressDialog(A);
//    }
//
//    @Override
//    protected void onPreExecute() {
//        dialog.setMessage("Doing something, please wait...");
//        dialog.show();
//    }
//
//    @Override
//    protected void onPostExecute(Map<String, Bitmap> result) {
//        // do UI work here
//        if (dialog.isShowing()) {
//            dialog.dismiss();
//        }
//    }
    @Override
    protected Map<String, Bitmap> doInBackground(String... strings) {
        try {

            URL url= new URL(strings[0]);
            String s = null;
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream inputStream = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String data = reader.readLine();

            int i=0;

            while(data!= null){
            i++;
            if (i>900) s+=data;
            data=reader.readLine();
            }


            URL url1;
            HttpURLConnection http1;
            InputStream inputStream1;
            Bitmap myBitmap;

            Map<String,Bitmap> x = new HashMap<>();

            Pattern p = Pattern.compile("img alt=\"(.*?)\"width=\"140\"");
            Matcher m = p.matcher(s);

            while(m.find()){
            String a = m.group(1);
//                Log.i("ALL1",a);
            String[] both = a.split("\"height=\"209\"src=\"");
//            Log.i("ALL1",both[0]+" "+both[1]);
            url1=new URL(both[1]);
            http1 = (HttpURLConnection) url1.openConnection();
            http1.connect();
            inputStream1 = http1.getInputStream();
            myBitmap = BitmapFactory.decodeStream(inputStream1);
            x.put(both[0],myBitmap);
//            Log.i("Juventus",both[0]);
            }
            return x;

        } catch (Exception e) {
            Log.i("error12",e.toString());
            e.printStackTrace();
            return null;
        }

    }




}
