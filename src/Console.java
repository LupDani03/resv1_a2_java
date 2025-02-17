import model.Charaktere;
import model.Produkte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }

    public Console() {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            System.out.println("""
                    1. Alles anschreiben
                    2. Produkt CRUD
                    3. Charaktere CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    controller.alleCharakterenAnschreiben();
                    controller.alleProdukteAnschreiben();
                    break;
                }
                case 2: {
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
                        case 1: {
                            controller.createProdukt();
                            break;
                        }
                        case 2: {
                            controller.alleProdukteAnschreiben();
                            break;
                        }
                        case 3: {
                            controller.showAProdukt();
                            break;
                        }
                        case 4: {
                            controller.updateProduktValidate();
                            break;
                        }
                        case 5: {
                            controller.deleteProdukt();
                            break;
                        }
                        case 0:
                            break;
                    }
                }
                case 3: {
                    System.out.println("""
                            1. Neuer Charaktere hinzufugen
                            2. Alle Charakteren sehen
                            3. Einen bestimmten Charakteren finden
                            4. Einen Charakteren aktualisieren
                            5. Einen Charakteren loschen
                            6. Charakteren nach Ort filtrieren
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {
                            controller.createCharaktere();
                            break;
                        }
                        case 2: {
                            controller.alleCharakterenAnschreiben();
                            break;
                        }
                        case 3: {
                            controller.showCharaktere();
                            break;
                        }
                        case 4: {
                            controller.updateCharaktereValidate();
                            break;
                        }
                        case 5: {
                            controller.deleteCharaktere();
                            break;
                        }
                        case 6: {
                            controller.charaktereNachOrtFiltrieren();
                            break;
                        }
                        case 0:
                            break;
                    }
                }
                case 0:
                    break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkte> produktRepository = new Repository<>();
        Repository<Charaktere> charaktereRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(charaktereRepository, produktRepository);

        Service service = new Service(charaktereRepository, produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Charaktere> charaktereRepository, Repository<Produkte> produktRepository) {
        Produkte produkt1 = new Produkte("Wheat", 50, "Riverlands");
        Produkte produkt2 = new Produkte("Iron", 100, "Iron Islands");
        Produkte produkt3 = new Produkte("Wood", 125, "Stormlands");
        Produkte produkt4 = new Produkte("Leather", 75, "Westerlands");
        Produkte produkt5 = new Produkte("Coal", 50, "Westerlands");
        Produkte produkt6 = new Produkte("Corn", 75, "Riverlands");
        Produkte produkt7 = new Produkte("Gold", 500, "Iron Islands");

        produktRepository.addElement(produkt1);
        produktRepository.addElement(produkt2);
        produktRepository.addElement(produkt3);
        produktRepository.addElement(produkt4);
        produktRepository.addElement(produkt5);
        produktRepository.addElement(produkt6);
        produktRepository.addElement(produkt7);

        List<Produkte> listeCharaktere1 = new ArrayList<>();
        listeCharaktere1.add(produkt1);
        listeCharaktere1.add(produkt3);
        listeCharaktere1.add(produkt4);
        Charaktere charaktere1 = new Charaktere(1, "Kevin", "Westerlands", listeCharaktere1);

        List<Produkte> listeCharaktere2 = new ArrayList<>();
        listeCharaktere2.add(produkt2);
        listeCharaktere2.add(produkt6);
        Charaktere charaktere2 = new Charaktere(2, "Maria", "Iron Islands", listeCharaktere2);

        List<Produkte> listeCharaktere3 = new ArrayList<>();
        listeCharaktere3.add(produkt3);
        listeCharaktere3.add(produkt5);
        Charaktere charaktere3 = new Charaktere(3, "Markus", "Riverlands", listeCharaktere3);

        List<Produkte> listeCharaktere4 = new ArrayList<>();
        listeCharaktere3.add(produkt1);
        listeCharaktere3.add(produkt5);
        Charaktere charaktere4 = new Charaktere(4, "Aurelius", "Stormlands", listeCharaktere4);

        charaktereRepository.addElement(charaktere1);
        charaktereRepository.addElement(charaktere2);
        charaktereRepository.addElement(charaktere3);
        charaktereRepository.addElement(charaktere4);
    }
}
