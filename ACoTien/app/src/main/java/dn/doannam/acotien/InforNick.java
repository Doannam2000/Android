package dn.doannam.acotien;

public class InforNick {
    private String idNick;
    private String NickName;
    private String ImageId;
    private int Job;
    private String Cookie;
    private boolean check;
    private int slJob;

    public InforNick(String idNick, String nickName, String imageId, int job, String cookie, boolean check, int slJob) {
        this.idNick = idNick;
        NickName = nickName;
        ImageId = imageId;
        Job = job;
        Cookie = cookie;
        this.check = check;
        this.slJob = slJob;
    }

    public String getIdNick() {
        return idNick;
    }

    public void setIdNick(String idNick) {
        this.idNick = idNick;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getImageId() {
        return ImageId;
    }

    public void setImageId(String imageId) {
        ImageId = imageId;
    }

    public int getJob() {
        return Job;
    }

    public void setJob(int job) {
        Job = job;
    }

    public String getCookie() {
        return Cookie;
    }

    public void setCookie(String cookie) {
        Cookie = cookie;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getSlJob() {
        return slJob;
    }

    public void setSlJob(int slJob) {
        this.slJob = slJob;
    }
}