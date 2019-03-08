package testing;

import entity.Computer;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import manager.ComputerManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class test {
    
    private ComputerManager cm;
    private EntityManager em;
     
    
    public test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        em = Mockito.mock(EntityManager.class);
        cm = new ComputerManager();
        cm.setEm(em);
    }
    
    private Computer createComputer() {
        return new Computer("Svive Luna S100", "MSI B360", "i5-8400 2.8GHz", "MSI Geforce GTX 1050 Ti 4GB", "CM MasterWatt 600W", "BX500 240GB SSD", "HyperX Fury DDR4 8GB", 3456.6);
    }
    
    private void mockQuery(String name, List<Computer> results) {
        TypedQuery mockedQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(mockedQuery.getResultList()).thenReturn(results);
        Mockito.when(mockedQuery.setParameter(Matchers.anyString(), Matchers.anyObject())).thenReturn(mockedQuery);
        Mockito.when(em.createNamedQuery(name, Computer.class)).thenReturn(mockedQuery);
    }
    
    @Ignore
    public void testGetAllComputers() {
        List<Computer> computersStored = Arrays.asList(createComputer());
        mockQuery("Computer.getAllComputers", computersStored);

        List<Computer> computersRead = cm.getAllComputers();
        assertEquals(computersStored, computersRead);
    }

    @Test
    public void addComputer() {
        Computer c = createComputer();
        cm.addComputer(c);
        Mockito.verify(em).persist(Matchers.eq(c));
    }
    
    @Test
    public void updateComputer() {
        Computer c = createComputer();
        cm.updateComputer(c);
        Mockito.verify(em).merge(Matchers.eq(c));
    }
    
    @Test
    public void removeComputer() {
        Computer c = createComputer();
        Mockito.when(em.find(Computer.class, 1L)).thenReturn(c);
        cm.deleteComputerByID(1L);
        Mockito.verify(em).remove(Matchers.eq(c));
    }
    
    @Test
    public void findComputerById() {
        Computer c = createComputer();
        Mockito.when(em.find(Computer.class, 1L)).thenReturn(c);
        Computer foundComp = cm.getComputer(1L);
        assertEquals(c, foundComp);
    }
    
    @Test
    public void findComputerWhenNotExist() {
        Computer foundComp = cm.getComputer(1L);
        assertNull(foundComp);
    }
  
}