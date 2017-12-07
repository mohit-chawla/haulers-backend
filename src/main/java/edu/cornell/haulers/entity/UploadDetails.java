package edu.cornell.haulers.entity;


public class UploadDetails {
	public UploadDetails(){}
	 
    public UploadDetails(String key, String url) {
       this.key = key;
       this.url = url;
    }

    
    
    private String key;
    private String url;
    
    
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
}
