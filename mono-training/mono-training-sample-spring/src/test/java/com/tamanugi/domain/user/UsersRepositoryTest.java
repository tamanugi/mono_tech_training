package com.tamanugi.domain.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
@DataJpaTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository repository;
  
    @Test
    public void testFindByNameContaining() {
        {
            UsersEntity user = new UsersEntity();
            user.setName("hoge");
            repository.save(user);
        }

        {
            UsersEntity user = new UsersEntity();
            user.setName("ogho");
            repository.save(user);
        }

        assertThat(repository.findByNameContaining("hoge").size(), is(1));
        assertThat(repository.findByNameContaining("og").size(), is(2));

    }
}
