package model;

public class Produkte implements Comparable {
    String name;
    int preis;
    String herkunfstregion;

    public Produkte(String name, int preis, String herkunfstregion) {
        this.name = name;
        this.preis = preis;
        this.herkunfstregion = herkunfstregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getHerkunfstregion() {
        return herkunfstregion;
    }

    public void setHerkunfstregion(String herkunfstregion) {
        this.herkunfstregion = herkunfstregion;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "Name='" + name + '\'' +
                ", Preis=" + preis +
                ", Herkunfstregion='" + herkunfstregion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getPreis() - ((Produkte) o).getPreis();
    }
}
