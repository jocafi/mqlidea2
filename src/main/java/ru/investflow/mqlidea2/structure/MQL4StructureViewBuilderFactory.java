package ru.investflow.mqlidea2.structure;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.investflow.mqlidea2.psi.MQL4File;

public class MQL4StructureViewBuilderFactory implements PsiStructureViewFactory {
    @Nullable
    @Override
    public StructureViewBuilder getStructureViewBuilder(@NotNull PsiFile psiFile) {
        return (fileEditor, project) -> new MQL4FileStructureViewComponent(project, (MQL4File) psiFile, fileEditor);
    }
}
