package dn.doannam.listviewpart2;

public class DongHo {
    private String Ten;
    private String Mota;
    private int Hinh;

    public DongHo(String ten, String mota, int hinh) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public String getMota() {
        return Mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
