package co.edu.umanizales.tads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor


public class Kid {

    private String identification;
    private String name;
    private byte age;
    private Gender gender;
    private Location location;

}
