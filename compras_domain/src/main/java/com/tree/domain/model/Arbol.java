package com.tree.domain.model;

public class Arbol {
	
	/* Atributos */
    private Nodo raiz;
    
    private Integer identificador;
 
    /* Contructories */    
    
    public Arbol( ) {
        this.setRaiz(null);
    }
    
    public Arbol( int valor ) {
        this.setRaiz(new Nodo( valor ));
    }
    
    public Arbol( Nodo raiz ) {
        this.setRaiz(raiz);
    }

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	 
	 
	public void addNodo( Nodo nodo ) {
        this.addNodo( nodo , this.raiz );
    }
	
	
	private void addNodo( Nodo nodo, Nodo raiz ) {
       
        if ( raiz == null ) {          
            this.setRaiz(nodo);
        }
        else {          
            if ( nodo.getValor() <= raiz.getValor() ) {
               
                if (raiz.getHijoIzquierdo() == null) {
                    raiz.setHijoIzquierdo(nodo);
                }
                else {
                    addNodo( nodo , raiz.getHijoIzquierdo() );
                }
            }
            else {                
                if (raiz.getHijoDerecho() == null) {
                    raiz.setHijoDerecho(nodo);
                }
                else {
                    addNodo( nodo, raiz.getHijoDerecho() );
                }
            }
        }
    }
	
	
	  public void imprimirInOrder (Nodo nodo)
      {
          if (nodo != null)
          {    
        	  imprimirInOrder(nodo.getHijoIzquierdo());
              System.out.print(nodo.getValor() + " ");
              imprimirInOrder(nodo.getHijoDerecho());
          }
      }
	  
	  
	  public int getValorMaximo(Nodo nodo){
		  if(nodo == null ){
			  return -1;
			  
		  }
		  
		  while(nodo.getHijoDerecho() != null){
			  nodo = nodo.getHijoDerecho();
		  }
		  
		  return nodo.getValor();
	  }

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

}
