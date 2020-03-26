package com.app.downloadimage;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.downloadimage.Classes.DownloadImage;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    public void Download_Image(View view) throws ExecutionException, InterruptedException {
        //https://assets3.sportsnet.ca/wp-content/uploads/2019/04/cristiano-ronaldo-celebrates-goal-for-juventus-1040x572.jpg
        DownloadImage downloadImage = new DownloadImage();
        Bitmap x =downloadImage.execute("https://m.media-amazon.com/images/M/MV5BMjExODkxODU3NF5BMl5BanBnXkFtZTgwNTM0MTk3NjE@._V1_UY209_CR5,0,140,209_AL_.jpg").get();
        imageView.setImageBitmap(x);
    }
}
