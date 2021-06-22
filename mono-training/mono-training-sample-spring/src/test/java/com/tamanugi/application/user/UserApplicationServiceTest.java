package com.tamanugi.application.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.tamanugi.domain.user.UsersEntity;
import com.tamanugi.domain.user.UsersRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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

    /**
     * TODO: use mockito
     */
    public static class MockUsersRepository implements UsersRepository {

        private List<UsersEntity> store = new ArrayList<>();

        @Override
        public <S extends UsersEntity> S save(S entity) {
            store.add(entity);
            return entity;
        }

        @Override
        public <S extends UsersEntity> Iterable<S> saveAll(Iterable<S> entities) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Optional<UsersEntity> findById(Integer id) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean existsById(Integer id) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Iterable<UsersEntity> findAll() {
            // TODO Auto-generated method stub
            return store;
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
                .stream()
                .filter(v -> v.getName().contains(name))
                .collect(Collectors.toList());
        }

    }
 

}
