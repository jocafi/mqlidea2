package ru.investflow.mqlidea2.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import org.jetbrains.annotations.NotNull;
import ru.investflow.mqlidea2.psi.MQL4File;

public class MQL4FileStructureViewModel extends TextEditorBasedStructureViewModel {
    private final MQL4File file;

    public MQL4FileStructureViewModel(final MQL4File file) {
        super(file);
        this.file = file;
    }

    @NotNull
    public StructureViewTreeElement getRoot() {
        return new MQL4FileStructureViewElement(file);
    }
}
