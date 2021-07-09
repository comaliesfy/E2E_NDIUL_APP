package ru.stqa.ptf.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.stqa.ptf.tests.testsUNP.PrimaryDocs.PrimaryDocDFTests;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        PrimaryDocDFTests.class
})
public class SuiteForTest {

}
