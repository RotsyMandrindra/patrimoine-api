package hei.school.patrimoineapi;

import hei.school.patrimoineapi.model.Patrimoine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PatrimoineTest {

    @Autowired
    private MockMvc mockMvc;

    private Patrimoine patrimoine;

    @BeforeEach
    public void setUp() {
        patrimoine = new Patrimoine();
        patrimoine.setPossesseur("ilo");
        patrimoine.setDerniereModification(LocalDateTime.now());
    }

    @Test
    public void getPatrimoineNotFound() throws Exception {
        mockMvc.perform(get("/patrimoines/2"))
                .andExpect(status().isNotFound());
    }
}