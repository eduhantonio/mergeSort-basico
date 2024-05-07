import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // Array de inteiros a ser ordenado
        int[] vetor = {7, 4, 6, 2, 1, 10, 9};
        
        // Chamada inicial para o mergeSort com índices inicial e final do vetor
        mergeSort(vetor, 0, 6); // 0 e 6 são os índices do vetor ("tamanho")
        
        // Imprime o vetor ordenado
        System.out.println(Arrays.toString(vetor));
    }

    // Função recursiva para ordenar o vetor usando o algoritmo Merge Sort
    public static void mergeSort(int[] vetor, int inicio, int fim) {
        // Verifica se há mais de um elemento no vetor a ser ordenado
        if (inicio < fim) {
            // Calcula o ponto médio do vetor
            int meio = (inicio + fim) / 2;
            // Chama recursivamente o mergeSort para a metade esquerda do vetor
            mergeSort(vetor, inicio, meio); // Vetor esquerda
            
            // Chama recursivamente o mergeSort para a metade direita do vetor
            mergeSort(vetor, meio+1, fim);  // Vetor Direita

            // Mescla as duas metades ordenadas
            System.out.println("Inicio esquerda: "+inicio+", Fim esquerda: "+meio+", Inicio Direita: "+ (meio+1)+", Fim Direita: "+ fim);
            merge(vetor, inicio, meio, meio+1, fim);
        }
    }

    // Função para mesclar duas metades ordenadas do vetor
    public static void merge(int[] vetor, 
                             int inicioEsquerda,
                             int fimEsquerda,
                             int inicioDireita,
                             int fimDireita) {
        // Variáveis para controlar a mesclagem
        int inicioVetor = inicioEsquerda;
        int[] vetorAuxiliar = new int[(fimDireita - inicioEsquerda) + 1];
        int indiceVetorAuxiliar = 0;
        int indiceVetor = inicioEsquerda;

        // Loop para mesclar os elementos das duas metades
        while (inicioEsquerda <= fimEsquerda && inicioDireita <= fimDireita) {
            // Compara os elementos das duas metades e copia o menor para o vetorAuxiliar
            if (vetor[inicioEsquerda] > vetor[inicioDireita]) { // invertendo o sinal, ele ficará em ordem decrescente (?)
                vetorAuxiliar[indiceVetorAuxiliar] = vetor[inicioEsquerda];
                inicioEsquerda++;
            } else {
                vetorAuxiliar[indiceVetorAuxiliar] = vetor[inicioDireita];
                inicioDireita++;
            }
            indiceVetorAuxiliar++;
        }
        
        // Copia os elementos restantes da metade esquerda para o vetorAuxiliar
        for (; inicioEsquerda <= fimEsquerda; inicioEsquerda++) {
            vetorAuxiliar[indiceVetorAuxiliar] = vetor[inicioEsquerda];
            indiceVetorAuxiliar++;
        }
        
        // Copia os elementos restantes da metade direita para o vetorAuxiliar
        for (; inicioDireita <= fimDireita; inicioDireita++) {
            vetorAuxiliar[indiceVetorAuxiliar] = vetor[inicioDireita];
            indiceVetorAuxiliar++;
        }
        
        // Copia os elementos ordenados de volta para o vetor original
        for (indiceVetorAuxiliar = 0; indiceVetor <= fimDireita; indiceVetorAuxiliar++, indiceVetor++)
            vetor[indiceVetor] = vetorAuxiliar[indiceVetorAuxiliar];
    }
}
