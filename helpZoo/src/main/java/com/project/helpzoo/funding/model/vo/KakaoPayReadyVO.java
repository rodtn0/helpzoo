package com.project.helpzoo.funding.model.vo;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.JsonAdapter;





public class KakaoPayReadyVO {
    
    //response
	@JsonProperty
    private String tid, next_redirect_pc_url;
	@JsonProperty
    private Date created_at;
    
   
    
    
    public KakaoPayReadyVO() {
    	
    }
    
    
    
    
    
    
    
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
	@Override
	public String toString() {
		return "KakaoPayReadyVO [tid=" + tid + ", next_redirect_pc_url=" + next_redirect_pc_url + ", created_at="
				+ created_at + "]";
	}







	public Date getCreated_at() {
		return created_at;
	}







	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}







	public KakaoPayReadyVO(String tid, String next_redirect_pc_url, Date created_at) {
		super();
		this.tid = tid;
		this.next_redirect_pc_url = next_redirect_pc_url;
		this.created_at = created_at;
	}







	





    
    
    
    
    
    
    
    
    
    
    
    
}