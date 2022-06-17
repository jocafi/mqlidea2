package ru.investflow.mqlidea2.psi.stub;

import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;
import ru.investflow.mqlidea2.psi.impl.MQL4ClassElement;

public interface MQL4ClassElementStub extends StubElement<MQL4ClassElement> {

    @NotNull
    String getName();

    @NotNull
    MQL4ClassElement.ClassType getClassType();
}

