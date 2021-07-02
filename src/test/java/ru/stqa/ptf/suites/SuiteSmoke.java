package ru.stqa.ptf.suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.stqa.ptf.tests.testsOperator.OperatorClientTest;
import ru.stqa.ptf.tests.testsUNP.Declaration.DeclarationSFTests;
import ru.stqa.ptf.tests.testsUNP.Declaration.testKND56Test;
import ru.stqa.ptf.tests.testsUNP.Downloads.DownloadsOperTests;
import ru.stqa.ptf.tests.testsUNP.NonResidenceTest;
import ru.stqa.ptf.tests.testsUNP.Operation.OperationDeleteTest;
import ru.stqa.ptf.tests.testsUNP.Operation.OperationSFClientTest;
import ru.stqa.ptf.tests.testsUNP.Operation.OperationsDFTests;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocClientSFTests;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocDFTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OperatorClientTest.class,
        DownloadsOperTests.class,
        NonResidenceTest.class,
        PrimaryDocClientSFTests.class,
        PrimaryDocDFTests.class,
        OperationsDFTests.class,
        OperationDeleteTest.class,
        OperationSFClientTest.class,
        DeclarationSFTests.class,
        testKND56Test.class,
})
public class SuiteSmoke {
}
