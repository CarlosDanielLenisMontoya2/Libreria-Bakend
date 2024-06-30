package com.example.demo.dto.transformer;

import com.example.demo.dto.PrestamoDto;
import com.example.demo.model.Prestamo;
import org.springframework.stereotype.Component;

@Component
public class PrestamoTransformer {
    public Prestamo pretamoTransformerFroDto (PrestamoDto prestamoDto){
        if (prestamoDto == null)return null;

        Prestamo prestamo = new Prestamo();
        prestamo.setId(prestamoDto.getId());
        prestamo.setFecha(prestamoDto.getFecha());
        prestamo.setClienteId(prestamoDto.getClienteId());
        prestamo.setLibroId(prestamoDto.getLibroId());
        return prestamo;
    }
    public PrestamoDto pretamoTransformerFroModel (Prestamo prestamo){
        if(prestamo == null)return null;

        PrestamoDto dto = new PrestamoDto();
        dto.setId(prestamo.getId());
        dto.setFecha(prestamo.getFecha());
        dto.setFecha(prestamo.getFecha());
        dto.setClienteId(prestamo.getClienteId());
        dto.setLibroId(prestamo.getLibroId());
        return dto;
    }
}
