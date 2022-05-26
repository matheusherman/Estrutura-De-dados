public class ArvoreBusca {
    private No raiz;


    public ArvoreBusca() //construtor
    {
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
            if (novo.getValor() < inicio.getValor())
                inicio.p_Esq = this.Inserir(novo, inicio.p_Esq);
            else
                inicio.p_Dir = this.Inserir(novo, inicio.p_Dir);
            return inicio;
        } else
            return novo;
    }

    // Ordem crescente
    public void ImprimirCrescente(No raiz) {
        if (raiz != null) {
            this.ImprimirCrescente(raiz.p_Esq);
            System.out.print(raiz.getValor() + ", ");
            this.ImprimirCrescente(raiz.p_Dir);
        }
    }

    // Ordem decrescente
    public void ImprimirDecrescente(No raiz) {
        if (raiz != null) {
            this.ImprimirDecrescente(raiz.p_Dir);
            System.out.print(raiz.getValor() + ", ");
            this.ImprimirDecrescente(raiz.p_Esq);
        }
    }

}
