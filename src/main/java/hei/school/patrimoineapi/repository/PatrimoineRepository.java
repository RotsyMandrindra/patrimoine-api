package hei.school.patrimoineapi.repository;

import hei.school.patrimoineapi.model.Patrimoine;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Repository
public class PatrimoineRepository {
    public Patrimoine createOrUpdatePatrimoine(Patrimoine patrimoine) throws IOException {
        String json = "{\"id\":" + patrimoine.getId() + ",\"possesseur\":\"" + patrimoine.getPossesseur() + "\",\"derniereModification\":" + "\""+ LocalDateTime.now()+"\"}";

        String filename = "data";
        try (FileWriter fileWriter = new FileWriter(filename + patrimoine.getId()+".json")){
            fileWriter.write(json);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Patrimoine(patrimoine.getId(), patrimoine.getPossesseur(), LocalDateTime.now());
    }

    public Patrimoine getPatrimoine(int id) throws IOException{
        String filename = "data";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename + id + ".json"))){
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            String json = stringBuilder.toString();
            String[] fields = json.split(",");
            int parseId = Integer.parseInt(fields[0].split(":")[1].trim().replaceAll("\"", ""));
            String possesseur = fields[1].split(":")[1].trim().replaceAll("\"", "");
            LocalDateTime derniereModification = LocalDateTime.parse(fields[2].split(":")[1].trim().replaceAll("\"", "").replaceAll("Z", "+00:00"));

            return new Patrimoine(parseId, possesseur, derniereModification);
        }catch (IOException | NumberFormatException e){
            System.err.println("Erreur lors de la lecteur du fichier :" + e.getMessage());
            throw new IOException("Impossible de lire le fichier patrimoine pour l'id" + id, e);
        }
    }
}
