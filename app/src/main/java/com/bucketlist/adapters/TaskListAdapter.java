package com.bucketlist.adapters;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bucketlist.R;

import com.bucketlist.activities.MyListData;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {




    MyListData[] taskListData;
    Context mcontext;
    String TAG="TaskListAdapter";
    public TaskListAdapter(MyListData[] myListData, Context context) {
        this.taskListData =myListData;
        this.mcontext =context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View taskListItem= layoutInflater.inflate(R.layout.task_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(taskListItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MyListData myTaskListData = taskListData[position];
        holder.taskView.setText(taskListData[position].getData());
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
        return taskListData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout layout;
        public TextView taskView;
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(View itemView) {
            super(itemView);
           this.layout=(ConstraintLayout) itemView.findViewById(R.id.task_layout);
            this.taskView=itemView.findViewById(R.id.task_view);
        }


    }
}
