package hei.school.patrimoineapi.service;

import hei.school.patrimoineapi.model.Patrimoine;
import hei.school.patrimoineapi.repository.PatrimoineRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PatrimoineService {
    private PatrimoineRepository patrimoineRepository;

    public Patrimoine createOrUpdatePatrimoine(Patrimoine patrimoine) throws IOException {
        return patrimoineRepository.createOrUpdatePatrimoine(patrimoine);
    }

    public Patrimoine getPatrimoine(int id) throws IOException {
        return patrimoineRepository.getPatrimoine(id);
    }
}
