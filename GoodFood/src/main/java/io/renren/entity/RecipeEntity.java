package io.renren.entity;

public class RecipeEntity {

	
	
	//菜谱名字
	private String foodname;
	//准备时间
	private String preparationtime;
	//制作时间
	private String makingtime;
	//难易程度
	private String thedefficulty;
	//分享人数
	private Integer sharenumber;
	//制作人
	private String provider;
	//食品简介
	private String introduce;
	
	//原料名字
	private String materailname;
	//原料用量
	private String meterailnumber;
	
	//制作步骤
	private String foodstep;
	
	//图片存储路径
	private String imgfilepath;
	
	
	
	

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getPreparationtime() {
		return preparationtime;
	}

	public void setPreparationtime(String preparationtime) {
		this.preparationtime = preparationtime;
	}

	public String getMakingtime() {
		return makingtime;
	}

	public void setMakingtime(String makingtime) {
		this.makingtime = makingtime;
	}

	public String getThedefficulty() {
		return thedefficulty;
	}

	public void setThedefficulty(String thedefficulty) {
		this.thedefficulty = thedefficulty;
	}

	public Integer getSharenumber() {
		return sharenumber;
	}

	public void setSharenumber(Integer sharenumber) {
		this.sharenumber = sharenumber;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getMaterailname() {
		return materailname;
	}

	public void setMaterailname(String materailname) {
		this.materailname = materailname;
	}

	public String getMeterailnumber() {
		return meterailnumber;
	}

	public void setMeterailnumber(String meterailnumber) {
		this.meterailnumber = meterailnumber;
	}

	public String getFoodstep() {
		return foodstep;
	}

	public void setFoodstep(String foodstep) {
		this.foodstep = foodstep;
	}

	public String getImgfilepath() {
		return imgfilepath;
	}

	public void setImgfilepath(String imgfilepath) {
		this.imgfilepath = imgfilepath;
	}
	
	
	
}
