package xyz.rashidul.testplugin.dia;

import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.psi.PsiClass;
import com.intellij.ui.CollectionListModel;
import com.intellij.ui.ToolbarDecorator;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by rashidul on 7/4/2018.
 */
public class MyDia extends DialogWrapper {

    CollectionListModel<String> psiFieldCollectionListModel;
    LabeledComponent<JPanel> jPanelLabeledComponent;

    public MyDia() {
        super(true);
        setTitle("this is the generator");

        psiFieldCollectionListModel = new CollectionListModel<>();
        psiFieldCollectionListModel.add("func1");
        psiFieldCollectionListModel.add("func2");
        psiFieldCollectionListModel.add("func3");
        JList fieldList = new JList(psiFieldCollectionListModel);
        fieldList.setCellRenderer(new DefaultPsiElementCellRenderer());
        ToolbarDecorator toolbarDecorator = ToolbarDecorator.createDecorator(fieldList);
        toolbarDecorator.disableAddAction();
        JPanel jPanel = toolbarDecorator.createPanel();
        jPanelLabeledComponent = LabeledComponent.create(jPanel, "im gooing to add code");
        init();

    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return jPanelLabeledComponent;
    }
}
