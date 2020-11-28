package arbitrage;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class Formatclass {
    static double[] format(double[] fiyat)
	{
		double yenidizi[]=new double[fiyat.length];
		
		for(int i=0;i<fiyat.length;i++)
		{
			BigDecimal bd = new BigDecimal(fiyat[i]).setScale(4, RoundingMode.HALF_UP);
			yenidizi[i]=bd.doubleValue();
		}
		return yenidizi ;
		
	}
    
}
