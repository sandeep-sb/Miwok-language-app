package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String TAG = "WordAdapter";

    public WordAdapter(Context context, ArrayList<Word> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Check if existing view is being reused, otherwise inflate in the View
        View listitemView = convertView;
        if(listitemView == null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Get the data item for this position
        Word word = getItem(position);

        //Lookup View for data populate
        TextView tvMiwok = (TextView) listitemView.findViewById(R.id.miwok_text_view);
        TextView tvDeault = (TextView) listitemView.findViewById(R.id.default_text_view);

        //Populate the data into template View using data object
        tvMiwok.setText(word.getMiwoktWord());
        tvDeault.setText(word.getDefaultWord());

        //Return the completed view to render on the screen
        return listitemView;
    }
}
