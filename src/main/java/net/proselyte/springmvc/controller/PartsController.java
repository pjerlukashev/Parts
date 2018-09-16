package net.proselyte.springmvc.controller;


import net.proselyte.springmvc.PartNotFoundException;
import net.proselyte.springmvc.model.Part;
import net.proselyte.springmvc.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PartsController {

    @Autowired
    @Qualifier("partService")
    private Service partService;

    public void setPartService(Service partService) {
        this.partService = partService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/addPart", method = RequestMethod.POST)
    public String addPart(@ModelAttribute("mvc-dispatcher") Part part,
                          ModelMap model, @RequestParam(required=false) Integer page) {

        model.addAttribute("page", page);

        if (part.getId()==0) {
            partService.createPart(part);
        } else
        {
            partService.updatePart(part);
        }

        return "redirect:parts";
    }

    @RequestMapping(value="parts", method= RequestMethod.GET )
    public  String listParts(@RequestParam (required = false) Integer page,  Model model){


        model.addAttribute("command", new Part());

        model.addAttribute("computerCount", partService.getComputerCount());

        List<Part> parts = partService.getAllParts();

        setPageHolder(model,page,parts);

        return  "parts";

    }

    @RequestMapping(value = "/remove/{id}")
    public  String removePart(@PathVariable("id") int id, Model model, @RequestParam(required = false)Integer page){

        model.addAttribute("page", page);
        this.partService.deletePart(id);

        return "redirect:/parts";
    }

    @RequestMapping(value = "/edit/{id}")
    public  String editPart(@RequestParam (required = false) Integer page, @PathVariable("id") int id, Model model){

        Part part = this.partService.fingPartById(id);



        model.addAttribute("command", part);


        List<Part> parts = partService.getAllParts();

        setPageHolder(model,page,parts);

        model.addAttribute("computerCount", partService.getComputerCount());

        return "parts";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchPart (HttpServletRequest request, Model model, @RequestParam (required = false)Integer page)throws PartNotFoundException {
        String partName=request.getParameter("partName");
        System.out.println("Searching part by title: " + partName);
        Part part=this.partService.loadPartByName(partName);
        String result;
        if(part==null){
            result="errPage";
        }
        else result="result";

        List<Part> parts = partService.getAllParts();

        setPageHolder(model,page,parts);

        model.addAttribute("part",part);
        return result;
    }

    public Model  setPageHolder(Model model, Integer page, List<Part> parts){

        PagedListHolder<Part> pagedListHolder = new PagedListHolder<Part>(parts);
        pagedListHolder.setPageSize(10);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;

        model.addAttribute("page", page);


        if(page>pagedListHolder.getPageCount()){
            pagedListHolder.setPage(page);
            model.addAttribute("listParts", pagedListHolder.getPageList());
        }

        else if(page <= pagedListHolder.getPageCount()) {

            pagedListHolder.setPage(page-1);
            model.addAttribute("listParts", pagedListHolder.getPageList());
        }

        return model;
    }

    @RequestMapping(value="requiredparts", method= RequestMethod.GET )
    public  String requiredParts(@RequestParam (required = false) Integer page,  Model model){


        model.addAttribute("command", new Part());

        model.addAttribute("computerCount", partService.getComputerCount());

        List<Part> parts = partService.getRequiredParts();

        setPageHolder(model,page,parts);

        return  "requiredparts";

    }


    @RequestMapping(value="optionalparts", method= RequestMethod.GET )
    public  String optionalParts(@RequestParam (required = false) Integer page,  Model model){

        model.addAttribute("command", new Part());

        model.addAttribute("computerCount", partService.getComputerCount());

        List<Part> parts = partService.getOptionalParts();

        setPageHolder(model,page,parts);

        return  "optionalparts";

    }
}
