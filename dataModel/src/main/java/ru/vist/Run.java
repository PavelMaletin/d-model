/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ru.vist.model.domain.ref.Corporation;
import ru.vist.model.domain.ref.Dept;
import ru.vist.model.domain.ref.Factory;
import ru.vist.model.domain.ref.Post;
import ru.vist.model.domain.ref.Reference;
import ru.vist.model_src.src.Doljnost;
import ru.vist.model_src.src.Objed;
import ru.vist.model_src.src.Predpr;
import ru.vist.model_src.src.Sotrud;
import ru.vist.model_src.src.Uchast;


/**
 *
 * @author chernov
 */
public class Run {
    
    private static final Map<String,Reference> mapPost = new Hashtable<>();

    private static EntityManager em = getEntityManager();
    private static EntityManager emDest = getEntityManagerDest();

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modelSTATPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    private static EntityManager getEntityManagerDest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modelSTATPU2");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public static void persist(Object object) {
        emDest.getTransaction().begin();
        try {
            emDest.persist(object);
            emDest.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            emDest.getTransaction().rollback();
        } finally {
            emDest.close();
        }
    }

    private static String newId() {
        UUID id = UUID.randomUUID();
        return id.toString();
    }
    
    private void insertObj(Reference ref){
        
    }
    
    private static Reference findRef(String id){
        
        return null;
    }

    public static void main(String[] args) {
        int ii = 0;
        mapPost.clear();
        Query qwr = em.createNamedQuery("Objed.findAll");
        List<Objed> resultList = qwr.getResultList();
        for (Objed o : resultList) {
            ii++;
            System.out.println(" Объединение = " + o.getObjedNaim());
            Corporation corporation = new Corporation(newId(), o.getObjedNaim());
            corporation.setImpKey(o.getObjedK().longValue());
            List<Predpr> predprList = o.getPredprList();
            for (Predpr p : predprList) {
                ii++;
                System.out.println(" Предриятие = " + p.getPredprNaim());
                Factory factory = new Factory(newId(), p.getPredprNaim());
                factory.setImpKey(p.getPredprK().longValue());
                corporation.addUnit(factory);
                List<Doljnost> doljnostList = p.getDoljnostList();
                for (Doljnost d : doljnostList) {
                    ii++;
                    System.out.println("Должность = " + d.getText());
                    Post post = new Post(newId(), d.getText());
                    post.setImpKey(d.getKod().longValue());
                    post.setProdUnit(factory);
                    if(! mapPost.containsKey(post.getId())){
                        mapPost.put(post.getId(), post);
                    }
                    factory.addPost(post);                    
                }
                List<Uchast> uchastList = p.getUchastList();
                for (Uchast u : uchastList) {
                    ii++;
                    System.out.println(" Участок " + u.getUchastNaim());
                    Dept dept = new Dept(newId(), u.getUchastNaim());
                    dept.setParent(factory);
                    factory.addUnit(dept);
                    List<Sotrud> sotrudList = u.getSotrudList();
                    for(Sotrud s :sotrudList){
                        
                    }
                }
            }
            System.out.println(" сохраняется " + ii +" объектов");
            persist(corporation);
            System.out.println("" + ii +" объектов сохранено");
        }
    }
}
