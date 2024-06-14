package backend.clinicaMVC.service;

import backend.clinicaMVC.Dto.request.TurnoRequestDto;
import backend.clinicaMVC.Dto.response.TurnoResponseDto;
import backend.clinicaMVC.exception.BadRequestException;
import backend.clinicaMVC.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    TurnoResponseDto registrar(TurnoRequestDto turnoRequestDto) throws BadRequestException;

    TurnoResponseDto buscarPorId(Integer id);

    List<TurnoResponseDto> buscarTodos();
    void actualizarTurno(Integer id, TurnoRequestDto turnoRequestDto);
    void eliminarTurno(Integer id) throws ResourceNotFoundException;

    // HQL
    List<TurnoResponseDto> buscarTurnoEntreFechas(LocalDate startDate,LocalDate endDate);
}
