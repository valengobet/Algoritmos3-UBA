
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static int dfs(int v, int p, ArrayList<ArrayList<Integer>> grafo, int[] visitados, int[] backedge, int[] valor_paloma){
        if(p == -1){
            visitados[v] = 1;
        } else{
            visitados[v] = visitados[p] + 1;
        }
        int cubren = 0;
        int cubren_hijo = 0;

        for(int i = 0; i < grafo.get(v).size(); i++){
            int hijo = grafo.get(v).get(i);
            if(visitados[hijo] == 0){
                cubren_hijo = dfs(hijo, v, grafo, visitados, backedge, valor_paloma);

                if(cubren_hijo - backedge[v] == 0){
                    valor_paloma[v]++;
                }
                cubren += cubren_hijo - backedge[v];
                backedge[v] = 0;
            }
            else if(hijo != p && visitados[hijo] < visitados[v]){
                cubren++;
                backedge[hijo]++;
            }
        }
        return cubren;
    }

    public static void sort(int[][] lista, int izquierda, int derecha){
        if(izquierda < derecha){
            int mitad = (izquierda + derecha) / 2;

            sort(lista, izquierda, mitad);
            sort(lista, mitad+1, derecha);

            merge(lista, izquierda, mitad, derecha);
        }
    }

    public static void merge(int[][] lista, int izquierda, int mitad, int derecha){
        int n1 = mitad - izquierda + 1;
        int n2 = derecha - mitad;

        int [][] mitad_izquierda = new int[n1][];
        int [][] mitad_derecha = new int[n2][];

        for(int i = 0; i < n1; i++){
            mitad_izquierda[i] = lista[izquierda+i];
        }
        for(int j = 0; j < n2; j++){
            mitad_derecha[j] = lista[mitad + j + 1];
        }

        int i = 0; int j = 0; int k = izquierda;

        while(i < n1 && j < n2){
            if(mitad_izquierda[i][1] > mitad_derecha[j][1]){
                lista[k] = mitad_izquierda[i];
                i++;
            } else if(mitad_izquierda[i][1] == mitad_derecha[j][1]){
                if(mitad_izquierda[i][0] < mitad_derecha[j][0]){
                    lista[k] = mitad_izquierda[i];
                    i++;
                } else{
                    lista[k] = mitad_derecha[j];
                    j++;
                }
            } else{
                lista[k] = mitad_derecha[j];
                j++;
            } 
            k++;
        }

        while (i < n1) {
            lista[k] = mitad_izquierda[i];
            i++;
            k++;
          }

          while (j < n2) {
            lista[k] = mitad_derecha[j];
            j++;
            k++;
          }
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        while(N != 0 && M != 0){
            int cant_estaciones = N;
            int estaciones_candidatas = M;
            ArrayList<ArrayList<Integer>> grafo = new ArrayList<>();
            for(int k = 0; k < cant_estaciones; k++){
                grafo.add(new ArrayList<>());
            }
            int[] visitados = new int[cant_estaciones];
            int[] backedge = new int[cant_estaciones];
            int[] valor_paloma = new int[cant_estaciones];
            for(int i = 1; i < cant_estaciones; i++){
                valor_paloma[i] = 1;
            }

            int v = scanner.nextInt();
            int u = scanner.nextInt();
            while(v != -1 && u != -1){
                grafo.get(v).add(u);
                grafo.get(u).add(v);
                v = scanner.nextInt();
                u = scanner.nextInt();
            }
            dfs(0, -1, grafo, visitados, backedge, valor_paloma);
            int[][] valor_paloma_index = new int[cant_estaciones][2];
            for(int j = 0; j < cant_estaciones; j++){
                valor_paloma_index[j][0] = j;
                valor_paloma_index[j][1] = valor_paloma[j];
            }
            sort(valor_paloma_index, 0, valor_paloma_index.length-1);
            for(int j = 0; j < estaciones_candidatas; j++){
                System.out.println(valor_paloma_index[j][0] + " " + valor_paloma_index[j][1]);
            }
            N = scanner.nextInt();
            M = scanner.nextInt();
            System.out.println();
        }
        scanner.close();
    }
}

