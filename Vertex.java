package arbitrage;



import java.util.ArrayList;
import java.util.List;


public class Vertex {
    
    private String id;
	private boolean visited;
	private double mindinstance=Integer.MAX_VALUE;
	private Vertex previousvertex;
	private List<Edge> adkenci;
	
	public Vertex(String id) {
		this.id=id;
		this.adkenci=new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public double getMindinstance() {
		return mindinstance;
	}

	public void setMindinstance(double mindinstance) {
		this.mindinstance = mindinstance;
	}

	public Vertex getPreviousvertex() {
		return previousvertex;
	}

	public void setPreviousvertex(Vertex previousvertex) {
		this.previousvertex = previousvertex;
	}

	public List<Edge> getAdkenci() {
		return adkenci;
	}

	public void setAdkenci(List<Edge> adkenci) {
		this.adkenci = adkenci;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.id;
	}

    
    
    
}
