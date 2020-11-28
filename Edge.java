package arbitrage;





public class Edge {
    
   private double weight;
	private Vertex startvertex;
	private Vertex targetvertex;
	
	public Edge(Vertex startvertex,Vertex targetvertex,double weight) {
		this.weight=weight;
		this.startvertex=startvertex;
		this.targetvertex=targetvertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStartvertex() {
		return startvertex;
	}

	public void setStartvertex(Vertex startvertex) {
		this.startvertex = startvertex;
	}

	public Vertex getTargetvertex() {
		return targetvertex;
	}

	public void setTargetvertex(Vertex targetvertex) {
		this.targetvertex = targetvertex;
	}
    
    
    
}
