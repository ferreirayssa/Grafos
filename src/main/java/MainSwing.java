import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainSwing {
    public static void main(String[] args) {
        Grafo grafo = GrafoBuilder.montarGrafoCompleto();

        JFrame frame = new JFrame("Menor rota entre capitais (Dijkstra)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);
        frame.setLayout(new GridLayout(6, 1));
        frame.setLocationRelativeTo(null);

        JLabel label1 = new JLabel("Origem:");
        JComboBox<String> origemBox = new JComboBox<>(grafo.getCapitaisOrdenadas());

        JLabel label2 = new JLabel("Destino:");
        JComboBox<String> destinoBox = new JComboBox<>(grafo.getCapitaisOrdenadas());

        JButton calcularButton = new JButton("Calcular rota");
        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        calcularButton.addActionListener((ActionEvent e) -> {
            String origem = (String) origemBox.getSelectedItem();
            String destino = (String) destinoBox.getSelectedItem();

            Dijkstra.Resultado resultado = Dijkstra.calcularMenorCaminho(
                grafo.getConexoes(),
                origem,
                destino
            );

            resultadoArea.setText("Caminho: " + String.join(" → ", resultado.getCaminho()) +
                                  "\nDistância total: " + resultado.getDistanciaTotal() + " km");
        });

        frame.add(label1);
        frame.add(origemBox);
        frame.add(label2);
        frame.add(destinoBox);
        frame.add(calcularButton);
        frame.add(new JScrollPane(resultadoArea));

        frame.setVisible(true);
    }
}
