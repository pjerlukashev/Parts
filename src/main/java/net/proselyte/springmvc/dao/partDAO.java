package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.PartNotFoundException;
import net.proselyte.springmvc.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class partDAO implements DAO {
    private  SessionFactory sessionFactory;

 private static Logger logger = LoggerFactory.getLogger(partDAO.class);

    public  void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Part fingPartById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Part part = (Part) session.load(Part.class, new Integer(id));

        if (part!=null){
            logger.info("Part successfully found. Part details:" + part);
        }else{

            logger.info("Part with id:" + id + "not found");
        }

        return part;
    }

    @Override
    public void createPart(Part part) {

        Session session = this.sessionFactory.getCurrentSession();

        session.persist(part);

        logger.info("Part successfully saved. Part details:" + part);

    }

    @Override
    public void updatePart(Part part) {


        Session session = this.sessionFactory.getCurrentSession();

        session.update(part);

        logger.info("Part successfully updated. Part details:" + part);

    }

    @Override
    public void deletePart(int id) {

        Session session = this.sessionFactory.getCurrentSession();

        Part part = (Part) session.load(Part.class, new Integer(id));

        if (part!=null){

            session.delete(part);
            logger.info("Part successfully deleted. Part details:" + part);
        }else{

            logger.info("Part with id:" + id + "not found");
        }

    }

    @Override
    public List<Part> getAllParts() {
        Session session = this.sessionFactory.getCurrentSession();

        List<Part> parts = session.createQuery("from Part").list();

        for(Part part:parts){logger.info("Parts list:" + part);}

        return parts;
    }

    @Override
    public Part findPartByName(String partName) {
        Part part=null;

        Session session = this.sessionFactory.getCurrentSession();

        try {

            List<Part> partList = session.createQuery("from Part  where partName = :partName").setString("partName",partName).list();

            if(partList.size()==0){
                throw new PartNotFoundException("Part with title " + partName + " not found");
            }else{

                part = partList.get(0);
                logger.info("Part successfully found by name. Part details:" + part);
            }
        } catch (PartNotFoundException e){
            e.printStackTrace();
        }
        return part;
    }

    public List<Part>  getOptionalParts(){

        Session session = this.sessionFactory.getCurrentSession();

        List<Part> parts = session.createQuery("from Part  where isRequired = :nul").setParameter("nul", 0).list();

        for(Part part:parts){logger.info("Optional parts list:" + part);}

        return parts;

    }

    @Override
    public List<Part>  getRequiredParts(){

        Session session = this.sessionFactory.getCurrentSession();

        List<Part> parts = session.createQuery("from Part  where isRequired = :unit").setParameter("unit", 1).list();

        for(Part part:parts){logger.info("Required parts list:" + part);}

        return parts;

    }

    public int getComputerCount(){

   List<Part> requiredParts = getRequiredParts();

   List<Integer> quantities = new ArrayList<Integer>();

        for (int i = 0; i <requiredParts.size() ; i++) {

         quantities.add(requiredParts.get(i).getQuantity());

        }

        int count = quantities.size()!=0? Collections.min(quantities):0;

        logger.info("Computer count is:" + count);

return count;

    }
}




