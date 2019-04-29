package ua.procamp.dao.impl;

import org.springframework.stereotype.Component;
import ua.procamp.dao.AccountDao;
import ua.procamp.exception.EntityNotFountException;
import ua.procamp.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link AccountDao} implementation that is based on {@link java.util.HashMap}.
 * <p>
 * todo: 1. Configure a component with name "accountDao"
 */
@Component
public class InMemoryAccountDao implements AccountDao {

    private Map<Long, Account> accountMap = new HashMap<>();
    private static AtomicLong idCounter = new AtomicLong();

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountMap.values());
    }

    @Override
    public Account findById(long id) {
        if (accountMap.containsKey(id)) {
            return accountMap.get(id);
        } else {
            throw new EntityNotFountException("Account with id=" + id + " not found");
        }
    }

    @Override
    public Account save(Account account) {
        Long accountId = account.getId();
        if (accountId == null) {
            accountId = idCounter.incrementAndGet();
            account.setId(accountId);
            accountMap.put(accountId, account);
        } else {
            accountMap.put(accountId, account);
        }
        return account;
    }

    @Override
    public void remove(Account account) {
        Long accountId = account.getId();
        if (accountId != null) {
            accountMap.remove(accountId);
        }
    }

    public void clear() {
        accountMap.clear();
    }
}
