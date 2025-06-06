package br.com.exercicios_minsait.exercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCleaner {

    private final Path inputPath;
    private final Path outputPath;

    public FileCleaner(String inputPath, String outputPath) {
        this.inputPath = Paths.get(inputPath);
        this.outputPath = Paths.get(outputPath);
    }

    public void removeBlankLines() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
        }
    }
}
