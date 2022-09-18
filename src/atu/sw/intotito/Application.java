package atu.sw.intotito;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Paint;
import java.awt.Color;
import java.awt.geom.Path2D;


public class Application extends JFrame {
	static class Panel extends JPanel {
		private double cuspRatio = Math.PI / 10;
		private int majorRadius = 100;
		private int minorRadius = (int)(majorRadius * cuspRatio);
		private void drawStar(int points, float R, float r, Path2D.Double path, Graphics2D canvas) {
			double rotation = 2 * Math.PI / points;
			double angle = 0.5 * Math.PI;

			canvas.drawArc((int)R - 10, (int)R - 10, 20, 20, 0, 360);

			for (int i = 0; i < points; i++, angle += rotation) {
				if (i == 0)
					path.moveTo( (R + R * Math.cos(angle)), R -  (R * Math.sin(angle)));
				else
					path.lineTo( (R + R * Math.cos(angle)), R -  (R * Math.sin(angle)));

				path.lineTo( (R + r * Math.cos(angle + rotation / 2f)),
						R -  (r * Math.sin(angle + rotation / 2f)));
			}
			path.closePath();
			canvas.draw(path);
		}

		@Override
		public void paintComponent(Graphics gr) {
			Graphics2D g = (Graphics2D) gr;
			g.setColor(Color.RED);
			drawStar(5, majorRadius, minorRadius, new Path2D.Double(), g);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Application() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public Application(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Application(String title) throws HeadlessException {
		super(title);
		setContentPane(new Panel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public Application(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
