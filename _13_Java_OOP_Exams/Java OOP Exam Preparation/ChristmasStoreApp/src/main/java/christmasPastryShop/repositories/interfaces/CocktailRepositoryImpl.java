package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.ArrayList;
import java.util.Collection;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {

    private Collection<Cocktail> models;

    public CocktailRepositoryImpl() {
        this.models = new ArrayList<>();
    }
    @Override
    public Collection<Cocktail> getAll() {
        return null;
    }

    @Override
    public void add(Cocktail cocktail) {

    }

    @Override
    public Cocktail getByName(String name) {
        return null;
    }
}
