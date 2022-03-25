package az.company.bookshopweb2.service;

import az.company.bookshopweb2.dao.entity.appUser.AppUser;
import org.springframework.data.domain.Page;

import java.util.List;


public interface AppUserService  {
    List<AppUser> getAllAppUser();
    void saveAppUser(AppUser appUser);
    AppUser getAppUserById(long id);
    void deleteAppUserById(long id);
    Page<AppUser> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
