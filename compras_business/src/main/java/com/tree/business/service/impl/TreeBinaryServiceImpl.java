package com.tree.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tree.business.service.ITreeBinaryService;
import com.tree.commons.util.ConfigProperties;
import com.tree.domain.cache.CacheArboles;
import com.tree.domain.model.Arbol;
import com.tree.domain.model.Nodo;


/**
 * implementación del servicio {@link ITreeBinaryService} para el menejo de lógica de los Arboles Binarios. 
 * 
 * @author 	MHernandez <br>
 * @date 22/09/2018
 * @version 1.0
 */

@Service
public class TreeBinaryServiceImpl implements ITreeBinaryService {
	
	@Autowired
	private CacheArboles cacheArboles;

	@Override
	public Arbol getTreeForkey(Integer id) {
		
		return cacheArboles.getArbolForKey(id);
	}

	@Override
	public boolean addNodoToTree(Nodo nodo, Integer idArbol) {
		
		Arbol arbol = cacheArboles.getArbolForKey(idArbol);
		
		if(arbol != null) {
			arbol.addNodo(nodo);			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean createTreeInCache(Arbol arbol) {		
		
		return cacheArboles.insertarArbol(arbol);
	}


	@Override
	public int getMaxIdArbol() {
		return cacheArboles.getMaxIdArboles();
	}

	@Override
	public void updateArbol(Arbol arbol) {
		
		cacheArboles.actualizarArbol(arbol);
		
	}
	
	
    
    
}
