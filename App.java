package arbitrage;


import java.util.ArrayList;
import java.util.List;


public class App {
    
    static ArrayList<String> calistir(double dizi[][])
	{
		List<Vertex> vertexlist=new ArrayList<>();
		vertexlist.add(new Vertex("USD"));
		vertexlist.add(new Vertex("EUR"));
		vertexlist.add(new Vertex("GBP"));
		vertexlist.add(new Vertex("CHF"));
		vertexlist.add(new Vertex("CAD"));

		
		
		List<Edge> edgelist=new ArrayList<>();
		edgelist.add(new Edge(vertexlist.get(0),vertexlist.get(1),-1*Math.log(dizi[0][1])));
		edgelist.add(new Edge(vertexlist.get(0),vertexlist.get(2),-1*Math.log(dizi[0][2])));
		edgelist.add(new Edge(vertexlist.get(0),vertexlist.get(3),-1*Math.log(dizi[0][3])));
		edgelist.add(new Edge(vertexlist.get(0),vertexlist.get(4),-1*Math.log(dizi[0][4])));
	
		
		edgelist.add(new Edge(vertexlist.get(1),vertexlist.get(0),-1*Math.log(dizi[1][0])));
		edgelist.add(new Edge(vertexlist.get(1),vertexlist.get(2),-1*Math.log(dizi[1][2])));
		edgelist.add(new Edge(vertexlist.get(1),vertexlist.get(3),-1*Math.log(dizi[1][3])));
		edgelist.add(new Edge(vertexlist.get(1),vertexlist.get(4),-1*Math.log(dizi[1][4])));
	
		
		edgelist.add(new Edge(vertexlist.get(2),vertexlist.get(0),-1*Math.log(dizi[2][0])));
		edgelist.add(new Edge(vertexlist.get(2),vertexlist.get(1),-1*Math.log(dizi[2][1])));
		edgelist.add(new Edge(vertexlist.get(2),vertexlist.get(3),-1*Math.log(dizi[2][3])));
		edgelist.add(new Edge(vertexlist.get(2),vertexlist.get(4),-1*Math.log(dizi[2][4])));
		
		
		edgelist.add(new Edge(vertexlist.get(3),vertexlist.get(0),-1*Math.log(dizi[3][0])));
		edgelist.add(new Edge(vertexlist.get(3),vertexlist.get(1),-1*Math.log(dizi[3][1])));
		edgelist.add(new Edge(vertexlist.get(3),vertexlist.get(2),-1*Math.log(dizi[3][2])));
		edgelist.add(new Edge(vertexlist.get(3),vertexlist.get(4),-1*Math.log(dizi[3][4])));
		

		edgelist.add(new Edge(vertexlist.get(4),vertexlist.get(0),-1*Math.log(dizi[4][0])));
		edgelist.add(new Edge(vertexlist.get(4),vertexlist.get(1),-1*Math.log(dizi[4][1])));
		edgelist.add(new Edge(vertexlist.get(4),vertexlist.get(2),-1*Math.log(dizi[4][2])));
		edgelist.add(new Edge(vertexlist.get(4),vertexlist.get(3),-1*Math.log(dizi[4][3])));
		
		
	
	
	
		
		
		Bellmanford belman=new Bellmanford(vertexlist, edgelist);
		belman.mybelmann(vertexlist.get(0));
		ArrayList<String> myliste=belman.yazdir();
		return myliste;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anaclass nesne=new Anaclass();
		double dizi[][]=nesne.yolla();
		calistir(dizi);
		
	}
    
}
