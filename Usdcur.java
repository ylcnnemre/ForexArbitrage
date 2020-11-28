package arbitrage;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Usdcur {
    String isim;
	double fiyat;
	static String usdurl="https://api.exchangeratesapi.io/latest?base=USD";
	static double[] dizi=new double[5];
	
	static HttpURLConnection baglanti;
	public  double[] oku()
	{
	
		BufferedReader as;
		String line;
		StringBuffer stringb=new StringBuffer();
		try {
			URL url=new URL(usdurl);
			baglanti=(HttpURLConnection) url.openConnection();
			baglanti.setRequestMethod("GET");
			baglanti.setConnectTimeout(10000);
			baglanti.setReadTimeout(10000);
			
			int status=baglanti.getResponseCode();
			
			if(status>200)
			{
				as=new BufferedReader(new InputStreamReader(baglanti.getErrorStream()));
				while((line=as.readLine())!=null)
				{
					stringb.append(line);
				}
				as.close();
			}
			else {
				as=new BufferedReader(new InputStreamReader(baglanti.getInputStream()));
				while((line=as.readLine())!=null)
				{
					stringb.append(line);
				}
				as.close();
			}
			
				String metin=stringb.toString();
				JSONParser em=new JSONParser();
			
					JSONObject nesne=(JSONObject)em.parse(metin);
					JSONObject nesne2=(JSONObject) nesne.get("rates");
					
					Double usd=Double.valueOf(nesne2.get("USD").toString());
					dizi[0]=usd;
					//usddizi[0].fiyat=usd;
					//usddizi[0].isim="USD";
					
					Double eur=Double.valueOf(nesne2.get("EUR").toString());
					dizi[1]=eur;
					
					
					Double gbp=Double.valueOf(nesne2.get("GBP").toString());
					dizi[2]=gbp;
					
					
					Double chf=Double.valueOf(nesne2.get("CHF").toString());
					dizi[3]=chf;
					
					
					Double cad=Double.valueOf(nesne2.get("CAD").toString());
					dizi[4]=cad;
				
					
					return Formatclass.format(dizi);
			
		}
		catch(Exception e)
                {
                    e.printStackTrace();
                }
		finally {
			baglanti.disconnect();
		}
		return dizi;
		
	}
	public  String  date()
	{
		
		BufferedReader as;
		String line;
		String tarih="";
		StringBuffer stringb=new StringBuffer();
		try {
			URL url=new URL(usdurl);
			baglanti=(HttpURLConnection) url.openConnection();
			baglanti.setRequestMethod("GET");
			baglanti.setConnectTimeout(10000);
			baglanti.setReadTimeout(10000);
			
			int status=baglanti.getResponseCode();
			
			if(status>200)
			{
				as=new BufferedReader(new InputStreamReader(baglanti.getErrorStream()));
				while((line=as.readLine())!=null)
				{
					stringb.append(line);
				}
				as.close();
			}
			else {
				as=new BufferedReader(new InputStreamReader(baglanti.getInputStream()));
				while((line=as.readLine())!=null)
				{
					stringb.append(line);
				}
				as.close();
			}
			
				String metin=stringb.toString();
				JSONParser em=new JSONParser();
					
					JSONObject nesne=(JSONObject)em.parse(metin);
					tarih=nesne.get("date").toString();
					
		}
		catch(Exception e)
                {
                    e.printStackTrace();
                }
		
		finally {
			baglanti.disconnect();
		}
		return tarih;
		
	}
}
