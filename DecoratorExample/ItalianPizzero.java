package sp.designpatterns.DecoratorExample;

public class ItalianPizzero extends Pizza{

	ItalianPizzero(String description){
		this.description=description;
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 70;
	}

}
