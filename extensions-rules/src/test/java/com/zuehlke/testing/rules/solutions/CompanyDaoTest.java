package com.zuehlke.testing.rules.solutions;

import com.zuehlke.testing.rules.Company;
import com.zuehlke.testing.rules.CompanyDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

import java.util.Collection;
import java.util.LinkedList;

@ExtendWith(CompanyDaoTest.CompanyResourceExtension.class)
class CompanyDaoTest {

    private CompanyDao dao = new CompanyDao();

    @Test
    void find(CompanyResource companyResource) {
        // arrange
        Company expected = companyResource.createCompany("Zuehlke Engineering AG");
        // act
        Company result = dao.find(expected.getName());
        // assert
        Assertions.assertEquals(expected.getName(), result.getName());
    }

    static class CompanyResourceExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

        private static final String COMPANY_RESOURCE = "companies";
        private final Namespace namespace = Namespace.create("Zuehlke", "Testing", "Companies");

        @Override
        public void beforeEach(ExtensionContext context) {
            getStore(context).put(COMPANY_RESOURCE, new CompanyResource());
        }


        @Override
        public void afterEach(ExtensionContext context) {
            CompanyResource companyResource = (CompanyResource) getStore(context).get(COMPANY_RESOURCE);
            companyResource.cleanUp();
        }

        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return CompanyResource.class.equals(parameterContext.getParameter().getType());
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return getStore(extensionContext).get(COMPANY_RESOURCE);
        }

        private Store getStore(ExtensionContext context) {
            return context.getStore(namespace);
        }
    }

    private static class CompanyResource {

        private CompanyDao dao = new CompanyDao();
        private Collection<Company> companies = new LinkedList<>();

        Company createCompany(String name) {
            final Company company = new Company(name);
            dao.save(company);
            companies.add(company);
            return company;
        }

        public void cleanUp() {
            for (Company company : companies) {
                dao.delete(company);
            }
        }
    }
}
