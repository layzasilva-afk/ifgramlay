package com.ifpb.ifgram.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // o Spring Data implementa a partir do nome do método
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    List<User> findByNomeContainingIgnoreCase(String trecha);

    // quando o nome do rétodo não basta, JPQL explicito
    @Query("select u from User u where u.email like concat('%', :dominio)")
    List<User> doDominio(String dominio);
}
