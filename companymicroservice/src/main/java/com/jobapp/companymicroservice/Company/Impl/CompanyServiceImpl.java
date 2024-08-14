package com.jobapp.companymicroservice.Company.Impl;


import com.jobapp.companymicroservice.Company.Company;
import com.jobapp.companymicroservice.Company.CompanyRepository;
import com.jobapp.companymicroservice.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

        private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getallCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findByid(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updatecompany(Long id, Company com) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company=companyOptional.get();

            company.setName(com.getName());
            company.setDescription(com.getDescription());
//            company.setJobs(com.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createcompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deletecompany(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


}
