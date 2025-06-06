package br.com.exercicios_minsait.exercicio2;

public class MainExercicio2 {
    public static void main(String[] args) {
        FileCleaner cleaner = new FileCleaner("src/main/java/br/com/exercicios_minsait/exercicio2/input.txt", "src/main/java/br/com/exercicios_minsait/exercicio2/output.txt");

        try {
            cleaner.removeBlankLines();
            System.out.println("Arquivo processado");
        } catch (Exception e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
