package visitor;

import dominio.CartaEnergy;
import dominio.CartaItem;
import dominio.CartaPokemon;
import dominio.CartaSupporter;

public interface Visitor {
	
    double visit(CartaPokemon pokemon);
    
    double visit(CartaItem item);
    
    double visit(CartaSupporter supporter);
    
    double visit(CartaEnergy energy);
    
}