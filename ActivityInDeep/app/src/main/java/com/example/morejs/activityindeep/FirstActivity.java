package com.example.morejs.activityindeep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ListView listView = (ListView) findViewById(R.id.myListView);
        final EditText editText = (EditText) findViewById(R.id.myEditText);

        final ArrayList<String> todoItems = new ArrayList<String>();

        final ArrayAdapter<String> aa;

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        listView.setAdapter(aa);

        editText.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                        todoItems.add(0, editText.getText().toString());
                        aa.notifyDataSetChanged();
                        editText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        //TextView myTextView = new TextView(this);
        //myTextView.setText("hello,more js.");
        //setContentView(myTextView);

    }


}
