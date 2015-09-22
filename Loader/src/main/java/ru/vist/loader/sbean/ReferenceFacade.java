package ru.vist.loader.sbean;

import ru.vist.loader.src.Doljnost;
import ru.vist.loader.src.Groups;
import ru.vist.model.domain.ref.Corporation;
import ru.vist.model.domain.ref.Dept;
import ru.vist.model.domain.ref.Factory;
import ru.vist.model.domain.ref.Reference;
import ru.vist.model.domain.sys.UserRole;
import ru.vist.model.domain.sys.User;
import ru.vist.model.domain.ref.Worker;
import ru.vist.model.domain.ref.Post;
import ru.vist.loader.src.Objed;
import ru.vist.loader.src.Predpis;
import ru.vist.loader.src.Predpr;
import ru.vist.loader.src.Sotrud;
import ru.vist.loader.src.Uchast;
import ru.vist.loader.src.Users;
import ru.vist.model.domain.sys.Config;
import ru.vist.model.domain.ref.ProdUnit;
import ru.vist.model.domain.doc.Precept;
import ru.vist.model.domain.sys.Subscriber;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ReferenceFacade extends AbstractFacade<Reference> implements IRef {

    @PersistenceContext(unitName = "DEST_PU")
    private EntityManager em;

    @EJB
    private ObjedFacadeLocal objedFacade;

    public ObjedFacadeLocal getObjedFacade() {
        return objedFacade;
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReferenceFacade() {
        super(Reference.class);
    }

    Map<Integer, Post> dolj_map = new HashMap<>();
    Map<Integer, User> user_map = new HashMap<>();
    Map<Integer, UserRole> role_map = new HashMap<>();
    Map<Integer, Worker> worker_map = new HashMap<>();
    Map<Integer, Factory> factory_map = new HashMap<>();
    Map<Integer, Dept> dept_map = new HashMap<>();

    private UserRole findOrCreateRole(Users s) {
        if (s == null)
            return null;
        Groups g = s.getGroupId();
        if (g == null)
            return null;
        int index = g.getGroupId().intValue();
        UserRole role = role_map.get(index);
        if (role == null) {
            role = new UserRole(newId(), g.getGroupName());
            role_map.put(index, role);
        }
        return role;
    }

    private User findOrCreateUser(Sotrud s) {
        if (s == null)
            return null;
        Users u = s.getUserId();
        if (u == null)
            return null;
        int index = u.getUserId().intValue();
        User get = user_map.get(index);
        if (get == null) {
            get = new User(newId(), u.getUserName());
            get.setUserRole(findOrCreateRole(u));
            user_map.put(index, get);
        }
        return get;
    }

    private Post findOrCreatePost(Sotrud s) {
        if (s == null)
            return null;
        Doljnost d = s.getDoljK();
        if (d == null)
            return null;
        int index = d.getKod().intValue();
        Post post = dolj_map.get(index);
        if (post == null) {
            post = new Post(newId(), d.getText());
            post.setSmen(8);
            dolj_map.put(index, post);
        }
        return post;
    }

    public void createDefaultObjects(){
        User guest = new User("1", "ГОСТЬ");        
        UserRole role = new UserRole("2", "GUEST");
        em.persist(role);
        guest.setUserRole(role);
        em.persist(guest);
//        em.persist(new UserRole("8", "superadmin"));
//        em.persist(new UserRole("9", "ГОСТЬ"));
    } 
//    @Override
    public int loadRefs() {
        int ret = 0;
        Long key = 0L;
        worker_map.clear();
        factory_map.clear();
        dept_map.clear();
        createDefaultObjects();
//        em.persist(new UserRole("1", "admin"));
//        em.persist(new UserRole("2", "superadmin"));
//        em.persist(new UserRole("3", "ГОСТЬ"));
//        em.persist(new Subscribe("4", "Справочники"));
//        em.persist(new Subscribe("5", "Предписания"));
//        em.persist(new Subscribe("6", "Наряд-задания"));
//        em.persist(new Subscribe("7", "Отчеты"));
        List<Objed> objeds = getObjedFacade().findAll();
        for (Objed o : objeds) {
            String new_id = newId();
            Corporation corporation = new Corporation(new_id, o.getObjedNaim());
            corporation.setImpKey(o.getObjedK().longValue());
//            corporation.setSubs(subscribes);
            em.persist(new Config(key++, "CORP_KEY", o.getObjedNaim(), new_id));
            List<Predpr> predprList = o.getPredprList();
            for (Predpr predpr : predprList) {
                new_id = newId();
                Factory factory = new Factory(new_id, predpr.getPredprNaim());
                factory.setImpKey(predpr.getPredprK().longValue());
//                factory.setSubs(subscribes);
//                em.persist(new Config(key++, "FACT_KEY", predpr.getPredprNaim(),new_id));
                factory_map.put(factory.getImpKey().intValue(), factory);
                corporation.addUnit(factory);
                List<Uchast> uchastList = predpr.getUchastList();
                for (Uchast uchast : uchastList) {
                    Dept dept = new Dept(newId(), uchast.getUchastNaim());
//                    dept.setSubs(subscribes);
                    dept.setImpKey(uchast.getUchastK().longValue());
                    factory.addUnit(dept);
                    List<Sotrud> sotrudList = uchast.getSotrudList();
                    dept_map.put(dept.getImpKey().intValue(), dept);
                    for (Sotrud sotrud : sotrudList) {
                        String fam = sotrud.getSotrudFam();
                        String im = sotrud.getSotrudIm();
                        String otch = sotrud.getSotrudOtch();

                        Worker worker = new Worker(newId(), fam, im, otch);
                        worker.setImpKey(sotrud.getSotrudK().longValue());
                        worker.setPost(findOrCreatePost(sotrud));
//                        User user = findOrCreateUser(sotrud);
//                        if (user != null) {
//                            user.setImpKey(sotrud.getUserId().getUserId().longValue());
//                            user.setWorker(worker);
//                            user.setPassword("1");
//                        }
//                        worker.setUser(findOrCreateUser(sotrud));
                        worker_map.put(worker.getImpKey().intValue(), worker);
                        dept.addWorker(worker);
                        ret++;
                    }
                }
            }
            em.persist(corporation);
        }
        return ret;
    }

    private Worker findWorker(Object id) {
        return worker_map.get(id);
    }

    private ProdUnit findProdUnit(Object id, String type) {
        ProdUnit prodUnit;

        switch (type) {
            case "FACTORY":
                prodUnit = factory_map.get(id);
                break;
            case "DEPT":
                prodUnit = dept_map.get(id);
                break;
            default:
                prodUnit = null;
        }
        return prodUnit;
    }

    private Boolean boolValue(Object val) {
        if (val == null)
            return false;
        return val.toString().equalsIgnoreCase("Y");
    }

    private String stringValue(Object val) {
        if (val == null)
            return null;
        return val.toString();
    }

    private Short shortValue(Object val) {
        if (val == null)
            return null;
        return Short.parseShort(val.toString());
    }

    private String sayTip(Integer tip) {
        if (tip == null)
            return "";

        switch (tip) {

            case 1:
                return "Маршрутная";
            case 2:
                return "Внеплановая";
            case 3:
                return "Целевая";
            case 4:
                return "Комплексная";
            default:
                return "";
        }
    }

//    @Override
    public int loadDocs() {
        int cnt = 0, cntf = 0;
//        Query qwr = getEntityManager().createNamedQuery("Predpis.findAll_1",Predpis.class);
        Query qwr = objedFacade.getEntityManager().createNamedQuery("Predpis.findAll_1");
        List<Predpis> list = qwr.getResultList();
        for (Predpis p : list) {
            cnt++;
            cntf++;
            Precept r = new Precept(newId(), "Предписание");
            r.setImpKey(new Long(p.getPredpisK()));
            r.setIssueDate(p.getVydData());
            r.setExecDate(p.getIspData());
            r.setPlanExecDate(p.getIspSrok());
            r.setNoticeDate(p.getUvData());
            r.setReviewDate(p.getOznakomlenie());
            r.setReviewer(findWorker(p.getApprovedK()));
            r.setNotificator(findWorker(p.getUvSotrK()));
            r.setLetupWork(boolValue(p.getPriostanovka()));
            r.setLetupByShift(p.getSmena());
            r.setProdUnit(findProdUnit(p.getPredprK(), "FACTORY"));
            r.setSubProdUnit(findProdUnit(p.getUchastK(), "DEPT"));
            r.setAuthor(findWorker(p.getVydSotrK()));
            r.setCheckingType(sayTip(p.getTip()));
            r.setRoute(stringValue(r.getRoute()));
            r.setExecutor(findWorker(p.getNachK()));
            r.setOperand(p.getBrigadTekst());
            r.setDescription(p.getFreetext());
            r.setLawArticle(p.getPicketLoad());
            r.setCauseOfProblem(p.getManufactory());
            r.setDanger(null); ////<------
            r.setClog(shortValue(p.getBal()));
            r.setPossibility(shortValue(p.getVer()));
            r.setRequaredOrder(boolValue(p.getIsRequiredNaryad()));
            em.persist(r);
            if (cnt == 100) {
                cnt = 0;
                System.out.println(" перенесено " + cntf + " записей ");
            }
        }

        return cntf;
    }

//    @Override
    public Reference find(String id) {
        Reference obj = find(id);
        if (obj != null)
            System.out.println("  obj = " + obj.getClass().getSimpleName());// + " : " + obj.toJSON());
        return obj;
    }

    @Override
    public int laod() {
        int ret = loadRefs();
        ret = ret + loadDocs();
        return ret;
    }

}
