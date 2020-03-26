package com.app.guessthecelebrity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.app.guessthecelebrity.classes.ImageNameDownload;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    List<String> names= new ArrayList<>();
    Random rand = new Random();
    LinearLayout ln;
    int correctAnswer,listPosition,c,d;
    Map<String, Bitmap> s;
    ImageView imageView;
    Bitmap q;
    int current=0,total=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imageView.setImageBitmap(null);
       ln=findViewById(R.id.ln);
       imageView=findViewById(R.id.imageView2);

       ImageNameDownload a = new ImageNameDownload();

        try {
        s= a.execute("https://www.imdb.com/search/name?gender=male,female&ref_=nv_cel_m/").get();

            Log.i("Juventus",Integer.toString(s.size()));

            for(Map.Entry<String,Bitmap> e: s.entrySet()){
                names.add(e.getKey());
            }

            setButtons();

        } catch (ExecutionException e) {
            Log.i("error1",e.toString());
            e.printStackTrace();
        } catch (InterruptedException e) {
            Log.i("error1",e.toString());
            e.printStackTrace();
        }
    }

public void setButtons(){

    correctAnswer=rand.nextInt(ln.getChildCount());
    //    correctAnswer-=1;
    listPosition=rand.nextInt(names.size());
//    listPosition-=1;
    Log.i("CORRECT",Integer.toString(correctAnswer)+" "+Integer.toString(listPosition));
    int y;
    for(int i=0; i<ln.getChildCount(); i++)
    {
        Button b = (Button) ln.getChildAt(i);
        if (i==correctAnswer)
        {
//            Log.i("CORRECT",names.get(listPosition));
            b.setText(names.get(listPosition));
            q = s.get(names.get(listPosition));
//            imageView.setImageBitmap(null);
            imageView.setImageBitmap(q);
        }
        else
        {
            y=rand.nextInt(names.size());
//            y-=1;
            b.setText(names.get(y));
        }

    }
    }

    public void Check(View view) {
        Button b = (Button) view;
        try {
//            Log.i("CORRECT", (String) b.getTag());
            if (((String) b.getTag()).equals(Integer.toString(correctAnswer))) {
//                Log.i("CORRECT", "CORRECT");
                current++;
                total++;
                Toast.makeText(MainActivity.this,"Correct! "+Integer.toString(current)+"/"+Integer.toString(total),Toast.LENGTH_SHORT).show();
            }
            else
            {
                total++;
//                Log.i("CORRECT", "WRONG");
                Toast.makeText(MainActivity.this,"Wrong! "+Integer.toString(current)+"/"+Integer.toString(total),Toast.LENGTH_SHORT).show();
            }
            setButtons();
        }
        catch (Exception e){Log.i("CORRECT", e.toString());
        e.printStackTrace();}
    }
}
