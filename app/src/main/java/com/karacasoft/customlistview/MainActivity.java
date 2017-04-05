package com.karacasoft.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(i, 100);
            }
        });

        todoListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                todoList.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if(resultCode == RESULT_OK) {
                String title = data.getStringExtra(AddItemActivity.EXTRA_TITLE);
                String description = data.getStringExtra(AddItemActivity.EXTRA_DESCRIPTION);

                TodoListItem item = new TodoListItem();
                item.setText(title);
                item.setDescription(description);
                todoList.add(item);

                adapter.notifyDataSetChanged();
            }

        }

    }
}
