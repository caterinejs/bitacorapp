package com.bitacora.bitacorapp.service.empresa;


import com.bitacora.bitacorapp.domain.empresa.EmpresaDomain;
import com.bitacora.bitacorapp.repository.empresa.EmpresaRepository;
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
import java.util.Locale;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    public ArrayList<EmpresaDomain> findAll(){
        return (ArrayList<EmpresaDomain>) empresaRepository.findAll();
    }

    @Transactional
    public ArrayList<EmpresaDomain> get(String nombre) {
        return empresaRepository.findByNombre(nombre.toUpperCase(Locale.ROOT));
    }

    @Transactional
    public EmpresaDomain getByEmail(String email) {
        return empresaRepository.findByEmail(email);
    }
    @Transactional
    public EmpresaDomain save(EmpresaDomain empresa) {
        validationData(empresa);
        if (empresaRepository.countByEmail(empresa.getEmail()) > 0) {
            throw new IllegalArgumentException("email alredy exits");
        }
        return empresaRepository.save(empresa);
    }

    @Transactional
    public void update(Long id, EmpresaDomain empresa) {
        validationData(empresa);
        if (empresaRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        empresaRepository.updateById(empresa.getNombre(),
                empresa.getTelefono(),
                empresa.getEmail(),
                empresa.getResponsableLegal(),
                id);
    }
    @Transactional
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    @Transactional
    public EmpresaDomain patch(long id, JsonPatch patch) {
        return empresaRepository.save(
                applyPatchToEmpresa(patch, empresaRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new)));
    }

    private EmpresaDomain applyPatchToEmpresa(JsonPatch patch, EmpresaDomain empresa) {
        try {
            validationData(empresa);
            var objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(empresa, JsonNode.class));
            return objectMapper.treeToValue(patched, EmpresaDomain.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void validationData(EmpresaDomain empresaDomain) {

        UtilStrings.requieresNoNullOrNoEmpty(empresaDomain.getEmail(),
                String.format(Constants.TXT_EXPECT_VALUE, empresaDomain.getEmail()));
        UtilStrings.requieresNoNullOrNoEmpty(empresaDomain.getNombre(),
                String.format(Constants.TXT_EXPECT_VALUE, empresaDomain.getNombre()));
        UtilStrings.requieresNoNullOrNoEmpty(empresaDomain.getTelefono(),
                String.format(Constants.TXT_EXPECT_VALUE, empresaDomain.getTelefono()));
        UtilStrings.requieresNoNullOrNoEmpty(empresaDomain.getResponsableLegal(),
                String.format(Constants.TXT_EXPECT_VALUE, empresaDomain.getResponsableLegal()));


        UtilStrings.requieresLength(empresaDomain.getTelefono().toString(), 10, 14,
                String.format(Constants.TXT_NO_LENGTH_REQUIERED, empresaDomain.getTelefono().toString()));
        UtilStrings.requiresPattern(empresaDomain.getEmail(), Constants.TXT_PATTER_EMAIL,
                String.format(Constants.TXT_BAD_EMAIL, empresaDomain.getEmail()));

    }

}