package com.bitacora.bitacorapp.service.historicomantenimiento;

import com.bitacora.bitacorapp.domain.historicomantenimiento.HistoricoMantenimientosDomain;
import com.bitacora.bitacorapp.repository.historicomantenimiento.HistoricoMantenimientoRepository;
import com.bitacora.bitacorapp.util.Constants;
import com.bitacora.bitacorapp.util.UtilStrings;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class HistoricoMantenimientosService {
    @Autowired
    private HistoricoMantenimientoRepository  HistoricoMantenimientoRepository;


    @Transactional
    public ArrayList<HistoricoMantenimientosDomain> findAll() {
        return (ArrayList<HistoricoMantenimientosDomain>) HistoricoMantenimientoRepository.findAll();
    }

    @Transactional
    public ArrayList<HistoricoMantenimientosDomain> get(String detalleMantenimiento) {
        return HistoricoMantenimientoRepository.findByMaintenanceDetail(detalleMantenimiento.toUpperCase(Locale.ROOT));
    }
    @Transactional
    public HistoricoMantenimientosDomain save(HistoricoMantenimientosDomain historico) {
        validationData(historico);
        return HistoricoMantenimientoRepository.save(historico);
    }

    @Transactional
    public void update(Long id, HistoricoMantenimientosDomain historico) {
        validationData(historico);
        if (HistoricoMantenimientoRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        HistoricoMantenimientoRepository.updateById(historico.getIdHistoria(), historico.getDetalleMantenimiento(), historico.getFechaEntrega(), historico.getFechaRecibido(), historico.getIdResponsable(),  historico.getIdAutoriza(),
                historico.getIdElabora(), id);
    }

    @Transactional
    public void delete(Long id) {

        HistoricoMantenimientoRepository.deleteById(id);
    }

    @Transactional
    public HistoricoMantenimientosDomain patch(long id, JsonPatch patch) {
        return HistoricoMantenimientoRepository.save(
                applyPatchToPerson(patch, HistoricoMantenimientoRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new)));
    }

    private HistoricoMantenimientosDomain applyPatchToPerson(JsonPatch patch, HistoricoMantenimientosDomain historico) {
        try {
            validationData(historico);
            var objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(historico, JsonNode.class));
            return objectMapper.treeToValue(patched, HistoricoMantenimientosDomain.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void validationData(HistoricoMantenimientosDomain historicoMantenimientosDomain) {

        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getDetalleMantenimiento(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getDetalleMantenimiento()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getIdHistoria().toString(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getIdHistoria().toString()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getIdResponsable().toString(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getIdResponsable().toString()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getIdAutoriza().toString(),
        String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getIdAutoriza().toString()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getIdElabora().toString(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getIdElabora().toString()));

        UtilStrings.requiresPattern(historicoMantenimientosDomain.getIdHistoria().toString(), Constants.TXT_PATTER_NUMBER,
                String.format(Constants.TXT_ONLY_NUMBERS, historicoMantenimientosDomain.getIdHistoria()));
        UtilStrings.requiresPattern(historicoMantenimientosDomain.getIdAutoriza().toString(), Constants.TXT_PATTER_NUMBER,
                String.format(Constants.TXT_ONLY_NUMBERS, historicoMantenimientosDomain.getIdAutoriza()));
        UtilStrings.requiresPattern(historicoMantenimientosDomain.getIdElabora().toString(), Constants.TXT_PATTER_NUMBER,
                String.format(Constants.TXT_ONLY_NUMBERS, historicoMantenimientosDomain.getIdElabora()));
        UtilStrings.requiresPattern(historicoMantenimientosDomain.getIdResponsable().toString(), Constants.TXT_PATTER_NUMBER,
                String.format(Constants.TXT_ONLY_NUMBERS, historicoMantenimientosDomain.getIdResponsable()));
    }

}