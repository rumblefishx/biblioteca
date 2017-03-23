package br.com.biblioteca.config.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

@ManagedBean
public class UploadBean {
	
	private final String DIRETORIO_IMAGENS = "upload_fotos";
	
	private UploadedFile file;
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
        	StringBuilder filePath = new StringBuilder();
        	filePath.append(System.getProperty("user.dir"));
        	filePath.append("/");
        	filePath.append(DIRETORIO_IMAGENS);
        	filePath.append("/");
        	filePath.append(file.getFileName());
        	
        	FacesMessage message;
        	
        	try {
				OutputStream output = new FileOutputStream(new File(filePath.toString()));
				message = new FacesMessage("Arquivo ", file.getFileName() + "Arquivo subiu!");
			} catch (FileNotFoundException e) {
				message = new FacesMessage();
			}
        	
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
