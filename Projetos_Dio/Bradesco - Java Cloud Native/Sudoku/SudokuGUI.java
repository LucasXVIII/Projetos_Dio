import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends JFrame {
    private SudokuBoard board;
    private JTextField[][] cells = new JTextField[9][9];
    private JPanel gridPanel;

    public SudokuGUI() {
        board = new SudokuBoard();
        setTitle("Sudoku Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 600);
        setLayout(new BorderLayout());

        // Grade Sudoku
        gridPanel = new JPanel(new GridLayout(9, 9));
        Font font = new Font("Arial", Font.BOLD, 20);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(font);

                int value = board.getValue(row, col);
                if (value != 0) {
                    cell.setText(String.valueOf(value));
                    cell.setEditable(false);
                    cell.setBackground(new Color(220, 220, 220));
                } else {
                    int finalRow = row;
                    int finalCol = col;
                    cell.addActionListener(e -> handleInput(finalRow, finalCol, cell));
                }

                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        JButton verifyButton = new JButton("Verificar");
        JButton resetButton = new JButton("Reiniciar");

        verifyButton.addActionListener(e -> verifyBoard());
        resetButton.addActionListener(e -> resetBoard());

        buttonPanel.add(verifyButton);
        buttonPanel.add(resetButton);

        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void handleInput(int row, int col, JTextField cell) {
        try {
            int num = Integer.parseInt(cell.getText());
            if (num < 1 || num > 9) throw new NumberFormatException();

            if (board.isValidMove(row, col, num)) {
                board.placeNumber(row, col, num);
                cell.setForeground(Color.BLUE);
                if (board.isBoardFull()) {
                    JOptionPane.showMessageDialog(this, "Parabéns! Sudoku completo!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Movimento inválido!");
                cell.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número de 1 a 9.");
            cell.setText("");
        }
    }

    private void verifyBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String text = cells[row][col].getText();
                if (!text.isEmpty()) {
                    try {
                        int num = Integer.parseInt(text);
                        // Apaga temporariamente o valor para verificar
                        int current = board.getValue(row, col);
                        board.placeNumber(row, col, 0);
                        if (!board.isValidMove(row, col, num)) {
                            JOptionPane.showMessageDialog(this, "Erro na posição: Linha " + (row + 1) + ", Coluna " + (col + 1));
                            board.placeNumber(row, col, current);
                            return;
                        }
                        board.placeNumber(row, col, num);
                    } catch (NumberFormatException ignored) {}
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Tudo certo até agora!");
    }

    private void resetBoard() {
        board = new SudokuBoard();
        gridPanel.removeAll();

        Font font = new Font("Arial", Font.BOLD, 20);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(font);

                int value = board.getValue(row, col);
                if (value != 0) {
                    cell.setText(String.valueOf(value));
                    cell.setEditable(false);
                    cell.setBackground(new Color(220, 220, 220));
                } else {
                    int finalRow = row;
                    int finalCol = col;
                    cell.addActionListener(e -> handleInput(finalRow, finalCol, cell));
                }

                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SudokuGUI::new);
    }
}
