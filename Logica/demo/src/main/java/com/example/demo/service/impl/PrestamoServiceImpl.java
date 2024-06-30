package com.example.demo.service.impl;

import com.example.demo.dto.PrestamoDto;
import com.example.demo.dto.transformer.PrestamoTransformer;
import com.example.demo.model.Prestamo;
import com.example.demo.repository.PrestamoRepository;
import com.example.demo.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoTransformer transformer;
    private final PrestamoRepository repository;
    @Override
    public PrestamoDto create(PrestamoDto prestamoDto) {
        Prestamo prestamo = transformer.pretamoTransformerFroDto(prestamoDto);
        prestamoDto = transformer.pretamoTransformerFroModel(repository.save(prestamo));
        return prestamoDto;
    }

    @Override
    public PrestamoDto update(PrestamoDto prestamoDto) {
        Prestamo prestamo = transformer.pretamoTransformerFroDto(prestamoDto);
        prestamoDto = transformer.pretamoTransformerFroModel(repository.save(prestamo));
        return prestamoDto;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Page<Prestamo> read(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public Prestamo findById(Long id) {
        return repository.findById(id).get();
    }
}
