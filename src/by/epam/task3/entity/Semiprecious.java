package by.epam.task3.entity;

public class Semiprecious extends GemType {
    private String name;
    private int transparency;
    private GemColor gemColor;

    public Semiprecious() {
        transparency = 100;
        gemColor = GemColor.COLORLESS;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Semiprecious that = (Semiprecious) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode() + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Semiprecious{");
        builder.append("name=").append(name);
        builder.append(", origin=").append(this.getOrigin());
        builder.append(", id=").append(this.getId());
        builder.append(", parameters=").append(this.getParameters());
        builder.append(", value=").append(this.getValue());
        builder.append(", date=").append(this.getDate());
        builder.append('}');
        return builder.toString();
    }
}
