import java.util.*;

public class Main {
    
    public static int prim(int raiz, ArrayList<ArrayList<int[]>> costos, int nodos) {
        PriorityQueue<int[]> pq = new PriorityQueue<> (Comparator.comparingInt(a -> a[0]));
        boolean[] vis = new boolean[nodos];
        int movimientosTotales = 0;
        aggAristasValidas(0, costos, vis, pq);
        int i = 1;
        while (!pq.isEmpty() && i < nodos) {
            int[] arista = pq.poll();
            if (!vis[arista[2]]) {
                // System.out.print("entra a if");
                // System.out.print(arista[0]);
                movimientosTotales += arista[0];
                aggAristasValidas(arista[2], costos, vis, pq);
                i++;
            }
        }
        return movimientosTotales;
    }

    public static void aggAristasValidas(int nodo, ArrayList<ArrayList<int[]>> costos, boolean[] vis, PriorityQueue<int[]> pq) {
        vis[nodo] = true;
        ArrayList<int[]> aristas = costos.get(nodo);
        for (int[] arista : aristas) {
            if (!vis[arista[2]]) {
                pq.add(arista);
            }
        }
    }

    public static int rolls(String v1, String v2) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int a = Character.getNumericValue(v1.charAt(i));;
            int b = Character.getNumericValue(v2.charAt(i));
            res += Math.min((a - b + 10) % 10, (b - a + 10) % 10);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantTest = scanner.nextInt();
		
        for (int i = 0; i < cantTest; i++) {
            int cant_codigos = scanner.nextInt() + 1;
            String[] codigos = new String[cant_codigos];
            codigos[0] = "0000";

			for(int j = 1; j < cant_codigos; j++){
				codigos[j] = scanner.next();
			}
            ArrayList<ArrayList<int[]>> costos = new ArrayList<ArrayList<int[]>>();

            for(int k = 0; k < cant_codigos; k++){
                costos.add(new ArrayList<int[]>());
                if(k > 0){
                    for(int l = 0; l < cant_codigos; l++){
                        if(k != l){
                            costos.get(k).add(new int[]{rolls(codigos[k], codigos[l]), k, l});
                        }
                    }
                }
            }
            
            int minimos = 37;
            int codigoInicial = 1;
            for (int l = 1; l < cant_codigos; l++) {
                int costo = rolls(codigos[l], "0000");
                if (costo < minimos) {
                    minimos = costo;
                    codigoInicial = l;
                }
            }
            costos.get(0).add(new int[]{minimos, 0, codigoInicial});
            int res = prim(0, costos, cant_codigos);
            System.out.println(res);

        }
        scanner.close();
    }
}