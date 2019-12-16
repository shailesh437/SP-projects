package sp.designpatterns.DecoratorExample;

public class CheeseLayer extends ToppingLayer {
	Pizza pizza;

	CheeseLayer(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ",Cheesy";
	}

	@Override
	public double getCost() {
		return pizza.getCost() + 18;
	}

}
