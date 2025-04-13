package Actividad_02;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class PythagorasTree extends JPanel {
	private int profundidad;
	
	public PythagorasTree(int profundidad) {
		this.profundidad = profundidad;
		setPreferredSize(new Dimension(800,800));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,0,getWidth(),getWidth());
		g2d.setColor(Color.GREEN);
		
		trazaArbol(g2d,400,600,100,-90, profundidad);
	}
	
	private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
		if (nivel == 0 || lado < 5) return;
		
		int x2 = x + (int)(lado*Math.cos(Math.toRadians(angulo)));
		int y2 = y + (int)(lado * Math.sin(Math.toRadians(angulo)));
		
		g.drawLine(x,y,x2,y2);
		
		int nuevoLado = (int)(lado * 0.8);
		trazaArbol(g,x2,y2, nuevoLado, angulo -45, nivel -1);
		trazaArbol(g,x2,y2, nuevoLado, angulo +45, nivel -1);
	}
	
	public static void main(String[] args) {
        JFrame frame6 = new JFrame("Árbol de Pitágoras - 6 Niveles");
        PythagorasTree tree6 = new PythagorasTree(3);
        frame6.add(tree6);
        frame6.setSize(800, 800);
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setVisible(true);
    }
}
