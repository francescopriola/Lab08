package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private SimpleWeightedGraph<Airport, DefaultWeightedEdge> graph;
	private ExtFlightDelaysDAO dao;
	
	public SimpleWeightedGraph<Airport, DefaultWeightedEdge> creaGrafo(int distMin) {
		this.graph = new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		dao = new ExtFlightDelaysDAO();
		
		List<Airport> aeroporti = dao.loadAllAirports(); 
		Graphs.addAllVertices(this.graph, aeroporti);
		
		List<CoppiaID> voliOk = new ArrayList<CoppiaID>();
		List<CoppiaID> voliEsistenti = dao.loadFlightDistance();
		
		for(CoppiaID v : voliEsistenti) {
			if(v.getMedia() > distMin)
				voliOk.add(v);
		}
		
		for(CoppiaID v1 : voliOk) {
			for(CoppiaID v2 : voliOk) {
				if(v1.getIdArrivo() == v2.getIdPartenza() &&  v1.getIdPartenza() == v2.getIdArrivo())
					Graphs.addEdge(graph, aeroporti.get(v1.getIdPartenza()), aeroporti.get(v1.getIdArrivo()), (v1.getMedia()+v2.getMedia())/2);
				else
					Graphs.addEdge(graph, aeroporti.get(v1.getIdPartenza()), aeroporti.get(v1.getIdArrivo()), v1.getMedia());
			}
		}
		
//		System.out.println("Vertici: " + graph.vertexSet().size());
//		System.out.println("Archi: " + graph.edgeSet().size());
//		
//		for(DefaultWeightedEdge d : this.graph.edgeSet())
//			System.out.println(d + " " + this.graph.getEdgeWeight(d));
		
		return graph;
 	}
	
//	public List<CoppiaID> voli(int distMin){
//		this.creaGrafo(distMin);
//		List<CoppiaID> 
//	}
}
