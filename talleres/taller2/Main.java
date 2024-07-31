import java.util.Scanner;

public class Main {
    
    public static void calcula_horizonte(int[] alturas, int[] anchos, int n, int test){
        int creciente = secuencia_creciente(alturas, anchos, n);
        int decreciente = secuencia_decreciente(alturas, anchos, n);

        if(creciente >= decreciente){
            System.out.println("Case " + test + ". Increasing (" + creciente + "). " + "Decreasing (" + decreciente + ").");
        }else{
            System.out.println("Case " + test + ". Decreasing (" + decreciente + "). " + "Increasing (" + creciente + ").");

        }
    }

    public static int secuencia_creciente(int[] alturas, int[] anchos, int n){
        int[] tabla = new int[n];

        tabla[0] = anchos[0];
        for(int i = 0; i < n; i++){
            int max_actual = 0;
            for(int j = 0; j < i; j++){
                if(alturas[i] > alturas[j] && max_actual < tabla[j]){
                    max_actual = tabla[j];
                }
            }
            tabla[i] = max_actual + anchos[i];
        }
        return maximo(tabla);
    }

    public static int secuencia_decreciente(int[] alturas, int[] anchos, int n){
        int[] tabla = new int[n];

        tabla[0] = anchos[0];
        for(int i = 0; i < n; i++){
            int max_actual = 0;
            for(int j = 0; j < i; j++){
                if(alturas[i] < alturas[j] && max_actual < tabla[j]){
                    max_actual = tabla[j];
                }
            }
            tabla[i] = max_actual + anchos[i];
        }
        return maximo(tabla);
    }

    public static int maximo(int[] tabla){
        int maximo = tabla[0];
        for (int i = 1; i < tabla.length; i++){
            int actual = tabla[i];
            if(actual > maximo){
                maximo = actual;
            }
        }
        return maximo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt();
        for(int i = 0; i < casos; i++){
            int cantidad_edificios = scanner.nextInt();
            int[] alturas = new int[cantidad_edificios];
            int[] anchos = new int[cantidad_edificios];
            for(int j = 0; j < cantidad_edificios; j++){
                alturas[j] = scanner.nextInt();
            }
            for(int k = 0; k < cantidad_edificios; k++){
                anchos[k] = scanner.nextInt();
            }
            calcula_horizonte(alturas, anchos, cantidad_edificios, i + 1);
        }

        scanner.close();
    }
}


