package pert6;

public class PersegiPanjang extends Shape implements hitLuas{

	public PersegiPanjang(int sisi, int sisi2) {
		super(sisi, sisi2);
	}

	@Override
	public int hitLuas(int sisi, int sisi2) {
		// TODO Auto-generated method stub
		return sisi*sisi2;
	}

	@Override
	public int hitLuas(int sisi) {
		// TODO Auto-generated method stub
		return 0;
	}

}
