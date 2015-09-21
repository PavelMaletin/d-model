package cvr.vist.stat.quickforms;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.*;
import com.vaadin.ui.Field;
import cvr.vist.stat.quickforms.ann.QFormBean;
import cvr.vist.stat.quickforms.ann.QFormField;
import cvr.vist.stat.quickforms.api.QuickFormFieldFactory;
import cvr.vist.stat.quickforms.api.QCellConstraint;

public class QuickForm extends VerticalLayout {

    private BeanFieldGroup formController;

    private HorizontalLayout uiButtonsRoot;
    private GridLayout uiFormRoot;
    private Label uiTitle, uiHeader, uiFooter;
    private Button uiBtnCommit, uiBtnCancel;

    private Class formType;
    private QFormBean formMetadata;

    private Object formData;

    public Button getUiBtnCommit() {
        return uiBtnCommit;
    }

    
    
    public QuickForm(Object formBean) {
        this();
        setFormData(formBean);
    }

    public QuickForm() {
        super();
        buildRootLayout();
    }

    private void assembleFormCompoments() {
        if (uiTitle != null)
            addComponent(uiTitle);

        if (uiHeader != null)
            addComponent(uiHeader);

        addComponent(uiFormRoot);

        if (uiFooter != null)
            addComponent(uiFooter);

        if (uiButtonsRoot != null)
            addComponent(uiButtonsRoot);

        setExpandRatio(uiFormRoot, 1.0f);
    }

    private void buildRootLayout() {
        setSizeFull();
        setSpacing(true);
    }

    private void preflightFormAnnotations() {
        if (formMetadata == null)
            throw new IllegalArgumentException(String.format("Specified formData class is not annotated by a @Form annotation: %s", formType.getSimpleName()));

        if (formMetadata.rows() <= 0 || formMetadata.columns() <= 0)
            throw new IllegalArgumentException("Your @Form annotation must specify non-zero positive bumber of rows and columns for a layout.");
    }

    private void buildFormHeaders() {
        if (formMetadata.title() != null && !formMetadata.title().trim().isEmpty())
            uiTitle = new Label(translateTextItem(formMetadata.title()));

        if (formMetadata.header() != null && !formMetadata.header().trim().isEmpty())
            uiHeader = new Label(translateTextItem(formMetadata.header()));

        if (formMetadata.footer() != null && !formMetadata.footer().trim().isEmpty())
            uiFooter = new Label(translateTextItem(formMetadata.footer()));
    }

    private void buildFormCommitButtons() {
        if (formMetadata.commitButtonVisible()) {
            uiBtnCommit = new Button((formMetadata.commitButtonTitle() != null && !formMetadata.commitButtonTitle().trim().isEmpty()) ? 
                    translateTextItem(formMetadata.commitButtonTitle()) : translateTextItem("Save"));
            uiBtnCommit.addClickListener(new Button.ClickListener() {
                public void buttonClick(final Button.ClickEvent event) {
                    try {
                        commit();
                    } catch (FieldGroup.CommitException e) {
                        e.printStackTrace();
                        new RuntimeException(e);
                    }
                }
            });
        }

        if (formMetadata.cancelButtonVisible()) {
            uiBtnCancel = new Button((formMetadata.cancelButtonTitle() != null && !formMetadata.cancelButtonTitle().trim().isEmpty()) ? translateTextItem(formMetadata.cancelButtonTitle()) : translateTextItem("Cancel"));
            uiBtnCancel.addClickListener(new Button.ClickListener() {
                public void buttonClick(final Button.ClickEvent event) {
                    reset();
                }
            });
        }

        if (uiBtnCancel != null || uiBtnCommit != null) {
            uiButtonsRoot = new HorizontalLayout();
            uiButtonsRoot.setWidth("100%");
            uiButtonsRoot.setHeight(null);
            uiButtonsRoot.setSpacing(true);

            Label sizer = new Label();
            sizer.setWidth("100%");
            sizer.setHeight(null);

            uiButtonsRoot.addComponent(sizer);

            if (uiBtnCommit != null)
                uiButtonsRoot.addComponent(uiBtnCommit);

            if (uiBtnCancel != null)
                uiButtonsRoot.addComponent(uiBtnCancel);

            uiButtonsRoot.setExpandRatio(sizer, 1.0f);
        }
    }

    private void buldFormUI() {
        formController = new BeanFieldGroup(formType);
        formController.setBuffered(true);

        uiFormRoot = new GridLayout(formMetadata.columns(), formMetadata.rows());
        uiFormRoot.setWidth("100%");
        uiFormRoot.setHeight(null);
        uiFormRoot.setSpacing(true);

        java.lang.reflect.Field[] classFields = formType.getDeclaredFields();

        for (java.lang.reflect.Field beanField : classFields)
            buildSingleField(beanField);
    }

    private void buildSingleField(final java.lang.reflect.Field beanField) {
        QFormField metadata = (QFormField) beanField.getAnnotation(QFormField.class);

        if (metadata != null) {
            QCellConstraint constraint = new QCellConstraint(metadata.location());
            Field uiField = QuickFormFieldFactory.createFormField(beanField, metadata);

            if (constraint.getStartCell() == constraint.getEndCell())
                uiFormRoot.addComponent(uiField, constraint.getStartCell(), constraint.getStartRow());
            else {
                uiField.setWidth("100%");
                if (constraint.getStartRow() != constraint.getEndRow())
                    uiField.setHeight("90%");
                uiFormRoot.addComponent(uiField, constraint.getStartCell(), constraint.getStartRow(), constraint.getEndCell(), constraint.getEndRow());
            }

            formController.bind(uiField, beanField.getName());
        }
    }

    private String translateTextItem(final String text) {
        return text;
    }

    public void setFormData(final Object formBean) {
        if (formBean == null)
            throw new IllegalArgumentException("You cannot set NULL beans here.");

        this.formData = formBean;

        if (this.formType == null || !this.formType.equals(formBean.getClass())) {
            this.formType = formBean.getClass();
            initializeFormWithNewBeantype();
        }

        formController.setItemDataSource(formData);
    }

    private void initializeFormWithNewBeantype() {
        formMetadata = (QFormBean) formType.getAnnotation(QFormBean.class);

        removeAllComponents();

        uiTitle = null;
        uiHeader = null;
        uiFooter = null;
        uiBtnCancel = null;
        uiBtnCommit = null;

        if (uiFormRoot != null) {
            uiFormRoot.removeAllComponents();
            uiFormRoot = null;
        }

        preflightFormAnnotations();
        buildFormHeaders();
        buildFormCommitButtons();
        buldFormUI();
        assembleFormCompoments();
    }

    public Object getFormData() {
        return formData;
    }

    public Object commit() throws FieldGroup.CommitException {
        formController.commit();
        return getFormData();
    }

    public void reset() {
        formController.discard();
    }

}
