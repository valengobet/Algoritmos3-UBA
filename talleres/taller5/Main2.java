import java.util.Scanner;
public class Main2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cant_casas = scanner.nextInt();

        while(cant_casas != 0){
            int[] demandas = new int[cant_casas];
            for(int i = 0; i < cant_casas; i++){
                int demanda = scanner.nextInt();
                demandas[i] = demanda;
            }
            
            trabajoMinimo(demandas);
            cant_casas = scanner.nextInt();
        }
        scanner.close();
    }

    public static void trabajoMinimo(int[] demandas){
        int trabajo = 0;
        for(int i = 0; i < demandas.length; i++){
            int j = i+1;
            int k = i-1;
            while(demandas[i] > 0){
                if(j < demandas.length){
                    if(demandas[j] < 0){
                        int distancia = j - i;
                        if(demandas[i] <= Math.abs(demandas[j])){
                            int viajes = demandas[i];
                            demandas[j] += demandas[i];
                            demandas[i] = 0;
                            trabajo += viajes * distancia;
                        }else{
                            int viajes = Math.abs(demandas[j]);
                            demandas[i] += demandas[j];
                            demandas[j] = 0;
                            trabajo += viajes * distancia;
                        }
                    }else{ 
                        j++;
                    }
                }

                if(k >= 0){
                    if(demandas[k] < 0){
                        int distancia = i - k;
                        if(demandas[i] <= Math.abs(demandas[k])){
                            int viajes = demandas[i];
                            demandas[k] += demandas[i];
                            demandas[i] = 0;
                            trabajo += viajes * distancia;
                        }else{
                            int viajes = Math.abs(demandas[k]);
                            demandas[i] += demandas[k];
                            demandas[k] = 0;
                            trabajo += viajes * distancia;
                        }
                    }else{
                        k--;
                    }
                }
            }
        }
        System.out.println(trabajo);
    }
}
