package dn.doannam.gridview2;

public class HinhAnh {
    private String Ten;
    private  int Hinh;

    public HinhAnh(String ten, int hinh) {
        Ten = ten;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
