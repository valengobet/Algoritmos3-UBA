import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    public static int[][] BFS (int[][] aristas,  int raiz, int cant_nodos, int[][] dist){
        int[] pred = new int[cant_nodos+1];
        int[] orden = new int[cant_nodos+1];
        int next = 1;
        int r = raiz;
        pred[r] = 0;
        orden[r] = next;
        boolean noHay = false;
        Queue<Integer> Lista = new LinkedList<>();
        Lista.add(r);
        while(!Lista.isEmpty()){
            int i = Lista.peek();
            for(int j = 1; j <= 10; j++){
                int[] arco = {i,j};
                if((pertenece(arco, aristas)) && !Lista.contains(j) && orden[j] == 0){
                    pred[j] = i;
                    dist[r-1][j-1] = dist[r-1][i-1] + 1;
                    dist[j-1][r-1] = dist[r-1][j-1];
                    next += 1;
                    orden[j] = next;
                    Lista.add(j);
                } else if(j == 10){
                    noHay = true;
                }
            }

            if(noHay){
                Lista.remove(i);
                noHay = false;
            }

        }
        int[][] res = {pred, orden};
        return res;
    }

    public static boolean pertenece(int[] arco, int[][]aristas){
        for(int i = 0; i < aristas.length; i++){
            if(Arrays.equals(aristas[i], arco)){
                //System.out.println("entra al if pertenece");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("empezo");
        int[][] aristas = {{1,2}, {1,3}, {3,2}};
        int cant_nodos = 3;
        int[][] dist = new int[3][3];
        int[][] res = new int[2][cant_nodos];
        for(int v = cant_nodos; v >= 1; v--){
            res = BFS(aristas, v, cant_nodos, dist);
        }
        for(int i = 0; i < res[0].length; i++){
            System.out.println(res[0][i] + " ");
        }


        for(int j = 0; j < dist.length; j++){
            System.out.print("[ ");
            for(int k = 0; k < dist[j].length; k++){
                System.out.print(dist[j][k] + ", ");
            }
            System.out.print(" ]");
        }
    }
}
