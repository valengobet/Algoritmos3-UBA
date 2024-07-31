import java.util.Scanner;
public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int cant_casas = scanner.nextInt();
            if(cant_casas == 0){
                break;
            }

            int[] demandas = new int[cant_casas];
            int trabajo = 0;
            int carga = 0;
            for(int i = 0; i < demandas.length; i++){
                demandas[i] = scanner.nextInt();
                carga += demandas[i];
                trabajo += Math.abs(carga);
            }
    
            System.out.println(trabajo);
        }


        scanner.close();
    }


}
