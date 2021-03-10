package com.bucketlist.adapters;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bucketlist.R;

import com.bucketlist.activities.MainActivity;
import com.bucketlist.activities.MyListData;
import com.bucketlist.activities.TaskList;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<String> listdata;
    private Context mContext;
    String TAG="Adapter";
    public Adapter(ArrayList<String> myListData, Context context) {
        this.listdata=myListData;
        this.mContext=context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.linear_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String myListData = listdata.get(position);
        holder.textView.setText(listdata.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "BucketList"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,TaskList.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

//        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                Log.d(TAG, "onLongClick: true");
//               final Dialog alertDialog = new Dialog(mContext); //Read Update
//                alertDialog.setCancelable(false);
//                alertDialog.setContentView(R.layout.add_bucket_dialog);
//                /*WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//                lp.copyFrom(alertDialog.getWindow().getAttributes());
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//                lp.gravity = Gravity.CENTER;
//                alertDialog.getWindow().setAttributes(lp);*/
//                Button Submit=alertDialog.findViewById(R.id.Done);
//                Button Cancel=alertDialog.findViewById(R.id.Cancel);
//
//                final EditText BuckeName= alertDialog.findViewById(R.id.BucketNameEditText);
//                Cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        alertDialog.cancel();
//                    }
//                });
//                Submit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String bucketName= String.valueOf(BuckeName.getText());
//
//                        alertDialog.cancel();
//                    }
//                });
//                alertDialog.show();
//                return false;
//            }
//        });

/*
        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d(TAG, "onLongClick: ");

                return true;
            }
        });
*/




    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout linearLayout;
        public CardView cardView;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            linearLayout = itemView.findViewById(R.id.linear_layout_view);
            this.cardView=itemView.findViewById(R.id.card_view);

            if (!(this.cardView.getTranslationZ() ==20)){
                this.cardView.setTranslationZ(20);
            }


        }


    }
}
