package edu.buffalo.tiramisu;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.*;

public class onListFilesListener implements OnClickListener {

    private static final String TAG = onListFilesListener.class.getName();

    private final TextView tView;
    public Context mContext = null;
    public onListFilesListener(Context context, TextView textview, ContentResolver _cr) {
        tView = textview;
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        tView.setText("");
        File file = mContext.getFilesDir() ;
        ListFiles(file,"");

    }
    public void ListFiles(File file, String prefix){
                File[] list = file.listFiles();
                if(list == null || list.length == 0)
                    return;
                for(File f : list){
                    String level = prefix;
                    if(!f.isDirectory()){
                        tView.append("\n" + prefix + f.getName());
                    }
                    else
                    {
                        prefix = prefix + "\t";
                        String text = "<font color=#cc0029>" + "<br/>" +prefix +f.getName() + "</font>";
                        tView.append(Html.fromHtml(text));
                        ListFiles(f, prefix);
                    }
                    prefix = level;
        }

    }

}
