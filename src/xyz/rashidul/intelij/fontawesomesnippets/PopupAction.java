package xyz.rashidul.intelij.fontawesomesnippets;


import com.google.gson.Gson;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.components.JBList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rashidul.intelij.fontawesomesnippets.fa.FontAwesomeUnicode;
import xyz.rashidul.intelij.fontawesomesnippets.fa.Regular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class PopupAction extends BaseAction{

    public PopupAction() {
        super();
    }

    public PopupAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    @NotNull
    @Override
    public String getActionId() {
        return "123";
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

        InputStream is = PopupAction.class.getResourceAsStream("fa-regular-400.ttf");
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(Font.PLAIN, 24f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DefaultListModel<FontIcon> listModel = getList();

        JBList jl = new JBList(listModel);
        jl.setSelectionBackground(new Color(0,0,150));
        jl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FontIcon fontIcon = (FontIcon) jl.getModel().getElementAt(jl.locationToIndex(e.getPoint()));
                // ediotr
                //Get required data keys
                final Project project = anActionEvent.getProject();
                final Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);
                //Set visibility only in case of existing project and editor
                anActionEvent.getPresentation().setVisible(project != null && editor != null);

                assert editor != null;
                final int cursorOffset = editor.getCaretModel().getOffset();
                final Document document = editor.getDocument();

                new WriteCommandAction(project){
                    @Override
                    protected void run(@NotNull Result result) throws Throwable {
                        document.insertString(cursorOffset, "kuttar baccha");
                    }
                }.execute();

            }
        });

        jl.setCellRenderer(new PopupCellRenderer(font));
        jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JBPopupFactory.getInstance()
            .createListPopupBuilder(jl)
            .setTitle("Choose Font Awesome Icon")
            .setFilteringEnabled(o -> {
                FontIcon fontIcon = (FontIcon) o;
                return fontIcon.getName();
            })
            .setCloseOnEnter(true)
            .setAutoselectOnMouseMove(false)
            .createPopup()
            .showInFocusCenter();
    }

    private DefaultListModel<FontIcon> getList() {
        DefaultListModel<FontIcon> listModel = new DefaultListModel<>();
        Gson gson = new Gson();
        BufferedReader br = null;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("character-list.json").getFile());
        try {
            br = new BufferedReader(new FileReader(file));
            FontAwesomeUnicode result = gson.fromJson(br, FontAwesomeUnicode.class);
            if (result != null) {
                java.util.List<Regular> solids = result.getRegular();
                for(Regular icon : solids){
                    FontIcon fontIcon1 = new FontIcon();
                    fontIcon1.setCode(icon.getUnicode());
                    fontIcon1.setName(icon.getName());
                    listModel.addElement(fontIcon1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return listModel;
    }

}

