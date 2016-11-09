package jsos.randomverse.db;

import android.provider.BaseColumns;

/**
 * Created by JHESE154 on 8/22/2016.
 */
public class VerseContract {


    public static final String DB_NAME = "jsos.randomverse.db.VerseDAO";
    public static final int DB_VERSION = 1;
    public static final int VERSE_COUNT = 2;  // Update this everytime. Used this instead of DB call for faster return

    public class VerseEntry implements BaseColumns {
        public static final String TABLE = "bible_verse";

        // properties
        public static final String COL_NAME = "name"; // i.e. Genesis 1:1 - always camel case
        public static final String COL_CONTENT_ENG_NIV = "content_english_niv";
        public static final String COL_CONTENT_FIL_MB = "content_filipino_mbb";

        public static final String COL_IS_FAVORITE = "is_favorite";

        // dates and modifications
        public static final String COL_DATE_CREATED = "date_created";
        public static final String COL_DATE_MODIFIED = "date_modified";

    }

}
