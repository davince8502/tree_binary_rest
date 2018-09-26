package com.tree.domain.cache;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tree.domain.model.Arbol;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CacheArboles {
	
	private  List<Arbol> arboles = new ArrayList<>();
	
		
	public boolean insertarArbol(Arbol arbol) {
		if(arbol == null || null == arbol.getIdentificador()){
			return false;
		}
		
		if(arboles.stream().anyMatch(a -> a.getIdentificador()== arbol.getIdentificador())) {
			return false;
		}
		
		arboles.add(arbol);
			
		
		return true;
	}
	
	
	
	public Arbol getArbolForKey(Integer key) {
		
		Optional<Arbol> opt = arboles.stream().filter(a -> a.getIdentificador()== key).findFirst();
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		return null;
		
	}
	
	
	
	public int getMaxIdArboles() {
		return this.arboles.size();
	}

	
	public void actualizarArbol(Arbol arbol) {
		
		arboles.set(arbol.getIdentificador() -1, arbol);
		
	}

}
