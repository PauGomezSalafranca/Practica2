package AprendizajeAutomatico;

public interface AlgoritmoML<T, R, S> {


    void train(T data);
    R estimate(S sample);
}
