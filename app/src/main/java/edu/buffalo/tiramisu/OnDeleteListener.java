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

public class OnDeleteListener implements OnClickListener {

    private static final String TAG = OnDeleteListener.class.getName();

    public Context mContext = null;

    private final EditText fileName;

    public OnDeleteListener(Context context, EditText fName, ContentResolver _cr) {
        mContext = context;
        fileName = fName;
    }

    @Override
    public void onClick(View v) {
        try {
            mContext.deleteFile(fileName.getText().toString());
        }catch(Exception e){
            Log.e(TAG, "Content provider delete failed");
        }
        fileName.setText("");
    }

}
