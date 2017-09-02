package pl.com.bottega.photostock.sales.infrastructure;

import pl.com.bottega.photostock.sales.model.Address;
import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.ClientRepository;
import pl.com.bottega.photostock.sales.model.VIPClient;

import java.util.HashMap;
import java.util.Map;

public class InMemoryClientRepository implements ClientRepository {

    private static final Map<String, Client> REPO = new HashMap<>();

    static {
        Client c = new VIPClient("Jan Nowak", new Address("ul. Północna 11", "Poland", "Lublin", "20-001"));
        REPO.put(c.getNumber(), c);
    }

    @Override
    public Client get(String number) {
        if(!REPO.containsKey(number))
            throw new IllegalArgumentException(String.format("No client %s found", number));
        return REPO.get(number);
    }

    @Override
    public void save(Client client) {
        REPO.put(client.getNumber(), client);
    }
}
