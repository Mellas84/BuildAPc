
package manager;

import entity.Computer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ComputerManager {
    
    @PersistenceContext(name="BuildYourComputerProjectPU")
    EntityManager em;
    
    public void addComputer(Computer c) {
        em.persist(c);
    }
    
    public void updateComputer(Computer c) {
        em.merge(c);
    }
    
    public void deleteComputer(Computer c) {
        em.remove(em.merge(c));
    }
    
    public List<Computer> getAllComputers() {
       Query q = em.createQuery("Select c from Computer c");
       return q.getResultList();
    }
    
    public Computer getComputer(Integer id) {
        return em.find(Computer.class, id);
    }
}
