import model.Produkte;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Service {

    private Repository<Produkte> produktRepository;

    public Service(Repository<Produkte> produktRepository) {
        this.produktRepository = produktRepository;
    }

    public List<Produkte> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    public void createAProdukt(String name,int preis, String jahreszeit){
        produktRepository.addElement(new Produkte(name,preis,jahreszeit));
    }

    public Produkte getProdukt(String name){
        int id = -1;
        for (Produkte p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }

    public void updateProdukt(Produkte produkt){
        for (Produkte p : produktRepository.getAllElements()){
            if (p.getName().equals(produkt.getName())){
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPreis(produkt.getPreis());
                p.setHerkunfstregion(produkt.getHerkunfstregion());
                produktRepository.updateElement(index,produkt);
                break;
            }
        }
    }

    public void deleteProdukt(String name){
        for (Produkte p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }

}
