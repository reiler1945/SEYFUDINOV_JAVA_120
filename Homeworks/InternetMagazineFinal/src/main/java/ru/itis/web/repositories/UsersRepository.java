package ru.itis.web.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.web.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Query(nativeQuery = true, value = "select * from service_user order by id limit :limit_ offset :offset_")
    List<User> findAllByPage(@Param("limit_") int pageId, @Param("offset_") int siteCount);

    @Query(nativeQuery = true, value = "select count(*) from service_user")
    Integer getCountUsers();


}
