package by.epam.task3.entity;

public class Precious extends GemType {
    private int transparency;
    private GemColor gemColor;
    private Name name;

    public Precious() {
        transparency = 100;
        gemColor = GemColor.COLORLESS;
        name=Name.DIAMOND;
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public GemColor getGemColor() {
        return gemColor;
    }

    public void setGemColor(GemColor gemColor) {
        this.gemColor = gemColor;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Precious precious = (Precious) o;
        return name.equals(precious.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode() + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Precious{");
        builder.append("name=").append(name.getTitle());
        builder.append(", origin=").append(this.getOrigin());
        builder.append(", id=").append(this.getId());
        builder.append(", parameters=").append(this.getParameters());
        builder.append(", value=").append(this.getValue());
        builder.append(", date=").append(this.getDate());
        builder.append('}');
        return builder.toString();
    }
}