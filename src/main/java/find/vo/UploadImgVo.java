package find.vo;

public class UploadImgVo {

	private long iNum;
	private long lostNum;
	private long findNum;
	private String originalFile;
	private String originalFileExtension;
	private String storedFileName;
	
	public UploadImgVo() {}
	
	public UploadImgVo(long lostNum, long findNum, String originalFile, String originalFileExtension,
			String storedFileName) {
		this.lostNum = lostNum;
		this.findNum = findNum;
		this.originalFile = originalFile;
		this.originalFileExtension = originalFileExtension;
		this.storedFileName = storedFileName;
	}

	public long getiNum() {
		return iNum;
	}

	public void setiNum(long iNum) {
		this.iNum = iNum;
	}

	public long getLostNum() {
		return lostNum;
	}

	public void setLostNum(long lostNum) {
		this.lostNum = lostNum;
	}

	public long getFindNum() {
		return findNum;
	}

	public void setFindNum(long findNum) {
		this.findNum = findNum;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getOriginalFileExtension() {
		return originalFileExtension;
	}

	public void setOriginalFileExtension(String originalFileExtension) {
		this.originalFileExtension = originalFileExtension;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

}
