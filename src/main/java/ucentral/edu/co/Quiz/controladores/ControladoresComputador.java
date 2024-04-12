package ucentral.edu.co.Quiz.controladores;


import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.edu.co.Quiz.dto.ComputadorDto;
import ucentral.edu.co.Quiz.servicio.ServicioComputador;

@Log4j2
@Controller
public class ControladoresComputador {

    private static final Logger logger = LogManager.getLogger(ControladoresComputador.class);

    @Autowired
    ServicioComputador servicioComputador;


    @GetMapping({  "/computador"})
    public String listarComputador( Model model){
        logger.info("Verificando ");
        model.addAttribute("computador",servicioComputador.obtenerComputador());
        return "computador";
    }



    @GetMapping("/computador/nuevo")
    public String mostrarFormulario(Model model){
        ComputadorDto computadorDto = new ComputadorDto();
        model.addAttribute("computador", computadorDto);
        return "crearComputador";
    }

    @PostMapping("/computador")
    public String registrarComputador(@ModelAttribute("computador") ComputadorDto computador) {
        servicioComputador.registrar(computador);
        return "redirect:/computador";
    }

    @GetMapping("/computador/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        ComputadorDto computadorDto = new ComputadorDto();
        model.addAttribute("computador", servicioComputador.obtenerComputador());
        return "editarComputador";
    }

    @PostMapping("/computador/{serial}")
    public String modificarComputador(@PathVariable long serial,@ModelAttribute( "computador") ComputadorDto computadorDto, Model model){


        model.addAttribute("computador", servicioComputador.actualizar(computadorDto));
        return "redirect:/computador";
    }


    @GetMapping("/computador/{serial}")
    public String eliminarComputador(@PathVariable long serial){

        servicioComputador.eliminar(serial);

        return "redirect:/computador";
    }

}
