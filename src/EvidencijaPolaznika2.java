import java.util.*;

public class EvidencijaPolaznika2 {

    //private static HashMap<String, Polaznik> polaznici = new HashMap<>();
    private static TreeMap<String, Polaznik> polaznici = new TreeMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Dobrodošli u Evidenciju Polaznika Tečaja!");

            boolean run = true;
            while (run) {
                System.out.println("1. Unos novog polaznika");
                System.out.println("2. Ispis svih polaznika");
                System.out.println("3. Pretraživanje polaznika po e-mail adresi");
                System.out.println("4. Izlaz\n");

                System.out.print("Odaberi opciju (1-4): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        unosNovogPolaznika();
                        break;
                    case 2:
                        ispisiSvePolaznike();
                        break;
                    case 3:
                        pretraziPolaznikaPoEmailu();
                        break;
                    case 4:
                        run = false;
                        System.out.println("Hvala što ste koristili program. Doviđenja!");
                        break;
                    default:
                        System.out.println("Nepostojeća opcija. Molimo odaberite ponovno.");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void unosNovogPolaznika() {
        System.out.print("Unesite ime polaznika: ");
        String ime = scanner.nextLine();

        System.out.print("Unesite prezime polaznika: ");
        String prezime = scanner.nextLine();

        System.out.print("Unesite e-mail adresu polaznika: ");
        String email = scanner.nextLine();

        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);

        if(polaznici.containsKey(email.toLowerCase())){
            System.out.println("Polaznik s navedenim emailom (" + email + ") već postoji!\n");
        } else{
            polaznici.put(email.toLowerCase(), noviPolaznik);
            System.out.println("Polaznik " + noviPolaznik.toString() + " uspješno dodan!\n");
        }
    }

    private static void ispisiSvePolaznike() {
        System.out.println("Popis polaznika:");
        polaznici.forEach((k, v) -> { System.out.println(v); });
        System.out.println();

        List<Polaznik> newList = new ArrayList<>(polaznici.values());

        System.out.println("Popis polaznika u obrnutom redoslijedu:");
        Collections.reverse(newList);
        newList.forEach((p) -> { System.out.println(p.toString()); });
        System.out.println();

        System.out.println("Popis polaznika korištenjem shuffle opcije:");
        Collections.shuffle(newList);
        newList.forEach((p) -> { System.out.println(p.toString()); });
        System.out.println();


        System.out.println("Popis polaznika korištenjem swap opcije:");
        Collections.swap(newList,0,1);
        newList.forEach((p) -> { System.out.println(p.toString()); });
        System.out.println();
    }

    private static void pretraziPolaznikaPoEmailu() {
        System.out.print("Unesite e-mail adresu polaznika za pretraživanje: ");
        String email = scanner.nextLine();

        if(polaznici.containsKey(email.toLowerCase())){
            System.out.println("Polaznik s traženom e-mail adresom " + email + " je pronađen: " + polaznici.get(email.toLowerCase()).toString());
        } else{
            System.out.println("Nema polaznika s e-mail adresom " + email + ".\n");
        }
    }
}

