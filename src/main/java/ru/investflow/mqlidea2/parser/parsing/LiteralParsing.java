package ru.investflow.mqlidea2.parser.parsing;

import com.intellij.lang.PsiBuilder;
import org.jetbrains.annotations.NotNull;
import ru.investflow.mqlidea2.psi.MQL4TokenSets;

public class LiteralParsing {

    public static boolean parseLiteral(@NotNull PsiBuilder b) {
        if (MQL4TokenSets.LITERALS.contains(b.getTokenType())) {
            b.advanceLexer();
            return true;
        }
        return false;
    }

}
