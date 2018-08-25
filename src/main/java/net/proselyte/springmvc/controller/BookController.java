package net.proselyte.springmvc.controller;


import net.proselyte.springmvc.model.Book;
import net.proselyte.springmvc.service.MockService;
import net.proselyte.springmvc.service.Service;
import net.proselyte.springmvc.service.bookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
   @Qualifier("bookServiceImpl")
   private Service bookService;

    public void setBookService(Service bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }
   /* @RequestMapping(value = "book", method = RequestMethod.GET)
    public ModelAndView book() {
        return new ModelAndView("book", "command", new Book());
    }
*/
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("mvc-dispatcher") Book book,
                             ModelMap model) {
        model.addAttribute("id", book.getId());
        model.addAttribute("title", book.getTitle());
        model.addAttribute("description", book.getDescription());
        model.addAttribute("author", book.getAuthor());
        model.addAttribute("isbn", book.getIsbn());
        model.addAttribute("printYear", book.getPrintYear());
        model.addAttribute("readAlready", book.getReadAlready());
 if (book.getId()==0) {
     bookService.createBook(book);
 } else
 {
     bookService.updateBook(book);
 }

        return "redirect:books";
    }

    @RequestMapping(value="books", method= RequestMethod.GET )
    public  String listBooks(Model model){

        model.addAttribute("command", new Book());

        model.addAttribute("listBooks", this.bookService.getAllBooks());

       return  "books";

    }

    @RequestMapping(value = "/remove/{id}")
    public  String removeBook(@PathVariable("id") int id){


this.bookService.deleteBook(id);

         return "redirect:/books";
    }


    @RequestMapping(value = "/edit/{id}")
    public  String editBook(@PathVariable("id") int id, Model model){

model.addAttribute("command", this.bookService.fingBookById(id));

model.addAttribute("listBooks", this.bookService.getAllBooks());
        return "books";
    }

}
