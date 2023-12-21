package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
	private List<Edge> edges = new ArrayList<Edge>();
	
	public Path(List<Edge> edges) {
		this.edges = edges;
	}
	
	public double getLength() {
		double length = 0.0;
		for(Edge edge : edges) {
			length += edge.getGeometry().getLength();
		}
		return length;
	}

	public List<Edge> getEdges() {
		return edges;
	}


	public Edge get(int i) {
		return this.edges.get(i);
	}

	public Object size() {
		return this.edges.size();
	}
	
}
