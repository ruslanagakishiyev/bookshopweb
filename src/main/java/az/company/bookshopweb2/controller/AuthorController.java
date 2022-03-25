package az.company.bookshopweb2.controller;

import az.company.bookshopweb2.dao.entity.appUser.AppUser;
import az.company.bookshopweb2.dao.entity.appUser.Author;
import az.company.bookshopweb2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewAuthorForm")
    public String showNewAuthorForm(Model model) {
        // create model attribute to bind form data
        Author author = new Author();
        model.addAttribute("author", author);
        return "new_author";
    }
    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        // save employee to database
        authorService.saveAuthor(author);
        return "redirect:/";
    }

    @GetMapping("/showFormForAuthorUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get employee from the service
        Author author = authorService.getAuthorById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("author", author);
        return "update_author";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.authorService.deleteAuthorById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Author> page = authorService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Author> listAuthor = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listAuthor", listAuthor);
        return "author";
    }
}
