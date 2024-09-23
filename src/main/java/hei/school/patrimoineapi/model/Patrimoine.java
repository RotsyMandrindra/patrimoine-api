package hei.school.patrimoineapi.model;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Patrimoine {
    private int id;
    private String possesseur;
    private LocalDateTime derniereModification;
}
