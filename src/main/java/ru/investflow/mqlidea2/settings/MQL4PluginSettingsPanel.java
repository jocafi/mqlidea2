package ru.investflow.mqlidea2.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.util.FileContentUtil;
import com.intellij.util.ui.JBUI;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//todo: SearchableConfigurable,
public class MQL4PluginSettingsPanel extends JPanel implements Configurable {

    @NotNull
    private final JComboBox<String> docsLangCombo;

    @NotNull
    private final JComboBox<String> errorAnalysisCombo;

    @NotNull
    private final MQL4PluginSettings settings;

    public MQL4PluginSettingsPanel() {
        this.settings = MQL4PluginSettings.getInstance();

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel form = new JPanel(new GridBagLayout());
        form.setLayout(new GridBagLayout());
        add(form);


        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = JBUI.insets(10);

        gc.gridx = 0;
        gc.gridy = 0;
        form.add(new JLabel("Docs language: "), gc);

        gc.gridx = 1;
        gc.gridy = 0;
        docsLangCombo = new ComboBox<>(new String[]{"Russian", "English"});
        int useEnDocs = settings == null ? 1 : (settings.isUseEnDocs() ? 1 : 0);
        docsLangCombo.setSelectedIndex(useEnDocs);
        form.add(docsLangCombo, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        form.add(new JLabel("Error analysis: "), gc);

        gc.gridx = 1;
        gc.gridy = 1;
        errorAnalysisCombo = new ComboBox<>(new String[]{"On", "Off"});
        int performErrorAnalysis = settings == null ? 1 : (settings.performErrorAnalysis() ? 0 : 1);
        errorAnalysisCombo.setSelectedIndex(performErrorAnalysis);
        form.add(errorAnalysisCombo, gc);
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "MQL4";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    /**
     * Returns the user interface component for editing the configuration.
     *
     * @return the component instance.
     */
    @Nullable
    @Override
    public JComponent createComponent() {
        return this;
    }

    /**
     * Checks if the settings in the user interface component were modified by the user and
     * need to be saved.
     *
     * @return true if the settings were modified, false otherwise.
     */
    @Override
    public boolean isModified() {
        int useEnDocs = settings == null ? 1 : (settings.isUseEnDocs() ? 1 : 0);
        return docsLangCombo.getSelectedIndex() != useEnDocs
                || isErrorAnalysisFlagChanged();
    }

    private boolean isErrorAnalysisFlagChanged() {
        if (settings == null) {
            return false;
        } else {
            return errorAnalysisCombo.getSelectedIndex() != (settings.performErrorAnalysis() ? 0 : 1);
        }
    }

    /**
     * Store the settings from configurable to other components.
     */
    @Override
    public void apply() {
        settings.setUseEnDocs(docsLangCombo.getSelectedIndex() == 1);
        if (isErrorAnalysisFlagChanged()) {
            FileContentUtil.reparseOpenedFiles();
        }
        settings.setPerformErrorAnalysis(errorAnalysisCombo.getSelectedIndex() == 0);
    }

    /**
     * Load settings from other components to configurable.
     */
    @Override
    public void reset() {
        int useEnDocs = settings == null ? 1 : (settings.isUseEnDocs() ? 1 : 0);
        docsLangCombo.setSelectedIndex(useEnDocs);
        int performErrorAnalysis = settings == null ? 1 : (settings.performErrorAnalysis() ? 0 : 1);
        errorAnalysisCombo.setSelectedIndex(performErrorAnalysis);
    }

}
