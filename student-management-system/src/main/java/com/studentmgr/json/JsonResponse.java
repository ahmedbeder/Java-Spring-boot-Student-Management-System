package com.studentmgr.json;

import com.fasterxml.jackson.annotation.JsonInclude;


public class JsonResponse {
    private boolean ok;
    private Object data;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;


    /**
     * @param data
     */
    public JsonResponse(Object data) {
    	this.data = data;
        ok = true;
    }
    
    /**
     * @param message
     */
    public JsonResponse(String message) {
    	this.message = message;
        ok = true;
    }
    
	/**
	 * @param data
	 * @param message
	 */
	public JsonResponse(Object data, String message) {
    	this.data = data;
    	this.message = message;
        ok = true;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
