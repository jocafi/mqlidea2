package parser;

import com.intellij.core.CoreApplicationEnvironment;
import com.intellij.lang.LanguageExtensionPoint;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.testFramework.ParsingTestCase;
import org.jetbrains.annotations.NotNull;
import ru.investflow.mqlidea2.parser.MQL4ParserDefinition;

public abstract class MQL4ParserTestBase extends ParsingTestCase {

    public MQL4ParserTestBase(String dataPath) {
        this(dataPath, "mq4");
    }

    public MQL4ParserTestBase(String dataPath, String fileExt) {
        super(dataPath, fileExt, new MQL4ParserDefinition());
    }

    @NotNull
    @Override
    protected String getTestDataPath() {
        return "src/test/resources/testData";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }

    protected void doTest() {
        super.doTest(true);
    }

//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//        CoreApplicationEnvironment.registerExtensionPoint(Extensions.getRootArea(), "com.intellij.lang.braceMatcher", LanguageExtensionPoint.class);
//    }
}