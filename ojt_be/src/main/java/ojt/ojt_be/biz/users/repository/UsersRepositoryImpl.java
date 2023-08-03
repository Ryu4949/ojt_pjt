package ojt.ojt_be.biz.users.repository;

import ojt.ojt_be.biz.users.domain.Users;

import java.util.*;

public class UsersRepositoryImpl implements UsersRepository {

    private static Map<Integer, Users> store = new HashMap<>();
    private static Integer sequence = 0;

    @Override
    public Users save(Users user){
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public List<Users> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Users> findByUserId(String userId) {
        return store.values().stream().filter(user -> user.getUserId().equals(userId)).findFirst();
    }

    @Override
    public Users update(Users user) {
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(Integer id) {
        store.remove(id);
    }

    public void clearStore() {
        store.clear();
    }
}
