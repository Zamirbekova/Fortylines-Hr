package com.example.fortylineshr.dto.mapper;

import com.example.fortylineshr.dto.VacancyRequest;
import com.example.fortylineshr.dto.VacancyResponse;
import com.example.fortylineshr.model.Vacancy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class VacancyMapperImpl {

    public Vacancy create(VacancyRequest vacancyRequest) {
        if (vacancyRequest==null) {
            return null;
        }
        Vacancy vacancy =new Vacancy();
        vacancy.setVacancy(vacancyRequest.getVacancy());
        return vacancy;
    }

    public Vacancy update(Vacancy vacancy, VacancyRequest vacancyRequest) {

        vacancy.setVacancy(vacancyRequest.getVacancy());
        return vacancy;
    }

    public VacancyResponse convert(Vacancy vacancy) {
        VacancyResponse vacancyResponse=new VacancyResponse();
        if (vacancy.getId()!=null){
            vacancyResponse.setId(vacancy.getId());
        }
        vacancyResponse.setVacancy(vacancy.getVacancy());
        return vacancyResponse;
    }

    public List<VacancyResponse> deConvert(List<Vacancy> vacancies) {
        List<VacancyResponse>vacancyResponses=new ArrayList<>();
        for (Vacancy v:vacancies) {
            vacancyResponses.add(convert(v));
        }
        return vacancyResponses;
    }
}
