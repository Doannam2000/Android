package dn.doannam.acotien;

public class InforNick {
    private String idNick;
    private String NickName;
    private String ImageId;
    private int Job;

    public InforNick(String idNick, String nickName, String imageId, int job) {
        this.idNick = idNick;
        NickName = nickName;
        ImageId = imageId;
        Job = job;
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
}