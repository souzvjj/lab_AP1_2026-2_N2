
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Os testes prontos servem de exemplo.
 * Complete os testes marcados com //TODO (Tarefas 4 e 5).
 */
public class AssinanteTest {

    private Assinante assinante;

    @BeforeEach
    void setUp() {
        assinante = new Assinante("Ana");
    }

    @Test
    void deveRegistrarAssistidoPorTitulo() {
        assinante.adicionar(new Episodio("Piloto", 1, 42));
        assertTrue(assinante.registrarAssistido("Piloto"));
        assertEquals(42, assinante.tempoTotalAssistido());
    }

    @Test
    void naoDeveRegistrarTituloInexistente() {
        assinante.adicionar(new Episodio("Piloto", 1, 42));
        assertFalse(assinante.registrarAssistido("Final"));
    }

    @Test
    void deveCalcularCreditoDeTempo() {
        assinante.adicionar(new Episodio("A", 1, 40));
        assinante.adicionar(new Episodio("B", 1, 50));
        assinante.registrarAssistido("A");
        assertEquals(50, assinante.creditoDeTempo());
    }

    @Test
    void resumoDeveConterNomeEClassificacao() {
        assinante.adicionar(new Episodio("Piloto", 1, 42));
        String r = assinante.resumo();
        assertTrue(r.contains("Ana"), r);
        assertTrue(r.contains("INICIANTE"), r);
    }

    @Test
    void deveClassificarEngajamento() {
        //TODO Tarefa 4: testar classificacaoEngajamento em pelo menos dois cenários
        // (ex.: 4 episódios com 2 assistidos → REGULAR; 4 com 4 assistidos → BINGE)
        assinante.adicionar(new Episodio("Felipe Python", 1, 50));
        assinante.adicionar(new Episodio("Lucca Java", 1, 50));
        assinante.adicionar(new Episodio("Wesley",1,50 ));
        assinante.adicionar(new Episodio("Bloons TD6: História completa", 1, 600));

        //Vai dar Regular
        assinante.registrarAssistido("Felipe Python");
        assertEquals(1.0, assinante.classificacaoEngajamento().getTaxaAplicada(), 0.01);
        // Vai dar 0, por passar de 600 minutos
        assinante.registrarAssistido("Lucca Java");
        assinante.registrarAssistido("Bloons TD6: História completa");
        assertEquals(0.0, assinante.classificacaoEngajamento().getTaxaAplicada(), 0.01);
    }

    @Test
    void deveCalcularTarifaMensal() {
        //TODO Tarefa 5: testar tarifaMensal usando o fator da classificação
        // (ex.: BINGE sem isenção → 29,90 × 1,10) e a isenção acima de 600 minutos
        assinante.adicionar(new Episodio("Felipe Python", 1, 50));
        assinante.adicionar(new Episodio("Lucca Java", 1, 50));
        assinante.adicionar(new Episodio("Wesley",1,50 ));
        assinante.adicionar(new Episodio("Bloons TD6: História completa", 1, 600));

        //Vai dar 29.9(50 minutos)
        assinante.registrarAssistido("Lucca Java");
        assertEquals(29.9, assinante.tarifaMensal(), 0.01);

        //Vai dar 0 (acima 600)
        assinante.registrarAssistido("Bloons TD6: História completa");
        assertEquals(0,assinante.tarifaMensal(), 0.01);
    }
}
