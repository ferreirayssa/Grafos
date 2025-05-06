import java.awt.Font;
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
        frame.setSize(700, 450);
        frame.setLayout(new GridLayout(6, 1));
        frame.setLocationRelativeTo(null);

        // Fontes
        Font fonteNegrito = new Font("SansSerif", Font.BOLD, 18);
        Font fonteNormal = new Font("SansSerif", Font.PLAIN, 18);

        // Componentes
        JLabel label1 = new JLabel("Origem:");
        label1.setFont(fonteNegrito);

        JComboBox<String> origemBox = new JComboBox<>(grafo.getCapitaisOrdenadas());
        origemBox.setFont(fonteNormal);

        JLabel label2 = new JLabel("Destino:");
        label2.setFont(fonteNegrito);

        JComboBox<String> destinoBox = new JComboBox<>(grafo.getCapitaisOrdenadas());
        destinoBox.setFont(fonteNormal);

        JButton calcularButton = new JButton("Calcular rota");
        calcularButton.setFont(fonteNegrito);

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setFont(fonteNormal);
        resultadoArea.setEditable(false);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);

        calcularButton.addActionListener((ActionEvent e) -> {
            String origem = (String) origemBox.getSelectedItem();
            String destino = (String) destinoBox.getSelectedItem();

            Dijkstra.Resultado resultado = Dijkstra.calcularMenorCaminho(
                grafo.getConexoes(),
                origem,
                destino
            );

            if (resultado.getDistanciaTotal() == Integer.MAX_VALUE) {
                resultadoArea.setText("Não há rota possível entre as capitais selecionadas.");
            } else {
                resultadoArea.setText(
                    "Caminho: " + String.join(" → ", resultado.getCaminho()) + "\n" +
                    "Distância total: " + resultado.getDistanciaTotal() + " km"
                );
            }
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
