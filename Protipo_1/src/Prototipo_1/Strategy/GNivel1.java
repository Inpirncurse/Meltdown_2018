package Prototipo_1.Strategy;

public class GNivel1 implements GameNivel{

	private int sx;
	private int sy;
	private int wx;
	private int hy;
	
	public GNivel1 () {
		sx = 900;
		sy = 350;
		wx = 100;
		hy = 150;
	}

	
	@Override
	public boolean pasarLevel(int px, int py) {
		// TODO Auto-generated method stub
		if((px >sx && px<sx+wx)&&(py>sy && py<sy+hy)) {
			return true;
		}else {
			return false;
		}
	}


	@Override
	public boolean eliminarEnimigos(int i) {
		// TODO Auto-generated method stub
		if(i==3) {
			return true;	
		}else {
			return false;
		}
		
	}

}
