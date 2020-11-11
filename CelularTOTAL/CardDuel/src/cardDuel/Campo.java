package cardDuel;

public class Campo {
		private int Jogadores;

		public Campo(int jogadores) {
			super();
			Jogadores = jogadores;
		}
		
		private int CompararCartas(Carta jogadores[],int numJogadores,int atributo)
		{
			int maior =0;
			int vencedor = 0;
				if (atributo == 1)
				{
					for(int i =0;i< numJogadores;i++)
					{
					if(maior < jogadores[i].getAtaque())
					{
						maior = jogadores[i].getAtaque();
					vencedor = i;
					}
				}
			}
				else if (atributo == 2)
				{
					for(int i =0;i< numJogadores;i++)
					{
					if(maior < jogadores[i].getDefesa())
					{
						maior = jogadores[i].getDefesa();
					vencedor = i;
					}
				}
			}
				else if (atributo == 3)
				{
					for(int i =0;i< numJogadores;i++)
					{
					if(maior < jogadores[i].getMagia())
					{
						maior = jogadores[i].getMagia();
					vencedor = i;
					}
				}
			}
				else if (atributo == 4)
				{
					for(int i =0;i< numJogadores;i++)
					{
					if(maior < jogadores[i].getDefesaMagia())
					{
					maior = jogadores[i].getDefesa();
					vencedor = i;
					}
				}
			}
				else if (atributo == 5)
				{
					for(int i =0;i< numJogadores;i++)
					{
					if(maior < jogadores[i].getVelocidade())
					{
					maior = jogadores[i].getVelocidade();
					vencedor = i;
					}
				}
			}
				return vencedor;
		}

		
}
