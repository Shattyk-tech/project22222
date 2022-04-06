package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.second_project_sh.dto.CompanyDto;
import peaksoft.second_project_sh.dto.mapper.CompanyMapper;
import peaksoft.second_project_sh.model.Company;
import peaksoft.second_project_sh.model.Course;
import peaksoft.second_project_sh.repositories.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final  CompanyRepository companyRepository;
    private final CompanyMapper companyMapper ;

    @Override
    public Company saveCompany(CompanyDto companyDto) {
        Company company = companyMapper.create(companyDto);
        return companyRepository.save(company);
    }

    @Override
    public void removeCompanyById(Long id) {
         companyRepository.deleteById(id);
    }

    @Override
    public Optional<Company> getById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public CompanyDto update( CompanyDto companyDto,Long id) {
        Company company =companyRepository.getById(id);

        String currentName = company.getName();
        String newName = companyDto.getName();
        if (!Objects.equals(currentName, newName)) {
            company.setName(newName);
        }

        String locatedCountry = company.getLocatedCountry();
        String newLocatedCountry = companyDto.getLocatedCountry();
        if (!Objects.equals(locatedCountry,newLocatedCountry)){
            company.setLocatedCountry(newLocatedCountry);
        }

        return companyDto;
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.getById(id);
    }
}
