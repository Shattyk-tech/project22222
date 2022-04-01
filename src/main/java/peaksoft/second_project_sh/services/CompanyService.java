package peaksoft.second_project_sh.services;


import peaksoft.second_project_sh.dto.CompanyDto;
import peaksoft.second_project_sh.model.Company;


import java.util.List;
import java.util.Optional;

public interface CompanyService {

    Company saveCompany(CompanyDto company);

    void removeCompanyById(Long id);

    Optional<Company> getById(Long id);


    List<Company> getAllCompany();

    Company update( Company company);
    Company findById(Long id);
}

