package edu.buffalo.tiramisu;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;

public class onAppendListener implements OnClickListener {

    private static final String TAG = onAppendListener.class.getName();

    private final EditText fileName;
    private final TextView fileText;
    public Context mContext = null;
    public onAppendListener(Context context, EditText fName, EditText fText, ContentResolver _cr) {
        fileName = fName;
        fileText = fText;
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        String filename = fileName.getText().toString();
        String text = fileText.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = mContext.openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            Log.e("Tiramisu", "Content provider insert failed");
        }
    }

}
