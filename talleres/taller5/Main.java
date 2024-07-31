import java.util.Scanner;
public class Main {
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
            if(i < demandas.length - 1){
                boolean hayMas = true;
                while(demandas[i] > 0 && hayMas){
                    for(int j = i+1; j < demandas.length; j++){
                        if(demandas[j] < 0){
                            trabajo += j - i;
                            demandas[i] -= 1;
                            demandas[j] += 1;
                        }
                    }
                    hayMas = false;
                }
            }

            if(i > 0){
                int j = i -1;
                while(demandas[i] > 0){
                    while(demandas[j] >= 0 && j > 0){
                        j--;
                    }
                    trabajo += i - j;
                    demandas[i] -= 1;
                    demandas[j] += 1;
                }

            }
        }

        System.out.println(trabajo);
    }
}
