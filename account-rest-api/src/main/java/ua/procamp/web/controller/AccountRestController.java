package ua.procamp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.procamp.dao.AccountDao;
import ua.procamp.model.Account;

import java.util.List;

/**
 * <p>
 * todo: 1. Configure rest controller that handles requests with url "/accounts"
 * todo: 2. Inject {@link AccountDao} implementation
 * todo: 3. Implement method that handles GET request and returns a list of accounts
 * todo: 4. Implement method that handles GET request with id as path variable and returns account by id
 * todo: 5. Implement method that handles POST request, receives account as request body, saves account and returns it
 * todo:    Configure HTTP response status code 201 - CREATED
 * todo: 6. Implement method that handles PUT request with id as path variable and receives account as request body.
 * todo:    It check if account id and path variable are the same and throws {@link IllegalStateException} otherwise.
 * todo:    Then it saves received account. Configure HTTP response status code 204 - NO CONTENT
 * todo: 7. Implement method that handles DELETE request with id as path variable removes an account by id
 * todo:    Configure HTTP response status code 204 - NO CONTENT
 */
@RestController
@RequestMapping("/accounts")
public class AccountRestController {
    @Autowired
    AccountDao accountDao;

    @GetMapping
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable("id") Long id) {
        return accountDao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Account account) {
        accountDao.save(account);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody Account account) {
        if (account.getId().equals(id)) {
            accountDao.save(account);
        } else {
            throw new IllegalStateException();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id) {
        Account account = accountDao.findById(id);
        accountDao.remove(account);
    }

}
