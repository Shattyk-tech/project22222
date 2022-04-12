package peaksoft.second_project_sh.apis;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Operation(method = "postmethod", description = "create company")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/save")
    public Company createCompany(@RequestBody CompanyDto company) {
        return companyService.saveCompany(company);
    }

    @Operation(method = "putMethod", description = "update from id")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update/{id}")
    public CompanyDto update(@RequestBody CompanyDto company, @PathVariable("id") Long id) {
        return companyService.update(company, id);
    }

    @Operation(method = "getMethod", description = "get all companies")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/get")
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    @Operation(method = "deleteMethod", description = "delete from id")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        companyService.removeCompanyById(id);
    }

    @Operation(method = "getMethod", description = "get from id")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/get/{id}")
    public Optional<Company> getById(@PathVariable("id") Long id) {
        return companyService.getById(id);

    }
}
