package xyz.rashidul.testplugin;


import com.google.gson.Gson;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.PopupChooserBuilder;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.components.JBList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rashidul.testplugin.fa.FontAwesomeUnicode;
import xyz.rashidul.testplugin.fa.Regular;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class MyAction extends BaseAction{

//    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
//    private static final FontIcon BIG_ICON = new ImageIcon(MyAction.class.getResource("water.png"));

    public MyAction() {
        super();
    }

    public MyAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    @NotNull
    @Override
    public String getActionId() {
        return "123";
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        System.out.println("click kora hoyeche");

        InputStream is = MyAction.class.getResourceAsStream("fa-regular-400.ttf");
            Font font = null;
            try {
                font = Font.createFont(Font.TRUETYPE_FONT, is);
                font = font.deriveFont(Font.PLAIN, 24f);
            } catch (FontFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        JLabel label = new JLabel("\\u" + "f0f3");
            label.setFont(font);
            label.setForeground(new Color(255, 0, 0));

        /*IdeFrame ideFrame = WindowManager.getInstance().getIdeFrame(DataKeys.PROJECT.getData(anActionEvent.getDataContext()));
        Dimension ideFrameSize = ideFrame.getComponent().getSize();
        boolean useBigIcon = 1000 <= ideFrameSize.getWidth() || 800 <= ideFrameSize.getHeight();*/

        /*JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder("", BIG_ICON, TRANSPARENT_COLOR, null)
                .setBorderColor(TRANSPARENT_COLOR)
                .setFadeoutTime(5000)
                .createBalloon()
                .show(RelativePoint.getSouthEastOf(ideFrame.getComponent()), Balloon.Position.atRight);*/

        /*JBPopupFactory.getInstance()
                .createConfirmation("Hey there", new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("testy");
                    }
                }, 1)
                .showInFocusCenter();*/
        DefaultListModel<FontIcon> listModel = getList();

        /*listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Cxvxanada");
        listModel.addElement("Denxcvmark");
        listModel.addElement("Fraxvnce");
        listModel.addElement("Grexcvat Britain");
        listModel.addElement("Japxvcan");*/


        /*ColoredListCellRenderer cr = new ColoredListCellRenderer() {
            @Override
            protected void customizeCellRenderer(@NotNull JList jList, Object o, int i, boolean b, boolean b1) {

            }
        };
        cr.setIcon(PluginIcons.STRUCTURE_TOOL_WINDOW);
*/

        JBList jl = new JBList(listModel);
        jl.setSelectionBackground(new Color(0,0,150));

        // selection
        /*jl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                FontIcon fontIcon = (FontIcon) jl.getSelectedValue();
                System.out.println(fontIcon.getName());
            }
        });
*/

        jl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                System.out.println("clocl mar");


//                super.mouseClicked(e);
                FontIcon fontIcon = (FontIcon) jl.getModel().getElementAt(jl.locationToIndex(e.getPoint()));
                System.out.println(fontIcon.getName());


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

//        jl.setFont(font);
//        jl.setForeground(new Color(255, 0, 0));
//        jl.setBackground(new Color(255, 255, 255));
        jl.setCellRenderer(new MyCellRenderer(font));
        jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        jl.setCellRenderer(cr);
//        jl.setCellRenderer(new Ce());






        JBPopupFactory.getInstance()
                .createListPopupBuilder(jl)
                .setTitle("Choose Font Awesome FontIcon")
                .setFilteringEnabled(o -> {
//                    System.out.println(o.toString());
                    FontIcon fontIcon = (FontIcon) o;
                    return fontIcon.getName();
                })
                .setCloseOnEnter(true)
                .setAutoselectOnMouseMove(false)
                .createPopup()
                .showInFocusCenter();

        /*JBPopupFactory.getInstance()
                .createListPopup()
                .showInFocusCenter();*/


//        PsiClass psiClass = getPsiClassFromContext(anActionEvent);
        /*MyDia genActionDialog = new MyDia();
        genActionDialog.show();
*/

        // add jpanel to dialog
        /*JPanel pan=new JPanel();
        pan.setLayout(new FlowLayout());

        pan.add(label);
        pan.add(new JButton("button"));


        JLabel label2 = new JLabel("?");
        label.setFont(font);*/

        /*JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/


        /*MyDialog dialog = new MyDialog();
        dialog.pack();
        dialog.setVisible(true);*/

//        dialog.add(pan);
//        dialog.revalidate();
//        dialog.repaint();
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
//                    String elem = icon.getUnicode() + "  " + icon.getName();
//                    String elem = icon.getUnicode();
//                    String elem = icon.getName();
                    FontIcon fontIcon1 = new FontIcon();
                    fontIcon1.setCode(icon.getUnicode());
                    fontIcon1.setName(icon.getName());
                    listModel.addElement(fontIcon1);
                }


                String test;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return listModel;
    }

    private PsiClass getPsiClassFromContext(AnActionEvent e) {
        PsiFile psiFile = e.getData(LangDataKeys.PSI_FILE);
        Editor editor = e.getData(PlatformDataKeys.EDITOR);

        int offset = editor.getCaretModel().getOffset();
        PsiElement elementAt = psiFile.findElementAt(offset);
        PsiClass psiClass = PsiTreeUtil.getParentOfType(elementAt, PsiClass.class);
        if (psiClass == null) {
            e.getPresentation().setEnabled(false);
            return null;

        }
        return psiClass;
    }
}


class MyCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;
    Font font;

    public MyCellRenderer(Font font) {
        setOpaque(true);
        this.font = font;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                            boolean cellHasFocus) {

    FontIcon fontIcon = (FontIcon) value;

//        Color background = Color.white;

        /*String entry = (String) value;

        value = entry.getText();

        Color foreground = entry.getType().getColor();

        Font font = list.getFont();

        font = new Font(list.getFont().getFontName(), entry.getType().getFontStyle(), list.getFont().getSize());

        if (isSelected)
            background = Color.lightGray;*/

        /*InputStream is = MyAction.class.getResourceAsStream("fa-regular-400.ttf");
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(Font.PLAIN, 24f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        JPanel jPanel = new JPanel();


//        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        JLabel c = new JLabel(fontIcon.getCode());
//        c.setForeground(new Color(255, 0, 0));
        c.setFont(font);
//        c.repaint();

        JLabel text = new JLabel(fontIcon.getName());
        jPanel.add(c);
        jPanel.add(text);

        if (isSelected) {
            jPanel.setBackground(Color.RED);
        }

        return jPanel;



        /*JBLabel c = new JBLabel((String) value);
        c.setForeground(new Color(255, 0, 0));
        c.setBackground(background);
        c.setFont(font);

        return c;*/
    }
}
