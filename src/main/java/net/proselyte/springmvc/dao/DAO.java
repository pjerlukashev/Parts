package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.model.Book;
import net.proselyte.springmvc.model.Part;

import java.util.List;

public interface DAO {

    Part fingPartById(int id);
    void createPart(Part part);

    void updatePart(Part part);

    void deletePart(int  id);
    List<Part> getAllParts();
   Part findPartByName(String partName);

}
