package ru.stqa.ptf.suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.stqa.ptf.tests.testsAdmin.AdminTest;
import ru.stqa.ptf.tests.testsOperator.OperatorClientTest;
import ru.stqa.ptf.tests.testsOperator.OperatorContractorTest;
import ru.stqa.ptf.tests.testsOperator.OperatorDepositoryTest;
import ru.stqa.ptf.tests.testsUNP.*;
import ru.stqa.ptf.tests.testsUNP.Declaration.ControlRationsTest;
import ru.stqa.ptf.tests.testsUNP.Declaration.DeclarationSFTests;
import ru.stqa.ptf.tests.testsUNP.Declaration.testKND24Test;
import ru.stqa.ptf.tests.testsUNP.Declaration.testKND56Test;
import ru.stqa.ptf.tests.testsUNP.Downloads.DownloadsOperTests;
import ru.stqa.ptf.tests.testsUNP.Downloads.DownloadsSFClientTest;
import ru.stqa.ptf.tests.testsUNP.Downloads.DownloadsSFContractorTest;
import ru.stqa.ptf.tests.testsUNP.Downloads.DownloadsSFDepoTest;
import ru.stqa.ptf.tests.testsUNP.Operation.*;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocClientSFTests;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocContractorSFTests;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocDFTests;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocDepoSFTests;
import ru.stqa.ptf.tests.testsUNP.Representation.ExpenseFdeptSFTest;
import ru.stqa.ptf.tests.testsUNP.Representation.IncomeFdeptSFTest;
import ru.stqa.ptf.tests.testsUNP.Representation.RepresentationDFExpIncTest;
import ru.stqa.ptf.tests.testsUNP.Representation.RepresentationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdminTest.class,
        OperatorClientTest.class,
        OperatorContractorTest.class,
        OperatorDepositoryTest.class,
        AdministrationUNPTest.class,
        DownloadsOperTests.class,
        DownloadsSFClientTest.class,
        DownloadsSFContractorTest.class,
        DownloadsSFDepoTest.class,
        NonResidenceTest.class,
        NonResidenceSF.class,
        PrimaryDocClientSFTests.class,
        PrimaryDocContractorSFTests.class,
        PrimaryDocDepoSFTests.class,
        PrimaryDocDFTests.class,
        OperationsDFTests.class,
        OperationDeleteTest.class,
        OperationSFClientTest.class,
        OperationSFContractorTest.class,
        OperationSFDepoTest.class,
        DeclarationSFTests.class,
        testKND24Test.class,
        testKND56Test.class,
        ControlRationsTest.class,
        DedublicationNonResidenceTest.class,
        ReferenceBooksTests.class,
        RepresentationTest.class,
        RepresentationDFExpIncTest.class,
        IncomeFdeptSFTest.class,
        ExpenseFdeptSFTest.class

})
public class SuiteRegress {
    // This class remains empty, it is used only as a holder for the above annotations
}
