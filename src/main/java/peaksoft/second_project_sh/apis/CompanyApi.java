package peaksoft.second_project_sh.apis;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.CompanyDto;
import peaksoft.second_project_sh.model.Company;
import peaksoft.second_project_sh.services.CompanyService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/companies")
@AllArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @PostMapping("/save")
    public Company createCompany(@RequestBody CompanyDto company) {
        return companyService.saveCompany(company);
    }

    @PutMapping("/update/{id}")
    public Company update(@RequestBody Company company,@PathVariable("id")Long id){
        company.setId(id);
        return companyService.update(company);
    }

    @GetMapping("/get")
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }

    @DeleteMapping("{id}")
    public void deleteCompanyById(@PathVariable Long id){
          companyService.removeCompanyById(id);
    }

    @GetMapping("/get/{id}")
    public Optional<Company> getById(@PathVariable("id") Long id){
        return companyService.getById(id);

}
}
