package com.bucketlist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bucketlist.R;
import com.bucketlist.adapters.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBucket=findViewById(R.id.add_bucket);
        LinearLayout addBucketLayout=findViewById(R.id.add_bucket_layout);

        //Adding list data
        final ArrayList<String> myListData = new ArrayList<>();
        myListData.add("BucketList1");
        myListData.add("BucketList2");
        myListData.add("BucketList3");
        myListData.add("BucketList4");
        myListData.add("BucketList5");
        myListData.add("BucketList6");

        //setting adapter
        final Adapter adapter=new Adapter(myListData,getApplicationContext());
        final RecyclerView rec_view=findViewById(R.id.rec_view);
        rec_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rec_view.setHasFixedSize(true);
        rec_view.setAdapter(adapter);



        addBucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Dialog alertDialog = new Dialog(MainActivity.this); //Read Update
                alertDialog.setCancelable(false);
                alertDialog.setContentView(R.layout.add_bucket_dialog);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alertDialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;

                alertDialog.getWindow().setAttributes(lp);
                Button Submit=alertDialog.findViewById(R.id.Done);
                Button Cancel=alertDialog.findViewById(R.id.Cancel);

                final EditText BuckeName= alertDialog.findViewById(R.id.BucketNameEditText);
                Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String bucketName= String.valueOf(BuckeName.getText());
                            myListData.add(bucketName);
                            adapter.notifyDataSetChanged();
                            rec_view.smoothScrollToPosition(myListData.size()-1);
                            alertDialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });

    }




}
