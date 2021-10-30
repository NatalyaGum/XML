package by.epam.task3.builder;

import by.epam.task3.entity.GemType;
import by.epam.task3.exception.GemException;

import java.util.HashSet;
import java.util.Set;

public abstract class GemBuilder {
    protected Set<GemType> gems;

    public GemBuilder() {
        gems = new HashSet<>();
    }

    public Set<GemType> getGems() {
        return gems;
    }

    public abstract void buildSetGems(String filename) throws GemException;
}



