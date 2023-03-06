package com.bitacora.bitacorapp.service.suscriptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscriptorService {
/*
    @Autowired
    private SuscriptorRepository suscriptorRepository;

    public static SuscriptorDomain get(Integer id) {
        return suscriptorRepository.findById(id);
    }
    public static SuscriptorDomain getAll() { return suscriptorRepository.findAll();}

    public static SuscriptorDomain save(SuscriptorDomain name) {
        return suscriptorRepository.save(id);
    }
    public static SuscriptorDomain update(Integer id, SuscriptorDomain suscriptorDomain){
        return suscriptorRepository.findById(id).flatMap(existingSuscriptorDomain -> {
            existingSuscriptorDomain.setName(
                    suscriptorDomain.getName().isEmpty() ? existingSuscriptorDomain.getName() : suscriptorDomain.getName());
            existingSuscriptorDomain.setPhone(
                    suscriptorDomain.getPhone().isEmpty() ? existingSuscriptorDomain.getPhone() : suscriptorDomain.getPhone());
            existingSuscriptorDomain.setSignature(
                    suscriptorDomain.getSignature().isEmpty() ? existingSuscriptorDomain.getSignature() : suscriptorDomain.getSignature());
            existingSuscriptorDomain.setcCompanyId(
                    suscriptorDomain.getCompanyId().isEmpty() ? existingSuscriptorDomain.getCompanyId() : suscriptorDomain.getCompanyId());
        });
    }
    public static Void delete(Integer id) {
        return SuscriptorRepository.findById(id).flatMap(existingSuscriptorDomain ->
                suscriptorRepository.deleteById(id));
    }
*/
}
