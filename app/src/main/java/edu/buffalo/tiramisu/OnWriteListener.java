package edu.buffalo.tiramisu;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;


import static android.os.ParcelFileDescriptor.MODE_APPEND;

public class OnWriteListener implements OnClickListener {

    private static final String TAG = OnWriteListener.class.getName();

    private final EditText fileName;
    private final EditText fileContent;
    public Context mContext;
    public OnWriteListener(Context context, EditText fName, EditText fContent, ContentResolver _cr) {
        fileName = fName;
        fileContent = fContent;
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        String filename = fileName.getText().toString();
        String text = fileContent.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            Log.e("Tiramisu", "Content provider insert failed");
        }
        fileName.setText("");
        fileContent.setText("");
    }

}
