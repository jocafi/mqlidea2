package ru.investflow.mqlidea2.structure.elements;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import ru.investflow.mqlidea2.psi.impl.MQL4FunctionElement;
import ru.investflow.mqlidea2.structure.MQL4StructureViewElement;


public class MQL4StructureViewFunctionElement extends MQL4StructureViewElement<MQL4FunctionElement> {

    public MQL4StructureViewFunctionElement(@NotNull MQL4FunctionElement element) {
        super(element);
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return element.getPresentation();
    }
}
