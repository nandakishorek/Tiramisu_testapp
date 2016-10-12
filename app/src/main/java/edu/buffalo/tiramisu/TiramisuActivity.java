package edu.buffalo.tiramisu;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class TiramisuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiramisu);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setMovementMethod(new ScrollingMovementMethod());

        final EditText fileName = (EditText) findViewById(R.id.editText);
        final EditText fileContent = (EditText) findViewById(R.id.editText2);
        //Write
        findViewById(R.id.button).setOnClickListener(
                new OnWriteListener(getApplicationContext(), fileName,fileContent, getContentResolver()));

        //Delete
        findViewById(R.id.button2).setOnClickListener(
                new OnDeleteListener(getApplicationContext(), fileName, getContentResolver()));
        //Read
        findViewById(R.id.button3).setOnClickListener(
                new OnReadListener(getApplicationContext(), fileName, fileContent, getContentResolver()));

        //Append
        findViewById(R.id.button4).setOnClickListener(
                new onAppendListener(getApplicationContext(), fileName,fileContent,getContentResolver()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_tiramisu, menu);
        return true;
    }

    }

