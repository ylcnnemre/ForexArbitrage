package arbitrage;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Gbpcur {
    static String usdurl="https://api.exchangeratesapi.io/latest?base=GBP";
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
}
