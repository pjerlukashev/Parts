package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.PartNotFoundException;
import net.proselyte.springmvc.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class partDAO implements DAO {
    private  SessionFactory sessionFactory;

    public  void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Part fingPartById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Part part = (Part) session.load(Part.class, new Integer(id));

        return part;
    }

    @Override
    public void createPart(Part part) {

        Session session = this.sessionFactory.getCurrentSession();

        session.persist(part);

    }

    @Override
    public void updatePart(Part part) {


        Session session = this.sessionFactory.getCurrentSession();

        session.update(part);

    }

    @Override
    public void deletePart(int id) {

        Session session = this.sessionFactory.getCurrentSession();

        Part part = (Part) session.load(Part.class, new Integer(id));

        if (part!=null){

            session.delete(part);
        }

    }

    @Override
    public List<Part> getAllParts() {
        Session session = this.sessionFactory.getCurrentSession();

        List<Part> parts = session.createQuery("from Part").list();

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

            }
        } catch (PartNotFoundException e){
            e.printStackTrace();
        }
        return part;
    }
}
