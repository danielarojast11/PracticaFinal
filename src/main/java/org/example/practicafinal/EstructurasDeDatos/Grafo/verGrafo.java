package org.example.practicafinal.EstructurasDeDatos.Grafo;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class verGrafo extends JPanel {
    private Map<String, String> grafo;

    public verGrafo (Map<String, String> grafo){
        this.grafo = grafo;
    }

    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 50;
        int y = 50;
        int nodeDiameter = 30;
        int yIncrement = 50;
        for (Map.Entry<String, String> entry : grafo.entrySet()) {
            String source = entry.getKey();
            String target = entry.getValue();

            int sourceX = x;
            int sourceY = y;
            int targetX = x;
            int targetY = y + yIncrement;

            g2d.drawOval(sourceX, sourceY, nodeDiameter, nodeDiameter);
            g2d.drawString(source, sourceX + 5, sourceY + 20);

            g2d.drawOval(targetX, targetY, nodeDiameter, nodeDiameter);
            g2d.drawString(target, targetX + 5, targetY + 20);

            g2d.drawLine(sourceX + nodeDiameter / 2, sourceY + nodeDiameter, targetX + nodeDiameter / 2, targetY);
            y += yIncrement;
        }
    }

    public static void visualizarGrafo(Map<String, String> graph) {
        JFrame frame = new JFrame("Simulation Graph");
        verGrafo graphVisualizer = new verGrafo(graph);
        frame.add(graphVisualizer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
