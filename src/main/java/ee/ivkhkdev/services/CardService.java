package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Card;
import ee.ivkhkdev.repository.Storage;
import java.util.List;
import java.util.Optional;

public class CardService {
    private final Storage<Card> storage;

    // Constructor
    public CardService(Storage<Card> storage) {
        this.storage = storage;
    }

    // Methods to handle Card operations
    public List<Card> getAllCards() {
        return storage.findAll();
    }

    public Optional<Card> getCardById(String id) {
        return storage.findById(id);
    }

    public void addCard(Card card) {
        storage.save(card);
    }

    public void updateCard(Card card) {
        storage.update(card);
    }

    public void deleteCard(String id) {
        storage.delete(id);
    }
}
