package ru.investflow.mqlidea2.doc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MQL4DocumentationProviderTest {

    @Test
    public void testMQL4DocumentationProvider() {
        MQL4DocumentationProvider bean = new MQL4DocumentationProvider();
        DocEntry docEntry = MQL4DocumentationProvider.getEntryByText("CHART_BEGIN");
        assertNotNull(docEntry);
        assertEquals(docEntry.text, "CHART_BEGIN");
        assertEquals(docEntry.link, "/chart_operations/chartnavigate");
        assertEquals(docEntry.type.name(), "BuiltInConstant");
    }
}