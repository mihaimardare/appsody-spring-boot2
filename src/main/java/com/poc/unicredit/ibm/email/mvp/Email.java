package com.poc.unicredit.ibm.email.mvp;


public class Email {
    // toAddress: []
    // toCCAddress: []
    // from: []
    // title: ‘’ 
    // messageBody: ‘’

    private String ToAddress;

    private String ToCCAddress;

    private String From;

    private String Title;

    private String MessageBody;

    public Email() {
    }

    public Email(String toAddress, String toCCAddress, String fromAddress, String title, String messageBody) {
        this.ToAddress = toAddress;
        this.ToCCAddress = toCCAddress;
        this.From = fromAddress;
        this.Title = title;
        this.MessageBody = messageBody;
    }
    

    public String getToAddress() {
        return this.ToAddress;
      }
    
    public void setToAddress(String toAddress) {
        this.ToAddress = toAddress;
    }

    public String getToCCAddress() {
        return this.ToCCAddress;
    }
    
    public void setToCCAddress(String toCCAddress) {
        this.ToCCAddress = toCCAddress;
    }

    public String getFrom() {
        return this.From;
    }
    
    public void setFrom(String fromAddress) {
        this.From = fromAddress;
    }

    public String getTitle() {
        return this.Title;
    }
    
    public void setTitle(String title) {
        this.Title = title;
    }

    public String getMessageBody() {
        return this.MessageBody;
    }
    
    public void setMessageBody(String messageBody) {
        this.MessageBody = messageBody;
    }
}