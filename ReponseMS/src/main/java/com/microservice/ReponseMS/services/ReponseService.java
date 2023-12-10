package com.microservice.ReponseMS.services;

import com.microservice.ReponseMS.entities.Reponse;
import com.microservice.ReponseMS.repositories.ReponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReponseService {

private ReponseRepository reponseRepository ;


    public Reponse add(Reponse reponse)
    {
        reponse.setDate(LocalDate.now());
        return reponseRepository.save(reponse);
    }
    public List<Reponse> getAll()
    {

        return reponseRepository.findAll();
    }
    public Reponse getbyId(Long id)
    {

        return  reponseRepository.findById(id).get();
    }
    public void delete(Long id)
    {
        reponseRepository.deleteById(id);
    }
    public Reponse update(Reponse reponse)
    {
        return  reponseRepository.save(reponse);
    }

    public Reponse FindAllReponseByReclamation(Long reclamationId) {

        return reponseRepository.findByIdReclamation(reclamationId);

    }
}
