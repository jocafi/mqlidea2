package ru.investflow.mqlidea2.structure;

import com.intellij.ide.structureView.newStructureView.StructureViewComponent;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.project.Project;
import ru.investflow.mqlidea2.psi.MQL4File;

public class MQL4FileStructureViewComponent extends StructureViewComponent {

    public MQL4FileStructureViewComponent(Project project, MQL4File file, FileEditor fileEditor) {
        super(fileEditor, new MQL4FileStructureViewModel(file), project, true);
    }
}