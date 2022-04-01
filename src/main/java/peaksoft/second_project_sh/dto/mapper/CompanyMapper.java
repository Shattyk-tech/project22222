package peaksoft.second_project_sh.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.second_project_sh.dto.CompanyDto;
import peaksoft.second_project_sh.model.Company;

@Component
public class CompanyMapper {

    public Company create(CompanyDto companyDto){

        if (companyDto == null){
            return  null;
        }

        Company company = new Company();
        company.setName(companyDto.getName());
        company.setLocatedCountry(companyDto.getLocatedCountry());
        return  company;
    }


}
