
package org.superbiz.struts;
 
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
 
@Stateless
public class UserServiceImpl implements UserService {
 
    @PersistenceContext(unitName = "user")
    private EntityManager manager;
 
    public void add(User user) {
        manager.persist(user);
    }
 
    public User find(int id) {
        return manager.find(User.class, id);
    }
 
    public List<User> findAll() {
        return manager.createQuery("select u from User u").getResultList();
    }
}
