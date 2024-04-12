package ucentral.edu.co.Quiz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ComputadorDto implements Serializable {

    private long serial;

    private String nombre;

    private String ram;

    private String pantalla;

    private String ssd;

    private String puertos;



}
