package jsos.randomverse.models;

/**
 * Created by Jhesed 2016/12/19
 */
public class Verse {
    public int id;
    public String name;
    public String contentEnglish;
    public String contentFilipino;

    public Verse(int id, String verse, String contentEnglish, String contentFilipino) {
        this.id = id;  // index in array
        this.name = verse;
        this.contentEnglish = contentEnglish;
        this.contentFilipino = contentFilipino;
    }
}
