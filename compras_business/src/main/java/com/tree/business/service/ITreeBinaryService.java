package com.tree.business.service;

import com.tree.domain.model.Arbol;
import com.tree.domain.model.Nodo;

/**
 * 
 * IUserService
 */
public interface ITreeBinaryService{
	

	
	Arbol getTreeForkey(Integer id);
	
	int getMaxIdArbol();

	boolean createTreeInCache(Arbol arbol);

	boolean addNodoToTree(Nodo nodo, Integer idArbol);
	
	void updateArbol(Arbol arbol);
	
	
	
}
