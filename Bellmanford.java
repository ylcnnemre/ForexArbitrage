package arbitrage;



import java.util.ArrayList;
import java.util.List;

public class Bellmanford {
         private List<Vertex> vertexliste;
	private List<Edge> edgelist;
	private List<Vertex> cyclelist;
	
	public Bellmanford(List<Vertex> vertexlist,List<Edge> edgelist) {
		this.vertexliste=vertexlist;
		this.edgelist=edgelist;
		this.cyclelist=new ArrayList<>();
	}
	public void mybelmann(Vertex sourcevertex)
	{
		sourcevertex.setMindinstance(0);
		
		for(Vertex vertex:vertexliste)
		{
			for(Edge edge:edgelist)
			{
				if(edge.getStartvertex().getMindinstance()==Integer.MAX_VALUE)
				{
					continue;
				}
				
				double newdistance=edge.getStartvertex().getMindinstance()+edge.getWeight();
				
				if(newdistance<edge.getTargetvertex().getMindinstance())
				{
					edge.getTargetvertex().setMindinstance(newdistance);
					edge.getTargetvertex().setPreviousvertex(edge.getStartvertex());
				}
			}
		}
		int knt=0;
		for(Edge edge:edgelist)
		{
			if(edge.getStartvertex().getMindinstance()!=Integer.MAX_VALUE)
			{
				if(degerhesapla(edge))
				{
					Vertex vertex=edge.getStartvertex();
					while(!vertex.equals(edge.getTargetvertex()))
					{
						
						this.cyclelist.add(vertex);
						vertex=vertex.getPreviousvertex();
						
						
					}
					this.cyclelist.add(edge.getTargetvertex());
					
					return ;
				}
			}
		}
	}
	
	public boolean degerhesapla(Edge edge)
	{
		return edge.getTargetvertex().getMindinstance() > edge.getStartvertex().getMindinstance()+edge.getWeight();
	}
	public ArrayList<String> yazdir()
	{
            ArrayList<String> liste=new ArrayList<String>();
		if(this.cyclelist!=null)
		{
			for(Vertex vertex:this.cyclelist)
			{
				System.out.println(vertex);
                                liste.add(vertex.toString());
			}
			
		}
		else {
			liste.add("arbitraj yok");
		}
                return liste;
	}
}
