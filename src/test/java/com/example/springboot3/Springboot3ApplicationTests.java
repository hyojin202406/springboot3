package com.example.springboot3;

import com.example.springboot3.domain.QUser;
import com.example.springboot3.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class Springboot3ApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Test
    void contestLoads() {
        User user = new User("test@gmail.com", "test", "name");
        em.persist(user);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QUser qUser = new QUser("u");

        User result = query.selectFrom(qUser).fetchOne();

        assertThat(result).isEqualTo(user);
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
    }

}
