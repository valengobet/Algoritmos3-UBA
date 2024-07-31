import java.util.*;
public class Main2{
	// public int[][] dijkstra(int raiz,int cant_nodos,  int[][] aristas){
	// 	ArrayList<Integer> S = new ArrayList<Integer>();
	// 	int[] distancias = new int[cant_nodos];
	// 	int[] pred = new int[cant_nodos];
	// 	for(int i = 1; i < cant_nodos; i++){
	// 		if()
	// 	}
		
	// }




    public static void main(String args[]){
		int cant_asc = 2;
		int[] vel = {5, 3};
        int[][] paradas = {{0, 1}, {1, 1}, {1, 2}, {2, 2}};
		ArrayList<ArrayList<int[]>> grafo = new ArrayList<ArrayList<int[]>>();
		int[][] vis = new int[cant_asc][100];
		// int[][][] grafo = new int[paradas.length][][];
		for (int i = 0; i < vis.length; i++) {
			for(int j = 0; j < 100; j++){
				vis[i][j] = -1;
			}
        }
		for(int i = 0; i < paradas.length; i++){
			grafo.add(new ArrayList<int[]>());
			int piso = paradas[i][0];
			int asc_actual = paradas[i][1];
			for(int j = 0; j < asc_actual; j++){
				if(vis[j][piso] != -1 && asc_actual != j){;
					System.out.println("se agrega por parada visitada");
					grafo.get(i).add(new int[] {vis[j][piso], 60});
				}
			}
			if((i+1) < paradas.length && paradas[i+1][1] == asc_actual){
				System.out.println("se agrega normal");
				vis[asc_actual-1][piso] = i;
				int piso_sig = paradas[i+1][0];
				int costo = (piso_sig -piso)* vel[asc_actual-1];
				grafo.get(i).add(new int[] {i+1, costo});
			} else{
				vis[asc_actual-1][piso] = i;
			}
		}
		for(int i = 0; i < grafo.size(); i++){
			for(int j = 0; j < grafo.get(i).size(); j++){
				System.out.println("nodo: " + i);
				System.out.print("(" + grafo.get(i).get(j)[0] + ", " + grafo.get(i).get(j)[1] +  ")");
			}
		}
	}
		
		
		
}
