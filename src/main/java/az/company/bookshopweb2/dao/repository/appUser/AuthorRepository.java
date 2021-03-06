package az.company.bookshopweb2.dao.repository.appUser;

import az.company.bookshopweb2.dao.entity.appUser.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
