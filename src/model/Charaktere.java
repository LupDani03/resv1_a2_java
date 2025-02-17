package model;

import java.util.List;

public class Charaktere {
    int id;
    String name;
    String ort;
    List<Produkte> listeProdukte;

    public Charaktere(int id, String name, String ort, List<Produkte> listeProdukte) {
        this.id = id;
        this.name = name;
        this.ort = ort;
        this.listeProdukte = listeProdukte;
    }

    public Charaktere() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public List<Produkte> getListeProdukte() {
        return listeProdukte;
    }

    public void setListeProdukte(List<Produkte> listeProdukte) {
        this.listeProdukte = listeProdukte;
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ort='" + ort + '\'' +
                ", listeProdukte=" + listeProdukte +
                '}';
    }

    public boolean richtigeRegion(String herkunfstRegion) {
        for (Produkte p : this.listeProdukte) {
            if (p.getHerkunfstregion().equals(herkunfstRegion)) {
                return true;
            }
        }
        return false;
    }

}
