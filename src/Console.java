import model.Produkte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Produkte CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("""
                            1. Neues Produkte hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkte finden
                            4. Ein Produkte aktualisieren
                            5. Ein Produkte loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createProdukt(); break;}
                        case 2: {controller.alleProdukteAnschreiben(); break;}
                        case 3: {controller.showAProdukt(); break;}
                        case 4: {controller.updateProduktValidate(); break;}
                        case 5: {controller.deleteProdukt(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkte> produktRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(produktRepository);

        Service service = new Service(produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Produkte> produktRepository) {
        Produkte produkt1 = new Produkte("Wheat",50,"Riverlands");
        Produkte produkt2 = new Produkte("Iron",100,"Iron Islands");
        Produkte produkt3 = new Produkte("Wood",125,"Stormlands");
        Produkte produkt4 = new Produkte("Leather",75,"Westerlands");
        Produkte produkt5 = new Produkte("Coal",50,"Westerlands");
        Produkte produkt6 = new Produkte("Corn",75,"Riverlands");
        Produkte produkt7 = new Produkte("Gold",500,"Iron Islands");

        produktRepository.addElement(produkt1);
        produktRepository.addElement(produkt2);
        produktRepository.addElement(produkt3);
        produktRepository.addElement(produkt4);
        produktRepository.addElement(produkt5);
        produktRepository.addElement(produkt6);
        produktRepository.addElement(produkt7);
    }
}
