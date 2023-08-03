package ojt.ojt_be.biz.users.repository;

import ojt.ojt_be.biz.users.domain.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryImplTest {

    UsersRepositoryImpl usersRepository = new UsersRepositoryImpl();

    @AfterEach
    public void afterEach() {
        usersRepository.clearStore();
    }

    @Test
    void save() {
        Users newUser = new Users();
        newUser.setUserId("kyong");
        newUser.setEmail("khr@mail.com");
        newUser.setName("gaengha");
        newUser.setPassword("1234");
        newUser.setDepartment("architect");
        newUser.setRankName("sawon");
        newUser.setStartDate(LocalDate.now());
        newUser.setLastChangeDate(LocalDate.now());
        newUser.setUseAccount(false);

        usersRepository.save(newUser);

        Users result = usersRepository.findByUserId(newUser.getUserId()).get();
        System.out.println(result);
        assertEquals(result, newUser);

    }

    @Test
    void findAll() {
    }

    @Test
    void findByUserId() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}