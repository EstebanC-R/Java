public class SentenciaForEach {
    static void main() {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8};
        
        for(int num : numeros){
            System.out.println("num = " + num);
        }

        String[] nombres = {"Milton", "Yony", "Yeison", "Mateo", "Daniel"};

        for(String nom : nombres){
            System.out.println("Nombre = " + nom);
        }
    }
}
