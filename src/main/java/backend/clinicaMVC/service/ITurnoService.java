package backend.clinicaMVC.service;

import backend.clinicaMVC.Dto.request.TurnoRequestDto;
import backend.clinicaMVC.Dto.response.TurnoResponseDto;

import java.util.List;

public interface ITurnoService {
    TurnoResponseDto registrar(TurnoRequestDto turnoRequestDto);

    TurnoResponseDto buscarPorId(Integer id);

    List<TurnoResponseDto> buscarTodos();
    void actualizarTurno(Integer id, TurnoRequestDto turnoRequestDto);
    void eliminarTurno(Integer id);
}
