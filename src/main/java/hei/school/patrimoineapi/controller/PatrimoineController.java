package hei.school.patrimoineapi.controller;

import hei.school.patrimoineapi.model.Patrimoine;
import hei.school.patrimoineapi.service.PatrimoineService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController("patrimoine")
@AllArgsConstructor
@NoArgsConstructor
public class PatrimoineController {
    private PatrimoineService patrimoineService;

    @PutMapping("/id")
    public Patrimoine createOrUpdatePatrimoine(@RequestBody Patrimoine patrimoine) throws IOException {
        return patrimoineService.createOrUpdatePatrimoine(patrimoine);
    }

    @GetMapping("/id")
    public Patrimoine getPatrimoine(@PathVariable int id) throws IOException {
        return patrimoineService.getPatrimoine(id);
    }
}
