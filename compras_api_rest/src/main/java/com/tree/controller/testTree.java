package com.tree.controller;

import com.tree.domain.model.Arbol;
import com.tree.domain.model.Nodo;

public class testTree {

	public static void main(String[] args) {
		
		Arbol arbol = new Arbol();
		
		arbol.addNodo(new Nodo(8));
		arbol.addNodo(new Nodo(3));
		arbol.addNodo(new Nodo(6));
		arbol.addNodo(new Nodo(10));
		arbol.addNodo(new Nodo(4));
		arbol.addNodo(new Nodo(7));
		arbol.addNodo(new Nodo(1));
		arbol.addNodo(new Nodo(14));
		arbol.addNodo(new Nodo(18));	
		
		
		arbol.imprimirInOrder(arbol.getRaiz());
		
		 System.out.print("Valor mayor: "+arbol.getValorMaximo(arbol.getRaiz()));

	}

}
