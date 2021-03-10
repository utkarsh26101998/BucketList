package com.bucketlist.utilities;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

import com.bucketlist.R;
import com.bucketlist.activities.MainActivity;

public class customDialog {


    public  customDialog(Context context, @LayoutRes int layoutResID, @IdRes int ok, @IdRes int cancel, @IdRes int editText) {
       final android.app.Dialog dialog = new android.app.Dialog(context); //Read Update
       dialog.setContentView(layoutResID);
       WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
       lp.copyFrom(dialog.getWindow().getAttributes());
       lp.width = WindowManager.LayoutParams.MATCH_PARENT;
       lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
       lp.gravity = Gravity.CENTER;

       dialog.getWindow().setAttributes(lp);
       Button Submit=dialog.findViewById(ok);
       Button Cancel=dialog.findViewById(cancel);

       final EditText editTextName= dialog.findViewById(editText);
       Cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.cancel();
           }
       });
       Submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               dialog.cancel();
           }
       });
    }
}
