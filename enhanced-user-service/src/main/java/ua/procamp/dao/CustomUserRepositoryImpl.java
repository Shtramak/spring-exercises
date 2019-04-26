package ua.procamp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.procamp.model.jpa.Role;
import ua.procamp.model.jpa.RoleType;
import ua.procamp.model.jpa.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addRoleToAllUsers(RoleType roleType) {
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        users.stream()
                .filter(user -> user.getRoles().stream().map(Role::getRoleType).noneMatch(rt -> rt.equals(roleType)))
                .forEach(u -> u.addRole(Role.valueOf(roleType)));
    }
}
