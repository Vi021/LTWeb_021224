package vn.iostar.ltweb_161224.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iostar.ltweb_161224.model.category;

@Repository
public interface iCategoryRepos extends JpaRepository<category, Long> {
}
