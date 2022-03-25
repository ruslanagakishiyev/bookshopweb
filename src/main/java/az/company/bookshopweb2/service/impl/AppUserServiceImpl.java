package az.company.bookshopweb2.service.impl;

import az.company.bookshopweb2.dao.entity.appUser.AppUser;
import az.company.bookshopweb2.dao.repository.appUser.AppUserRepository;
import az.company.bookshopweb2.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAllAppUser() {
        return appUserRepository.findAll();
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        this.appUserRepository.save(appUser);
    }

    @Override
    public AppUser getAppUserById(long id) {
        Optional<AppUser> optional = appUserRepository.findById(id);
        AppUser appUser = null;
        if (optional.isPresent()) {
            appUser = optional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return appUser;
    }

    @Override
    public void deleteAppUserById(long id) {
        this.appUserRepository.deleteById(id);
    }

    @Override
    public Page<AppUser> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.appUserRepository.findAll(pageable);
    }
}
