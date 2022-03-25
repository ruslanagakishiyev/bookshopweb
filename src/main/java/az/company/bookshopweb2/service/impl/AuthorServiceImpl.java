package az.company.bookshopweb2.service.impl;

import az.company.bookshopweb2.dao.entity.appUser.Author;
import az.company.bookshopweb2.dao.repository.appUser.AuthorRepository;
import az.company.bookshopweb2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(long id) {
        Optional<Author> optional = authorRepository.findById(id);
        Author author = null;
        if (optional.isPresent()) {
            author = optional.get();
        } else {
            throw new RuntimeException(" Author not found for id :: " + id);
        }
        return author;
    }

    @Override
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public Page<Author> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.authorRepository.findAll(pageable);
    }
}
