package com.karacasoft.customlistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mahmutkaraca on 4/5/17.
 */

public class CustomListAdapter extends ArrayAdapter<TodoListItem> {

    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<TodoListItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(convertView == null) {
            LayoutInflater inf = LayoutInflater.from(getContext());
            v = inf.inflate(R.layout.list_item_todo, parent, false);
        }
        TodoListItem item = getItem(position);

        TextView txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        TextView txtDesc = (TextView) v.findViewById(R.id.txtDesc);

        if(item != null) {
            txtTitle.setText(item.getText());
            txtDesc.setText(item.getDescription());
        }

        return v;
    }
}
