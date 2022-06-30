public class ArvoreBusca {
    private No raiz;
    private No raizBusca;

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

    public Integer Buscar(int busca) {
        try {
            this.raizBusca = this.raiz;
            while (busca != raizBusca.valor) {
                Busca(busca, raizBusca);
            }
            return raizBusca.valor;
        } catch (NullPointerException e) {
            return null;
        }
    }

    private No Busca(int busca, No raizBusca) {
        if (busca != raizBusca.getValor()) {
            if (busca < raizBusca.getValor())
                this.raizBusca = raizBusca.p_Esq;
            else
                this.raizBusca = raizBusca.p_Dir;
            return this.raizBusca;
        } else
            return this.raiz;
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
