package menuDecorator;
import menu.Menu;
import menu.State;
public class TitleMenuDecorator extends MenuDecorator{
    public TitleMenuDecorator(State s){
        super(s);
    }
    @Override
    public void changeMenu(Menu menu){
        System.out.println(">>>>>>Library System<<<<<<");
        super.changeMenu(menu);
        System.out.println(">>>>>>>>>>>>><<<<<<<<<<<<<");
        System.out.println();
    }
}
