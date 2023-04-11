package com.bitacora.bitacorapp.service.historicomantenimiento;

import com.bitacora.bitacorapp.domain.historicomantenimiento.HistoricoMantenimientosDomain;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HistoricoMantenimientosService {
    @Autowired
    private HistoricoMantenimientosRepository historicoMantenimientosRepository;


    @Transactional
    public ArrayList<HistoricoMantenimientosDomain> findAll() {
        return (ArrayList<HistoricoMantenimientosDomain>) HistoricoMantenimientosRepository.findAll();
    }

    @Transactional
    public ArrayList<HistoricoMantenimientosDomain> get(String maintenanceDetail) {
        return HistoricoMantenimientosRepository.findBymaintenanceDetail(maintenanceDetail.toUpperCase(Locale.ROOT));
    }
    @Transactional
    public HistoricoMantenimientosDomain save(HistoricoMantenimientosDomain historico) {
        validationData(historico);
        return HistoricoMantenimientosRepository.save(historico);
    }

    @Transactional
    public void update(Long id, HistoricoMantenimientosDomain historico) {
        validationData(historico);
        if (HistoricoMantenimientosRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        historicoMantenimientosRepository.updateById(historico.getMaintenanceDetail(), historico.getIdHistorical(), historico.getDeliverDate(),
                historico.getDateReceived(), historico.getIdResponsible(), historico.getIdAuthorizes(), id);
    }

    @Transactional
    public void delete(Long id) {
        historicoMantenimientosRepository.deleteById(id);
    }

    @Transactional
    public HistoricoMantenimientosDomain patch(long id, JsonPatch patch) {
        return historicoMantenimientosRepository.save(
                applyPatchToPerson(patch, historicoMantenimientosRepository.findById(id)
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

        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getMaintenanceDetail(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getMaintenanceDetail()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getIdHistorical(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getIdHistorical()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientossDomain.getDeliverDate(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getDeliverDate()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getDateReceived(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getDateReceived()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getIdResponsible(),
                String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getIdResponsible()));
        UtilStrings.requieresNoNullOrNoEmpty(historicoMantenimientosDomain.getIdAuthorizes(),
        String.format(Constants.TXT_EXPECT_VALUE, historicoMantenimientosDomain.getIdAuthorizes()));

    }

}