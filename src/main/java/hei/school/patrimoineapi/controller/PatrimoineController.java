package hei.school.patrimoineapi.controller;

import hei.school.patrimoineapi.model.Patrimoine;
import hei.school.patrimoineapi.service.PatrimoineService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController("patrimoine")
@AllArgsConstructor
@NoArgsConstructor
public class PatrimoineController {
    private PatrimoineService patrimoineService;

    @PutMapping("/id")
    public ResponseEntity<Patrimoine> createOrUpdatePatrimoine(@RequestBody Patrimoine patrimoine) throws IOException {
        if (patrimoine.getPossesseur() == null || patrimoine.getPossesseur().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Patrimoine updatedPatrimoine = patrimoineService.createOrUpdatePatrimoine(patrimoine);
        return ResponseEntity.ok(updatedPatrimoine);

    }

    @GetMapping("/id")
    public ResponseEntity<Patrimoine> getPatrimoine(@PathVariable int id) throws IOException {
        Patrimoine patrimoine = patrimoineService.getPatrimoine(id);
        if (patrimoine != null) {
            return ResponseEntity.ok(patrimoine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
