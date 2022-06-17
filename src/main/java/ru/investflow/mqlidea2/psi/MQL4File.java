package ru.investflow.mqlidea2.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import ru.investflow.mqlidea2.MQL4FileType;
import ru.investflow.mqlidea2.MQL4Language;

public class MQL4File extends PsiFileBase {

    public MQL4File(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MQL4Language.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MQL4FileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "MQL4 File";
    }
}