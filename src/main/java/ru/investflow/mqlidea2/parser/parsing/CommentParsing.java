package ru.investflow.mqlidea2.parser.parsing;

import com.intellij.lang.PsiBuilder;
import ru.investflow.mqlidea2.psi.MQL4Elements;

public class CommentParsing implements MQL4Elements {

    public static boolean parseComment(PsiBuilder b) {
        if (b.getTokenType() != LINE_COMMENT && b.getTokenType() != BLOCK_COMMENT) {
            return false;
        }
        b.advanceLexer();
        return true;
    }
}
