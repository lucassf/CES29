package test;

import com.mycompany.interfaces.IRepositorioProcessos;
import com.mycompany.siapj1.Processo;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersistenceMockTest {
    
    private static Processo processo1;
    private static Processo processo2;
    private static IRepositorioProcessos rep;
    
    @BeforeClass
    public static void setUpClass() {
        processo1 = new Processo(0,"A","0129","A@gmail.com","ata0");
        processo2 = new Processo(1,"B","0129","B@gmail.com","ata1");
        
        rep = mock(IRepositorioProcessos.class);
        when(rep.addProcess(processo1)).thenReturn(true);
        when(rep.addProcess(processo2)).thenReturn(false);
        when(rep.getProcess(0)).thenReturn(processo2);
    }
    
    @Test
    public void AddValidProcess(){
        assertTrue(rep.addProcess(processo1));
    }
    
    @Test
    public void AddInvalidProcess(){
        assertFalse(rep.addProcess(processo2));
    }
    
    @Test
    public void GetProcessFromDatabase(){
        Processo processo = rep.getProcess(0);
        assertEquals(processo2.getNomeReclamante(), processo.getNomeReclamante());
        assertEquals(processo2.getTelefone(), processo.getTelefone());
        assertEquals(processo2.getEmail(), processo.getEmail());
        assertEquals(processo2.getContent(), processo.getContent());
    }
}
