package com.delta.honestgabe;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    MediaPlayer mp= new MediaPlayer();

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.hvoice);


        mp.start();




        Button talk= (Button)findViewById(R.id.button);
        talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();

               i =new Intent(getApplicationContext(),Honestanswer.class);
                startActivity(i);
                finish();



            }


        });







    }




    public void PickGalleryImage(){
        Intent go = new Intent(getApplicationContext(),About.class);
        startActivity(go);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.gallery_button:
                PickGalleryImage();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        { //Back key pressed
            //Things to Do
            if(mp!= null)
            {
                mp.stop();
               mp=null;
            }
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;

            }

        }
