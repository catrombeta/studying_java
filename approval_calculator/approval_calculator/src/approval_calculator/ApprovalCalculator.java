package approval_calculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ApprovalCalculator {
    public static void main(String[] args) {

        String nome = getInput("Digite o nome do aluno: ");
        float nota1 = getInputFloat("Digite a primeira nota: ");
        float nota2 = getInputFloat("Digite a segunda nota: ");
        float nota3 = getInputFloat("Digite a terceira nota: ");

        Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
        float media = aluno.calcularMedia();

        System.out.println("A média do aluno " + aluno.getNome() + " é: " + media);

        String texto = aluno.toString();

        writeToFile(texto);
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).nextLine();
    }

    private static float getInputFloat(String prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).nextFloat();
    }

    private static void writeToFile(String texto) {
        File file = new File("alunos.txt"); // Caminho relativo

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo!");
        }
    }
}

class Aluno {
    private String nome;
    private float nota1;
    private float nota2;
    private float nota3;

    public Aluno(String nome, float nota1, float nota2, float nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNome() {
        return nome;
    }

    public float calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    @Override
    public String toString() {
        return "Nome do aluno: " + nome + "\n" +
                "Nota 1: " + nota1 + "\n" +
                "Nota 2: " + nota2 + "\n" +
                "Nota 3: " + nota3 + "\n" +
                "Média: " + calcularMedia();
    }
}
