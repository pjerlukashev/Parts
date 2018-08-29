package net.proselyte.springmvc.controller;


import net.proselyte.springmvc.BookNotFoundException;
import net.proselyte.springmvc.model.Book;
import net.proselyte.springmvc.service.MockService;
import net.proselyte.springmvc.service.Service;
import net.proselyte.springmvc.service.bookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public  String listBooks(@RequestParam (required = false) Integer page,  Model model){

        model.addAttribute("command", new Book());

      //  model.addAttribute("listBooks", this.bookService.getAllBooks());

        List<Book> users = bookService.getAllBooks();

        PagedListHolder<Book> pagedListHolder = new PagedListHolder<Book>(users);
        pagedListHolder.setPageSize(10);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());


        if(page==null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;


        model.addAttribute("page", page);

        if(page>pagedListHolder.getPageCount()){
            pagedListHolder.setPage(page);
            model.addAttribute("listBooks", pagedListHolder.getPageList());
        }

        else if(page <= pagedListHolder.getPageCount()) {

            pagedListHolder.setPage(page-1);
            model.addAttribute("listBooks", pagedListHolder.getPageList());
        }


        return  "books";

    }

    @RequestMapping(value = "/remove/{id}")
    public  String removeBook(@PathVariable("id") int id){


this.bookService.deleteBook(id);

         return "redirect:/books";
    }


    @RequestMapping(value = "/edit/{id}")
    public  String editBook(@RequestParam (required = false) Integer page, @PathVariable("id") int id, Model model){

model.addAttribute("command", this.bookService.fingBookById(id));

        List<Book> users = bookService.getAllBooks();

        PagedListHolder<Book> pagedListHolder = new PagedListHolder<Book>(users);
        pagedListHolder.setPageSize(10);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());


        if(page==null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;


        model.addAttribute("page", page);

        if(page>pagedListHolder.getPageCount()){
            pagedListHolder.setPage(page);
            model.addAttribute("listBooks", pagedListHolder.getPageList());
        }

        else if(page <= pagedListHolder.getPageCount()) {

            pagedListHolder.setPage(page-1);
            model.addAttribute("listBooks", pagedListHolder.getPageList());
        }
        return "books";
    }



    @RequestMapping(value = "/mark/{id}")
    public  String markBook(@RequestParam (required = false) Integer page,@PathVariable("id") int id, Model model) {

        Book book = this.bookService.fingBookById(id);

        book.setReadAlready(1);

        this.bookService.updateBook(book);

        model.addAttribute("command", new Book());

        List<Book> users = bookService.getAllBooks();

        PagedListHolder<Book> pagedListHolder = new PagedListHolder<Book>(users);
        pagedListHolder.setPageSize(10);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());


        if (page == null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;


        model.addAttribute("page", page);

        if (page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page);
            model.addAttribute("listBooks", pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()) {

            pagedListHolder.setPage(page - 1);
            model.addAttribute("listBooks", pagedListHolder.getPageList());

        }
            return "books";

    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchBook (HttpServletRequest request, Model model)throws BookNotFoundException {
        String bookTitle=request.getParameter("title");
        System.out.println("Searching book by title: " + bookTitle);
       Book book=this.bookService.loadBookByTitle(bookTitle);
        String result;
        if(book==null){
            result="errPage";
        }
        else result="result";



        model.addAttribute("book",book);
        return result;
    }

}
