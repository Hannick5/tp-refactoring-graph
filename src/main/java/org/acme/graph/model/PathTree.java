package org.acme.graph.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acme.graph.routing.DijkstraPathFinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathTree {
	private Map<Vertex, PathNode> nodes = new HashMap<Vertex, PathNode>();
	private static final Logger log = LogManager.getLogger(DijkstraPathFinder.class);
	
	public PathTree(Graph graph, Vertex origin) {
		log.trace("initGraph({})", origin);
		for (Vertex vertex : graph.getVertices()) {
			PathNode pathNode = new PathNode();
			
			pathNode.setCost(origin == vertex ? 0.0 : Double.POSITIVE_INFINITY);
			pathNode.setReachingEdge(null);
			pathNode.setVisited(false);
			
			nodes.put(vertex, pathNode); 
		}
	}
	
	public List<Edge> getPath(Vertex destination) {
		List<Edge> result = new ArrayList<>();

		Edge current = this.getNode(destination).getReachingEdge();
		do {
			result.add(current);
			current = this.getNode(current.getSource()).getReachingEdge();
		} while (current != null);

		Collections.reverse(result);
		return result;
	}
	
	public PathNode getNode(Vertex vertex) {
		return this.nodes.get(vertex);
	}
	
	
}
