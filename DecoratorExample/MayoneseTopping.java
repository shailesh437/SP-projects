package sp.designpatterns.DecoratorExample;

public class MayoneseTopping extends ToppingLayer {
	Pizza pizza;

	MayoneseTopping(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ",Mayonese";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost() + 19;
	}

}
