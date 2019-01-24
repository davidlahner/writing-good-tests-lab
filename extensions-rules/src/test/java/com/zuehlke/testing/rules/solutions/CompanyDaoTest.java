package com.zuehlke.testing.rules.solutions;

import com.zuehlke.testing.rules.Company;
import com.zuehlke.testing.rules.CompanyDao;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExternalResource;

import java.util.Collection;
import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CompanyDaoTest {

    private CompanyDao dao = new CompanyDao();

    @Rule
    public CompanyResource companyResource = new CompanyResource();

    @Test
    public void find() {
        // arrange
        Company expected = companyResource.createCompany("Zuehlke Engineering AG");
        // act
        Company result = dao.find(expected.getName());
        // assert
        assertThat(result.getName(), is(equalTo(expected.getName())));
    }

    private class CompanyResource extends ExternalResource {

        private CompanyDao dao = new CompanyDao();
        private Collection<Company> companies = new LinkedList<>();

        public Company createCompany(String name) {
            final Company company = new Company(name);
            dao.save(company);
            companies.add(company);
            return company;
        }

        @Override
        protected void after() {
            for (Company company : companies) {
                dao.delete(company);
            }
            super.after();
        }

    }
}
