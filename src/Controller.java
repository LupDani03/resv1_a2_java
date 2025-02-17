import model.Produkte;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleProdukteAnschreiben(){
        for (Produkte produkt: service.alleProdukteZuruckgeben())
            System.out.println(produkt);
    }

    public void createProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunfstregion");
        String herkunfstregion = sc.nextLine();

        service.createAProdukt(name, preis, herkunfstregion);
    }

    public void showAProdukt(){
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Produkte produkt = service.getProdukt(name);
        System.out.println(produkt);
    }

    public void updateProduktValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Herkunfstregion:");
        String herkunfstregion = sc.nextLine();

        service.updateProdukt(new Produkte(name, preis, herkunfstregion));
    }

    public void deleteProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteProdukt(name);
    }
}
