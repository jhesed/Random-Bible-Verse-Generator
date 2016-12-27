package jsos.randomverse.adapters;

/**
 * Created by Jhesed on 8/4/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import jsos.randomverse.R;
import jsos.randomverse.VerseDetailsActivity;
import jsos.randomverse.VerseListActivity;
import jsos.randomverse.models.Verse;

public class VerseAdapter extends ArrayAdapter<Verse> {
    /**
     * A custom List Adapter to handle verse objects
     * */

    private final String TAG = "verseListAdapter";
    private final Context context;
    private final ArrayList<Verse> verse;

    public VerseAdapter(Context context, ArrayList<Verse> verse) {
        /**
         * Constructor to initialize verseListAdapter
         */

        super(context, R.layout.activity_verse_list, verse);
        Log.d(TAG, "Initialization");
        this.context = context;
        this.verse = verse;
    }

    private static class ViewHolder {
        /**
         * Private class for recyclable information
         * */
        TextView verseName;
        TextView verseContent;
    }

    public View getView(int position, View view, ViewGroup parent) {
        /**
         * Overrides parent for retrieving view
         * */
        Log.d(TAG, "Initializing getView");
        // Initialization
        Verse verse = getItem(position);
        ViewHolder viewHolder;
        viewHolder = new ViewHolder();
        view = LayoutInflater.from(getContext()).inflate(R.layout.activity_verse_list, null, true);

        Log.d(TAG, "Retrieved verse: " + verse.name);

        // Lookup view for data population
        viewHolder.verseName = (TextView) view.findViewById(R.id.verseItem);
        //viewHolder.verseContent = (TextView) view.findViewById(R.id.verseContent);

        // Populate the data into the template view using the data object
        Log.d(TAG, "VERSE NAME: " + verse.name);
        viewHolder.verseName.setText(verse.name);
        // viewHolder.verseContent.setText(verse.content);

        view.setTag(verse);
        view.setLongClickable(true);

        // TODO: Optimize using code below! (which does not work)


        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Verse verse = (Verse) view.getTag();
                Intent intent = new Intent(context, VerseDetailsActivity.class);
                intent.putExtra("verseId", verse.id);
                context.startActivity(intent);
            }
        });
        return view;
    };

    public Verse get(int position) {
        /**
         * Retrieves verse object based on ArrayList of verses
         * @param position: Index position to be retrieved
         * */
        return verse.get(position);
    }
}