package model.managerBeans;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import model.actions.MembreAction;
import model.actions.PhotoAction;
import model.entities.Photos;

import org.primefaces.event.FileUploadEvent;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@ManagedBean(name = "fileUploadController")
public class UpdatePhoto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int IMG_WIDTH = 250;
	private static final int IMG_HEIGHT = 187;
	private static final int type = BufferedImage.TYPE_INT_ARGB;
	private String email;
	private String img;
	private String s = "s";

	public UpdatePhoto() {
		setEmail((String) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("email"));
	}

	public void upload(FileUploadEvent event) {

		System.out.println("Dans upload");
		FacesMessage msg = new FacesMessage("Success! ", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		PhotoAction pa = new PhotoAction();
		MembreAction ma = new MembreAction();
		
		// resizing image with new dimension
		BufferedImage newImage;
		BufferedImage bImageFromConvert = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] imageByte = event.getFile().getContents();
		InputStream in = new ByteArrayInputStream(imageByte);
		try {
			bImageFromConvert = ImageIO.read(in);
		} catch (IOException e) {

			e.printStackTrace();
		}
		newImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(bImageFromConvert, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		try {
			ImageIO.write(newImage, "png", baos);
			baos.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}

		byte[] imageResize = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// adding picture into database

		int id = ma.getMembreIdByEmail(getEmail());
		if (pa.getCheminById(id) != null) {
			img = Base64.encode(imageResize);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("chemin", getImg());
			map.put("membreId", Integer.toString(id));
			pa.updateChemin(map);
			System.out.println("update photo");
		} else {
			img = Base64.encode(event.getFile().getContents());
			// recuperer le id du user en cours
			// creer une nouvelle photo
			Photos photo = new Photos(id, getImg());

			ma.insertPhoto(photo);
			System.out.println("insert photo");
		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
