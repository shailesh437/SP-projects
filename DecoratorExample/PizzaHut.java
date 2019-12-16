package sp.designpatterns.DecoratorExample;

public class PizzaHut {
	public static void main(String[] args) {
		 //We are in PizzaHut and have ordered Japanese Pizza with double mayo tops
		Pizza pizza = new JapanesePizzo("Japanese-Hoshimushi");
		MayoneseTopping mayoTop = new MayoneseTopping(pizza);
		MayoneseTopping mayoDoubleTop = new MayoneseTopping(mayoTop);
		System.out.println("[Japanese-Hoshimushi]" + mayoDoubleTop.getDescription() + "::" + mayoDoubleTop.getCost());
		
		
		//Now lets order ItalianPizza with tripple cheese Layer
		ItalianPizzero pizzaI = new ItalianPizzero("Rome-Taste-Pizzeria");
		CheeseLayer cl1 = new CheeseLayer(pizzaI);
		CheeseLayer cl2 = new CheeseLayer(cl1);
		CheeseLayer cl3 = new CheeseLayer(cl2);
		
		System.out.println("[Italian-Pizzeria]"+cl3.getDescription()+"::"+cl3.getCost());
		
		
		
	}

}
