package com.example.bribe;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity  {
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rules(View v)
    {
        Intent i=new Intent(this,rules.class);
        startActivity(i);
    }
    public void contact(View e)
    {
        Intent c=new Intent(this,contact.class);
        startActivity(c);
    }
    public void about(View a)
    {
        Intent d=new Intent(this,about.class);
        startActivity(d);
    }
    public void register(View r)
    {
        Intent e=new Intent(this,complaint.class);
        startActivity(e);
    }

    public void terms(View k)
    {
        Intent e=new Intent(this,Terms.class);
        startActivity(e);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void rateMe() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp&hl=en_IN&showAllReviews=true" )));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp&hl=en_IN&showAllReviews=true")));   }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu resource file in your activity
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //code for item select event handling
        switch(item.getItemId()){
            case R.id.profile:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody="https://www.videoder.com/download/videoder-for-android";
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"ShareUsing"));
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(("http://www.facebook.com")));
                startActivity(intent);*/
                break;
            case R.id.settings:
                rateMe();
                break;
            case R.id.signout:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    }
