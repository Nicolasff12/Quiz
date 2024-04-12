package ucentral.edu.co.Quiz.servicio;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.Quiz.dto.ComputadorDto;
import ucentral.edu.co.Quiz.identidad.Computador;
import ucentral.edu.co.Quiz.repositorio.RepositorioComputador;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@Service
public class ServicioComputador implements Serializable {

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final RepositorioComputador repositorioComputador;

    public ComputadorDto registrar(ComputadorDto equipoDto) {

        Computador elComputador = repositorioComputador.save(modelMapper.map(equipoDto, Computador.class));
        return modelMapper.map(elComputador, ComputadorDto.class);
    }

    public List<ComputadorDto> obtenerComputador() {
        TypeToken<List<ComputadorDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioComputador.findAll(), typeToken.getType());
    }



    public ComputadorDto actualizar(ComputadorDto computadorDto) {
        repositorioComputador.save(modelMapper.map(computadorDto, Computador.class));
        return computadorDto;
    }

    public void eliminar(long serial) {
        repositorioComputador.deleteById(serial);

    }


}
