import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt();
        for(int i = 0; i < casos; i++){
            int t = scanner.nextInt(); 
            int h = scanner.nextInt();
            int f = scanner.nextInt();
            int[][] arboles = new int[h][t];
            // Armo una matriz en donde cada columna representa un arbol y cada fila una altura. En esta matriz guardo cuantas bellotas hay en cada altura en cada arbol.
            for(int j = 0; j < t; j++){
                int cant_bellotas = scanner.nextInt();
                for(int k = 0; k < cant_bellotas; k++){
                    arboles[scanner.nextInt() - 1][j] += 1;
                }
            }
            // Llamo a la funcion que calcula cual es la mayor cantidad de bellotas que se pueden recolectar en una bajada.
            int res = mjBajada(arboles, h, t, f);
            System.out.println(res);

        }   
        scanner.nextInt();
        scanner.close();
    }

    public static int mjBajada(int[][] arboles, int h, int t, int f){
        // Creo una lista de la misma longitud que las alturas de los arboles. En esta lista guardo en la posicion i la mayor cantidad de bellotas que se pueden recolectar bajando 
        // desde esa altura.
        int[] max_por_altura = new int[h];
        
        // Recorro para cada altura cada arbol y calculo cual es el maximo de bellotas que se pueden recolectar desde esa posicion. Luego guardo esta informacion en la matriz de los arboles
        // para no tener que calcularla nuevamente si la vuelvo a necesitar.
        for(int i = 0; i < h; i++){
            for(int j = 0; j < t; j++){
                if(i - f >= 0){
                    arboles[i][j] = Math.max(arboles[i - 1][j], max_por_altura[i -f]) + arboles[i][j];
                }
                else if(i != 0){
                    arboles[i][j] = arboles[i - 1][j] + arboles[i][j];
                }
                if(arboles[i][j] >= max_por_altura[i]){
                    max_por_altura[i] = arboles[i][j];
                }
            }
        }
        int res = max_por_altura[h-1];
        return res;
    }
}
