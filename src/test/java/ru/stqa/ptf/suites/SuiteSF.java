package ru.stqa.ptf.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.stqa.ptf.tests.testsUNP.Declaration.DeclarationSFTests;
import ru.stqa.ptf.tests.testsUNP.NonResidenceSF;
import ru.stqa.ptf.tests.testsUNP.Operation.OperationSFClientTest;
import ru.stqa.ptf.tests.testsUNP.Operation.OperationSFContractorTest;
import ru.stqa.ptf.tests.testsUNP.Operation.OperationSFDepoTest;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocClientSFTests;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocContractorSFTests;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocDepoSFTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PrimaryDocClientSFTests.class,
        PrimaryDocContractorSFTests.class,
        PrimaryDocDepoSFTests.class,
        OperationSFClientTest.class,
        OperationSFContractorTest.class,
        OperationSFDepoTest.class,
        DeclarationSFTests.class,
        NonResidenceSF.class
})
public class SuiteSF {
}
