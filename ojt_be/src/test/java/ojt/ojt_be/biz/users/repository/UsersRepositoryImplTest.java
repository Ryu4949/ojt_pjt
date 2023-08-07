package ojt.ojt_be.biz.users.repository;

import ojt.ojt_be.biz.users.domain.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryImplTest {

    @Autowired
    UsersRepositoryImpl usersRepository = new UsersRepositoryImpl();

    @AfterEach
    public void afterEach() {
        usersRepository.clearStore();
    }

    @Test
    void save() {
        Users newUser = new Users("kyong", "khr@mail.com", "gaengha", "1234", "architect", "sawon", LocalDate.now(), LocalDate.now(), false);

        usersRepository.save(newUser);

        Users result = usersRepository.findByUserId(newUser.getUserId()).get();
        System.out.println(result);
        assertEquals(result, newUser);

    }

    @Test
    void findAll() {
        Users user1 = new Users("kyong", "khr@mail.com", "gaengha", "1234", "architect", "sawon", LocalDate.now(), LocalDate.now(), false);
        Users user2 = new Users("kyong2", "khr2@mail.com", "gaengha22", "1234", "architect", "sawon", LocalDate.now(), LocalDate.now(), false);

        usersRepository.save(user1);
        usersRepository.save(user2);

        List<Users> result = usersRepository.findAll();
        assertEquals(2, result.size());

    }

    @Test
    void findByUserId() {
        Users newUser = new Users("kyong", "khr@mail.com", "gaengha", "1234", "architect", "sawon", LocalDate.now(), LocalDate.now(), false);
        usersRepository.save(newUser);

        Users result1 = usersRepository.findByUserId("gaengha").get();
        Optional<Users> result2 = usersRepository.findByUserId("kyungha");

        assertEquals(newUser, result1);
        assertEquals(Optional.empty(), result2);

    }

    @Test
    void update() {
        Users newUser = new Users("kyong", "khr@mail.com", "gaengha", "1234", "architect", "sawon", LocalDate.now(), LocalDate.now(), false);
        usersRepository.save(newUser);
        Integer result1 = newUser.getId();

        Users updateUser = new Users("kyongha", "khr@mail.com", "gaengha", "1234", "architect", "sawon", LocalDate.now(), LocalDate.now(), false);
        Users result2 = usersRepository.update(updateUser);

        System.out.println(result2);

        assertEquals(result1, result2.getId());
        assertNotEquals(newUser.getName(), result2.getName());

    }

    @Test
    void delete() {
        Users newUser = new Users("kyong", "khr@mail.com", "gaengha", "1234", "architect", "sawon", LocalDate.now(), LocalDate.now(), false);
        usersRepository.save(newUser);

        usersRepository.delete(newUser.getId());

        Optional<Users> result = usersRepository.findByUserId(newUser.getUserId());

        assertEquals(Optional.empty(), result);
    }
}