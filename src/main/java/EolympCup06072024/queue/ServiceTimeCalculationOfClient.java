package EolympCup06072024.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ServiceTimeCalculationOfClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Client> clients = new ArrayList<>();
        List<List<Client>> clientQueueChanged = new ArrayList<>();

        int amountClients = scanner.nextInt();
        for (int i = 0; i < amountClients; i++) {
            clients.add(new Client(scanner.nextInt()));
        }

        for (Client client : clients) {
            client.setPositionForGiveUp(scanner.nextInt());
        }

/*        for (int i = 0; i < clientsServiceTime.length; i++) {
            clients.add(new Client(Integer.parseInt(clientsServiceTime[i]), Integer.parseInt(positionForGiveUp[i])));
        }*/

        ServiceTimeCalculationOfClient calculation = new ServiceTimeCalculationOfClient();

        List<Integer> amountQueueChanges = new ArrayList<>();
        int count = 0;
        for (Client client : clients) {
            if (client.getPositionForGiveUp() > 0) {
                amountQueueChanges.add(count);
            }
            count++;
        }

        if (amountQueueChanges.size() > 0) {
            for (Client client : clients) {

            }
        }

        int calculate = calculation.calculate(clients);

        System.out.println(calculate);

    }

    public int calculate(List<Client> clients) {
        int result = 0;

        for (int i = 0; i < clients.size(); i++) {
            result += clients.get(i).getServiceTime();
            for (int j = 0; j < i; j++) {
                result += clients.get(j).getServiceTime();
            }
        }
        return result;
    }

    public List<Client> queueChange(List<Client> clients, int indexForChange) {
        ArrayList<Client> result = new ArrayList<>(clients);

        Client client = new Client(clients.get(indexForChange).getServiceTime(), clients.get(indexForChange).getPositionForGiveUp());

        clients.remove(indexForChange);
        clients.add((indexForChange + client.getPositionForGiveUp()), client);

        return result;
    }
}