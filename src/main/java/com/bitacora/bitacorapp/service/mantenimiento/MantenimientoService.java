package com.bitacora.bitacorapp.service.mantenimiento;


import com.bitacora.bitacorapp.domain.mantenimiento.MantenimientoDomain;
import com.bitacora.bitacorapp.repository.mantenimiento.MantenimientoRepository;
import com.bitacora.bitacorapp.util.Constants;
import com.bitacora.bitacorapp.util.UtilStrings;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Transactional
    public ArrayList<MantenimientoDomain> findAll() {
        return (ArrayList<MantenimientoDomain>) mantenimientoRepository.findAll();
    }

    @Transactional
    public ArrayList<MantenimientoDomain> get(Integer numeroMantenimiento) {
        return mantenimientoRepository.findByNumeroMantenimiento(numeroMantenimiento);
    }

    @Transactional
    public ArrayList<MantenimientoDomain> getIdEmpresaEncargada(Integer idEmpresaEncargada) {
        return mantenimientoRepository.findByIdEmpresaSolicitante(idEmpresaEncargada);
    }

    @Transactional
    public ArrayList<MantenimientoDomain> getIdEmpresaSolicitante(Integer idEmpresaSolicitante) {
        return mantenimientoRepository.findByIdEmpresaSolicitante(idEmpresaSolicitante);
    }

    @Transactional
    public MantenimientoDomain save(MantenimientoDomain mantenimientos) {
        validationData(mantenimientos);
        return mantenimientoRepository.save(mantenimientos);
    }

    @Transactional
    public void update(Long id, MantenimientoDomain mantenimientos) {
        validationData(mantenimientos);
        if(mantenimientoRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        mantenimientoRepository.updateById(mantenimientos.getNumeroMantenimiento(), mantenimientos.getFechaInicio(), mantenimientos.getFechaEntrega(), mantenimientos.getIdEmpresaEncargada(), mantenimientos.getIdEmpresaSolicitante(), mantenimientos.getZona(), mantenimientos.getTipoDeMantenimiento(), id);
    }

    @Transactional
    public void delete(Long id) {
        mantenimientoRepository.deleteById(id);
    }

    @Transactional
    public MantenimientoDomain patch(long id, JsonPatch patch) {
        return mantenimientoRepository.save(
                applyPatchPerson(patch, mantenimientoRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new)));
    }

    private MantenimientoDomain applyPatchPerson(JsonPatch patch, MantenimientoDomain mantenimientos) {
        try {
            validationData(mantenimientos);
            var objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(mantenimientos, JsonNode.class));
            return objectMapper.treeToValue(patched, MantenimientoDomain.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw  new RuntimeException(e);
        }
    }

    private void validationData(MantenimientoDomain mantenimientoDomain) {

       UtilStrings.requieresNoNullOrNoEmpty(mantenimientoDomain.getNumeroMantenimiento().toString(),
                String.format(Constants.TXT_ONLY_NUMBERS, mantenimientoDomain.getNumeroMantenimiento()));
        UtilStrings.requieresNoNullOrNoEmpty(mantenimientoDomain.getTipoDeMantenimiento(),
                String.format(Constants.TXT_EXPECT_VALUE, mantenimientoDomain.getTipoDeMantenimiento()));
        UtilStrings.requieresNoNullOrNoEmpty(mantenimientoDomain.getZona(),
                String.format(Constants.TXT_EXPECT_VALUE, mantenimientoDomain.getZona()));
                String.format(Constants.TXT_ONLY_NUMBERS, mantenimientoDomain.getId());
        UtilStrings.requieresNoNullOrNoEmpty(mantenimientoDomain.getIdEmpresaEncargada().toString(),
                String.format(Constants.TXT_ONLY_NUMBERS, mantenimientoDomain.getIdEmpresaEncargada()));
        UtilStrings.requieresNoNullOrNoEmpty(mantenimientoDomain.getIdEmpresaSolicitante().toString(),
                String.format(Constants.TXT_ONLY_NUMBERS, mantenimientoDomain.getIdEmpresaSolicitante()));

    }

}
