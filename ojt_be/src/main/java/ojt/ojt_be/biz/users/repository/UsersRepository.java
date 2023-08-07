package ojt.ojt_be.biz.users.repository;

import ojt.ojt_be.biz.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository {

    // 사용자 등록
    Users save(Users user);
    // 전체 사용자 조회
    List<Users> findAll();
    // 사용자 Id로 찾기
    Optional<Users> findByUserId(String userId);
    // 사용자 정보 수정
    Users update(Users user);
    // 사용자 정보 삭제
    void delete(Integer id);


}
