package by.epam.task3.entity;

public enum Name {
    ALEXANDRITE("alexandrite"),
    DIAMOND("diamond"),
    EMERALD("emerald"),
    RUBY("ruby"),
    SAPPHIRE("sapphire"),
    CHRYSOBERYL("chrysoberyl"),
    SPINEL("spinel");

    private String title;

    Name(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
