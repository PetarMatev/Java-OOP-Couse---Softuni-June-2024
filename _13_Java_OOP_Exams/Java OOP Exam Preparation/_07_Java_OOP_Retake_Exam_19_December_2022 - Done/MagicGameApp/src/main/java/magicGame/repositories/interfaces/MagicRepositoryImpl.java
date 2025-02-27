package magicGame.repositories.interfaces;

import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

import static magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private Collection<Magic> magics;

    public MagicRepositoryImpl() {
        this.magics = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return this.magics;
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        this.magics.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return this.magics.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return this.magics.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
