/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.forms.register;

import cvr.vist.stat.quickforms.ann.QFormBean;
import cvr.vist.stat.quickforms.ann.QFormField;
import cvr.vist.stat.quickforms.api.QFormFieldType;
import java.io.Serializable;

@QFormBean(rows = 5, columns = 3, cancelButtonVisible = false, commitButtonVisible = true,cancelButtonTitle = "Отмена",commitButtonTitle = "Сохранить",
        header = "Укажите как вас зовут, Ваши контактные данные. Придумайте пароль. "
        + "Все остальные данные вы сможете заполнить позднее в соответствующих справочниках.")

public class SignupForm implements Serializable {

    @QFormField(title = "Фамилия", location = "0,0", required = true, requiredFieldErrorMessage = "Введите фамилию",type = QFormFieldType.List)
    private String fam = "";

    @QFormField(title = "Имя", location = "1,0", required = true, requiredFieldErrorMessage = "Введите имя",type = QFormFieldType.List)
    private String im = "";

    @QFormField(title = "Отчество", location = "2,0", requiredFieldErrorMessage = "Введите Отчество",type = QFormFieldType.List)
    private String otch = "";

    @QFormField(title = "E-Mail", location = "0,1,2,1", required = true, requiredFieldErrorMessage = "Введите e-mail")
    private String email = "a@b.c";

    @QFormField(title = "Телефоны", location = "0,2,2,2", required = true, requiredFieldErrorMessage = "Введите контактные телефоны")
    private String phones = "";

    @QFormField(title = "Ваша должность на предприятии", location = "0,3,2,3", required = true,type = QFormFieldType.MultiList)
    private String post = "";
    
    
    @QFormField(title = "Ваш ЛОГИН", location = "0,4", required = true, requiredFieldErrorMessage = "Ввод ЛОГИНа обязателен!!!")
    private String nikName = "";

    @QFormField(title = "Пароль", location = "1,4", required = true, requiredFieldErrorMessage = "Ведите пароль",type = QFormFieldType.Password)
    private String password1 = "";

    @QFormField(title = "Пароль(повтор)", location = "2,4", required = true, requiredFieldErrorMessage = "Ведите пароль ещё раз",type = QFormFieldType.Password)
    private String password2 = "";

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    
    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public SignupForm() {
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public SignupForm(String name, String password1) {
        this.fam = name;
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

}
