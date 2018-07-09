package xyz.rashidul.testplugin;


import com.intellij.openapi.project.DumbAwareAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class BaseAction extends DumbAwareAction{

    public BaseAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    public BaseAction() {
        super();
    }

    @NotNull
    public abstract String getActionId();
}
