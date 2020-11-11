class Fila1 {
    int inicio,fim,total,tamanho;
    int vetor[];
    Fila1 (int tam) {
        inicio = 0;
        fim = 0;
        total = 0;
        tamanho = tam;
        vetor = new int[tam];
    }
    public boolean vazia(){
        if (total == 0){
            return true;
        }
        else
            return false;
    }
    public boolean cheia() {
        if (total >= tamanho)
            return true;
        else
            return false;
    }
    public void enfileirar(int x){
        if (! cheia()){
            vetor[fim] = x;
            fim++;
            total ++;
            if (fim >= tamanho)
                fim = 0;            
        }
        else
                System.out.println("A fila esta cheia");
    }
    public int desenfileirar() {
        int num = 0;
        if (vazia()){
            System.out.println("A fila esta vazia");
        }
        else {
            num = vetor[inicio];
            inicio ++;
            total --;
            if (inicio >= tamanho){
                inicio = 0;
            }
        }
       return num;
    }
    public void mostrarfila(){
        int aux = inicio;
        for (int i = 1;i<=total;i++){
            System.out.println(vetor[aux]);
            aux++;
            if (aux >= tamanho)
                aux = 0;
        }
    }
}
