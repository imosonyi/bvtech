package hu.imosonyi.bvtech.analysis;

public interface Analyzer<S, R> {
    
    R analyze (S source);

}
