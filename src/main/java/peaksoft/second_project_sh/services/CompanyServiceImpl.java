package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.second_project_sh.dto.CompanyDto;
import peaksoft.second_project_sh.dto.mapper.CompanyMapper;
import peaksoft.second_project_sh.model.Company;
import peaksoft.second_project_sh.repositories.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
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
    public Company update( Company company) {

       return companyRepository.save(company);

    }

    @Override
    public Company findById(Long id) {
        return companyRepository.getById(id);
    }
}
