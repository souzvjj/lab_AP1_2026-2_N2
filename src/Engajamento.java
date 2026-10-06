
/**
 * Classificação de engajamento do assinante.
 * Cada classificação tem um fator aplicado sobre a tarifa base:
 * INICIANTE 1,00; REGULAR 1,00; ENGAJADO 0,95; BINGE 1,10.
 */
public enum Engajamento {
    INICIANTE(1), REGULAR(1), ENGAJADO(0.95), BINGE(1.1), NAOPAGA(0);
    
    public double taxaAplicada;
    public double taxaBase = 29.9;

    private Engajamento(double taxaAplicada){
        this.taxaAplicada = taxaAplicada;  
    }
    public double getTaxaAplicada() {
        return taxaAplicada;
    }
    //TODO Tarefa 1: associar a cada constante seu fator de tarifa
    // (atributo, construtor e método getFator())
}
