import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String arq = System.getProperty("user.dir") + "\\src\\agmkruskel.txt";
        //D:\\
        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            List<Aresta> arestas;
            List<String> vertices;
            String linha = br.readLine();
            vertices = Arrays.asList(linha.split(" "));

            int[][] matriz = new int[vertices.size()][vertices.size()];
            alimentaMatriz(br, matriz);
            exibeMatriz(matriz);

            arestas = criaVetArestas(vertices, matriz);
            System.out.println("\n\n\nLista de Arestas: \n");
            arestas.forEach(System.out::println);
            System.out.println("\n\n\nComponentes:");

            boolean flag = false, parar = false;
            String res = "";
            int custoTotal= 0;
            int i;
            List<Aresta> arestasEncontradas = new ArrayList<>();
            for (i = 0; i < arestas.size() && !parar; i++) {
                Aresta a = arestas.get(i);
                if (!flag) {
                    if (!res.contains(a.getDestino()) && !res.contains(a.getOrigem())) {
                        res += a.getOrigem() + " " + a.getDestino() + " ";
                        custoTotal += a.getPeso();
                        arestasEncontradas.add(a);
                        linha = substituirVerticesLinha(linha, vertices, a.getOrigem(), a.getDestino());
                        System.out.println("" + linha);
                    } else {
                        if (!res.contains(a.getDestino())) {
                            res += a.getDestino() + " ";
                            custoTotal += a.getPeso();
                            arestasEncontradas.add(a);
                            linha = substituirVerticesLinha(linha, vertices, a.getOrigem(), a.getDestino());
                            System.out.println("" + linha);
                        } else if (!res.contains(a.getOrigem())) {
                            res += a.getOrigem() + " ";
                            custoTotal += a.getPeso();
                            arestasEncontradas.add(a);
                            linha = substituirVerticesLinha(linha, vertices, a.getOrigem(), a.getDestino());
                            System.out.println("" + linha);
                        }
                    }
                    if (temTodosVertices(vertices, res)) {
                        flag = true;
                    }
                }
                else{//somente apos ter todos os vertices
                    if (linha.contains(a.getOrigem()) || linha.contains(a.getDestino())){
                        int indexOrigem = vertices.indexOf(a.getOrigem());
                        int indexDestino = vertices.indexOf(a.getDestino());
                        String aux = linha.replace(" ", "");
                        if(aux.charAt(indexDestino) != aux.charAt(indexOrigem)) {
                            arestasEncontradas.add(a);
                            custoTotal += a.getPeso();
                            linha = substituirVerticesLinha(linha, vertices, a.getOrigem(), a.getDestino());
                            System.out.println("" + linha);
                        }
                    }
                    else{
                        String aux = linha.replace(" ","");
                        int indexOrigem = vertices.indexOf(a.getOrigem());
                        int indexDestino = vertices.indexOf(a.getDestino());
                        if(aux.charAt(indexOrigem) != aux.charAt(indexDestino)){
                            arestasEncontradas.add(a);
                            custoTotal+= a.getPeso();
                            char letra = aux.charAt(indexOrigem);
                            char letra2 = aux.charAt(indexDestino);
                            aux = aux.replace(letra+"", a.getOrigem());
                            aux = aux.replace(a.getOrigem(), letra2+"");
                            linha = "";
                            for (int j = 0; j < aux.length(); j++) {
                                linha += aux.charAt(j) + " ";
                            }
                            System.out.println("" + linha);
                        }
                    }
                    if (somenteUmaLetra(linha)) {
                        parar = true;
                    }
                }
                //System.out.println("Linha: " + linha);
            }
            System.out.println("\n\nT - Arestas selecionadas: ");
            arestasEncontradas.forEach(System.out::println);
            System.out.println("\nCusto total: " + custoTotal);
            System.out.println("Linha: " + linha);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String substituirVerticesLinha(String linha, List<String> vertices, String origem, String destino) {
        String aux = linha;
        aux = aux.replace(" ", "");
        if (aux.contains(origem) && aux.contains(destino)) {
            aux= aux.replace(origem, destino);
        }
        else {
            if (!aux.contains(origem)) {
                int index = vertices.indexOf(origem);
                char letra = aux.charAt(index);
                aux = aux.replace(letra+"", destino);
            } else if (!aux.contains(destino)) {
                int index = vertices.indexOf(destino);
                char letra = aux.charAt(index);
                aux = aux.replace(letra+"", origem);
            }
        }
        linha = "";
        for (int i = 0; i < aux.length(); i++) {
            linha += aux.charAt(i) + " ";
        }
        return linha;
    }

    private static boolean somenteUmaLetra(String linha) {
        linha= linha.replace(" ", "");
        char firstChar = linha.charAt(0);
        for (int i = 1; i < linha.length(); i++) {
            if (linha.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }

    private static boolean temTodosVertices(List<String> vertices, String res) {
        for (String vertice : vertices) {
            if(!res.contains(vertice)){
                return false;
            }
        }
        return true;
    }

    private static List<Aresta> criaVetArestas(List<String> vertices, int[][] matriz) {
        List<Aresta> arestas = new ArrayList<>();
        int qtdeVertices = vertices.size();
        for (int i = 0; i < qtdeVertices; i++) {
            for (int j = i; j < qtdeVertices; j++) {
                if(matriz[i][j] != 0){
                    arestas.add(new Aresta(vertices.get(i), vertices.get(j), matriz[i][j]));
                }
            }
        }
        arestas.sort((a1, a2) -> {
            int pesoComparison = a1.getPeso() - a2.getPeso();
            if (pesoComparison != 0) {
                return pesoComparison;
            }
            int origemComparison = a1.getOrigem().compareTo(a2.getOrigem());
            if (origemComparison != 0) {
                return origemComparison;
            }
            return a1.getDestino().compareTo(a2.getDestino());
        });
        return arestas;
    }

    private static void alimentaMatriz(BufferedReader br, int[][] matriz) throws IOException {
        String linha;
        int linhaIndex = 0;
        while ((linha = br.readLine()) != null) {
            String[] valores = linha.split(" ");
            for (int i = 0; i < valores.length; i++) {
                matriz[linhaIndex][i] = Integer.parseInt(valores[i]);
            }
            linhaIndex++;
        }
    }

    public static void exibeMatriz(int[][] matriz) {
        System.out.println("\n\n\n");
        System.out.println("Matriz de adjacência: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n\n");
    }
}