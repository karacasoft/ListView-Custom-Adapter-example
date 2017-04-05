package com.karacasoft.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<TodoListItem> todoList = new ArrayList<>();

    private ListView todoListView;
    private Button btnAdd;

    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListView = (ListView) findViewById(R.id.listViewTodo);

        btnAdd = (Button) findViewById(R.id.btnAdd);

        TodoListItem item1 = new TodoListItem();
        item1.setText("Todo uygulaması yazılacak");
        item1.setDescription("TodoList uygulaması için modüller hazır olmalı...");
        todoList.add(item1);
        TodoListItem item2 = new TodoListItem();
        item2.setText("Başka şeyler yapılacak");
        item2.setDescription("Başka başka :V ...");
        todoList.add(item2);

        adapter = new CustomListAdapter(this, R.layout.list_item_todo, todoList);

        todoListView.setAdapter(adapter);

    }
}
