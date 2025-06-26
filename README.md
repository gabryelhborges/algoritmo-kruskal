# Algoritmo de Kruskal

Uma implementação em Java do algoritmo de Kruskal para encontrar a Árvore Geradora Mínima (AGM) de um grafo ponderado.

## 📋 Sobre o Projeto

Este projeto implementa o algoritmo de Kruskal, um algoritmo guloso usado para encontrar a árvore geradora mínima de um grafo conectado e ponderado. O algoritmo encontra um subconjunto das arestas que forma uma árvore incluindo todos os vértices, onde o peso total das arestas é minimizado.

## 🏗️ Estrutura do Projeto

```
AlgoritmoKruskal/
├── src/
│   ├── Main.java           # Classe principal com implementação do algoritmo
│   ├── Aresta.java         # Classe que representa uma aresta do grafo
│   ├── agmkruskel.txt      # Arquivo de entrada com grafo de 7 vértices
│   └── grafo.txt           # Arquivo de entrada com grafo de 10 vértices
```

## 🔧 Funcionalidades

### Classe Aresta
A classe [`Aresta`](AlgoritmoKruskal/src/Aresta.java) representa uma conexão entre dois vértices com as seguintes propriedades:
- **Origem**: Vértice de origem da aresta
- **Destino**: Vértice de destino da aresta  
- **Peso**: Peso/custo da aresta

### Algoritmo de Kruskal
A implementação principal em [`Main.java`](AlgoritmoKruskal/src/Main.java) segue os seguintes passos:

1. **Leitura do Grafo**: 
   - Lê a primeira linha para obter os vértices
   - Constrói uma matriz de adjacência a partir do arquivo de entrada

2. **Criação das Arestas**:
   - Converte a matriz de adjacência em uma lista de arestas
   - Ordena as arestas por peso (critério principal) e depois por ordem alfabética

3. **Algoritmo de Kruskal**:
   - Processa as arestas em ordem crescente de peso
   - Utiliza uma técnica de union-find simplificada através de strings
   - Evita a formação de ciclos verificando se os vértices já estão conectados
   - Para quando todos os vértices estão conectados em uma única componente

4. **Resultados**:
   - Exibe a matriz de adjacência original
   - Lista todas as arestas ordenadas por peso
   - Mostra o processo de formação das componentes conexas
   - Apresenta as arestas selecionadas para a AGM
   - Calcula o custo total da árvore geradora mínima

## 📊 Formato dos Arquivos de Entrada

Os arquivos de entrada seguem o formato:
```
A B C D E F G
0 1 0 4 0 0 0
1 0 2 6 4 0 0
0 2 0 0 5 6 0
4 6 0 0 3 0 4
0 4 5 3 0 8 7
0 0 6 0 8 0 3
0 0 0 4 7 3 0
```

- **Primeira linha**: Vértices do grafo separados por espaço
- **Linhas seguintes**: Matriz de adjacência onde 0 indica ausência de aresta

## 🚀 Como Executar

1. Compile o projeto:
   ```bash
   javac AlgoritmoKruskal/src/*.java
   ```

2. Execute o programa:
   ```bash
   java -cp AlgoritmoKruskal/src Main
   ```

3. O programa utilizará o arquivo [`agmkruskel.txt`](AlgoritmoKruskal/src/agmkruskel.txt) por padrão

## 📈 Exemplo de Saída

O programa exibe:
- Matriz de adjacência do grafo original
- Lista de todas as arestas ordenadas por peso
- Processo iterativo de formação das componentes conexas
- Arestas selecionadas para formar a AGM
- Custo total da árvore geradora mínima

# Exemplo:
```
Matriz de adjacência: 
0 1 0 4 0 0 0 
1 0 2 6 4 0 0 
0 2 0 0 5 6 0 
4 6 0 0 3 0 4 
0 4 5 3 0 8 7 
0 0 6 0 8 0 3 
0 0 0 4 7 3 0 

Lista de Arestas: 
A B 1
B C 2
D E 3
F G 3
A D 4
B E 4
D G 4
C E 5
B D 6
C F 6
E G 7
E F 8

Componentes:
B B C D E F G 
C C C D E F G 
C C C E E F G 
C C C E E G G 
E E E E E G G 
G G G G G G G 

T - Arestas selecionadas: 
A B 1
B C 2
D E 3
F G 3
A D 4
D G 4

Custo total: 17
Linha: G G G G G G G
```
## 🔍 Algoritmo Implementado

A implementação utiliza uma abordagem simplificada do union-find através de manipulação de strings, onde:
- Cada vértice inicialmente forma sua própria componente
- Ao conectar dois vértices, suas componentes são unificadas
- O algoritmo para quando resta apenas uma componente (todos os vértices conectados)

Esta implementação é educacional e demonstra os conceitos fundamentais do algoritmo de Kruskal de forma clara e



