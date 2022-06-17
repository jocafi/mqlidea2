package ru.investflow.mqlidea2.psi.stub;

import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;
import ru.investflow.mqlidea2.psi.impl.MQL4FunctionElement;

public interface MQL4FunctionElementStub extends StubElement<MQL4FunctionElement> {

    @NotNull
    String getName();

    @NotNull
    String getSignature();

    boolean isDeclaration();
}

