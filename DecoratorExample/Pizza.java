package sp.designpatterns.DecoratorExample;

public abstract class Pizza {
	protected String description=null;
	
	public String getDescription() {
		return description;
	}
	
	public abstract double getCost();
}
