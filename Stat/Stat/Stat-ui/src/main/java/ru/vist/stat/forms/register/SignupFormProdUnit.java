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
        header = "Введите название и адрес предприятия для которого вы производите регистрацию ")
//        + "Все остальные данные вы сможете заполнить в соответствующих справочниках.")

public class SignupFormProdUnit implements Serializable {

    @QFormField(title = "Наименование предприятия", location = "0,0,2,0", required = true, requiredFieldErrorMessage = "Введите 'Наименование предприятия'")
    private String name = "";


    @QFormField(title = "Юридический адрес", location = "0,1,2,1", required = true)
    private String address = "";

    @QFormField(title = "Тип предприятия", location = "0,2", required = true, requiredFieldErrorMessage = "Введите фамилию",type = QFormFieldType.List)
    private String prodType = "Предприятие";

    @QFormField(title = "Промышленность", location = "1,2", required = false, requiredFieldErrorMessage = "Введите имя",type = QFormFieldType.List)
    private String industry = "";

    @QFormField(title = "Тип производства", location = "2,2", requiredFieldErrorMessage = "Введите Отчество",type = QFormFieldType.List)
    private String productionType = "";

    
    
    @QFormField(title = "ФИО руководителя", location = "0,3", required = true, requiredFieldErrorMessage = "Введите фамилию",type = QFormFieldType.List)
    private String fam_chef = "";

    @QFormField(title = ".", location = "1,3", required = false, requiredFieldErrorMessage = "Введите имя",type = QFormFieldType.List)
    private String im_chef = "";

    @QFormField(title = ".", location = "2,3", requiredFieldErrorMessage = "Введите Отчество",type = QFormFieldType.List)
    private String otch_chef = "";
    

    @QFormField(title = "Должность руководителя", location = "0,4,2,4", required = true,type = QFormFieldType.List)
    private String post = "";


    public SignupFormProdUnit() {
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFam_chef() {
        return fam_chef;
    }

    public void setFam_chef(String fam_chef) {
        this.fam_chef = fam_chef;
    }

    public String getIm_chef() {
        return im_chef;
    }

    public void setIm_chef(String im_chef) {
        this.im_chef = im_chef;
    }

    public String getOtch_chef() {
        return otch_chef;
    }

    public void setOtch_chef(String mname_chef) {
        this.otch_chef = mname_chef;
    }

//    public String getFio_chef() {
//        return fio_chef;
//    }
//
//    public void setFio_chef(String fio_chef) {
//        this.fio_chef = fio_chef;
//    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }


}
