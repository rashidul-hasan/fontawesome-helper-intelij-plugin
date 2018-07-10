package xyz.rashidul.intelij.fontawesomesnippets;


import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class PluginInitiator implements ApplicationComponent {

    @Override
    public void initComponent() {
//        Notifications.Bus.notify(new Notification("github", "Success rashed", "Component inited", NotificationType.INFORMATION));
//        System.out.println("Openedd");


//        ObjectMapper mapper = new ObjectMapper();




        /*InputStream stream = new ClassPathResource(resourceRelativePath).getInputStream();
        byte[] encoded = IOUtils.toByteArray(stream);
        String content = new String(encoded, Charset.forName("UTF-8"));*/


        /*ListPopup j = JBPopupFactory.getInstance().createConfirmation("heyyyy", new Runnable() {
            @Override
            public void run() {
                System.out.println("heyeyeyyeye");
            }
        }, 2);

        j.showInFocusCenter();*/


    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "Kutta";
    }
}
