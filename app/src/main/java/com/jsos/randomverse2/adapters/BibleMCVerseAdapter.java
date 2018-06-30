/***
 * VerseAdapter.java: A custom adapter for creating Verse list views
 * @Author: Jhesed Tacadena
 * @Date: November 2016
 * */

package com.jsos.randomverse2.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private ArrayList<Verse> verseList = new ArrayList<Verse>();

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
        this.verseList = verseList;
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

        final CheckBox cb = (CheckBox) view.findViewById(R.id.checkBoxMemorized);

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
                    if (!checkboxStates.get(position))
                        showVerificationDialog(position, cb);
                } else {
                    checkboxStates.set(position, false);
            }
                updateStatus();
            }
        });

        cb.setChecked(checkboxStates.get(position));

        return view;
    }

    private void showVerificationDialog(final int position, final CheckBox cb) {
        /*
         Displays dialog box of developer information
         */

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Get the layout inflater
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View layout = inflater.inflate(R.layout.dialog_memorization_check, null);

        TextView dialogTitle = (TextView) layout.findViewById(R.id.dialogTitle);
        dialogTitle.setText(verseList.get(position).name);

        builder.setView(layout);
        //        builder.setNegativeButton("OK", null);
        final AlertDialog dialog = builder.create();

        /* Events */
        Button okButton = (Button) layout.findViewById(R.id.dialogOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText content = (EditText) layout.findViewById(R.id.memorization_content);
                String contentText = content.getText().toString();

                // TODO: Optimize regex
                String actualAnswer = contentText.replaceAll(
                        "[\\p{Punct}]", "").replaceAll("\\s", "").toLowerCase();
                String expectedNIVAnswer = verseList.get(position).contentEnglish.replaceAll(
                        "[\\p{Punct}]", "").replaceAll("\\s", "").toLowerCase();
                String expectedMBBAnswer = verseList.get(position).contentFilipino.replaceAll(
                        "[\\p{Punct}]", "").replaceAll("\\s", "").toLowerCase();

                if (!actualAnswer.equals(expectedMBBAnswer) &&
                        !actualAnswer.equals(expectedNIVAnswer)) {

                    TextView incorrectText = (TextView) layout.findViewById(R.id.incorrect_text);
                    incorrectText.setVisibility(View.VISIBLE);
                    checkboxStates.set(position, false);
                    cb.setChecked(checkboxStates.get(position));
                } else {
                    checkboxStates.set(position, true);
                    updateStatus();
                    cb.setChecked(checkboxStates.get(position));
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        ImageView cancelButton = (ImageView) layout.findViewById(R.id.cancel_icon);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkboxStates.set(position, false);
                cb.setChecked(checkboxStates.get(position));
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void updateStatus() {

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

    private static class ViewHolder {
        /**
         * Private class for recyclable information
         */
        int verseId;
        TextView verseName;
    }
}