package com.example.morejs.activityindeep;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import  com.example.morejs.activityindeep.onNewItemAddedListener;
/**
 * Created by morejs on 16/9/17.
 */
public class NewItemFragment extends Fragment {
    private onNewItemAddedListener onNewItemAdded;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onNewItemAdded = (onNewItemAddedListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnNewItemAddedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editor_fragment, container, false);

        final EditText editText;
        editText = (EditText)view.findViewById(R.id.myEditTextTemp);

        editText.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                        String newItem = editText.getText().toString();
                        onNewItemAdded.onNewItemAdded(newItem);
                        editText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        return view;
    }
}
