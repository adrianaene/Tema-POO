package Liceu;

import java.util.ArrayList;

public interface IAdministrator extends IProfesor,ISecretar {
	public void addUtilizator(Utilizator u);
	public void delUtilizator(Utilizator u);
	public String listareUtilizatori();
}
