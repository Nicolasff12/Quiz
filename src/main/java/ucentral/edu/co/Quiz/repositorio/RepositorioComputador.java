package ucentral.edu.co.Quiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ucentral.edu.co.Quiz.identidad.Computador;

public interface RepositorioComputador extends JpaRepository<Computador, Long>, JpaSpecificationExecutor<Computador> {

}
