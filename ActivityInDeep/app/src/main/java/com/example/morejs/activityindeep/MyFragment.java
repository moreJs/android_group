package com.example.morejs.activityindeep;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by morejs on 16/9/17.
 */
public class MyFragment extends Activity implements onNewItemAddedListener {

    private ArrayAdapter<String> aa;
    private ArrayList<String> todoItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_fragment);

        FragmentManager fm = getFragmentManager();

        ToDoListFragment toDoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.ToDoListFragment);

        todoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        toDoListFragment.setListAdapter(aa);

    }
    public void onNewItemAdded(String newItem) {
        todoItems.add(newItem);
        aa.notifyDataSetChanged();
    }
}
