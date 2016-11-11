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
import java.io.*;

public class onMakeDirListener implements OnClickListener {

    private static final String TAG = onMakeDirListener.class.getName();

    private final EditText textBox;
    public Context mContext = null;
    public onMakeDirListener(Context context, EditText textbox, ContentResolver _cr) {
        textBox = textbox;
        mContext = context;
    }

    @Override
    public void onClick(View v) {
      File file = mContext.getFilesDir();
      String path = file.getAbsolutePath();
      File dir = new File(path+ "/"+ textBox.getText());
        if(!dir.exists())
            dir.mkdir();

        textBox.setText("");
    }

}
