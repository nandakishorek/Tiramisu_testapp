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

import java.io.File;
import java.io.FileInputStream;

public class OnReadListener implements OnClickListener {

    private static final String TAG = OnReadListener.class.getName();

    private final EditText fileName;
    public Context mcontext = null;
    private final EditText mfileContent;

    public OnReadListener(Context context, EditText fName, EditText fileContent, ContentResolver _cr) {
        fileName = fName;
        mfileContent = fileContent;
        mcontext = context;
    }

    @Override
    public void onClick(View v) {
        String filename = fileName.getText().toString();
        int c;
        StringBuilder message = new StringBuilder();
        FileInputStream inputStream;
        mfileContent.setText("");
        /*
        File file = new File(filename);
        if (file.exists() == false) {
            mfileContent.setText("File not found");
            return;
        }*/

        try{
            inputStream =  mcontext.openFileInput(filename);
            while((c = inputStream.read())!= -1){
                message.append((char) c);
            }

            if(message != null) {
              mfileContent.setText(message.toString());
            }
        }
        catch(Exception ex)
        {
            Log.e(TAG, "Exception " + ex.toString());
        }
    }

}
