import java.util.Scanner;
public class Main{

    public static class Jugador{
        private String n;
        private int atq;
        private int def; 

        public Jugador(String nombre, int ataque, int defensa){
            this.n = nombre;
            this.atq = ataque;
            this.def = defensa;
        }
    }

    public static void formacion(Jugador[] lista){
        quicksort(lista,0, lista.length - 1, 0);
    }

    public static void menorAlFinal(Jugador[] array, int low, int high, int alfabeticamente){
        if(alfabeticamente == 0){
            for(int i = low; i < high; i++){
                if(esMenor(array[i], array[high])){
                    Jugador temp = array[high];
                    array[high] = array[i];
                    array[i] = temp;
                }
            }
        }else{
            for(int i = low; i < high; i++){
                if(cmp2(array[i], array[high])){
                    Jugador temp = array[high];
                    array[high] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    

    public static boolean esMenor(Jugador a , Jugador b){
        if(a.atq < b.atq){
            return true;
        } else if(a.atq == b.atq && a.def > b.def){
            return true;
        } else if(a.atq == b.atq && a.def == b.def && a.n.compareTo(b.n) > 0){
            return true;
        } else return false;
    }

    public static boolean cmp2(Jugador a , Jugador b){
        if(a.n.compareTo(b.n) > 0){
            return true;
        } else return false;
    }



    public static void quicksort(Jugador[] array, int low, int high, int alfabeticamente){
        if(alfabeticamente == 0){
            if(high - low >= 2){
                menorAlFinal(array, low, high, 0);

                int pivoteIndex = high -1;

                Jugador temp = array[pivoteIndex];
                array[pivoteIndex] = array[low];
                array[low] = temp;
    
                int i = low + 1;
                int j = high - 1;
    
                while(i < j){
                    if(esMenor(array[low], array[i])){
                        i++;
                    } if(esMenor(array[j], array[low])){
                        j--;
                    } else if(esMenor(array[low], array[j]) && esMenor(array[i], array[low])){
                        Jugador temporal = array[j];
                        array[j] = array[i];
                        array[i] = temporal;
                        i++;
                        j--;
                    }
                }
                
                pivoteIndex = i;
                if(esMenor(array[low], array[pivoteIndex])){
                    array[low] = array[pivoteIndex];
                    array[pivoteIndex] = temp;
                } else{
                    array[low] = array[pivoteIndex - 1];
                    array[pivoteIndex - 1] = temp;
                    pivoteIndex = pivoteIndex - 1;
                }
                quicksort(array, low, pivoteIndex - 1, 0);
                quicksort(array, pivoteIndex + 1, high, 0);

            } else{
                menorAlFinal(array, low, high, 0);
                return;
            }
        } else{
            if(high - low >= 2){
                menorAlFinal(array, low, high, 1);
                int pivoteIndex = high - 1;
                Jugador temp = array[pivoteIndex];
                array[pivoteIndex] = array[low];
                array[low] = temp;
    
                int i = low + 1;
                int j = high - 1;
    
                while(i < j){
                    if(cmp2(array[low], array[i])){
                        i++;
                    } if(cmp2(array[j], array[low])){
                        j--;
                    } else if(cmp2(array[low], array[j]) && cmp2(array[i], array[low])){
                        Jugador temporal = array[j];
                        array[j] = array[i];
                        array[i] = temporal;
                        i++;
                        j--;
                    }
                }
                
                pivoteIndex = i;
                if(cmp2(array[low], array[pivoteIndex])){
                    array[low] = array[pivoteIndex];
                    array[pivoteIndex] = temp;
                } else{
                    array[low] = array[pivoteIndex - 1];
                    array[pivoteIndex - 1] = temp;
                    pivoteIndex = pivoteIndex - 1;
                }
                quicksort(array, low, pivoteIndex - 1, 1);
                quicksort(array, pivoteIndex + 1, high, 1);
            } else{
                menorAlFinal(array, low, high, 1);
                return;
            }
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt();
        for(int i = 0; i < casos; i++){
            System.out.println("Case " + (i + 1) + ":");
            Jugador[] lista = new Jugador[10];
            for(int j = 0; j < 10; j++){
                String nombre = scanner.next();
                int ataque = scanner.nextInt();
                int defensa = scanner.nextInt();
                lista[j] = new Jugador(nombre, ataque, defensa);
            }
            formacion(lista);

            Jugador[] atacantes = new Jugador[5];
            Jugador[] defensores = new Jugador[5];
            for(int k = 0; k < 10; k++){
                if(k<5){
                    atacantes[k] = lista[k];
                } else{
                    defensores[k-5] = lista[k];
                }
            }

            quicksort(atacantes, 0, 4, 1);
            quicksort(defensores, 0, 4, 1);

            System.out.print("(");
            for(int l = 0; l < 4; l++){
                System.out.print(atacantes[l].n + ", ");
            }
            System.out.println(atacantes[4].n + ")");

            System.out.print("(");
            for(int m = 0; m < 4; m++){
                System.out.print(defensores[m].n + ", ");
            }
            System.out.println(defensores[4].n + ")");
        }

        scanner.close();
    }
}

