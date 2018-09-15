package net.proselyte.springmvc.service;

import net.proselyte.springmvc.PartNotFoundException;
import net.proselyte.springmvc.model.Part;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface Service {

  List<Part> getAllParts();
    Part fingPartById(int id);

    void createPart(Part part);

    void updatePart(Part part);

    void deletePart(int  id);

  Part loadPartByName(String partName)throws PartNotFoundException, DataAccessException;


}
