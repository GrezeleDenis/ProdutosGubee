package model;

public class JavaBeans {
	private String codpro;
	private String nomepro;
	private String descripro;
	private String mercapro;
	private String tecnopro;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String codpro, String nomepro, String descripro, String mercapro, String tecnopro) {
		super();
		this.codpro = codpro;
		this.nomepro = nomepro;
		this.descripro = descripro;
		this.mercapro = mercapro;
		this.tecnopro = tecnopro;
	}

	public String getCodpro() {
		return codpro;
	}
	public void setCodpro(String codpro) {
		this.codpro = codpro;
	}
	public String getNomepro() {
		return nomepro;
	}
	public void setNomepro(String nomepro) {
		this.nomepro = nomepro;
	}
	public String getDescripro() {
		return descripro;
	}
	public void setDescripro(String descripro) {
		this.descripro = descripro;
	}
	public String getMercapro() {
		return mercapro;
	}
	public void setMercapro(String mercapro) {
		this.mercapro = mercapro;
	}
	public String getTecnopro() {
		return tecnopro;
	}
	public void setTecnopro(String tecnopro) {
		this.tecnopro = tecnopro;
	}

//	@Override
//	public String toString() {
//		return "JavaBeans [codpro=" + codpro + ", nomepro=" + nomepro + ", descripro=" + descripro + ", mercapro="
//				+ mercapro + ", tecnopro=" + tecnopro + "]";
//	}
//	
	

}
