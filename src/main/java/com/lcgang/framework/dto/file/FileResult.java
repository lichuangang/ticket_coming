package com.lcgang.framework.dto.file;

public class FileResult {
    private String fileName;
    private String orgName;
    private String url;

    public FileResult() {
    }

    public FileResult(String fileName) {
        this.fileName = fileName;
    }

    public FileResult(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
    }

    public FileResult(String fileName, String orgName, String url) {
        this.fileName = fileName;
        this.orgName = orgName;
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
