public class ler{
	String matriz[][] ;
	String jog ;
	String jog2;
	int teste= 0;
		if (matriz[0][1]== "X" || matriz[0][1]== "O")
		{
			if(matriz[0][0] == "X" && matriz[0][2] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[0][0] == "O" && matriz[0][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
		}
		if (matriz[1][1]== "X" || matriz[1][1]== "O")
		{
			if(matriz[1][0] == "X" && matriz[1][2] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[0][0] == "X" && matriz[2][2] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[0][2] == "X" && matriz[2][0] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[1][0] == "O" && matriz[1][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
			if(matriz[0][0] == "O" && matriz[2][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
			if(matriz[0][2] == "O" && matriz[2][0] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
		}
		if (matriz[2][1]== "X" || matriz[2][1]== "O")
		{
			if(matriz[2][0] == "X" && matriz[2][2] == "X")
			{
			System.out.println(jog + " Venceu");	
			teste++;
			}
			if(matriz[2][0] == "O" && matriz[2][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
		}
		if (matriz[1][0]== "X" || matriz[1][0]== "O")
		{
			if(matriz[0][0] == "X" && matriz[0][2] == "X")
			{
			System.out.println(jog + " Venceu");	
			teste++;
			}
			if(matriz[0][0] == "O" && matriz[0][2] == "O")
			{
			System.out.println(jog2 + " Venceu");	
			teste++;
			}
		}
		if (matriz[1][2]== "X" || matriz[1][2]== "O")
		{
			if(matriz[2][0] == "X" && matriz[2][2] == "X")
			{
			System.out.println(jog + " Venceu");	
			teste++;
			}
			if(matriz[2][0] == "O" && matriz[2][2] == "O")
			{
			System.out.println(jog2 + " Venceu");	
			teste++;
			}
		}
		if(teste == 1)
		{
			Printa(matriz);
			System.exit(0);
		}
	}