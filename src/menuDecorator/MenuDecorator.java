package menuDecorator;
import menu.Menu;
import menu.State;
public class MenuDecorator implements State{
    private State s;
    protected MenuDecorator(State s){
        this.s = s;
    }
    @Override
    public void changeMenu(Menu menu){
        s.changeMenu(menu);
    }
}
