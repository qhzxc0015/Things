package cn.guet2309.entity;

public class TourInformation {
	private String infoAutoID;
	public TourInformation() {
		super();
	}
	public TourInformation(String infoAutoID, String infoName,
			String infoIntro, String infoAddress, String infoTel,
			String infoKeyWord, String infoDPContent, String productName) {
		super();
		this.infoAutoID = infoAutoID;
		this.infoName = infoName;
		this.infoIntro = infoIntro;
		this.infoAddress = infoAddress;
		this.infoTel = infoTel;
		this.infoKeyWord = infoKeyWord;
		this.infoDPContent = infoDPContent;
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "TourInformation [infoAutoID=" + infoAutoID + ", infoName="
				+ infoName + ", infoIntro=" + infoIntro + ", infoAddress="
				+ infoAddress + ", infoTel=" + infoTel + ", infoKeyWord="
				+ infoKeyWord + ", infoDPContent=" + infoDPContent
				+ ", productName=" + productName + "]";
	}
	public String getInfoAutoID() {
		return infoAutoID;
	}
	public void setInfoAutoID(String infoAutoID) {
		this.infoAutoID = infoAutoID;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getInfoIntro() {
		return infoIntro;
	}
	public void setInfoIntro(String infoIntro) {
		this.infoIntro = infoIntro;
	}
	public String getInfoAddress() {
		return infoAddress;
	}
	public void setInfoAddress(String infoAddress) {
		this.infoAddress = infoAddress;
	}
	public String getInfoTel() {
		return infoTel;
	}
	public void setInfoTel(String infoTel) {
		this.infoTel = infoTel;
	}
	public String getInfoKeyWord() {
		return infoKeyWord;
	}
	public void setInfoKeyWord(String infoKeyWord) {
		this.infoKeyWord = infoKeyWord;
	}
	public String getInfoDPContent() {
		return infoDPContent;
	}
	public void setInfoDPContent(String infoDPContent) {
		this.infoDPContent = infoDPContent;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	private String infoName;
	private String infoIntro;
	private String infoAddress;
	private String infoTel;
	private String infoKeyWord;
	private String infoDPContent;
	private String productName;
}
