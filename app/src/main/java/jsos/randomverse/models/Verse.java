package jsos.randomverse.models;

/**
 * Created by Jhesed 2016/12/19
 */
public class Verse {
    public int id;
    public String name;
    public String content;

    public Verse(int id, String verse, String content) {
        this.id = id;  // index in array
        this.name = verse;
        this.content = content;
    }
}
