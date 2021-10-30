package by.epam.task3.entity;

import java.time.YearMonth;
public abstract class GemType {

    private static final String DEFAULT_VALUE = " ";

    private String origin;
    private String id;
    private VisualParameters parameters;
    private double value;
    private YearMonth date;


    public GemType(){
        origin="Russia";
        id=DEFAULT_VALUE;
        date=YearMonth.now();
        parameters = new VisualParameters();

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VisualParameters getParameters() {
        return parameters;
    }

    public void setParameters(VisualParameters parameters) {
        this.parameters = parameters;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public YearMonth getDate() {
        return date;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GemType gem = (GemType) o;
        return Double.compare(gem.value, value) == 0 &&
                origin.equals(gem.origin) &&
                parameters.equals(gem.parameters) &&
                date.equals(gem.date);
    }

    @Override
    public int hashCode() {
        int result = 11;
        Double value=this.value;
        result = result + (origin == null ? 0 : origin.hashCode()) +
                 parameters.hashCode() +
                 value.hashCode() +
                 date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Gem{");
        builder.append("origin=").append(origin);
        builder.append(", parameters=").append(parameters);
        builder.append(", value=").append(value);
        builder.append(", date=").append(date);
        builder.append('}');
        return builder.toString();
    }
}
