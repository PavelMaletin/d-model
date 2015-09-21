package ru.vist.stat.forms.authentication;

import java.io.Serializable;

import com.vaadin.event.ShortcutAction;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import cvr.vist.stat.common.Utils;
import ru.vist.stat.forms.register.RegistrationDlg;

public class LoginScreen extends CssLayout {

    private TextField username;
    private PasswordField password;
    private Button login;
    private Button forgotPassword;
    private final LoginListener loginListener;
    private final AccessControl accessControl;
    private final Button btnRegister = new Button("Регистрация");

    public LoginScreen(AccessControl accessControl, LoginListener loginListener) {
        this.loginListener = loginListener;
        this.accessControl = accessControl;
        buildUI();
        username.focus();
    }

    private void buildUI() {
        addStyleName("login-screen");

        Component loginForm = buildLoginForm();

        VerticalLayout centeringLayout = new VerticalLayout();
        centeringLayout.setStyleName("centering-layout");
        centeringLayout.addComponent(loginForm);
        centeringLayout.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

        CssLayout loginInformation = buildLoginInformation();

        addComponent(centeringLayout);
        addComponent(loginInformation);
    }

    private Component buildLoginForm() {
        FormLayout loginForm = new FormLayout();

        loginForm.addStyleName("login-form");
        loginForm.setSizeUndefined();
        loginForm.setMargin(true);

        loginForm.addComponent(username = new TextField("Пользователь", "ГОСТЬ"));
        username.setWidth(15, Unit.EM);
        loginForm.addComponent(password = new PasswordField("Пароль"));
        password.setWidth(15, Unit.EM);
        password.setDescription("Write anything");
        CssLayout buttons = new CssLayout();
        buttons.setStyleName("buttons");
        loginForm.addComponent(buttons);

        buttons.addComponent(login = new Button("Вход"));
        login.setDisableOnClick(true);
        login.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    login();
                } finally {
                    login.setEnabled(true);
                }
            }
        });
        login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        login.addStyleName(ValoTheme.BUTTON_FRIENDLY);

        buttons.addComponent(forgotPassword = new Button("Забыли пароль?"));
        forgotPassword.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Utils.showNotification(new Notification("Не хорошо!"));
            }
        });
        forgotPassword.addStyleName(ValoTheme.BUTTON_LINK);
        return loginForm;
    }

    private CssLayout buildLoginInformation() {
        CssLayout loginInformation = new CssLayout();
        loginInformation.setStyleName("login-information");
        Label loginInfoText = new Label(
                "<h1>Информация о входе в систему</h1>"
                + "Для просмотра демо версии войдите в систему как &quot;Гость&quot; без пароля. "
                + "Для регистрации нажмите кнопку &quot;Регистрация&quot;"
                + "<p>",
                ContentMode.HTML);
        //btnRegister.addStyleName(ValoTheme.BUTTON_LARGE);
        btnRegister.setWidth("90%");
        btnRegister.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                RegistrationDlg registrationDlg = new RegistrationDlg(getUI());
            }
        });

        loginInformation.addComponent(loginInfoText);
        loginInformation.addComponent(btnRegister);
        return loginInformation;
    }

    private void login() {
        if (accessControl.signIn(username.getValue(), password.getValue()))
            loginListener.loginSuccessful();
        else {
            Utils.showNotification(new Notification("Вход не выпоелнен",
                    "Проверьте имя и пароль",
                    Notification.Type.TRAY_NOTIFICATION));
            username.focus();
        }
    }
}
// cvr.vist.model.domain.sys.User 
// cvr.vist.model.domain.sys.User