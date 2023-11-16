import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class RelogioDigital extends JFrame {

    private JLabel rotuloHora;
    private JLabel rotuloData;

    public RelogioDigital() {
        setTitle("Relógio Digital");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Cria um painel para os rótulos de hora e data
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painel.setLayout(new BorderLayout());

        // Cria um rótulo para exibir a hora
        rotuloHora = new JLabel();
        rotuloHora.setFont(new Font("Arial", Font.PLAIN, 60));
        rotuloHora.setHorizontalAlignment(SwingConstants.CENTER);
        rotuloHora.setVerticalAlignment(SwingConstants.CENTER);
        rotuloHora.setForeground(Color.RED);

        // Cria um rótulo para exibir a data
        rotuloData = new JLabel();
        rotuloData.setFont(new Font("Arial", Font.PLAIN, 20));
        rotuloData.setHorizontalAlignment(SwingConstants.CENTER);
        rotuloData.setVerticalAlignment(SwingConstants.CENTER);
        rotuloData.setForeground(Color.WHITE);

        // Adiciona os rótulos de hora e data ao painel
        painel.add(rotuloHora, BorderLayout.CENTER);
        painel.add(rotuloData, BorderLayout.SOUTH);

        // Define a cor de fundo do painel
        painel.setBackground(Color.BLACK);

        // Adiciona o painel ao frame
        add(painel);

        // Usa um Timer para atualizar os rótulos de hora e data a cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarHoraEData();
            }
        });
        timer.start();
    }

    private void atualizarHoraEData() {
        // Obtém a hora atual e formata
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");
        String hora = formatadorHora.format(calendario.getTime());

        // Obtém a data atual e formata
        SimpleDateFormat formatadorData = new SimpleDateFormat("EEE, d MMM yyyy");
        String data = formatadorData.format(calendario.getTime());

        // Atualiza os rótulos de hora e data
        rotuloHora.setText(hora);
        rotuloData.setText(data);
    }

    public static void main(String[] args) {
        RelogioDigital relogio = new RelogioDigital();
        relogio.setVisible(true);
    }
}
