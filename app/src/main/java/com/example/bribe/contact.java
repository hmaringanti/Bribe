package com.example.bribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class contact extends AppCompatActivity {
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        e=(EditText)findViewById(R.id.editText);
    }
    public void submit(View v)
    {
        String data;
        data = e.getText().toString();
        if(data.equals(""))
        {
            Toast.makeText(this,"Enter the Suggestion or a Query",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"pavansai5557@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "");
            i.putExtra(Intent.EXTRA_TEXT, data);
            startActivity(Intent.createChooser(i, "Select the App"));
        }


    }
}
