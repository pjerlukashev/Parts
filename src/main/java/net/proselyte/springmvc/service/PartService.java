package net.proselyte.springmvc.service;


import net.proselyte.springmvc.PartNotFoundException;
import net.proselyte.springmvc.dao.DAO;
import net.proselyte.springmvc.model.Part;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class PartService implements Service {


private DAO partDAO;

    public void setPartDAO(DAO partDAO) {
        this.partDAO = partDAO;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<Part> getAllParts() {
        return partDAO.getAllParts();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Part fingPartById(int id) {
        return partDAO.fingPartById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createPart(Part part) { partDAO.createPart(part);

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePart(Part part) {

        partDAO.updatePart(part);

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePart(int id) {

        partDAO.deletePart(id);

    }

    @Override
    public Part loadPartByName(String partName) throws PartNotFoundException, DataAccessException {
        return partDAO.findPartByName(partName);
    }
}
