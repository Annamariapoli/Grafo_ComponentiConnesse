package application;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

public class Grafo {

	private DirectedGraph<Integer, DefaultEdge> grafo ;
	
	public void buildGraph(){
		grafo = new SimpleDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);
		for(int i =1 ; i<11; i++){
			grafo.addVertex(i);
		}
		grafo.addEdge(1,  2);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 1);
		
		grafo.addEdge(4,  5);
		grafo.addEdge(5, 6);
		grafo.addEdge(6, 4);
		
		grafo.addEdge(7, 8);
		grafo.addEdge(8, 9);
		grafo.addEdge(9, 7);
		grafo.addEdge(7, 10);
		
		System.out.println(grafo.toString());
	}
	
	
	 //per trovare tutti i nodi raggiungibili da start:
	
	public List<Integer> getVisitaGrafo(Integer start){
		List<Integer> cammino = new LinkedList<>();
		BreadthFirstIterator <Integer, DefaultEdge> visita = new BreadthFirstIterator <Integer, DefaultEdge>(grafo, start);
		while(visita.hasNext()){
			Integer i = visita.next();
			cammino.add(i);
		}
		System.out.println(cammino);
		return cammino;
	}
	


	
	//conto quanti nodi si possono raggiungere da start (start incluso):
	
	public int  getContoNodiRaggiungibili(Integer start){   
		List<Integer> all= new LinkedList<>();
		BreadthFirstIterator<Integer, DefaultEdge> vb = new BreadthFirstIterator<Integer, DefaultEdge>(grafo, start);
		while(vb.hasNext()){
			Integer i = vb.next();
			all.add(i);
		}
		System.out.println(all.size());
		return all.size();
		
	}
	
	
	
	//conto il numero di vertici nel grafo
	
	public int getNumeroVertici(){             
		int numV= grafo.vertexSet().size();
		System.out.println(numV);
		return numV;
	}
	
	
	 //per verificare se il grafo è connesso
	//conto il numero di componenti connesse
   //se il numero è 1 allora è connesso
	
	public Integer getComponentiConnesse(){
		Integer numComp=0;
		List<Integer> vertici = new LinkedList<>();   //creo una lista nella quale mettere tutti i vertici del grafo
		vertici.addAll(grafo.vertexSet());
		while(!vertici.isEmpty()){               //fino a quando la lista di vertici non è vuota
			                                    //fai una visita per ogni vertice
			BreadthFirstIterator<Integer, DefaultEdge> visita = new BreadthFirstIterator<Integer, DefaultEdge>(grafo, vertici.get(0));
			
		}
		return numComp;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args){
		Grafo g = new Grafo();
		g.buildGraph();
	}
}
