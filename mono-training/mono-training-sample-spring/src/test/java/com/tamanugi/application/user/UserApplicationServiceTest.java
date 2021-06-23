package com.tamanugi.application.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tamanugi.domain.user.UsersEntity;
import com.tamanugi.domain.user.UsersRepository;

import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class UserApplicationServiceTest {

    private UsersRepository usersRepository = new MockUsersRepository();
    private UserApplicationService sut = new UserApplicationService(usersRepository);

    @Test
    public void testCreateUser() {

        sut.createUser(new CreateUserCommand("hoge"));

        List<UsersEntity> actual = usersRepository.findByNameContaining("hoge");
        assertThat(actual.size(), is(1));
    }

    @Test
    public void testUpdateUser() {
        UsersEntity users = sut.createUser(new CreateUserCommand("hoge"));
        sut.updateUser(new UpdateUserCommand(users.getId(), "fuga"));

        {
            List<UsersEntity> actual = usersRepository.findByNameContaining("hoge");
            assertThat(actual.size(), is(0));
        }
        {
            List<UsersEntity> actual = usersRepository.findByNameContaining("fuga");
            assertThat(actual.size(), is(1));
        }
    }

    /**
     * TODO: use mockito
     */
    public static class MockUsersRepository implements UsersRepository {

        private Map<Integer, UsersEntity> store = new HashMap<>();

        @Override
        public UsersEntity save(UsersEntity entity) {
            int id = Optional.ofNullable(entity.getId()).orElse(store.size() + 1);
            return this.store.compute(id, (k, v) -> {
                entity.setId(k);
                return entity;
            });
        }

        @Override
        public <S extends UsersEntity> Iterable<S> saveAll(Iterable<S> entities) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Optional<UsersEntity> findById(Integer id) {
            return Optional.ofNullable(store.get(id));
        }

        @Override
        public boolean existsById(Integer id) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Iterable<UsersEntity> findAll() {
            // TODO Auto-generated method stub
            return store.values();
        }

        @Override
        public Iterable<UsersEntity> findAllById(Iterable<Integer> ids) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long count() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void deleteById(Integer id) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void delete(UsersEntity entity) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void deleteAll(Iterable<? extends UsersEntity> entities) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void deleteAll() {
            // TODO Auto-generated method stub
            
        }

        @Override
        public List<UsersEntity> findByNameContaining(String name) {
            return this.store
                .entrySet()
                .stream()
                .map(kv -> kv.getValue())
                .filter(v -> v.getName().contains(name))
                .collect(Collectors.toList());
        }

    }
 

}
