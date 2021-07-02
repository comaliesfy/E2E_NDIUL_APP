package ru.stqa.ptf.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.stqa.ptf.tests.testsUNP.Representation.ExpenseFdeptSFTest;
import ru.stqa.ptf.tests.testsUNP.Representation.IncomeFdeptSFTest;
import ru.stqa.ptf.tests.testsUNP.Representation.RepresentationDFExpIncTest;
import ru.stqa.ptf.tests.testsUNP.Representation.RepresentationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RepresentationTest.class,
        RepresentationDFExpIncTest.class,
        IncomeFdeptSFTest.class,
        ExpenseFdeptSFTest.class
})
public class SuiteForTest {
}
