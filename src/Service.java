import model.Charaktere;
import model.Produkte;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private Repository<Produkte> produktRepository;
    private Repository<Charaktere> charaktereRepository;

    public Service(Repository<Charaktere> charaktereRepository, Repository<Produkte> produktRepository) {
        this.charaktereRepository = charaktereRepository;
        this.produktRepository = produktRepository;
    }

    public List<Charaktere> alleCharakterenZuruckgeben() {
        return charaktereRepository.getAllElements();
    }

    public List<Produkte> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    public void createAProdukt(String name, int preis, String jahreszeit) {
        produktRepository.addElement(new Produkte(name, preis, jahreszeit));
    }

    public Produkte getProdukt(String name) {
        int id = -1;
        for (Produkte p : produktRepository.getAllElements()) {
            if (p.getName().equals(name)) {
                id = produktRepository.getAllElements().indexOf(p);
                break;
            }
        }
        return produktRepository.getElement(id);
    }

    public void updateProdukt(Produkte produkt) {
        for (Produkte p : produktRepository.getAllElements()) {
            if (p.getName().equals(produkt.getName())) {
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPreis(produkt.getPreis());
                p.setHerkunfstregion(produkt.getHerkunfstregion());
                produktRepository.updateElement(index, produkt);
                break;
            }
        }
    }

    public void deleteProdukt(String name) {
        for (Produkte p : produktRepository.getAllElements()) {
            if (p.getName().equals(name)) {
                produktRepository.remove(p);
                break;
            }
        }
    }

    public void createACharaktere(String name, String ort) {
        int id = -1;
        for (Charaktere k : charaktereRepository.getAllElements()) {
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;

        charaktereRepository.addElement(new Charaktere(id, name, ort, new ArrayList<>()));
    }

    public Charaktere getCharaktere(int id) {
        for (Charaktere p : charaktereRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Charaktere nicht gefunden");
    }

    public void updateCharaktere(Charaktere Charaktere) {
        for (Charaktere p : charaktereRepository.getAllElements()) {
            if (p.getId() == Charaktere.getId()) {
                int index = charaktereRepository.getAllElements().indexOf(p);
                p.setName(Charaktere.getName());
                p.setOrt(Charaktere.getOrt());
                charaktereRepository.updateElement(index, p);
                break;
            }
        }
    }

    public void deleteCharaktere(int id) {
        for (Charaktere p : charaktereRepository.getAllElements()) {
            if (p.getId() == id) {
                charaktereRepository.remove(p);
                break;
            }
        }
    }


    public List<Charaktere> filterNachOrt(String ort) {
        List<Charaktere> charaktereList = new ArrayList<>();
        charaktereList = charaktereRepository.getAllElements().stream().filter(Charaktere -> ort.equals(Charaktere.getOrt())).toList();

        return charaktereList;
    }
}
