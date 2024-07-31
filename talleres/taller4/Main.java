import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        Boolean res = equivalencia(a, b);
        if(res){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        scanner.close();
    }
    public static boolean equivalencia(String a, String b){
        // Si la palabra no se puede dividir en 2 partes iguales, evaluo si a es igual b ya que seria la unica forma de que sean equivalentes
        if(a.length()% 2 != 0){
            return a.equals(b);
        }else {
            // Separo a en 2 partes iguales a1 y a2
            int longitud_a = a.length();
            String a1 = a.substring(0, longitud_a/2);
            String a2 = a.substring(longitud_a/2);

            // Separo b en 2 partes iguales b1 y b2
            int longitud_b = b.length();
            String b1 = b.substring(0, longitud_b/2);
            String b2 = b.substring(longitud_b/2);

            // Evaluo si son equivalentes ya sea por que a1 es equivalente a b2 y a2 equivalente a b1 o si a1 es equivalente a b1 y a2 a b2
            // y retorno lo que corresponda
            return ((equivalencia(a1,b2) && equivalencia(a2, b1)) || (equivalencia(a1,b1) && equivalencia(a2, b2)));
        }
    }
}