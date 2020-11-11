package park.pacote;

/*    
 * A* algorithm implementation.
 * Copyright (C) 2007, 2009 Giuseppe Scrivano <gscrivano@gnu.org>

 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License along
 * with this program; if not, see <http://www.gnu.org/licenses/>.
 */

import java.util.*;

public class PathFinder extends AStar<PathFinder.Node> {
	private int[][] map;
	// private int[][] map2; // map2 nao sei qual a finalidade deste mapa
	private int f;
	private int p;
	private int t;
	private int i;
	private int d;
	private int e;
	private int in;
	private int fi;
	private int xFinal = 0;
	private int yFinal = 0;
	private PathFinder pf;

	public int getxFinal() {
		return xFinal;
	}

	public int getyFinal() {
		return yFinal;
	}

	public void setyFinal(int yFinal) {
		this.yFinal = yFinal;
	}

	public void setxFinal(int xFinal) {
		this.xFinal = xFinal;
	}

	public static class Node {
		public int x;
		public int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + x + ", " + y + ") ";
		}
	}

	public PathFinder(int[][] map) {
		this.map = map;
	}

	protected boolean isGoal(Node node) {

		// return (node.x==17) && (node.y ==13);
		return (node.x == map[0].length - 1) && (node.y == map.length - 1);
	}

	protected Double g(Node from, Node to) {

		if (from.x == to.x && from.y == to.y)
			return 0.0;
		if (map[to.y][to.x] == 2)
			return 2.0;

		if (map[to.y][to.x] == 3)
			return 3.0;

		if (map[to.y][to.x] == 11)
			return 11.0;

		if (map[to.y][to.x] == 10)
			return 10.0;

		if (map[to.y][to.x] == 50)
			return 50.0;

		if (map[to.y][to.x] == 8)
			return 8.0;

		return Double.MAX_VALUE;
	}

	protected Double h(Node from, Node to) {
		/* Use the Manhattan distance heuristic. */
		return new Double(Math.abs(map[0].length - 1 - to.x)
				+ Math.abs(map.length - 1 - to.y));
	}

	// gera os proximos caminhos do codigo, como o codigo estava para comparar
	// por 1 ele nao encontrava o proximo passo
	protected List<Node> generateSuccessors(Node node) {
		List<Node> ret = new LinkedList<Node>();
		int x = node.x;
		int y = node.y;

		// procura por pista
		if (y < map.length - 1 && map[y + 1][x] == 2)
			ret.add(new Node(x, y + 1));
		// procura por estacionamento
		if (y < map.length - 1 && map[y + 1][x] == 4)
			ret.add(new Node(x, y + 1));
		// procura por pista
		if (x < map[0].length - 1 && map[y][x + 1] == 2)
			ret.add(new Node(x + 1, y));

		// procura por estacionamento
		if (x < map[0].length - 1 && map[y][x + 1] == 4)
			ret.add(new Node(x + 1, y));

		if (x < map[0].length - 1 && map[y][x + 1] == 1)
			ret.add(new Node(x + 1, y));

		if (y < map.length - 1 && map[y + 1][x] == 1)
			ret.add(new Node(x, y + 1));

		return ret;
	}

	public void verificarCaminhoPessoaNaoEspecial(boolean deficiente) {
		// CONFERIR AQUI

		if (deficiente == false) {
			// pista
			p = 2;
			// faixa
			f = 11;
			// estacionamento
			e = 4;
			// travessia de pedestres
			t = 2;
			// impossivel
			i = 10;
			// deficiente
			d = 50;
			// inicio
			in = 0;
			// final
			fi = 1;

		} else {
			// pista
			p = 2;
			// faixa
			f = 11;
			// estacionamento
			e = 6;
			// travessia de pedestres
			t = 2;
			// impossivel
			i = 10;
			// deficiente
			d = 4;
			// inicio
			in = 0;
			// final
			fi = 1;
		}
	}

	public String RetornarMatriz() {

		String mapa = "";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				mapa = mapa + map[i][j] + " ";
			System.out.println(mapa = mapa + "\n");
		}
		return mapa;

	}

	public void troca(int vaix, int vaiy, boolean deficiente) {
		map[xFinal][yFinal] = e;
		map[vaix][vaiy] = fi;
		xFinal = vaix;
		yFinal = vaiy;
	}

	public int[][] Criar(boolean deficiente, int cont) {

		verificarCaminhoPessoaNaoEspecial(deficiente);
		if (cont == 0) {
			map = new int[][] {
					{ i, i, f, e, f, e, f, e, f, e, f, e, f, e, f, e, f, e, i, i },
					{ i, i, f, e, f, e, f, e, f, e, f, e, f, e, f, e, f, e, i, i },
					{ f, f, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, f, f },
					{ e, e, p, i, i, f, i, i, f, i, i, f, i, i, f, e, e, p, i, i },
					{ f, f, p, f, f, f, f, f, f, f, f, f, f, f, f, f, f, t, f, f },
					{ e, e, p, i, i, f, i, i, f, i, i, f, e, e, f, e, e, p, i, i },
					{ f, f, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, f, f },
					{ e, e, p, i, f, i, f, i, f, i, f, i, f, i, f, i, f, p, i, i },
					{ f, f, p, i, f, i, f, i, f, i, f, i, f, i, f, i, f, p, f, f },
					{ e, e, p, f, f, f, f, f, f, f, f, f, f, f, f, f, f, p, i, i },
					{ f, f, p, i, f, e, f, i, f, e, f, e, f, e, f, e, f, p, f, f },
					{ e, e, p, i, f, e, f, i, f, e, f, e, f, e, f, e, f, p, i, i },
					{ f, f, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, f, f },
					{ e, e, p, i, f, e, f, i, f, e, f, e, f, e, f, e, f, p, i, i },
					{ f, f, p, i, f, e, f, i, f, e, f, e, f, e, f, e, f, p, f, f },
					{ e, e, p, e, f, e, f, e, f, e, f, e, f, e, f, e, f, t, i, i },
					{ f, f, p, e, f, e, f, e, f, e, f, e, f, e, f,fi, f, p, f, f },
					{ e, e, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p },
					{ i, i, e, f, e, f, e, f, e, f, e, f, e, f, d, d, d, p, p, in },
					{ i, i, e, f, e, f, e, f, e, f, e, f, e, f, d, d, d, p, p, p }, };
		}

		pf = new PathFinder(map);

		System.out
				.println("Find a path from the top left corner to the right bottom one.");

		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map[0].length - 1; j++) {
				if (map[i][j] == fi) {
					xFinal = i;
					yFinal = j;
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		return CalcularCaminho(pf, xFinal, yFinal);
	}

	public int[][] CalcularCaminho(PathFinder pf, int xFinal, int yFinal) {
		long begin = System.currentTimeMillis();

		List<Node> nodes = pf.compute(new PathFinder.Node(0, 0),
				new PathFinder.Node(xFinal, yFinal));

		long end = System.currentTimeMillis();

		System.out.println("Time = " + (end - begin) + " ms");
		System.out.println("Expanded = " + pf.getExpandedCounter());
		System.out.println("Cost = " + pf.getCost());

		int caminho[][] = null;
		int cont = 0;
		int tamanhocaminho = 0;

		if (nodes == null)
			System.out.println("No path");
		else {
			for (Node n : nodes) {
				tamanhocaminho++;
			}
			caminho = new int[2][tamanhocaminho];
			for (Node n : nodes) {
				caminho[0][cont] = n.x;
				caminho[1][cont] = n.y;
				cont++;
			}
			System.out.println();
		}
		return caminho;
	}

	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public int getFi() {
		return fi;
	}

	public void setFi(int fi) {
		this.fi = fi;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getD() {
		return d;
	}

	public int getLocal(int x, int y) {

		return map[x][y];
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}
}