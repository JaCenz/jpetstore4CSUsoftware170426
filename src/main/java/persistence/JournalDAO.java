package persistence;

import domain.Account;
import domain.Item;
import domain.Journal;

import java.util.Date;
import java.util.List;

public interface JournalDAO {
    List<Journal> getJournalByUsername(String username);

    Journal getJournalByTime(Date time);

    void insertjournal(Journal journal);

    void accountSignOn(Account account);

    void itemBrowse(Item item, String userId);

    void cartAdd(Item item, String userId);

    void cartRemove(Item item, String userId);

    void orderGenerate(int orderId, String userId);
}
