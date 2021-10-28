package by.epam.task3.builder;

import by.epam.task3.entity.Gem;
import by.epam.task3.exception.GemException;

import java.util.HashSet;
import java.util.Set;

public abstract class GemBuilder {
    protected Set<Gem> gems;

    public GemBuilder() {
        gems = new HashSet<>();
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public abstract void buildSetGems(String filename) throws GemException;
}



