package form;

import java.sql.Date;

public class RequestRecord {
    private int requestId;
    private String sUsn;
    private String sName;
    private String sBranch;
    private int sSem;
    private String resource;
    private String remarks;
    private String status;
    private Date requestDate;

    // Getters and setters for each property

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getSUsn() {
        return sUsn;
    }

    public void setSUsn(String sUsn) {
        this.sUsn = sUsn;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSBranch() {
        return sBranch;
    }

    public void setSBranch(String sBranch) {
        this.sBranch = sBranch;
    }

    public int getSSem() {
        return sSem;
    }

    public void setSSem(int sSem) {
        this.sSem = sSem;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "RequestRecord [requestId=" + requestId + ", sUsn=" + sUsn + ", sName=" + sName + ", sBranch=" + sBranch +
               ", sSem=" + sSem + ", resource=" + resource + ", remarks=" + remarks + ", status=" + status +
               ", requestDate=" + requestDate + "]";
    }
}
