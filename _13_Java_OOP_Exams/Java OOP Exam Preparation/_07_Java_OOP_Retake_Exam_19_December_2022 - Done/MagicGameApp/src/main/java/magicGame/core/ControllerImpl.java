package magicGame.core;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGIC;
import static magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN;

public class ControllerImpl implements Controller {

    private MagicRepositoryImpl magicRepository;
    private MagicianRepositoryImpl magicianRepository;
    private RegionImpl region;

    public ControllerImpl() {
        this.magicRepository = new MagicRepositoryImpl();
        this.magicianRepository = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;
        switch (type) {
            case "RedMagic":
                magic = new RedMagic(name, bulletsCount);
                break;
            case "BlackMagic":
                magic = new BlackMagic(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }
        magicRepository.addMagic(magic);
        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magician magician;

        Magic magic = magicRepository.findByName(magicName);
        if (magic == null){
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        switch (type) {
            case "Wizard":
                magician = new Wizard(username, health, protection, magic);
                break;
            case "BlackWidow":
                magician = new BlackWidow(username, health, protection, magic);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }
        magicianRepository.addMagician(magician);
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        Collection<Magician> aliveMagicians = magicianRepository
                .getData()
                .stream()
                .filter(magician -> magician.isAlive())
                .collect(Collectors.toList());
        String result = region.start(aliveMagicians);
        return result;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        Collection<Magician> magicians = magicianRepository.getData();
        magicians.stream().sorted(Comparator
                .comparingInt(Magician::getHealth)
                .thenComparing(Magician::getUsername)
                .thenComparing(magician -> magician.getClass().getSimpleName()))
                .forEach(magician -> {
                    sb.append(String.format("%s: %s", magician.getClass().getSimpleName(), magician.getUsername())).append(System.lineSeparator());
                    sb.append(String.format("Health: %d", magician.getHealth())).append(System.lineSeparator());
                    sb.append(String.format("Protection: %d", magician.getProtection())).append(System.lineSeparator());
                    sb.append(String.format("Magic: %s", magician.getMagic().getName())).append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}
