package ru.vist.stat.db;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Container;
import com.vaadin.data.util.filter.Compare;
import ru.vist.model.domain.sys.Config;
import ru.vist.model.domain.ref.Corporation;
import ru.vist.model.domain.ref.Factory;
import ru.vist.model.domain.ref.Post;
import ru.vist.model.domain.ref.ProdUnit;
import ru.vist.model.domain.ref.Reference;
import ru.vist.model.domain.sys.User;
import ru.vist.model.domain.ref.Worker;
import ru.vist.model.domain.sys.Subscribe;
import ru.vist.model.domain.sys.Subscriber;
import ru.vist.model.domain.sys.UserRole;
import ru.vist.stat.forms.Common;
import ru.vist.stat.forms.order.OrderView;
import ru.vist.stat.forms.precept.PreceptView;
import ru.vist.stat.forms.precept1.Precept1View;
import ru.vist.stat.forms.ref.ReferenceView;
import ru.vist.stat.forms.report.ReportView;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Init {

    public static final String STAT_PU = "STAT_PU";
    private static final JPAContainer<Config> jpaConfig = JPAContainerFactory.make(Config.class, STAT_PU);
    private static final EntityManager em = jpaConfig.getEntityProvider().getEntityManager();

    private static JPAContainer<Post> jpaPost = null;
    private static JPAContainer<Worker> jpaWorker = null;
    private static JPAContainer<User> jpaUser = null;
    private static JPAContainer<UserRole> jpaRole = null;
    private static JPAContainer<ProdUnit> prodUnits = null;
    private static JPAContainer<Subscriber> jpaSubscriber = null;
    private static JPAContainer<Subscribe> jpaSubscribe = null;

    public static JPAContainer<UserRole> getJpaRole() {
        if (jpaRole == null)
            jpaRole = JPAContainerFactory.make(UserRole.class, STAT_PU);
        return jpaRole;
    }

    public static JPAContainer<Subscribe> getJpaSubscribe() {
        if (jpaSubscribe == null)
            jpaSubscribe = JPAContainerFactory.make(Subscribe.class, STAT_PU);
        return jpaSubscribe;
    }

    public static JPAContainer<Subscriber> getJpaSubscriber() {
        if (jpaSubscriber == null)
            jpaSubscriber = JPAContainerFactory.make(Subscriber.class, STAT_PU);
        return jpaSubscriber;
    }

    public static JPAContainer<Worker> getJpaWorker() {
        if (jpaWorker == null)
            jpaWorker = JPAContainerFactory.make(Worker.class, STAT_PU);
        return jpaWorker;
    }

    public static JPAContainer<User> getJpaUser() {
        if (jpaUser == null)
            jpaUser = JPAContainerFactory.make(User.class, STAT_PU);
        return jpaUser;
    }

    public static JPAContainer<Post> getJpaPost() {
        if (jpaPost == null)
            jpaPost = JPAContainerFactory.make(Post.class, STAT_PU);
        return jpaPost;
    }

    public static JPAContainer<ProdUnit> getProdUnits() {
        if (prodUnits == null)
            prodUnits = JPAContainerFactory.make(ProdUnit.class, STAT_PU);
        return prodUnits;
    }

    public static User verifyUser(String userName, String password) {
        Query qwr;
        User user = null;
        List<User> reslt;
        if ("ГОСТЬ".equalsIgnoreCase(userName)) {
            qwr = em.createNamedQuery("User.UserByName");
            qwr.setParameter("name", userName);
        } else {
            qwr = em.createNamedQuery("User.verifyUser");
            qwr.setParameter("name", userName);
            qwr.setParameter("password", password);
        }
        reslt = qwr.getResultList();
        if (reslt.size() > 0){
            user = reslt.get(0);
            Common.setUser(user);
        }
        return user;
    }

    public static Reference findRefObject(String id) {
        Reference reference = null;
        Query qwr = em.createNamedQuery("Reference.findById");
        qwr.setParameter("id", id);
        List resultList = qwr.getResultList();
        if (resultList.isEmpty())
            return reference;
        else
            return (Reference) resultList.get(0);
    }

    public static Reference findRefObject(String name, String refType) {
        Reference reference = null;
        Query qwr = em.createNamedQuery("Reference.findByName&Type");
        qwr.setParameter("name", name);
        qwr.setParameter("refType", refType);
        List resultList = qwr.getResultList();
        if (resultList.isEmpty())
            return reference;
        else
            return (Reference) resultList.get(0);
    }

    public static Post findOrCreatePost(String name) {
        Post post = null;
        JPAContainer<Post> posts = getJpaPost();
        Container.Filter filter = new Compare.Equal("name", name);
        posts.addContainerFilter(filter);
        int size = posts.size();
        if (size == 0) {
            String uuid = newUUID();
            post = new Post(uuid, name);
            posts.addEntity(post);
            posts.commit();
        } else {
            Collection<Object> itemIds = posts.getItemIds();
            Object[] toArray = itemIds.toArray();
            EntityItem<Post> item = posts.getItem(toArray[0]);
            post = item.getEntity();
        }
        posts.removeAllContainerFilters();
        return post;
    }

    public static Subscribe findSubsribe(String name) {
        Subscribe sub = null;
        JPAContainer<Subscribe> subs = getJpaSubscribe();
        Container.Filter filter = new Compare.Equal("name", name);
        subs.addContainerFilter(filter);
        int size = subs.size();
        if (size == 0)
            System.out.println(" ОШИБКА : Подписка [" + name + "] не найдена !!!");
        else {
            Collection<Object> itemIds = subs.getItemIds();
            Object[] toArray = itemIds.toArray();
            EntityItem<Subscribe> item = subs.getItem(toArray[0]);
            sub = item.getEntity();
        }
        subs.removeAllContainerFilters();
        return sub;
    }

    public static JPAContainer<Config> getJpaConfig() {
        int size = jpaConfig.size();
        return jpaConfig;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static String newUUID() {
        return UUID.randomUUID().toString();
    }

    public static ProdUnit findOrCreateProdUnit(String name, String prodType) {
        ProdUnit prodUnit = null;
        prodUnits = getProdUnits();
        com.vaadin.data.Container.Filter filter = new Compare.Equal("name", name);
        prodUnits.addContainerFilter(filter);
        int size = prodUnits.size();
        if (size == 0) {
            String uuid = newUUID();
            switch (prodType) {
                case "Предприятие":
                    prodUnit = new Factory(uuid, name);
                    break;
                case "Объединение":
                    prodUnit = new Corporation(uuid, name);
                    break;
            }
        } else {
            Collection<Object> itemIds = prodUnits.getItemIds();
            Object[] toArray = itemIds.toArray();
            EntityItem<ProdUnit> item = prodUnits.getItem(toArray[0]);
            prodUnit = item.getEntity();
        }
        prodUnits.removeAllContainerFilters();
        return prodUnit;
    }

    private static void createDefaultObjects() {
        Integer id = 1;
        String sid = (id++).toString();
        User guest;
        guest = (User) findRefObject(sid);
        if (guest == null)
            guest = new User(sid, "ГОСТЬ");

        sid = (id++).toString();
        UserRole roleGuest;
        roleGuest = (UserRole) findRefObject(sid);
        if (roleGuest == null)
            roleGuest = new UserRole(sid, "GUEST");

        guest.setUserRole(roleGuest);
        Subscriber subscriber = new Subscriber((id++).toString(), "Гостевая подписка");

        Subscribe s1 = new Subscribe((id++).toString(), ReferenceView.name, ReferenceView.class);
        Subscribe s2 = new Subscribe((id++).toString(), PreceptView.name, PreceptView.class);
        Subscribe s3 = new Subscribe((id++).toString(), Precept1View.name, Precept1View.class);
        Subscribe s4 = new Subscribe((id++).toString(), OrderView.name, OrderView.class);
        Subscribe s5 = new Subscribe((id++).toString(), ReportView.name, ReportView.class);

        subscriber.addSubs(s1, s2, s3, s4, s5);
        subscriber.setUser(guest);
        guest.setSubscriber(subscriber);

        getJpaRole().addEntity(roleGuest);
        getJpaRole().addEntity(new UserRole((id++).toString(), "superadmin"));
        getJpaRole().addEntity(new UserRole((id++).toString(), "ГОСТЬ"));
        getJpaUser().addEntity(guest);
        getJpaSubscriber().addEntity(subscriber);
        getJpaSubscribe().addEntity(s1);
        getJpaSubscribe().addEntity(s2);
        getJpaSubscribe().addEntity(s3);
        getJpaSubscribe().addEntity(s4);
        getJpaSubscribe().addEntity(s5);

        getJpaRole().commit();
        getJpaUser().commit();
        getJpaSubscribe().commit();
        getJpaSubscriber().commit();

        System.out.println(" Создано " + id + " сиcтемных объектов ");
    }

    public static void initiateDB() {
//        EntityManager em = getEm();
//        Query qwr = em.createNamedQuery("Reference.findById");
//        qwr.setParameter("id", "1");
//        List resultList = qwr.getResultList();
//        if (!resultList.isEmpty())
//            return;
//        createDefaultObjects();
    }
}
