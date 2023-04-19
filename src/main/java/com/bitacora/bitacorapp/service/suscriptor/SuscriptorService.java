package com.bitacora.bitacorapp.service.suscriptor;


import com.bitacora.bitacorapp.domain.suscriptor.SuscriptorDomain;
import com.bitacora.bitacorapp.repository.suscriptor.SuscriptorRepository;
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
public class SuscriptorService {

    @Autowired
    private SuscriptorRepository suscriptorRepository;

    @Transactional
    public ArrayList<SuscriptorDomain> findAll() {
        return (ArrayList<SuscriptorDomain>) suscriptorRepository.findAll();
    }

    @Transactional
    public ArrayList<SuscriptorDomain> get(String nombreUsuario) {
        return suscriptorRepository.findByNombreUsuario(nombreUsuario.toUpperCase(Locale.ROOT));
    }

    @Transactional
    public SuscriptorDomain getByEmail(String email) {
        return suscriptorRepository.findByEmail(email);
    }

    @Transactional
    public SuscriptorDomain save(SuscriptorDomain suscriptor) {
        validationData(suscriptor);
        if (suscriptorRepository.countByEmail(suscriptor.getEmail()) > 0) {
            throw new IllegalArgumentException("email already exits");
        }
        return suscriptorRepository.save(suscriptor);
    }


    @Transactional
    public void update(Long id, SuscriptorDomain suscriptor) {
        validationData(suscriptor);
        if (suscriptorRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        suscriptorRepository.updateById(suscriptor.getEmail(), suscriptor.getNombreUsuario(),
                suscriptor.getTelefono(), suscriptor.getTipoUsuario(), suscriptor.getTipoSuscriptor(),  id);
    }

    @Transactional
    public void delete(Long id) {
        suscriptorRepository.deleteById(id);
    }


    @Transactional
    public SuscriptorDomain patch(long id, JsonPatch patch) {
        return suscriptorRepository.save(
                applyPatchToPerson(patch, suscriptorRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new)));
    }

    private SuscriptorDomain applyPatchToPerson(JsonPatch patch, SuscriptorDomain suscriptor) {
        try {
            validationData(suscriptor);
            var objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(suscriptor, JsonNode.class));
            return objectMapper.treeToValue(patched, SuscriptorDomain.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void validationData(SuscriptorDomain suscriptorDomain) {

        UtilStrings.requieresNoNullOrNoEmpty(suscriptorDomain.getEmail(),
                String.format(Constants.TXT_EXPECT_VALUE, suscriptorDomain.getEmail()));
        UtilStrings.requieresNoNullOrNoEmpty(suscriptorDomain.getNombreUsuario(),
                String.format(Constants.TXT_EXPECT_VALUE, suscriptorDomain.getNombreUsuario()));
        UtilStrings.requieresNoNullOrNoEmpty(suscriptorDomain.getTelefono(),
                String.format(Constants.TXT_EXPECT_VALUE, suscriptorDomain.getTelefono()));
        UtilStrings.requieresNoNullOrNoEmpty(suscriptorDomain.getTipoSuscriptor(),
                String.format(Constants.TXT_EXPECT_VALUE, suscriptorDomain.getTipoSuscriptor()));
        UtilStrings.requieresNoNullOrNoEmpty(suscriptorDomain.getTipoUsuario(),
                String.format(Constants.TXT_EXPECT_VALUE, suscriptorDomain.getTipoUsuario()));


        UtilStrings.requieresLength(suscriptorDomain.getTelefono().toString(), 10, 14,
                String.format(Constants.TXT_NO_LENGTH_REQUIERED, suscriptorDomain.getTelefono().toString()));
        UtilStrings.requiresPattern(suscriptorDomain.getEmail(), Constants.TXT_PATTER_EMAIL,
                String.format(Constants.TXT_BAD_EMAIL, suscriptorDomain.getEmail()));

    }

}