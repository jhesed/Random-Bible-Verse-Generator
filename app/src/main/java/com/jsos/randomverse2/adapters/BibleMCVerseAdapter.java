/***
 * VerseAdapter.java: A custom adapter for creating Verse list views
 * @Author: Jhesed Tacadena
 * @Date: November 2016
 * */

package com.jsos.randomverse2.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jsos.randomverse2.BibleMCActivity;
import com.jsos.randomverse2.BibleMCDetailsActivity;
import com.jsos.randomverse2.R;
import com.jsos.randomverse2.models.Verse;

import java.util.ArrayList;

public class BibleMCVerseAdapter extends ArrayAdapter<Verse> {

    /* SECTION: Variable Declarations */

    private final String TAG = "verseListAdapter";
    private final Context context;
    private ArrayList<Boolean> checkboxStates = new ArrayList<Boolean>();

    public BibleMCVerseAdapter(Context context, ArrayList<Verse> verseList, int[] oldStatuses) {
        super(context, R.layout.activity_bible_memorization_verse_list, verseList);
        this.context = context;

        for (int i = 0; i < this.getCount(); i++) {
            checkboxStates.add(i, false);
        }
        if (oldStatuses != null) {
            for (int j = 0; j < oldStatuses.length; j++) {
                checkboxStates.set(oldStatuses[j], true);
            }
        }
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        /*
         * Overrides parent for retrieving view
         * */

        View view = convertView;
        final ViewHolder viewHolder;
        Verse verse = getItem(position);

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_bible_memorization_verse_list, null);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.verseId = verse.id;
        viewHolder.verseName = (TextView) view.findViewById(R.id.verseItem);
        viewHolder.verseName.setText(verse.name);

        view.setTag(viewHolder);
        view.setLongClickable(true);

        CheckBox cb = (CheckBox) view.findViewById(R.id.checkBoxMemorized);
//        cb.setChecked(checkboxStates.get(position));


        /* SECTION : Events */

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BibleMCDetailsActivity.class);
                intent.putExtra("verseId", viewHolder.verseId);
                context.startActivity(intent);
            }
        });

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    checkboxStates.set(position, true);
                } else {
                    checkboxStates.set(position, false);
                }

                String toStore = "";
                for (int i = 0; i < checkboxStates.size(); i++) {
                    if (checkboxStates.get(i)) {
                        toStore += i + ",";
                    }
                }

                // Update stored shared preference
                SharedPreferences.Editor prefsEditor = BibleMCActivity.getActivitySharedPreferencesEditor();
                prefsEditor.putString("checkbox_states", toStore.equals("") ? null
                        : toStore.substring(0, toStore.length() - 1));
                prefsEditor.commit();
            }
        });
        cb.setChecked(checkboxStates.get(position));

        return view;
    }

    public ArrayList<Boolean> getCheckedStatus() {
        return checkboxStates;
    }

    private static class ViewHolder {
        /**
         * Private class for recyclable information
         */
        int verseId;
        TextView verseName;
    }
}