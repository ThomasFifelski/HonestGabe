package com.delta.honestgabe;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tom on 10/2/13.
 */
public class About extends Activity {
    MediaPlayer union = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        union = MediaPlayer.create(this, R.raw.aboutsong);


       union.start();


        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Button face = (Button) findViewById(R.id.www);
        face.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                union.stop();
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/pages/Honest-Industries/573517519351236?ref=br_tf"));
                startActivity(myWebLink);
            }
        });

        Button m = (Button)findViewById(R.id.email);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                union.stop();
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

/* Fill it with Data */
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"honestindustries.co@gmail.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Honest Feedback");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Dear Honest,");

/* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));

            }
        });


        Button btn = (Button) findViewById(R.id.payPal);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                union.stop();
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=HonestIndustries%2eco%40gmail%2ecom&lc=US&item_name=Honest%20Industries&item_number=1987&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest"));
                startActivity(myWebLink);
            }
        });
        String creator = new  String("Tom Fifelski");
        final TextView text = (TextView) findViewById(R.id.tom);
        text.setText(creator);

        String so = new  String("Honest Industries"+", "+"the Delta Program"+", "+"Dude's Paradise"+", "+"T.G."+", "+"History of the U.S.A"+", "+"Mike Cooley"+", "+"Big earl" +", "+ "The Cave Productions");
        final TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(so);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        { //Back key pressed
            //Things to Do
            if(union!= null)
            {
               union.stop();
                union=null;
            }
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                union.stop();
                // app icon in action bar clicked; go home
                Intent intentHome = new Intent(this, MainActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentHome);
                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

