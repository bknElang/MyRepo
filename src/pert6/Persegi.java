package pert6;

public class Persegi extends Shape implements hitLuas{

	public Persegi(int sisi,int sisi2) {
		// TODO Auto-generated constructor stub
		super(sisi,sisi2);
	}

	@Override
	public int hitLuas(int sisi) {
		// TODO Auto-generated method stub
		return sisi*sisi;
	}

	@Override
	public int hitLuas(int sisi, int sisi2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
