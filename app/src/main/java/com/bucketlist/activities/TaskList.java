package com.bucketlist.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bucketlist.R;
import com.bucketlist.adapters.Adapter;
import com.bucketlist.adapters.TaskListAdapter;

public class TaskList extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list_view);
        getIntent();
        MyListData[] myTaskListData = new MyListData[] {
                new MyListData("Task 1"),
                new MyListData("Task 2"),
                new MyListData("Task 3"),
                new MyListData("Task 4"),
                new MyListData("Task 5"),
                new MyListData("Task 6"),
                new MyListData("Task 7"),
                new MyListData("Task 8"),
                new MyListData("Task 9"),
                new MyListData("Task 10")};
        TaskListAdapter TaskListAdapter=new TaskListAdapter(myTaskListData,getApplicationContext());
        RecyclerView task_list_rec_view=findViewById(R.id.task_list_rec);

        task_list_rec_view.setLayoutManager (new LinearLayoutManager(getApplicationContext()));
        task_list_rec_view.setHasFixedSize(true);
        task_list_rec_view.setAdapter(TaskListAdapter);
    }




}
