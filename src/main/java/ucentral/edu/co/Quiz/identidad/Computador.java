package ucentral.edu.co.Quiz.identidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Computador")
@Table(name = "COMPUTADOR")

public class Computador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMPUTADOR")
    @SequenceGenerator(name = "SEQ_COMPUTADOR", sequenceName = "SEQ_COMPUTADOR", allocationSize = 1)
    @Column(name = "COM_SERIE", nullable = false)
    private long serial;

    @Column(name = "COM_MARCA", nullable = false)
    private String nombre;

    @Column(name = "COM_RAM", nullable = false)
    private String ram;

    @Column(name = "COM_PANTALLA", nullable = false)
    private String pantalla;

    @Column(name = "COM_SSD", nullable = false)
    private String ssd;

    @Column(name = "COM_PUERTOS", nullable = false)
    private String puertos;


}
