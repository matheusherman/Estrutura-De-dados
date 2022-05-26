public class ArvoreBin {
    private No raiz;

    public ArvoreBin() { //construtor
        this.raiz = null;
    }

    public No ObtemRaiz() {
        return this.raiz;
    }

    public void Adicionar(int novo) {
        No n = new No(novo);
        this.raiz = this.Inserir(n, this.raiz);
    }

    private No Inserir(No novo, No inicio) {

        if (inicio != null) {
            if (inicio.p_Esq == null) {
                inicio.p_Esq = this.Inserir(novo, inicio.p_Esq);

            } else if (inicio.p_Dir == null) {
                inicio.p_Dir = this.Inserir(novo, inicio.p_Dir);
            } else
                inicio.p_Esq = this.Inserir(novo, inicio.p_Esq);
                return inicio;
        } else
            return novo;
    }

}
