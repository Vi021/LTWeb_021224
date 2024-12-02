package vn.iostar.ltweb_161224.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iostar.ltweb_161224.model.user;

@Repository
public interface iUserRepos extends JpaRepository<user, Long> {
}
