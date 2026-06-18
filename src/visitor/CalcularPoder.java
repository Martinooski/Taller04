package visitor;

import dominio.CartaEnergy;
import dominio.CartaItem;
import dominio.CartaPokemon;
import dominio.CartaSupporter;

public class CalcularPoder implements Visitor {

    @Override
    public double visit(CartaPokemon pokemon) {
    	
        if (pokemon.getCantEnergias() == 0) {
            return 0; 
        }
        // (daño / cantEnergias) * 100

        return ((double) pokemon.getDaño() / pokemon.getCantEnergias()) * 100;
    }

    @Override
    public double visit(CartaItem item) {
        // bonificacion * 20
        return item.getBonificacion() * 20;
    }

    @Override
    public double visit(CartaSupporter supporter) {
        // efectosPorTurno * 50
        return supporter.getEfectosPorTurno() * 50;
    }

    @Override
    public double visit(CartaEnergy energy) {
        // 1 
        return 1;
    }
}