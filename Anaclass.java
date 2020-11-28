package arbitrage;



import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Anaclass {
    public double [][] yolla()
	{
		double[][] fiyatlar=new double[5][5];
		
		
		Usdcur usd=new Usdcur();
		fiyatlar[0]=usd.oku();
		Eurcur eur=new Eurcur();
		fiyatlar[1]=eur.oku();
		Gbpcur gbp=new Gbpcur();
		fiyatlar[2]=gbp.oku();
		Chfcur chf=new Chfcur();
		fiyatlar[3]=chf.oku();
		Cadcur cad=new Cadcur();
        try {
            fiyatlar[4]=cad.oku();
        } catch (IOException ex) {
            Logger.getLogger(Anaclass.class.getName()).log(Level.SEVERE, null, ex);
        }

		
		
		
		return fiyatlar;
		
	}
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
                double[][] fiyatlar=new double[5][5];
		
		Usdcur usd=new Usdcur();
		fiyatlar[0]=usd.oku();
		Eurcur eur=new Eurcur();
		fiyatlar[1]=eur.oku();
		Gbpcur gbp=new Gbpcur();
		fiyatlar[2]=gbp.oku();
		Chfcur chf=new Chfcur();
		fiyatlar[3]=chf.oku();
		Cadcur cad=new Cadcur();
        try {
            fiyatlar[4]=cad.oku();
        } catch (IOException ex) {
            Logger.getLogger(Anaclass.class.getName()).log(Level.SEVERE, null, ex);
        }
		/*Nzdcur nzd=new Nzdcur();
		fiyatlar[5]=nzd.oku();
		Trycur tl=new Trycur();
		fiyatlar[6]=tl.oku();
		*/
		for (double[] ds : fiyatlar) {
			for (double a : ds) {
				System.out.println(a);
			}
			System.out.println("\n");
		}
	}
    
}
