package com.delta.honestgabe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.doubleclick.DfpAdView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
/**
 * Created by tom on 9/28/13.
 */
public class Honestanswer extends Activity {

    private ShareActionProvider mShareActionProvider;
    RelativeLayout mRelativeLayout;
    String MY_AD_UNIT_ID = "ca-app-pub-5357322922990776/3957375649";
    private DfpAdView adView;


    MediaPlayer mp = new MediaPlayer();
//    MediaPlayer boom = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ace);

        adView = new DfpAdView(this, AdSize.BANNER, MY_AD_UNIT_ID);
        adView.loadAd(new AdRequest());


        mp = MediaPlayer.create(this, R.raw.honestvoice);
//        boom = MediaPlayer.create(this, R.raw.boom);
        // Show the Up button in the action bar.


        String message = "OH NO!";
        Random rand = new Random();
        switch (Math.abs(rand.nextInt() % 62)) {
            case 0: message = "Get over yourself!";
                break;
            case 1: message = "Most likely.";
                break;
            case 2: message = "Hey these app don't make themselves how about a donation";
                break;
            case 3: message = "Hey you Rat";
                break;
            case 4: message = "Run you fool";
                break;
            case 5: message = "Spud that nail";
                break;
            case 6: message = "Let it ride";
                break;
            case 7: message = "I'm insulted you would ask me that";
                break;
            case 8: message = "When you got it, you got it, and you sir do NOT have it";
                break;
            case 9: message = "Get your mind straight and ask again";
                break;
            case 10: message = "Are you serious Clark?";
                break;
            case 11: message = "Get Legs!";
                break;
            case 12: message = "Just Shut Up and Put Your Head Down.";
                break;
            case 13: message = "Your a wonderful person but a bit strange";
                break;
            case 14: message = "Take a long look in the mirror";
                break;
            case 15: message = "If you have to ask you already know";
                break;
            case 16: message = "Ohh yeah";
                break;
            case 17: message = "Go with your gut";
                break;
            case 18: message = "Wallow in the mud with the pigs, or soar like an eagle?";
                break;
            case 19: message = "Grab a cold one and think it over";
                break;
            case 20: message = "Wow you need help";
                break;
            case 21: message = "You nailed that like a split Hog";
                break;
            case 22: message = "Maybe you should stop blaming others";
                break;
            case 23: message = "Life is for the living";
                break;
            case 24: message = "The winds of change are at hand";
                break;
            case 25: message = "Why did you ask me you already know";
                break;
            case 26: message = "Lay down with dogs, you'll get fleas";
                break;
            case 27: message = "Like moths to a flame";
                break;
            case 28: message = "You deserve it, treat yourself";
                break;
            case 29: message = "No, never you crazy";
                break;
            case 30: message = "There's something to be said for quiting";
                break;
            case 31: message = "Your just not cut out for it";
                break;
            case 32: message = "I think a staring contest with the wall would be better";
                break;
            case 33: message = "Sleep on it";
                break;
            case 34: message = "Can you see the finish line?";
                break;
            case 35: message = "Even a blind pig finds a nut once in a while";
                break;
            case 36: message = "Have you seen your bank account?";
                break;
            case 37: message = "If I could I would slap you";
                break;
            case 38: message = "Lasagna sounds good, yeah I have no idea";
                break;
            case 39: message = "Who do you think you are, Pocahontas";
                break;
            case 40: message = "Like fish in a barrel and your the fish";
                break;
            case 41: message = "Yes always yes";
                break;
            case 42: message = "I used to be like you, then I was Honest with myself";
                break;
            case 43: message = "Make mine a double";
                break;
            case 44: message = "Hey the world needs ditch diggers to";
                break;
            case 45: message = "Heavy is the crown";
                break;
            case 46: message = "Cash money";
                break;
            case 47: message = "If your ain't getting paid, your getting played";
                break;
            case 48: message = "How were the pyramids built?";
                break;
            case 49: message = "Go, be free, I emancipate you";
                break;
            case 50: message = "Don't shave for a few days,it put it all in prospective";
                break;
            case 51: message = "Really you would,... chauncy";
                break;
            case 52: message = "No,but think south of the border";
                break;
            case 53: message = "USA,USA,USA";
                break;
            case 54: message = "Have you tried not thinking about yourself for more then 2 seconds?";
                break;
            case 55: message = "Throw on a stovetop hat and ride out";
                break;
            case 56: message = "The most important person to be honest with is your self, so No!";
                break;
            case 57: message = "I put Wings Down!";
                break;
            case 58: message = "Wow your a piece of work";
                break;
            case 59: message = "No, no, no, no after all I've done for you";
                break;
            case 60: message = "Your lying to your self";
                break;
            case 61: message = "What would your mother say?";
                break;



        }
//        LinearLayout ll = new LinearLayout(this);
        TextView t = (TextView)findViewById(R.id.answer);
//        EditText et = (EditText) findViewById(R.id.ed1);
//        String str = et.getText().toString();
        t.setText(message);
        t.setTextColor(Color.WHITE);
//        t.setTextSize(45);
//
//
//        ll.addView(textView);
//        ll.setBackgroundColor(Color.BLACK);
        t.setGravity(Gravity.CENTER);
//        setContentView(ll);

        Button ask= (Button)findViewById(R.id.to_ask);
        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
                mp.stop();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();


            }


        });

    }
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.share, menu);

        MenuItem item = menu.findItem(R.id.menu_item_share);

        mShareActionProvider = (ShareActionProvider) item.getActionProvider();
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(createShareIntent());
        }



       // Return true to display menu
        return true;
    }
    private Intent createShareIntent() {
        Intent shareIntent = null;
       String a = new String("https://play.google.com/store/apps/details?id=com.delta.honestgabe&hl=en");
        // save to  cache out dir
        // put uri into extra_stream (uri = path +b filename)
        Uri b;

        b= createTempImageFile();
        if (b != null  ) {

            shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, b);
            shareIntent.putExtra(Intent.EXTRA_TEXT,a );
            //shareIntent.setType("image/png");
            shareIntent.setType("text/plain");
            shareIntent.setType("image/*");
            //startActivity(Intent.createCh

        } return shareIntent;

    }




    public Uri createTempImageFile() {
        {
            File direct = new File(Environment.getExternalStorageDirectory() + "/New Folder");

            if(!direct.exists())
            {
                direct.mkdir(); //directory is created;

            }

            // imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
            File outputDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) ;
            mRelativeLayout= (RelativeLayout)findViewById(R.id.advice);
            mRelativeLayout.setDrawingCacheEnabled(true);

// this is the important code :)
// Without it the view will have a dimension of 0,0 and the bitmap will be null
            mRelativeLayout.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            mRelativeLayout.layout(0, 0, mRelativeLayout.getMeasuredWidth(), mRelativeLayout.getMeasuredHeight());

            mRelativeLayout.buildDrawingCache(true);
            Bitmap rel = Bitmap.createBitmap(mRelativeLayout.getDrawingCache());
            mRelativeLayout.setDrawingCacheEnabled(false);


            String myPath;
            myPath = outputDir.getAbsolutePath() + File.separator + getPackageName() + File.separator;
            File newDirectory = new File(myPath);
            newDirectory.mkdirs();

            File imageBitmapFile = new File(myPath, "temp.jpg");
            FileOutputStream fileOutPutStream = null;
            Uri b = Uri.parse("file://" + imageBitmapFile.getAbsolutePath());
            try {

                fileOutPutStream = new FileOutputStream(imageBitmapFile);

                rel.compress(Bitmap.CompressFormat.JPEG, 80, fileOutPutStream);
                fileOutPutStream.flush();
                fileOutPutStream.close();
                return b; // result is OK
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null; // failure
        }

    }







}