public class No {
    int valor;
    public No p_Esq;
    public No p_Dir;

    public No(int valor) {
        this.valor = valor;
        this.p_Esq = null;
        this.p_Dir = null;
    }

    int getValor() {
        return this.valor;
    }

    void setValor(int novo) {
        this.valor = novo;
    }
}
