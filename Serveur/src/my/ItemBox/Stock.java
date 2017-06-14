package my.ItemBox;
import java.io.Serializable;

public class Stock implements Serializable{
	 private int id;
	 private String reference;
	 private String familleComposant;
	 private float prix;
	 private int nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFamilleComposant() {
		return familleComposant;
	}

	public void setFamilleComposant(String familleComposant) {
		this.familleComposant = familleComposant;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
