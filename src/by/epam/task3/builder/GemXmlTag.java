package by.epam.task3.builder;

public enum GemXmlTag {
    GEMS("gems"),
    PRECIOUS("precious"),
    SEMIPRECIOUS("semiprecious"),
    NAME("name"),
    ORIGIN("origin"),
    ID("id"),
    COLOR("color"),
    TRANSPARENCY("transparency"),
    CUT("cut"),
    VALUE("value"),
    DATE_OF_PROCESSING("date-of-processing"),
    VISUAL_PARAMETERS("visual-parameters");

    private String title;

    /*private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';*/

    GemXmlTag(String title) {
        this.title = title;
    }

    public String getTitle() {
        /*String title = this.name();
        title = title.toLowerCase();
        title = title.replace(UNDERSCORE, HYPHEN);*/
        return title;

    }

}
