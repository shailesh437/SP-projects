package sp.designpatterns.DecoratorExample;

public class JapanesePizzo extends Pizza{
	
	JapanesePizzo(String description){
		this.description=description;
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 67;
	}

}
